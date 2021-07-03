package org.sid;

import java.util.Date;

import org.sid.dao.BookRepository;
import org.sid.dao.BookReservationRepository;
import org.sid.dao.SubscriptionRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Book;
import org.sid.entities.BookReservation;
import org.sid.entities.Employee;
import org.sid.entities.Member;
import org.sid.entities.Subscription;
import org.sid.enumclass.BookReservationStatus;
import org.sid.enumclass.BookType;
import org.sid.enumclass.MemberFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliothequeApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookReservationRepository bookReservationRepository;
	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception  {
		MemberFunction mf1 = null;
		BookType bt1 = null;
		BookReservationStatus brs1=null;
	
		Employee A1= userRepository.save(new Employee("Abdellah", "Abdellah", "1234", "A1", "Abdellah@gmail.com"));
		Member M1= userRepository.save(new Member("yassine","yassine","123","y1","yassine@gmail.com,","menzeh", new Date(), mf1.STUDENT ));
		
		Subscription sb1 = subscriptionRepository.save(new Subscription(M1,1,false));
		Book b1 = bookRepository.save(new Book("aut1", "Illusions", bt1.ROMAN, 200, 20));
		BookReservation br1= bookReservationRepository.save(new BookReservation(M1,
				new Date(), brs1.VALIDATED, new Date(), b1 ));
		
	}

}
