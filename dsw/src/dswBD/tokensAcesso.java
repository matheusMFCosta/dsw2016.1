package dswBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.tokens;

public class tokensAcesso {
	
	private Connection myConn;
	private int id;
	private int idUsuario;
	private String token;
	private Date minhaData;

	
	public tokensAcesso() throws SQLException {
		super();
		this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSW", "root" , "123456");

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
	
	public void insereToken(int id,String token,Date validade) throws SQLException{
		//(IidUsuario VARCHAR(14), Itoken VARCHAR(40), Ivalidade DATE)
		CallableStatement  myStmt = myConn.prepareCall("{call InserirToken(?,?,?)}");
		myStmt.setInt(1,id);
		myStmt.setString(2,token);
		myStmt.setDate(3,(java.sql.Date) validade);
		myStmt.execute();	

	}

}
