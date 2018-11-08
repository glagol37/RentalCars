package net.rentalcars.entity;

import java.math.BigDecimal;

public class Score extends AbstractEntity<Integer>{

	private static final long serialVersionUID = -3683984083667225784L;
	
	private String accountLogin;
	private BigDecimal price;
	private int orderId;
		
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
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
