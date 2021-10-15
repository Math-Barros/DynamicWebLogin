<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="regbox box">
			<img class="avatar" src="img/user.jpg">
			<h1>Login</h1>
			<form action="Login" method="post">

				<p>Email</p>
				<input type="text" placeholder="Email" name="email" required>
				<p>Senha</p>
				<input type="password" placeholder="Senha" name="senha" required>
				<input type="submit" value="Login" name="botao"> <b> <a
					href="registro.jsp"> Criar uma conta</a> <br> <a
					href="senha.jsp">Esqueceu sua Senha?</a></b>

			</form>
		</div>
	</div>
</body>
</html>