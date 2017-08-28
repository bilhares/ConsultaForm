package br.com.psg.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String url;
	String dataBaseName;
	String dataBaseNameProd;
	String user;
	String password;
	Connection conn;

	public ConnectionFactory() {
		this.url = "";
		this.dataBaseName = "";
		this.dataBaseNameProd = "";
		this.user = "";
		this.password = "";
	}

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(this.url+"DatabaseName="+this.dataBaseName, this.user, this.password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Connection getConnectionProducao(){
		try {
			return DriverManager.getConnection(this.url+"DatabaseName="+this.dataBaseNameProd, this.user, this.password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws Exception{
		Connection con = new ConnectionFactory().getConnectionProducao();
		System.out.println("Conexão aberta");
		con.close();
	}

}
