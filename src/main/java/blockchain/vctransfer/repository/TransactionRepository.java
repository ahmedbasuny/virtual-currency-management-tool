package blockchain.vctransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blockchain.vctransfer.model.Account;
import blockchain.vctransfer.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	public List<Transaction> getBySenderAccount(Account senderAccount);

	public List<Transaction> getByReceiverAccount(Account accountById);
}
