package org.sid.dao;

import org.sid.entities.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReservationRepository extends JpaRepository<BookReservation, Long> {

}
