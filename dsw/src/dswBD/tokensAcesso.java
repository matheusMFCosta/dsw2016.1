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

import model.tokens;
import model.usuarios;

public class tokensAcesso {
	
	private Connection myConn;
	private int id;
	private int idUsuario;
	private String token;
	private Date minhaData;

	
	public tokensAcesso() throws SQLException {
	super();
	try{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSW", "root" , "123456");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	public void getTokensTable() throws SQLException{

		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from tokens");
		while (myRSGetUsuario.next()) {
			id = myRSGetUsuario.getInt("id");
			idUsuario = myRSGetUsuario.getInt("idUsuario");
			token = myRSGetUsuario.getString("token");
			minhaData = myRSGetUsuario.getDate("validade");
			tokens meuToken = new tokens(id,idUsuario,token,minhaData);
			System.out.println(meuToken);
		}
		System.out.println();
	}
	
	public void insereToken(int id,String token,java.sql.Date validade) throws SQLException{
		try{
			//(IidUsuario VARCHAR(14), Itoken VARCHAR(40), Ivalidade DATE)
			CallableStatement  myStmt = myConn.prepareCall("{call InserirToken(?,?,?)}");
			myStmt.setInt(1,id);
			myStmt.setString(2,token);
			myStmt.setDate(3, validade);
			myStmt.execute();	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void inserirTokenTabela(int idUsuario,String token,Date data) throws SQLException{
		
		
		  System.out.println("asdasdasdsadsad");
	      String query = " insert into personagens (nome)"
	    	        + " values (?,?,?)";
	    	      PreparedStatement preparedStmt = (PreparedStatement) myConn.prepareStatement(query);
	    	      preparedStmt.setInt (1,idUsuario);
	    	      preparedStmt.setString (2,token);
	    	      preparedStmt.setDate (3,(java.sql.Date) data);
	    	      preparedStmt.execute();

	}
	
	
	
	public ArrayList<tokens>  getTokens() throws SQLException{

		ArrayList<tokens> meuTokenList = new ArrayList<tokens>();
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from tokens");
		while (myRSGetUsuario.next()) {
			id = myRSGetUsuario.getInt("id");
			idUsuario = myRSGetUsuario.getInt("idUsuario");
			token = myRSGetUsuario.getString("token");
			minhaData = myRSGetUsuario.getDate("validade");
			tokens meuToken = new tokens(id,idUsuario,token,minhaData);
			meuTokenList.add(meuToken);
			
		}
		return meuTokenList;
	}
	
	public ArrayList<tokens>  getUserTokens(int InIdUsuario) {
		try{
			ArrayList<tokens> meuTokenList = new ArrayList<tokens>();
			Statement myStmtGetusuario = myConn.createStatement();
			ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from tokens Where idUsuario = "+InIdUsuario);
			while (myRSGetUsuario.next()) {
				id = myRSGetUsuario.getInt("id");
				idUsuario = myRSGetUsuario.getInt("idUsuario");
				token = myRSGetUsuario.getString("token");
				minhaData = myRSGetUsuario.getDate("validade");
				tokens meuToken = new tokens(id,idUsuario,token,minhaData);
				meuTokenList.add(meuToken);
			}
			return meuTokenList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}
