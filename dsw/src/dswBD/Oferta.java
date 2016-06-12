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
import model.Ofertas;
import model.Usuarios;

public class Oferta {
	
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
	
	
	public Oferta(){
		super();
		try{
			this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSW", "root" , "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void getCasamentosOfertaTable() throws SQLException{
		

		CasamentosOferta casamento;
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from casamentosOferta");
		while (myRSGetUsuario.next()) {
			idOfertaVenda = myRSGetUsuario.getInt("idOfertaVenda");
			idOfertaCompra = myRSGetUsuario.getInt("idOfertaCompra");
			data = myRSGetUsuario.getDate("dataExecucao");
			casamento = new CasamentosOferta (idOfertaVenda,idOfertaCompra,data);
			System.out.println(casamento);
		}
		System.out.println();
		
	}
	
public ArrayList<Ofertas>  getOfertasTable() {
		
		ArrayList<Ofertas> meuUsuarioList = new ArrayList<Ofertas>();
		try{
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
				Ofertas minhasOfertas = new Ofertas(id, tipo,idPersonagem,idUsuario, minhaData, quantidade, quantidadeOriginal, precoUnitario, status ,  idOrdemOriginal);
				meuUsuarioList.add(minhasOfertas);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meuUsuarioList;
	}
	
public ArrayList<Ofertas>  getUserOfertasVendaTable(int id) {
	
	ArrayList<Ofertas> meuUsuarioList = new ArrayList<Ofertas>();
	try{
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from ofertas where idUsuario="+id+ " AND tipo=0");
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
			Ofertas minhasOfertas = new Ofertas(id, tipo,idPersonagem,idUsuario, minhaData, quantidade, quantidadeOriginal, precoUnitario, status ,  idOrdemOriginal);
			meuUsuarioList.add(minhasOfertas);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return meuUsuarioList;
}

	public ArrayList<Ofertas>  getUserOfertasCompraTable(int id) {
		
		ArrayList<Ofertas> meuUsuarioList = new ArrayList<Ofertas>();
		try{
			Statement myStmtGetusuario = myConn.createStatement();
			ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from ofertas where idUsuario="+id+ " AND tipo=1");
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
				Ofertas minhasOfertas = new Ofertas(id, tipo,idPersonagem,idUsuario, minhaData, quantidade, quantidadeOriginal, precoUnitario, status ,  idOrdemOriginal);
				meuUsuarioList.add(minhasOfertas);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meuUsuarioList;
	}
	
	
	
	public Ofertas  getOferta(int id) {
		
		try{
			Statement myStmtGetusuario = myConn.createStatement();
			ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from ofertas where id="+id);
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
				Ofertas minhasOfertas = new Ofertas(id, tipo,idPersonagem,idUsuario, minhaData, quantidade, quantidadeOriginal, precoUnitario, status ,  idOrdemOriginal);
				return minhasOfertas;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public void registraOrdemCompra(int idusuario ,int idPersonagem,int quantidade,float precoUnitario,int error){
		try{ 
			CallableStatement myStmt = myConn.prepareCall("{call RegistraOrdemCompra(?,?,?,?,?)}");
			myStmt.setInt(1,idusuario );
			myStmt.setInt(2,idPersonagem);
			myStmt.setInt(3,quantidade);
			myStmt.setFloat(4,precoUnitario);
			myStmt.setInt(5,error);
			myStmt.execute();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int registraOrdemVenda(int idusuario ,int idPersonagem,int quantidade,float precoUnitario,int error) {
		int erro = 0;
		try{
			CallableStatement myStmt = myConn.prepareCall("{call RegistraOrdemVenda(?,?,?,?,?)}");
			myStmt.setInt(1,idusuario);
			myStmt.setInt(2,idPersonagem);
			myStmt.setInt(3,quantidade);
			myStmt.setFloat(4,precoUnitario);
			myStmt.registerOutParameter(5,error);
			myStmt.execute();
			
			
			erro = myStmt.getInt(5);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return erro;
	}
	
	
	public void cancelaOrdemCompra(int idCompra) {
		try{	
			CallableStatement myStmt = myConn.prepareCall("{call CancelaOrdemVenda(?)}");
			myStmt.setInt(1, idCompra);
			myStmt.execute();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CancelaOrdemVenda(int idVenda){
		try{	
			CallableStatement myStmt = myConn.prepareCall("{call CancelaOrdemVenda(?)}");
			myStmt.setInt(1, idVenda);
			myStmt.execute();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
