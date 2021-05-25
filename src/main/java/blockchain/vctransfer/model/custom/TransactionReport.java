package blockchain.vctransfer.model.custom;

import java.util.List;

public class TransactionReport {

	private List<AccountAmount> sendingOperations;
	private List<AccountAmount> receivingOperations;
	
	
	public TransactionReport(List<AccountAmount> sendingOperations, List<AccountAmount> receivingOperations) {
		super();
		this.sendingOperations = sendingOperations;
		this.receivingOperations = receivingOperations;
	} 
	
	public List<AccountAmount> getSendingOperations() {
		return sendingOperations;
	}
	public void setSendingOperations(List<AccountAmount> sendingOperations) {
		this.sendingOperations = sendingOperations;
	}
	public List<AccountAmount> getReceivingOperations() {
		return receivingOperations;
	}
	public void setReceivingOperations(List<AccountAmount> receivingOperations) {
		this.receivingOperations = receivingOperations;
	}
	
	
}
