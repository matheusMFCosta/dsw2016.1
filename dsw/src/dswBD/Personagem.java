package dswBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import model.Personagens;
import model.Usuarios;

public class Personagem {
	
	private Connection myConn;
	private int id;
	private String nome;

	
	
	public Personagem()  {
		super();
		try{
			this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSW", "root" , "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public int getIdentificadorPersonagem(String nome) throws SQLException{
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select id from personagens Where nome='"+nome+"'");
		myRSGetUsuario.next();
		return myRSGetUsuario.getInt("id");
	}
	
	public ArrayList<Personagens> getPersonagensTable()  {
		
		ArrayList<Personagens> meuPersonagemList = new ArrayList<Personagens>();
		try{
			Statement myStmtGetusuario = myConn.createStatement();
			ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from personagens");
			while (myRSGetUsuario.next()) {
				id = myRSGetUsuario.getInt("id");
				nome = myRSGetUsuario.getString("nome");
				Personagens meuPersonagem = new Personagens(id,nome);
				meuPersonagemList.add(meuPersonagem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meuPersonagemList;
	}
	
	public Personagens getPersonagem(int id){
		
		Personagens meuPersonagem = null;
		try{
			Statement myStmtGetusuario = myConn.createStatement();
			ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from personagens where id="+id);
			while (myRSGetUsuario.next()) {
				id = myRSGetUsuario.getInt("id");
				nome = myRSGetUsuario.getString("nome");
				meuPersonagem = new Personagens(id,nome);
				return meuPersonagem;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meuPersonagem;
		
	}
	
	
	public void inserirPersonagemTabela(String nome) {
		try{
		      String query = " insert into personagens (nome)"
		    	        + " values (?)";
		    	      PreparedStatement preparedStmt = (PreparedStatement) myConn.prepareStatement(query);
		    	      preparedStmt.setString (1,nome);
		    	      preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
