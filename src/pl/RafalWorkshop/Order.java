package pl.RafalWorkshop;

import java.util.Date;

import pl.Dao.EmployeeDao;

public class Order {

	
	private Integer id;

	private Date OrderDate;
	private Date plannigWorkingDate;
	private Date startOfWork;
	private Integer EmployeeID;
	private String problemDescription;
	private String afterFixDescription;
	private String status;
	private Integer vehicleID;
	private Double totalCost;
	private Double partsCost;
	private Double laborHouresToFix;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public Date getPlannigWorkingDate() {
		return plannigWorkingDate;
	}
	public void setPlannigWorkingDate(Date plannigWorkingDate) {
		this.plannigWorkingDate = plannigWorkingDate;
	}
	public Date getStartOfWork() {
		return startOfWork;
	}
	public void setStartOfWork(Date startOfWork) {
		this.startOfWork = startOfWork;
	}
	public Integer getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	public String getAfterFixDescription() {
		return afterFixDescription;
	}
	public void setAfterFixDescription(String afterFixDescription) {
		this.afterFixDescription = afterFixDescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(Integer vehicleID) {
		this.vehicleID = vehicleID;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double  totalCost) {
		this.totalCost = totalCost;
	}
	public Double getPartsCost() {
		return partsCost;
	}
	public void setPartsCost(Double partsCost) {
		this.partsCost = partsCost;
	}
	public Double getLaborHouresToFix() {
		return laborHouresToFix;
	}
	public void setLaborHouresToFix(Double laborHouresToFix) {
		this.laborHouresToFix = laborHouresToFix;
	}
	

}
