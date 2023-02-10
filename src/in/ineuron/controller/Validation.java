package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		System.out.println(userName + " " + passWord);

		RequestDispatcher requestDispatcher = null;
		if (userName.equalsIgnoreCase("Sagarbv") && passWord.equals("sag")) {

			requestDispatcher = request.getRequestDispatcher("/success.jsp");
			requestDispatcher.forward(request, response);
		} else {
			ServletContext servletContext = request.getServletContext();
			requestDispatcher = servletContext.getRequestDispatcher("/error.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
