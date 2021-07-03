package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.sid.enumclass.MemberFunction;

@Entity
@DiscriminatorValue("MEMBER")
public class Member extends User implements Serializable {
	
	private String address;
	private Date dateOfMembership;
	private MemberFunction function;
	@OneToOne
	@JoinColumn(name="Id_Subscription")	
	private Subscription subscription;
	@OneToMany
	@JoinColumn(name="id_BkReserv")
	private Collection<BookReservation> bookReservations;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String firstName, String lastName, String password, String cin, String email) {
		super(firstName, lastName, password, cin, email);
		// TODO Auto-generated constructor stub
	}
	
	
	public Member(String firstName, String lastName, String password, String cin, String email, String address,
			Date dateOfMembership, MemberFunction function) {
		super(firstName, lastName, password, cin, email);
		this.address = address;
		this.dateOfMembership = dateOfMembership;
		this.function = function;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDateOfMembership() {
		return dateOfMembership;
	}
	public void setDateOfMembership(Date dateOfMembership) {
		this.dateOfMembership = dateOfMembership;
	}
	public MemberFunction getFunction() {
		return function;
	}
	public void setFunction(MemberFunction function) {
		this.function = function;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	public Collection<BookReservation> getBookReservations() {
		return bookReservations;
	}
	public void setBookReservations(Collection<BookReservation> bookReservations) {
		this.bookReservations = bookReservations;
	}
	
	
}
