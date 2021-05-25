package blockchain.vctransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blockchain.vctransfer.model.custom.TransferBody;
import blockchain.vctransfer.service.TransactionService;
import blockchain.vctransfer.utls.Utils;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	Utils utils;

	@PostMapping("/transfer")
	ResponseEntity<?> transferMoneyToUsers(@RequestHeader("Account-Id")  Integer accountId, @RequestBody TransferBody transferBody) {
		try {
			transactionService.transferMoneyToUsers(accountId, transferBody.getAccountToReceived());
			return new ResponseEntity<>("transaction has been completed successfully.", HttpStatus.OK);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
	
	@GetMapping("/account/transaction")
	ResponseEntity<?> getTransactionList(@RequestHeader("Account-Id")  Integer accountId) {
		try {
			return new ResponseEntity<>(transactionService.getTransactionReport(accountId), HttpStatus.OK);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
}
