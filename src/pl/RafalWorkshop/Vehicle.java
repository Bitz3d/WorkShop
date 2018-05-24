package pl.RafalWorkshop;

import java.util.Date;

public class Vehicle {

	private Integer id;

	private String model;
	private String trademark;
	private Integer produtionYear;
	private String registrationNumber;
	private Date technicalReview;
	private Integer customerID;

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Vehicle(String model, String trademark, Integer produtionYear, String registrationNumber,
			Date technicalReview) {

		this.model = model;
		this.trademark = trademark;
		this.produtionYear = produtionYear;
		this.registrationNumber = registrationNumber;
		this.technicalReview = technicalReview;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public String getTrademark() {
		return trademark;
	}

	public Integer getProdutionear() {
		return produtionYear;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public Date getTechnicalReview() {
		return technicalReview;
	}

}
