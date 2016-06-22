package dswBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.LancamentosDinheiro;
import model.Transferencias;
import model.Usuarios;

public class Transferencia {
	
	private Connection myConn;
	private Statement myStmt;
	private int id;
	private CallableStatement myStmtCall;
	private String cpf;
	private String email;
	private String nome;
	private String telefone;
	private String senha;
	private boolean administrador;
	private Date data;
	private int numeroLogins ;
	private Date ultimoLogin;
	private int idOfertaVenda ;
	private int idOfertaCompra;
	private int idUsuario;
	private String token;
	private Date minhaData;
	private String numeroBanco;
	private String numeroAgencia;
	private String numeroConta;
	private float valor;
	private String historico;
	private int operacao ;
	private int idPersonagem;
	private int quantidade;
	private int tipo;
	private float quantidadeOriginal;
	private float precoUnitario;
	private int status;
	private int idOrdemOriginal;
	
	
	public Transferencia(){
		
			super();
		try{
			this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSW", "root" , "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getTransferencia() throws SQLException{
		
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from transferencias");
		while (myRSGetUsuario.next()) {
			id = myRSGetUsuario.getInt("id");
			idUsuario = myRSGetUsuario.getInt("idUsuario");
			java.util.Date minhaData = myRSGetUsuario.getDate("data");
			numeroBanco = myRSGetUsuario.getString("numeroBanco");
			numeroAgencia = myRSGetUsuario.getString("numeroAgencia");
			numeroConta = myRSGetUsuario.getString("numeroConta");
			valor =   myRSGetUsuario.getFloat("valor");
			Transferencias minhaTransferencia= new Transferencias(id,idUsuario,minhaData,numeroBanco,numeroAgencia,numeroConta,valor);
			System.out.println(minhaTransferencia);
		}
		System.out.println();
	}
	
	
	
	
	public ArrayList<LancamentosDinheiro> getLancamentosDinheiro() {

		ArrayList<LancamentosDinheiro> meuUsuarioList = new ArrayList<LancamentosDinheiro>();
		try{
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from lancamentosDinheiro");
		while (myRSGetUsuario.next()) {
			id = myRSGetUsuario.getInt("id");
			idUsuario = myRSGetUsuario.getInt("idUsuario");
			java.util.Date minhaData = myRSGetUsuario.getDate("data");
			historico = myRSGetUsuario.getString("historico");
			valor =   myRSGetUsuario.getFloat("valor");
			operacao = myRSGetUsuario.getInt("operacao");
			LancamentosDinheiro meuLancamentoDinheiro = new LancamentosDinheiro(id,idUsuario,minhaData,historico,valor,operacao);
			meuUsuarioList.add(meuLancamentoDinheiro );
		}
		
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return meuUsuarioList;
	}
	
	
	public void adicionaPersonagem(int id ,int idPersonagem,int quantidade) {
		try{	
			//(IidUsuario int, IidPersonagem int, Iquantidade int)
			CallableStatement myStmt = myConn.prepareCall("{call AdicionarPersonagem(?,?,?)}");
			myStmt.setInt(1,id);
			myStmt.setInt(2,idPersonagem);
			myStmt.setInt(3,quantidade);
			myStmt.execute();	
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public int removerPersonagem(int id ,int idPersonagem,int quantidade) {
		int error= 0;
		try{	
			//(IidUsuario int, IidPersonagem int, Iquantidade int)
			CallableStatement myStmt = myConn.prepareCall("{call RemoverPersonagem(?,?,?,?)}");
			myStmt.setInt(1,id);
			myStmt.setInt(2,idPersonagem);
			myStmt.setInt(3,quantidade);
			myStmt.setInt(4,error);
			
			myStmt.execute();	
			error = myStmt.getInt(4);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error =1;
		}	
		return error;
	}
	
	public void registaTransferencia(int idUsuario,String numeroBanco,String numeroAgencia,String numeroConta, float valor ) {
		try{
			//(IidUsuario INT, Ibanco VARCHAR(3), Iagencia VARCHAR(6), Iconta VARCHAR(10), Ivalor FLOAT)
			CallableStatement myStmt = myConn.prepareCall("{call RegistrarTransferencia(?,?,?,?,?)}");
			myStmt.setInt(1,idUsuario);
			myStmt.setString(2,numeroBanco);
			myStmt.setString(3,numeroAgencia);
			myStmt.setString(4,numeroConta);
			myStmt.setFloat(5,valor);
			myStmt.execute();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

}
