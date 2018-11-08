package net.rentalcars.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.*;
import org.apache.catalina.servlet4preview.RequestDispatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import net.rentalcars.model.CurrentAccount;
import net.rentalcars.service.AccountService;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ AuthorizationController.class })
public class AuthorizationControllerTest {
	private static final String path = "/WEB-INF/JSP/page-template.jsp";
	private static final String login = "login";
	private static final String password = "password";
	private AuthorizationController servlet = new AuthorizationController();
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private RequestDispatcher dispatcher;

	@Before
	public void before() {
		req = mock(HttpServletRequest.class);
		resp = mock(HttpServletResponse.class);
		dispatcher = mock(RequestDispatcher.class);
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		when(req.getRequestDispatcher(path)).thenReturn(dispatcher);
		servlet.doGet(req, resp);
		verify(req).setAttribute("currentPage", "page/authorization.jsp");
		verify(req, times(1)).getRequestDispatcher(path);
		verify(dispatcher).forward(req, resp);
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		CurrentAccount ñurrentAccount = mock(CurrentAccount.class);
		AccountService accountService = PowerMockito.mock(AccountService.class);
		PowerMockito.when(servlet.getAccountService()).thenReturn(accountService);
		when(req.getParameter(login)).thenReturn(login);
		when(req.getParameter(password)).thenReturn(password);
		when(accountService.authorization(login, password)).thenReturn(ñurrentAccount);
		servlet.doPost(req, resp);
		verify(req, times(1)).getParameter(login);
		verify(req, times(1)).getParameter(password);
		verify(accountService).authorization(login, password);
	}
}
