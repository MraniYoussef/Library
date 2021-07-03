package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Subscription implements Serializable {
	@Id @GeneratedValue
	private Long idSubscription;
	//private Employee employee;
	@OneToOne
	@JoinColumn(name="Id_Member")	
	private Member member;
	private int BlockageDaysPeriod;
	private Boolean isBlocked;
	
	
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Subscription( Member member, int blockageDaysPeriod, Boolean isBlocked) {
		super();
		
		this.member =  member;
		BlockageDaysPeriod = blockageDaysPeriod;
		this.isBlocked = isBlocked;
	}

	public Long getIdSubscription() {
		return idSubscription;
	}
	public void setIdSubscription(Long idSubscription) {
		this.idSubscription = idSubscription;
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public int getBlockageDaysPeriod() {
		return BlockageDaysPeriod;
	}
	public void setBlockageDaysPeriod(int blockageDaysPeriod) {
		BlockageDaysPeriod = blockageDaysPeriod;
	}
	public Boolean getIsBlocked() {
		return isBlocked;
	}
	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	
}
