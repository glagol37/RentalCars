package net.rentalcars.service;

import net.rentalcars.model.CurrentAccount;

public interface AccountService {

	CurrentAccount signIn(String login, String password, String string);

	CurrentAccount authorization(String login, String password);

	void changeStatusAccount(boolean isBlock, String login);

	int generateRandomNumber();
}
