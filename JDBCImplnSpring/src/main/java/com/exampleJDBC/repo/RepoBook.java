package com.exampleJDBC.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exampleJDBC.modal.Book;

public interface RepoBook extends JpaRepository<Book, Long>{
	
	@Query(value="select * from book",
			nativeQuery=true)
	List<Book> returnAllBook();

}
