package net.rentalcars.entity;

import java.math.BigDecimal;

public class Order extends AbstractEntity<Long> {

	private static final long serialVersionUID = 3898398846733276927L;

	private int carsId;
	private String accountLogin;
	private BigDecimal price;
	private String passportDetails;
	private boolean paid;
	private boolean cancel;
	private String description;
	private boolean isDriver;
	private Car car;
	private short days;

	public short getDays() {
		return days;
	}

	public void setDays(short days) {
		this.days = days;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public boolean isDriver() {
		return isDriver;
	}

	public void setDriver(boolean isDriver) {
		this.isDriver = isDriver;
	}

	public int getCarsId() {
		return carsId;
	}

	public void setCarsId(int carsId) {
		this.carsId = carsId;
	}

	public String getAccountLogin() {
		return accountLogin;
	}

	public void setAccountLogin(String accountLogin) {
		this.accountLogin = accountLogin;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPassportDetails() {
		return passportDetails;
	}

	public void setPassportDetails(String passportDetails) {
		this.passportDetails = passportDetails;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean isCancel() {
		return cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return car.getTitle();
	}

	public String getMark() {
		return car.getMark();
	}
}
