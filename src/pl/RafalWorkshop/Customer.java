package pl.RafalWorkshop;

import java.util.Date;

public class Customer {

	private Integer id;
	private String name;
	private String lastName;
	private Date dateOfBirth;
	
	
	public Customer(String name, String lastName, Date dateOfBirth) {

		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getLasyName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}





}
