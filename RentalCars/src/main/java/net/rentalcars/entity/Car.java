package net.rentalcars.entity;

import java.math.BigDecimal;

public class Car extends AbstractEntity<Integer>{

	private static final long serialVersionUID = -7063587303643813472L;
	private String mark;
	private short quality;
	private BigDecimal price;
	private String title;
	private boolean isBusy;
	
	
	public boolean isBusy() {
		return isBusy;
	}
	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public short getQuality() {
		return quality;
	}
	public void setQuality(short qulity) {
		this.quality = qulity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
