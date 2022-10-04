package com.exampleJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JdbcImplnSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JdbcImplnSpringApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		
	  //String sql = "INSERT INTO erp_springPract.book (title, author, price) VALUES (?, ?, ?)";
	  //int result = jdbcTemplate.update(sql, "Head First Java", "Kathy Sierra", 18.55f);
		
	  //if(result>0) {
		 // System.out.println("Inserted Successfully");
	 // }
	}

}
