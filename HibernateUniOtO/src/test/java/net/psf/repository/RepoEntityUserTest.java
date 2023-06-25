package net.psf.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import net.psf.entity.EntityAddress;
import net.psf.entity.EntityMobile;
import net.psf.entity.EntityUser;


@SpringBootTest
class RepoEntityUserTest {

	@Autowired
	private RepoEntityUser repoEntityUser;
	
	
	public void testOTOUnidirectional() {
		
		EntityUser user=new EntityUser();
		user.setFirstName("Piyushraj Jayram");
		user.setLastName("Singh");
		
		
		String ImeiNo1="359648713105743";
		String ImeiNo2="358136643105745";
		
		EntityMobile mobile=new EntityMobile();
		mobile.setImeiNo(ImeiNo1+"__"+ImeiNo2);
		mobile.setMobileName("Samsung Galaxy A22 5G R9ZRB05EC5V");
		
		user.setMobile(mobile);
		
		repoEntityUser.save(user);
		
		fail("Not yet implemented");
	}

	@Test
	@Transactional
	public void testFetchDataOtOUnidirectional() {
		 Optional<EntityUser> userOptional = repoEntityUser.findById(1L);
		 try {
	        userOptional.ifPresent(user -> {
	            // The associated EntityMobile object is not loaded yet

	            // Accessing the associated EntityMobile object triggers lazy loading\
	        	   Hibernate.initialize(user.getAddress());
	            EntityAddress mobile = user.getAddress();

	            // Now you can work with the loaded EntityMobile object
	            System.out.println("Mobile Name: " + mobile.getCountry ());
	        });
	        
		 }catch(Exception ex) { ex.printStackTrace(); }
	}
	
	
	@Test
	public void testToInsertIntoAddressEntity() {
		Optional<EntityUser> e1=Optional.of(repoEntityUser.findById(1L).get()) ;
		if(e1.isPresent()) {
	
			EntityUser eu1=e1.get();
			EntityAddress ea=new EntityAddress();
			ea.setStreet("Sakinaka");
			ea.setCity("Mumbai");
			ea.setState("Maharashtra");
			ea.setCountry("India");
			ea.setPincode("400055");
			eu1.setAddress(ea);
			repoEntityUser.save(eu1);
		}
	}
	
}
