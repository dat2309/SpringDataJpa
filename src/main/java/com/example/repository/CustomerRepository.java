package com.example.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	@Query(value = "SELECT c FROM customer c where c.id = ?1")
	CustomerEntity findOneCustomer(long id);

//  Not have JPQL query to insert
//	@Modifying
//	@Transactional
//	@Query(value = "INSERT INTO customer c (c.age,c.gender,c.name) values (?2,?3,?1)")
//	void createCustomer(String name, int age, String gender);

	@Modifying
	@Transactional
	@Query(value = "UPDATE customer SET name = ?2, age = ?3, gender = ?4 WHERE id = ?1")
	void updateCustomer(long id, String name, int age, String gender);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM customer c WHERE c.id = ?1")
	void deleteCustomer(long id);	
}
