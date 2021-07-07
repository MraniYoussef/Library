package org.sid.dao;

import org.sid.entities.Book;
import org.sid.entities.BookReservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookReservationRepository extends JpaRepository<BookReservation, Long> {
	@Query("select bk from BookReservation bk where bk.member.firstName like :x" )
	public Page<BookReservation> chercher(@Param("x")String bk, Pageable pageable);

}
