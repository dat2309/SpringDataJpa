package com.example.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	@Query(value = "SELECT * FROM customer c where c.id = 1", nativeQuery = true)
	CustomerEntity findOneCustomer(long id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO customer (age,gender,name) values (?2,?3,?1)", nativeQuery = true)
	void createCustomer(String name, int age, String gender);

	@Modifying
	@Transactional
	@Query(value = "UPDATE customer SET name = ?2, age = ?3, gender = ?4 WHERE id = ?1", nativeQuery = true)
	void updateCustomer(long id, String name, int age, String gender);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM customer c WHERE c.id = ?1", nativeQuery = true)
	void deleteCustomer(long id);	
}
