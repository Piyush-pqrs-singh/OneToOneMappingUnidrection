package com.exampleJDBC.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleJDBC.modal.Address;

public interface RepoAddress extends JpaRepository<Address, Long>{

}
