package blockchain.vctransfer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name="sender_account")
	private Account senderAccount;
	
	@ManyToOne
    @JoinColumn(name="receiver_account")
	private Account receiverAccount;
	
	private Date transactionDate;
	
	private double amount;
	
	public Transaction() {}

	public Transaction(Account senderAccout, Account receiverAccount, Date transactionDate, double amount) {
		super();
		this.senderAccount = senderAccout;
		this.receiverAccount = receiverAccount;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getSenderAccout() {
		return senderAccount;
	}

	public void setSenderAccout(Account senderAccout) {
		this.senderAccount = senderAccout;
	}

	public Account getReceiverAccount() {
		return receiverAccount;
	}

	public void setReceiverAccount(Account receiverAccount) {
		this.receiverAccount = receiverAccount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
