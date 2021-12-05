package mi20026618.foundation.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mi20026618.foundation.bank.Mi20026618BankApplication;
import mi20026618.foundation.bank.dao.CustomerRepository;
import mi20026618.foundation.bank.entity.Customer;
import mi20026618.foundation.bank.util.DataNotFoundException;

@Slf4j
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository custRepo;
	
	public void createCustomer(Customer customer) {
		custRepo.save(customer);
	}

	public Customer getCustomerInfo(int acctID) {
		//return custRepo.findById(acctID).orElse(null);
		return custRepo.findById(acctID).orElseThrow(()->new DataNotFoundException("AccountId not found, please enter valid AccountId. Invalid Account: " + acctID));
	}

	public void deleteCustomer(int acctID) {
		custRepo.deleteById(acctID);
	}
}
