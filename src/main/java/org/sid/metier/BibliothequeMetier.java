package org.sid.metier;

import java.util.Date;

import org.sid.dao.BookRepository;
import org.sid.dao.SubscriptionRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Book;
import org.sid.entities.BookReservation;
import org.sid.entities.Employee;
import org.sid.entities.Member;
import org.sid.entities.Subscription;
import org.sid.entities.User;
import org.sid.enumclass.MemberFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class BibliothequeMetier implements IBibliothequeMetier {
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Autowired
	private UserRepository userRepository;
	private BookRepository bookRepository;
	@Override
	public Page<Book> consulterBook(String title, String motCle, int size, int page) {
		Page<Book> bk = bookRepository.chercher( "%"+motCle+"%",PageRequest.of(page,size));
		if(bk==null) throw new RuntimeException("livre introuvable");	
		return bk;
	}

	

	@Override
	public Member consulterMember(Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	@Override
	public Subscription consulterSubscription(Long idSubscription) {
		Subscription subscription = subscriptionRepository.getById(idSubscription);
		if(subscription==null) throw new RuntimeException("Subscription introuvable");	
		return subscription;
	}

	
	

	@Override
	public void addMember() {
		//Subscription subscr = consulterSubscription(idSubscription);
		//User m = new Member(  firstName, lastName, password, cin, email, address, 
			//	dateOfMembership, function  );
		//userRepository.save(m);
		//cp.setSolde(cp.getSolde()+mantant);
		//compteRepository.save(cp);
		
	}

	@Override
	public void addSubscription() {;
		Subscription subs = new Subscription(  );
		subscriptionRepository.save(subs);
		
	}



	@Override
	public BookReservation reserverBook(Long idBook, Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public BookReservation consulterBookReservation(Long idBookReservation, Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
