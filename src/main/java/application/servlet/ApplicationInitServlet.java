package application.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import application.ApplicationContextHolder;

public class ApplicationInitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		try {
			ApplicationContextHolder.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		super.init();
	}
	
	
}
