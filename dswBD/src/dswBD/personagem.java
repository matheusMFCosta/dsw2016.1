package dswBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.personagens;

public class personagem {
	
	private Connection myConn;
	private int id;
	private String nome;

	
	
	public personagem() throws SQLException {
		super();
		this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSW", "root" , "123456");

	}
	
	public int getIdentificadorPersonagem(String nome) throws SQLException{
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select id from personagens Where nome='"+nome+"'");
		myRSGetUsuario.next();
		return myRSGetUsuario.getInt("id");
	}
	
	public void getPersonagensTable() throws SQLException {

		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from personagens");
		while (myRSGetUsuario.next()) {
			id = myRSGetUsuario.getInt("id");
			nome = myRSGetUsuario.getString("nome");
			personagens meuPersonagem = new personagens(id,nome);
			System.out.println(meuPersonagem);
		}
		System.out.println();
	}
	
	

}
