package mi20026618.foundation.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mi20026618.foundation.bank.Mi20026618BankApplication;
import mi20026618.foundation.bank.entity.Account;
import mi20026618.foundation.bank.service.AccountService;
import mi20026618.foundation.bank.util.DataNotFoundException;

@Slf4j
@RestController
public class AccountController {

		@Autowired
		AccountService acctService;
	
		// createAccount happens upon createCustomer
		public void createAccount(int acctID, int balance, String acctType) {
			Account acct = new Account(acctID, balance, acctType);
			acctService.createAccount(acct);
		}

		// checkBalance
		@GetMapping("/account/{acctID}/balance")
		public int getBalance(@PathVariable int acctID) {
			return acctService.getBalance(acctID);
		}

		// depositAmount
		@PutMapping("/account/{acctID}/deposit/{amount}")
		public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
			int initBal = getBalance(acctID);
			acctService.depositAmount(acctID, amount);
		}

		// withdrawAmount
		@PutMapping("/account/{acctID}/withdraw/{amount}")
		public void withdrawAmount(@PathVariable int acctID, @PathVariable int amount) {
			int initBal = getBalance(acctID);
			acctService.withdrawAmount(acctID, amount);
		}

		// transferAmount
		@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
		public void transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
			int initBalSender = getBalance(acctID);
			int initBalReceiver = getBalance(destAcctID);
			
			if(initBalSender < amount) {
				throw new DataNotFoundException("Cannot Transfer" + amount);
			}
			else {
				acctService.transferAmount(acctID, destAcctID, amount);
			}
		}

		// deleteAccount
		@DeleteMapping("/account/{acctID}")
		public void deleteAccount(@PathVariable int acctID) {
			acctService.deleteAccount(acctID);
			
		}

		// getAccountInfo
		@GetMapping("/account/{acctID}")
		public Account getAccountInfo(@PathVariable int acctID) {
			return acctService.getAccountInfo(acctID);
		}
	
}
