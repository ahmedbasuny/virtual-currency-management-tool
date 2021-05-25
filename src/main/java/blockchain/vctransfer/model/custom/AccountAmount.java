package blockchain.vctransfer.model.custom;

public class AccountAmount {
	
	private Integer accountId;
	private Double amount;
	
	public AccountAmount() {}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}