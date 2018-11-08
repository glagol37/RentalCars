package net.rentalcars.service.impl;

import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

import net.rentalcars.entity.Account;
import net.rentalcars.jdbc.JDBCConnectionUtils;
import net.rentalcars.jdbc.JDBCUtils;
import net.rentalcars.jdbc.ResultSetHandler;
import net.rentalcars.jdbc.ResultSetHandlerFactory;
import net.rentalcars.jdbc.Transactional;
import net.rentalcars.model.CurrentAccount;
import net.rentalcars.service.AccountService;

@Transactional
public class AccountServiceImpl implements AccountService {
	private static final ResultSetHandler<CurrentAccount> account = ResultSetHandlerFactory
			.getSingleResultSetHandler(ResultSetHandlerFactory.AUTHENTIFICATE);
	private Random random = new Random();
	
	public CurrentAccount signIn(String login, String password, String type) {
		if (JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from account where login =?", account, login) == null) {
			JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "insert into account values(nextval('account_seq'), ?, ?, false, ?)", login,
					DigestUtils.md5Hex(password), type);
			Account a = new Account();
			a.setLogin(login);
			a.setType(type);
			return a;
		}
		return null;
	}

	public CurrentAccount authorization(String login, String password) {
		return JDBCUtils.select(JDBCConnectionUtils.getCurrentConnection(), "select * from account where login=? and password=? and blocked=false", account,
				login, DigestUtils.md5Hex(password));
	}

	public void changeStatusAccount(boolean isBlock, String login) {
		JDBCUtils.insert(JDBCConnectionUtils.getCurrentConnection(), "update account set blocked=? where login = ?", isBlock, login);
	}

	public int generateRandomNumber() {
		return random.nextInt(15);
	}
}
