package pl.RafalWorkshop;

public class Employee {

	private Integer id;
	
	public Integer getId() {
		return id;
	}


	private String name;
	private String lastName;
	private String adress;
	private Integer telephoneNumber;
	private String note;
	private Double pricePerHour;
	
	public Employee(String name, String lastName, String adress, Integer telephoneNumber, String note,
			Double pricePerHour) {
		this.name = name;
		this.lastName = lastName;
		this.adress = adress;
		this.telephoneNumber = telephoneNumber;
		this.note = note;
		this.pricePerHour = pricePerHour;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAdress() {
		return adress;
	}

	public Integer getTelephoneNumber() {
		return telephoneNumber;
	}

	public String getNote() {
		return note;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}
	
	
	
	
}
