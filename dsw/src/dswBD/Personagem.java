package dswBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import model.Personagens;

public class Personagem {
	
	private Connection myConn;
	private int id;
	private String nome;

	
	
	public Personagem() throws SQLException {
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
			Personagens meuPersonagem = new Personagens(id,nome);
			System.out.println(meuPersonagem);
		}
		System.out.println();
	}
	
	public void inserirPersonagemTabela(String nome) throws SQLException{

	      String query = " insert into personagens (nome)"
	    	        + " values (?)";
	    	      PreparedStatement preparedStmt = (PreparedStatement) myConn.prepareStatement(query);
	    	      preparedStmt.setString (1,nome);
	    	      preparedStmt.execute();

	}
	

}
