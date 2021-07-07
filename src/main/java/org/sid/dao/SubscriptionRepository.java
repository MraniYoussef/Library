package org.sid.dao;

import org.sid.entities.Subscription;
import org.sid.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
	@Query("select s from Subscription s where s.member.firstName like :x" ) public
	 Page<Subscription> chercher(@Param("x")String s, Pageable pageable);
}
