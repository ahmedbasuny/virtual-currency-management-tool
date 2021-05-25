package blockchain.vctransfer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blockchain.vctransfer.exception.TransactionDataNotVaildException;
import blockchain.vctransfer.model.Account;
import blockchain.vctransfer.model.Transaction;
import blockchain.vctransfer.model.custom.AccountAmount;
import blockchain.vctransfer.model.custom.TransactionReport;
import blockchain.vctransfer.repository.TransactionRepository;
import blockchain.vctransfer.utls.Config;

@Service
public class TransactionService {

	@Autowired
	AccountService accountService;
	
	@Autowired
	TransactionRepository transactionRepo;
	
	public void transferMoneyToUsers(Integer accountSenderId, List<AccountAmount> accountToReceived) throws Exception {
		validateNumberOfUsers(accountToReceived);
		validateAvailableBalance(accountSenderId, accountToReceived);
		transferVC(accountSenderId, accountToReceived);
	}

	@Transactional
	private void transferVC(Integer accountSenderId, List<AccountAmount> accountToReceived) {
		Account senderAccount = accountService.getAccountById(accountSenderId);
		accountToReceived.forEach( account -> {
			Account receiverAccount = accountService.getAccountById(account.getAccountId());
			Transaction transaction = new Transaction(senderAccount, receiverAccount, new Date(), account.getAmount());
			transactionRepo.save(transaction);
			
			senderAccount.setBalance(senderAccount.getBalance() - account.getAmount());
			accountService.saveAccount(senderAccount);
			
			receiverAccount.setBalance(receiverAccount.getBalance() + account.getAmount());
			accountService.saveAccount(senderAccount);
		});
		
	}

	private void validateAvailableBalance(Integer accountSenderId, List<AccountAmount> accountToReceived) throws TransactionDataNotVaildException {
		Double amountToTransfer = accountToReceived.stream().mapToDouble(AccountAmount::getAmount).sum();
		Double currentUserAmount = accountService.getAccountById(accountSenderId).getBalance();
		if (amountToTransfer > currentUserAmount) {
			throw new TransactionDataNotVaildException("your balance doesn't  enough for the transaction.");
		}
	}

	private void validateNumberOfUsers(List<AccountAmount> accountToReceived) throws TransactionDataNotVaildException {
		if (accountToReceived.size() > Config.NUMBER_OF_USERS_TO_TRANSFER) {
			throw new TransactionDataNotVaildException("max number of users you can transfer to is " + Config.NUMBER_OF_USERS_TO_TRANSFER);
		}
	}
	
	public TransactionReport getTransactionReport(Integer accountId) {
		List<AccountAmount> sendingOpertaions = new ArrayList<>();
		List<AccountAmount> receivingOpertaions = new ArrayList<>();
		List<Transaction> sendingTransactions = transactionRepo.getBySenderAccount(accountService.getAccountById(accountId));
		List<Transaction> receivingTransactions = transactionRepo.getByReceiverAccount(accountService.getAccountById(accountId));
		sendingTransactions.forEach( transaction -> {
			AccountAmount accountAmount = new AccountAmount();
			accountAmount.setAccountId(transaction.getReceiverAccount().getId());
			accountAmount.setAmount(transaction.getAmount());
			sendingOpertaions.add(accountAmount);
		});
		receivingTransactions.forEach( transaction -> {
			AccountAmount accountAmount = new AccountAmount();
			accountAmount.setAccountId(transaction.getSenderAccout().getId());
			accountAmount.setAmount(transaction.getAmount());
			receivingOpertaions.add(accountAmount);
		});
		return new TransactionReport(sendingOpertaions, receivingOpertaions);
	}

}
