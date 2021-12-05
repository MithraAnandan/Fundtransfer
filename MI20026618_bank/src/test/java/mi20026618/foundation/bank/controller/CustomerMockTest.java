package mi20026618.foundation.bank.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import mi20026618.foundation.bank.entity.Customer;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerMockTest {
	
	@Autowired
	MockMvc mockMvc;

	@Test
	void testCreateCustomer() throws Exception{
		 Customer c1=new Customer(120,"name1",12345,"India","name1@1");
		 
		 mockMvc.perform(post("/customer")
				 .content(asJsonString(c1))
				 .contentType(MediaType.APPLICATION_JSON)
				 .accept(MediaType.APPLICATION_JSON)
				 )
		 	.andExpect(status().isCreated())
		 	.andExpect(MockMvcResultMatchers.jsonPath("$.cid").value(1)
				 );
		 
	}
	
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//@Test
	//void testGetCustomerInfo() {
	//}

}
