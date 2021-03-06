package org.sid.dao;

import java.util.List;

import org.sid.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository
		extends JpaRepository<User, Long> {
	
	 @Query("select u from User u where u.firstName like :x" ) public
	 Page<User> chercher(@Param("x")String u, Pageable pageable);
											 

	

	
}
