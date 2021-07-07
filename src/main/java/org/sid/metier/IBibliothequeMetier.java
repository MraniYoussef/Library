package org.sid.metier;

import org.sid.entities.Book;
import org.sid.entities.BookReservation;
import org.sid.entities.Member;
import org.sid.entities.Subscription;
import org.springframework.data.domain.Page;

public interface IBibliothequeMetier {
	

	public Page<Book> consulterBook(String title, String motCle, int size, int page);
	public BookReservation reserverBook(Long idBook, Long idUser);
	public BookReservation consulterBookReservation(Long idBookReservation, Long idUser);
	public Member consulterMember(Long idUser);
	public Subscription consulterSubscription(Long idSubscription);
	
	//public void retirer(String codeCompte, double mantant);
	//public void virement(String codeCompte1, String codeCompte2, double mantant);
	//public Page<Operation> listeOperation(String codeCompte, int page , int size);
	void addMember();
	void addSubscription();

}
