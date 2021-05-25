package blockchain.vctransfer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blockchain.vctransfer.exception.AccountDataNotVaildException;
import blockchain.vctransfer.model.Account;
import blockchain.vctransfer.repository.AccountRepository;
import blockchain.vctransfer.utls.Config;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	public Account getAccountById(Integer accountId) {
		return accountRepo.getById(accountId);
	}
	
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}
	
	public Account createNewAccount(Account account) throws AccountDataNotVaildException {
		validateAccountData(account);
		return accountRepo.save(account);
	}
	
	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}

	private void validateAccountData(Account account) throws AccountDataNotVaildException {
		if (account.getUserName() == null || account.getPassword() == null) {
			throw new AccountDataNotVaildException("username and password shouldn't be null.");
		}
		if(account.getUserName().trim().length() < 6 || 
				account.getUserName().trim().length() > 40) {
			throw new AccountDataNotVaildException("username should be more than 6 digits and less than 40 digits.");
		} else if(accountRepo.existsByUserName(account.getUserName())) {
			throw new AccountDataNotVaildException("username already exists.");
		} else if (account.getPassword().trim().length() < 6 || 
				account.getPassword().trim().length() > 40) {
			throw new AccountDataNotVaildException("password should be more than 6 digits and less than 40 digits.");
		}
	}
	
	@Scheduled(cron = "0 0/30 * * * *")
	@Transactional
	private void vcAccountAccure() {
		logger.info("starting schedule task to add accure amount.");
		accountRepo.updateBalance(Config.VC_ACCURE_AMOUNT);
	}
}
