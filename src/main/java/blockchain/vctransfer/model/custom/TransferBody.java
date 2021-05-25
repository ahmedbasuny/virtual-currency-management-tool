package blockchain.vctransfer.model.custom;

import java.util.List;

public class TransferBody {

	private List<AccountAmount> accountToReceived;
	
	public TransferBody() {}
	
	public List<AccountAmount> getAccountToReceived() {
		return accountToReceived;
	}

	public void setAccountToReceived(List<AccountAmount> accountToReceived) {
		this.accountToReceived = accountToReceived;
	}
}

