package net.rentalcars.model;

public interface CurrentAccount {	
	Integer getId();
	
	String getLogin();
	
	boolean isBlocking();
	
	String getType();
}
