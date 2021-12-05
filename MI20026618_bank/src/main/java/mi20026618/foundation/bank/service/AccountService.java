package mi20026618.foundation.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mi20026618.foundation.bank.Mi20026618BankApplication;
import mi20026618.foundation.bank.dao.AccountRepository;
import mi20026618.foundation.bank.entity.Account;
import mi20026618.foundation.bank.util.DataNotFoundException;

@Slf4j
@Service
public class AccountService {
	
	@Autowired
	AccountRepository acctRepo;
	
	public void createAccount(Account acct) {
		acctRepo.save(acct);
	}

	public Account getAccountInfo(int acctID) {
		//return acctRepo.findById(acctID).orElse(null);
		return acctRepo.findById(acctID).orElseThrow(()->new DataNotFoundException("AccountId not found, please enter valid AccountId. Invalid Account: " + acctID));
	}

	public void deleteAccount(int acctID) {
		acctRepo.deleteById(acctID);
	}

	public int getBalance(int acctID) {
		return acctRepo.findBalanceByAcctID(acctID);
	}

	public void depositAmount(int acctID, int amount) {
		acctRepo.saveBalanceByAcctID(acctID, amount);
	}

	public void withdrawAmount(int acctID, int amount) {
		acctRepo.withdrawAmountByAcctID(acctID, amount);
	}

	public void transferAmount(int acctID, int destAcctID, int amount) {
		acctRepo.withdrawAmountByAcctID(acctID, amount);
		acctRepo.saveBalanceByAcctID(destAcctID, amount);
	}

}
