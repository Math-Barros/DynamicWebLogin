package br.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.UserDAO;
import br.fiap.entidade.User;

@WebServlet("/Registrar")
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	public UserServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String botao = request.getParameter("botao");
		UserDAO dao = new UserDAO();

		if (botao.equalsIgnoreCase("listar")) {
			List<User> lista = dao.listar();
			request.setAttribute("lista", lista);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else {

			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			boolean sucesso = dao.cadastrar(new User(nome, email, senha));
			if (sucesso) {
				request.setAttribute("nome", nome);
				dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
