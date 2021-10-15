<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar conta</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="regbox box">
			<img class="avatar" src="img/user.jpg">
			<h1>Registrar uma conta</h1>
			<form action="Registrar" method="post">
				<p>Usuário</p>
				<input type="text" placeholder="Nome" name="nome" required>
				<p>Email</p>
				<input type="text" placeholder="Email" name="email" required>
				<p>Senha</p>
				<input type="password" placeholder="Senha" name="senha" required>
				<input type="submit" value="Registrar" name="botao"> <b>Já
					tem uma conta?</b> <a href="index.jsp"><b> Faça o login.</b></a>
			</form>
		</div>
	</div>
</body>
</html>