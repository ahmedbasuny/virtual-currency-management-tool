package blockchain.vctransfer.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true)
	private String userName;
	
	private String email;
	
	private String password;
	
	private Double balance = 0.0;
	
	@OneToMany(mappedBy="senderAccount")
    private List<Transaction> sendTransactions;
	
	@OneToMany(mappedBy="receiverAccount")
    private List<Transaction> receiveTransactions;
	
	public Account() {}

	public Account(String userName, String email, String password, Double balance) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<Transaction> getSendTransactions() {
		return sendTransactions;
	}

	public void setSendTransactions(List<Transaction> sendTransactions) {
		this.sendTransactions = sendTransactions;
	}

	public List<Transaction> getReceiveTransactions() {
		return receiveTransactions;
	}

	public void setReceiveTransactions(List<Transaction> receiveTransactions) {
		this.receiveTransactions = receiveTransactions;
	}
	
}
