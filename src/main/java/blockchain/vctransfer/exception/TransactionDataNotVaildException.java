package blockchain.vctransfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionDataNotVaildException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TransactionDataNotVaildException(String message) {
		super(message);
	}
}
