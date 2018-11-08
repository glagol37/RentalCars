package net.rentalcars.exception;

import javax.servlet.http.HttpServletResponse;

public class PreconditionFailedException extends AbstractApplicationException{

	private static final long serialVersionUID = 6785549639325517213L;

	public PreconditionFailedException(String s) {
		super(s, HttpServletResponse.SC_PRECONDITION_FAILED);
	}

}
