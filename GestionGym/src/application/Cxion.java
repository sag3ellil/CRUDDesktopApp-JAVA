package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cxion {
	Connection conn=null;
	public Cxion() {

		String serveurBD = "jdbc:mysql://127.0.0.1:3306/bd1?autoReconnect=true&useSSL=false";
		String login = "root";
		String motPasse = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(serveurBD, login, motPasse);

		} catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Execption");
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void inscri_parti() {

	}
}



