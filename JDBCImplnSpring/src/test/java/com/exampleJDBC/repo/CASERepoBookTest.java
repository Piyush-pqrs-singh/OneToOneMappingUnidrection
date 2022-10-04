package com.exampleJDBC.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exampleJDBC.modal.Book;

@SpringBootTest
class CASERepoBookTest {
	
    @Autowired
	JdbcTemplate jdbcTemplate;
    
    @Autowired
    private RepoBook repoBook;
	
	@Test
	void test() {
		
		   String sql = "INSERT INTO erp_springPract.book (title, author, price) VALUES (?, ?, ?)";
		  int result = jdbcTemplate.update(sql, "Head First C++", "Kathy Sierra", 18.55f);
			
		  if(result>0) {
			  System.out.println("Inserted Successfully");
		  }
		
		List<Book> l1=repoBook.returnAllBook();
		
		fail("Not yet implemented");
	}

}
