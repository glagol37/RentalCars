package net.rentalcars.entity;

import net.rentalcars.model.CurrentAccount;

public class Account extends AbstractEntity<Integer> implements CurrentAccount{

	private static final long serialVersionUID = 3217874925970095386L;
	private String type;
	private String login;
	private boolean blocking;	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public boolean isBlocking() {
		return blocking;
	}
	public void setBlocking(boolean blocking) {
		this.blocking = blocking;
	}
}
