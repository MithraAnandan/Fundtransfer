package mi20026618.foundation.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mi20026618.foundation.bank.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}