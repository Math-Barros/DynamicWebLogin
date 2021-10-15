package br.fiap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.fiap.dao.UserDAO;

@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String WELCMPG = "/home.jsp";
	private UserDAO dao;

	public LoginServlet() {
		super();
		dao = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pwOut = response.getWriter();

		String em = request.getParameter("email");
		String pw = request.getParameter("senha");

		// Validate Login with input
		if (dao.Login(em, pw)) {
			// create session and store variables

			HttpSession session = request.getSession();
			session.setAttribute("email", em);

			RequestDispatcher view = request.getRequestDispatcher(WELCMPG);
			view.forward(request, response);

		}

		else {
			pwOut.print("<p style=\"color:red\">Incorrect Username or Password!</p>");
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.include(request, response);

		}

		pwOut.close();

	}
}
