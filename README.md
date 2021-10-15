# DynamicWebProject

This is a JSP Login Authentication Web Application. Created with Eclipse and SQL Developer

It contains a Login, Registration and Welcome page. The login requires a username (email) and password. New Users may Register and will then be redirected to login.The welcome page is created with the logged in users session.

Java Servlet was used with Apache Tomcat rather than Spring Technologies included: JQuery, Html, Css, Java, Jsp, Sql Developer

## Preview
![Preview](/Preview.png)

### Getting Started

Run the project with [Apache Tomcat](https://tomcat.apache.org/download-90.cgi). To sync to the database, go to the [Connection](https://github.com/Math-Barros/DynamicWebLogin/blob/master/src/main/java/br/fiap/conexao/Conexao.java) class. 

You need to insert your database configurations:

```
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static final String USUARIO = "";
	private static final String SENHA = "";
```
