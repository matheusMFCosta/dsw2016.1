package dswBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.CasamentosOferta;

public class CasamentosAcesso {
	
	private Connection myConn;
	private int idOfertaVenda ;
	private int idOfertaCompra;

	
	
	public CasamentosAcesso(){
		super();
		try{
			this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSW", "root" , "123456");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void casamentoOfertasTable() throws SQLException {
		
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from casamentosOferta");
		while (myRSGetUsuario.next()) {
			idOfertaVenda = myRSGetUsuario.getInt("idOfertaVenda"); 
			idOfertaCompra = myRSGetUsuario.getInt("idOfertaCompra");
			java.util.Date dataExecucao = myRSGetUsuario.getDate("dataExecucao");

			CasamentosOferta meuCasamentoOferta= new CasamentosOferta(idOfertaVenda , idOfertaCompra, dataExecucao);
			System.out.println(meuCasamentoOferta);
		}
		System.out.println();
	}
	
	public ArrayList<CasamentosOferta> getCasamentoOfertas()  {
		ArrayList<CasamentosOferta> meuCasamento = new ArrayList<CasamentosOferta>();
		
		try{	
			Statement myStmtGetusuario = myConn.createStatement();
			ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from casamentosOferta");
			while (myRSGetUsuario.next()) {
				idOfertaVenda = myRSGetUsuario.getInt("idOfertaVenda"); 
				idOfertaCompra = myRSGetUsuario.getInt("idOfertaCompra");
				java.util.Date dataExecucao = myRSGetUsuario.getDate("dataExecucao");
	
				CasamentosOferta meuCasamentoOferta= new CasamentosOferta(idOfertaVenda , idOfertaCompra, dataExecucao);
				meuCasamento.add(meuCasamentoOferta);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return meuCasamento;
	}
	

}
