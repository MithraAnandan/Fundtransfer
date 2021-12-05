package mi20026618.foundation.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mi20026618.foundation.bank.Mi20026618BankApplication;
import mi20026618.foundation.bank.entity.Customer;
import mi20026618.foundation.bank.service.CustomerService;

@Slf4j
@RestController
public class CustomerController {

	@Autowired
	private CustomerService custService;
	
	@Autowired
	AccountController acctControll;
	
	@PostMapping("/customer")
	public void createCustomer(@RequestBody Customer customer) {
		custService.createCustomer(customer);
		acctControll.createAccount(customer.getAcctID(), 0, "Saving Account");
	}

	@GetMapping("/customer/{acctID}")
	public Customer getCustomerInfo(@PathVariable int acctID) {
		return custService.getCustomerInfo(acctID);
	}

	@DeleteMapping("/customer/{acctID}")
	public void deleteCustomer(@PathVariable int acctID) {
		custService.deleteCustomer(acctID);
	}
	
}
