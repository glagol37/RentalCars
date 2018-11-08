package net.rentalcars;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Constants {
	public static final String CURRENT_SHOPPING_CART = "CURRENT_SHOPPING_CART";

	public static final String ACCOUNT_ACTIONS_HISTORY = "ACCOUNT_ACTIONS_HISTORY";

	public static final List<String> TYPE = new ArrayList<String>(Arrays.asList("User", "Manager", "Admin"));

	public static final String CURRENT_ACCOUNT = "CURRENT_ACCOUNT";

	public static final String WELCOME_MESSAGE = "Добро пожаловать";

	public static final String USER_NOT_REGISTERED = "Данный пользователь уже зарегестрирован!";

	public static final BigDecimal PRICE_FOR_DRIVER = new BigDecimal("100.00");


}