package com.packt.cardatabase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ownerid;
	private String firstname, lastname;
	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
//	private List<Car> cars;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name="car_owner", joinColumns={@JoinColumn(name="ownerid")}, inverseJoinColumns={@JoinColumn(name="id")})
	@JsonIgnore
	private Set<Car> cars = new HashSet<Car>(0);
	
	public Owner() {
		// TODO Auto-generated constructor stub
	}
	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public long getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(long ownerid) {
		this.ownerid = ownerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
//	public List<Car> getCars() {
//		return cars;
//	}
//	public void setCars(List<Car> cars) {
//		this.cars = cars;
//	}
	public Set<Car> getCars() {
        return cars;
    }
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
}
