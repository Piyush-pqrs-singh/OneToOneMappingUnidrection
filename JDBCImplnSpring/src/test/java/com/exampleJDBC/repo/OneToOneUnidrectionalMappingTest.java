package com.exampleJDBC.repo;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exampleJDBC.modal.Address;
import com.exampleJDBC.modal.Order;

@SpringBootTest
public class OneToOneUnidrectionalMappingTest {

	
	@Autowired
	private RepoOrder orderRepo;
	
	@Test
	public void getOrderMethod() {
			Order order=orderRepo.findById(2L).get();
			System.out.println(order.toString());
	}
	
	@Test
	public void saveOrderRepositoryMethod() {
		
		Order order=new Order();
		order.setOrderTrackingNumber("1000ABC");
		order.setTotalQuantity(541);
		order.setTotalPrice(new BigDecimal(123));
		order.setStatus("In Progress");
		
		Address address=new Address();
		address.setStreet("Santacruz");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setZipCode("40055");
		
		order.setBillingAddress(address);
		
		orderRepo.save(order);
		
	}
	
	@Test
	public void updateOrMergeMethod() {
		Order order=orderRepo.findById(1L).get();
		//order.setOrderTrackingNumber("1000ABC");
//		order.setTotalQuantity(541);
//		order.setTotalPrice(new BigDecimal(123));
		
		order.setStatus("Delivered");
		
		order.getBillingAddress().setZipCode("400072");
		
//		Address address=new Address();
//		address.setStreet("Santacruz");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setZipCode("40055");
		
		orderRepo.save(order);
		
		
		//order.setBillingAddress(address);
	}
	
	
	@Test
	public void deleteOrder() {
		orderRepo.deleteById(1L);
	}
	

	
}
