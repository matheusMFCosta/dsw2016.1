package dswBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.casamentosOferta;
import model.ofertas;

public class oferta {
	
	private Connection myConn;
	private int id;
	private Date data;
	private int idOfertaVenda ;
	private int idOfertaCompra;
	private int idPersonagem;
	private int tipo;
	private float quantidadeOriginal;
	private float precoUnitario;
	private int status;
	private int idOrdemOriginal;
	
	
	public oferta() throws SQLException {
		super();
		this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSW", "root" , "123456");
	}
	
	
	public void getCasamentosOfertaTable() throws SQLException{
		

		casamentosOferta casamento;
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from casamentosOferta");
		while (myRSGetUsuario.next()) {
			idOfertaVenda = myRSGetUsuario.getInt("idOfertaVenda");
			idOfertaCompra = myRSGetUsuario.getInt("idOfertaCompra");
			data = myRSGetUsuario.getDate("dataExecucao");
			casamento = new casamentosOferta (idOfertaVenda,idOfertaCompra,data);
			System.out.println(casamento);
		}
		System.out.println();
		
	}
	

	
	public void getOfertasTable() throws SQLException {
		
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from ofertas");
		while (myRSGetUsuario.next()) {
			id = myRSGetUsuario.getInt("id");
			tipo = myRSGetUsuario.getInt("tipo"); 
			idPersonagem = myRSGetUsuario.getInt("idPersonagem");
			int idUsuario = myRSGetUsuario.getInt("idUsuario");
			java.util.Date minhaData = myRSGetUsuario.getDate("data");
			float quantidade = myRSGetUsuario.getFloat("quantidade");
			quantidadeOriginal = myRSGetUsuario.getFloat("quantidadeOriginal");
			precoUnitario =   myRSGetUsuario.getFloat("precoUnitario");
			status =  myRSGetUsuario.getInt("status");
			idOrdemOriginal = myRSGetUsuario.getInt("idOrdemOriginal");
			
			//(int id, int tipo, int idPersonagem, int idUsuario, java.util.Date data, float ,float , float , int , int)
			ofertas minhasOfertas = new ofertas(id, tipo,idPersonagem,idUsuario, minhaData, quantidade, quantidadeOriginal, precoUnitario, status ,  idOrdemOriginal);
			System.out.println(minhasOfertas);
		}
		System.out.println();
	}
	
	public void registraOrdemCompra(int idusuario ,int idPersonagem,int quantidade,float precoUnitario,int error) throws SQLException{
		CallableStatement myStmt = myConn.prepareCall("{call RegistraOrdemCompra(?,?,?,?,?)}");
		myStmt.setInt(1,idusuario );
		myStmt.setInt(2,idPersonagem);
		myStmt.setInt(3,quantidade);
		myStmt.setFloat(4,precoUnitario);
		myStmt.setInt(5,error);
		myStmt.execute();		
	}
	
	public int registraOrdemVenda(int idusuario ,int idPersonagem,int quantidade,float precoUnitario,int error) throws SQLException{
		CallableStatement myStmt = myConn.prepareCall("{call RegistraOrdemVenda(?,?,?,?,?)}");
		myStmt.setInt(1,idusuario);
		myStmt.setInt(2,idPersonagem);
		myStmt.setInt(3,quantidade);
		myStmt.setFloat(4,precoUnitario);
		myStmt.registerOutParameter(5,error);
		myStmt.execute();
		
		
		int erro = myStmt.getInt(5);
			
		return erro;
		
	}
	
	
	public void cancelaOrdemCompra(int idCompra) throws SQLException{
		CallableStatement myStmt = myConn.prepareCall("{call CancelaOrdemVenda(?)}");
		myStmt.setInt(1, idCompra);
		myStmt.execute();
	}

	public void CancelaOrdemVenda(int idVenda) throws SQLException{
		CallableStatement myStmt = myConn.prepareCall("{call CancelaOrdemVenda(?)}");
		myStmt.setInt(1, idVenda);
		myStmt.execute();
	}
	
	

}
