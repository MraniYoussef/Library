package org.sid.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User implements Serializable {

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, String password, String cin, String email) {
		super(firstName, lastName, password, cin, email);
		// TODO Auto-generated constructor stub
	}

	
	
	
	/*private BookReservationStatus  validateReservation(Subscription idSubscription) {
		BookReservationStatus bk = null;
		Subscription memberSubscription = new Subscription();
		if (memberSubscription.getIsBlocked()) {
			return bk.CANCELED;
		}
		else return bk.VALIDATED ;
		
	}*/

	
	
}
