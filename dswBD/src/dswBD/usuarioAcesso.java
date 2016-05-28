package dswBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.usuarios;

public class usuarioAcesso {

	private Connection myConn;
	private int id;
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	private boolean administrador;
	private int numeroLogins;
	private Date ultimoLogin;

	public usuarioAcesso() throws SQLException {
		super();
		this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSW", "root", "123456");

	}

	public void getUsuariosTable() throws SQLException {
		usuarios meuUsuario = null;

		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from usuarios");
		while (myRSGetUsuario.next()) {
			id = myRSGetUsuario.getInt("id");
			cpf = myRSGetUsuario.getString("cpf");
			email = myRSGetUsuario.getString("email");
			nome = myRSGetUsuario.getString("nome");
			telefone = myRSGetUsuario.getString("telefone");
			senha = myRSGetUsuario.getString("senha");
			administrador = myRSGetUsuario.getBoolean("administrator");
			ultimoLogin = myRSGetUsuario.getDate("ultimoLogin");
			numeroLogins = myRSGetUsuario.getInt("numeroLogins");
			meuUsuario = new usuarios(id, nome, telefone, cpf, senha, "foto", administrador, ultimoLogin, numeroLogins);
			System.out.println(meuUsuario);
		}
		System.out.println();
	}

	public void setUsuario(String nome, String telefone, String cpf, String email, String senha) throws SQLException {

		CallableStatement myStmtInserirUsuario = myConn.prepareCall("{call inserirUsuario(?,?,?,?,?)}");
		//// ( Inome VARCHAR(80), Itelefone VARCHAR(20), Icpf VARCHAR(14) ,
		//// Iemail VARCHAR(40), Isenha VARCHAR(255))
		myStmtInserirUsuario.setString(1, nome);
		myStmtInserirUsuario.setString(2, telefone);
		myStmtInserirUsuario.setString(3, cpf);
		myStmtInserirUsuario.setString(4, email);
		myStmtInserirUsuario.setString(5, senha);
		myStmtInserirUsuario.execute();

	}

	public void editUsuario(int id, String nome, String telefone, String cpf, String foto) throws SQLException {
		CallableStatement myStmtEditUsuario = myConn.prepareCall("{call EditarUsuario(?,?,?,?,?)}");
		// (IidUsuario INTEGER ,Inome VARCHAR(80), Itelefone VARCHAR(20), Icpf
		// VARCHAR(14), Ifoto blob)

		myStmtEditUsuario.setInt(1, id);
		myStmtEditUsuario.setString(2, nome);
		myStmtEditUsuario.setString(3, telefone);
		myStmtEditUsuario.setString(4, cpf);
		myStmtEditUsuario.setString(5, foto);
		myStmtEditUsuario.execute();
	}

	public void indicaFalha(int id) throws SQLException {
		CallableStatement myStmt = myConn.prepareCall("{call IndicarLoginFalha(?)}");
		myStmt.setInt(1, id);
		myStmt.execute();
	}

	public void indicaSucesso(int id) throws SQLException {
		CallableStatement myStmt = myConn.prepareCall("{call IndicarLoginSucesso(?)}");
		myStmt.setInt(1, 1);
		myStmt.execute();

	}
	
	public void trocaSenha(int id, String senha) throws SQLException{
		CallableStatement myStmtTrocaSenha = myConn.prepareCall("{call TrocarSenha(?,?)}");
		//(IidUsuario int , Isenha VARCHAR(255))
		myStmtTrocaSenha.setInt(1,id);
		myStmtTrocaSenha.setString(2,senha);
		myStmtTrocaSenha.execute();	
	}
	
	public int getIdentificadorUsuario(String email) throws SQLException{
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select id from usuarios Where email='"+email+"'");
		myRSGetUsuario.next();
		return myRSGetUsuario.getInt("id");
	}
	
	
	public int calculaSaldoDisponivelDinheiro(int idUsuario, int saldo) throws SQLException{
		CallableStatement myStmt = myConn.prepareCall("{call CalculaSaldoDisponivelDinheiro(?,?)}");
		myStmt.setInt(1, idUsuario);
		myStmt.registerOutParameter(2,saldo);
		myStmt.execute();
		return myStmt.getInt(2);

	}

	public int calculaSaldoDisponivelPersonagem( int idUsuario,int idPersonagem, int saldo) throws SQLException{
		CallableStatement myStmt = myConn.prepareCall("{call CalculaSaldoDisponivelPersonagem(?,?,?)}");
		myStmt.setInt(1, idUsuario);
		myStmt.setInt(2, idPersonagem);
		myStmt.registerOutParameter(3,saldo);	
		myStmt.execute();
		return myStmt.getInt(3);
	}
	
}
