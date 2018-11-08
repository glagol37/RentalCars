package net.rentalcars.util;

import javax.servlet.http.HttpServletRequest;

import net.rentalcars.Constants;
import net.rentalcars.model.CurrentAccount;


public class SessionUtils {
	public static CurrentAccount getCurrentAccount(HttpServletRequest req) {
		return (CurrentAccount) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);
	}

	public static void setCurrentAccount(HttpServletRequest req, CurrentAccount currentAccount) {
		req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, currentAccount);
	}

	public static boolean isCurrentAccountCreated(HttpServletRequest req) {
		return getCurrentAccount(req) != null;
	}
}
