package com.exampleJDBC.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleJDBC.modal.Order;


public interface RepoOrder extends JpaRepository<Order, Long>{

	
	Order findByOrderTrackingNumber(String orderTrackingNumber);
}
