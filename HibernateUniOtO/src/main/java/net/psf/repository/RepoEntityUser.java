package net.psf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.psf.entity.EntityUser;

@Repository
public interface RepoEntityUser extends JpaRepository<EntityUser, Long>{

	
	
}
