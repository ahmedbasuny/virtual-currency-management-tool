package blockchain.vctransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blockchain.vctransfer.model.Account;
import blockchain.vctransfer.service.AccountService;
import blockchain.vctransfer.utls.Utils;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	Utils utils;

	@PostMapping("/accounts")
	ResponseEntity<?> createNewAccount(@RequestBody Account account) {
		try {
			return new ResponseEntity<>(accountService.createNewAccount(account), HttpStatus.CREATED);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
	
	@GetMapping("/accounts")
	ResponseEntity<?> getAllAcounts() {
		try {
			return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
}
