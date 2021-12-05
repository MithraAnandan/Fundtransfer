package mi20026618.foundation.bank.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mi20026618.foundation.bank.entity.Customer;

@SpringBootTest
class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository repo;

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		
		Optional<Customer> foundCustomer=repo.findById(1);
		assertTrue(foundCustomer.isPresent());
		
	}


}
