package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.User;

public class UserDAO {

	private Connection connection;
	private PreparedStatement ps;
	private String sql;
	private ResultSet rs;

	public UserDAO() {
		connection = Conexao.getConnection();
	}

	public List<User> listar() {
		List<User> lista = new ArrayList<User>();
		sql = "select + from java_user";

		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new User(rs.getString("cpf"), rs.getString("nome"), rs.getString("fone")));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao listar users\n" + e);
			e.printStackTrace();
		}
		return lista;

	}

	public boolean cadastrar(User user) {
		boolean sucesso = false;
		sql = "insert into java_user values(?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getSenha());
			ps.setString(3, user.getEmail());
			ps.execute();
			sucesso = true;
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar user\n" + e);
			e.printStackTrace();
		}
		return sucesso;
	}

	public boolean Login(String em, String pw) {
		boolean canLogin = false;

		// Search database for email and password and return true if found
		try {
			PreparedStatement ps = connection.prepareStatement("select * from java_user where email=? and senha=?");
			ps.setString(1, em);
			ps.setString(2, pw);

			ResultSet rs = ps.executeQuery();
			canLogin = rs.next(); // true if found else false
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return canLogin;
	}

	public void alterar(User user) {
		sql = "update java_user set nome = ?, senha = ?, email = ? where email = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getSenha());
			ps.setString(3, user.getEmail());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public User pesquisar(String email) {
		User user = null;
		sql = "select * from java_user where email = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("nome"), rs.getString("senha"), email);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void remover(String email) {
		sql = "delete from java_user where email = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
