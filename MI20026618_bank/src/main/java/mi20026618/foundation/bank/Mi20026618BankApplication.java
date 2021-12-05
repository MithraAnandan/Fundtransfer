package mi20026618.foundation.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import mi20026618.foundation.bank.dao.AccountRepository;
import mi20026618.foundation.bank.dao.CustomerRepository;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@EnableSwagger2
@SpringBootApplication
public class Mi20026618BankApplication {

	@Autowired
	CustomerRepository repo1;
	
	@Autowired
	AccountRepository repo2;
	
	@Bean
	public Docket demoSwagger() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("mi20026618.foundation.bank.controller")).build();
	}
	
	@Bean
	CommandLineRunner demo() {
	  return (args)->{
			
			System.out.println(repo1+"####");
			System.out.println(repo2+"####");
			
		};
	}
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(Mi20026618BankApplication.class, args);
		
		CustomerRepository customerRepository = 
				configurableApplicationContext.getBean(CustomerRepository.class);
	}
	
	
}
