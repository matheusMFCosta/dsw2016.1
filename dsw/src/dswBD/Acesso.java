package dswBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.CasamentosOferta;
import model.LancamentosDinheiro;
import model.LancamentosPersonagem;
import model.Ofertas;
import model.Personagens;
import model.Tokens;
import model.Transferencias;
import model.Usuarios;

public class Acesso {
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



	
	
	
	public Acesso() throws SQLException {
		super();
		this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSW", "root" , "123456");

	}
	
	public void clearTables() throws SQLException{
		Statement myStmtt = myConn.createStatement();
		myStmtt.execute("SET FOREIGN_KEY_CHECKS = 0");
		myStmtt.execute("truncate table lancamentosPersonagem");
		myStmtt.execute("truncate table lancamentosDinheiro");
		myStmtt.execute("truncate table transferencias");
		myStmtt.execute("truncate table casamentosOferta");
		myStmtt.execute("truncate table ofertas");
		myStmtt.execute("truncate table personagens");
		myStmtt.execute("truncate table tokens");
		myStmtt.execute("truncate table usuarios");
		myStmtt.execute("SET FOREIGN_KEY_CHECKS = 1");

	}
	//------------------------------------------------//
	public int getIdentificadorPersonagem(String nome) throws SQLException{
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select id from personagens Where nome='"+nome+"'");
		myRSGetUsuario.next();
		return myRSGetUsuario.getInt("id");
	}
	
//	public int getIdentificadorUsuario(String email) throws SQLException{
//		Statement myStmtGetusuario = myConn.createStatement();
//		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select id from usuarios Where email='"+email+"'");
//		myRSGetUsuario.next();
//		return myRSGetUsuario.getInt("id");
//	}
	
	//-------------------------------------------------//

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
	
//	public void getUsuariosTable() throws SQLException{
//		usuarios meuUsuario = null;
//
//		
//		Statement myStmtGetusuario = myConn.createStatement();
//		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from usuarios");
//		while (myRSGetUsuario.next()) {
//			id = myRSGetUsuario.getInt("id");
//			cpf = myRSGetUsuario.getString("cpf");
//			email = myRSGetUsuario.getString("email");
//			nome = myRSGetUsuario.getString("nome");
//			telefone = myRSGetUsuario.getString("telefone");
//			senha = myRSGetUsuario.getString("senha");
//			administrador = myRSGetUsuario.getBoolean("administrator");
//			ultimoLogin = myRSGetUsuario.getDate("ultimoLogin");
//			numeroLogins = myRSGetUsuario.getInt("numeroLogins");
//			meuUsuario = new usuarios(id,nome,telefone,cpf,senha,"foto",administrador,ultimoLogin,numeroLogins);
//			System.out.println(meuUsuario);
//		}
//		System.out.println();
//	}

//	public void getTokensTable() throws SQLException{
//
//		
//
//		Statement myStmtGetusuario = myConn.createStatement();
//		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from tokens");
//		while (myRSGetUsuario.next()) {
//			id = myRSGetUsuario.getInt("id");
//			idUsuario = myRSGetUsuario.getInt("idUsuario");
//			token = myRSGetUsuario.getString("token");
//			minhaData = myRSGetUsuario.getDate("validade");
//			tokens meuToken = new tokens(id,idUsuario,token,minhaData);
//			System.out.println(meuToken);
//		}
//		System.out.println();
//	}

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

	public void getLancamentosDinheiro() throws SQLException {

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
			System.out.println(meuLancamentoDinheiro);
		}
		System.out.println();
	}
	
	public void getLancamentosPersonagem() throws SQLException{

		
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from lancamentosPersonagem");
		while (myRSGetUsuario.next()) {
			id = myRSGetUsuario.getInt("id");
			idPersonagem = myRSGetUsuario.getInt("idPersonagem");
			idUsuario = myRSGetUsuario.getInt("idUsuario");
			java.util.Date minhaData = myRSGetUsuario.getDate("data");
			historico = myRSGetUsuario.getString("historico");
			int quantidade = myRSGetUsuario.getInt("quantidade");
			valor =   myRSGetUsuario.getFloat("precoUnitario");
			int operacao = myRSGetUsuario.getInt("operacao");

			LancamentosPersonagem meuLancamentoPersonagem = new LancamentosPersonagem(id,idPersonagem,idUsuario,minhaData,historico,quantidade,valor,operacao);
			System.out.println(meuLancamentoPersonagem);
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
			idUsuario = myRSGetUsuario.getInt("idUsuario");
			java.util.Date minhaData = myRSGetUsuario.getDate("data");
			float quantidade = myRSGetUsuario.getFloat("quantidade");
			quantidadeOriginal = myRSGetUsuario.getFloat("quantidadeOriginal");
			precoUnitario =   myRSGetUsuario.getFloat("precoUnitario");
			status =  myRSGetUsuario.getInt("status");
			idOrdemOriginal = myRSGetUsuario.getInt("idOrdemOriginal");

					
			//Ofertas minhasOfertas = new Ofertas(id, tipo,idPersonagem,idUsuario, minhaData, quantidade, quantidadeOriginal, precoUnitario, status ,  idOrdemOriginal);
			//System.out.println(minhasOfertas);
		}
		System.out.println();
	}
	
	public void casamentoOfertasTable() throws SQLException {
		
		Statement myStmtGetusuario = myConn.createStatement();
		ResultSet myRSGetUsuario = myStmtGetusuario.executeQuery("select * from casamentosOferta");
		while (myRSGetUsuario.next()) {
			int idOfertaVenda = myRSGetUsuario.getInt("idOfertaVenda"); 
			int idOfertaCompra = myRSGetUsuario.getInt("idOfertaCompra");
			java.util.Date dataExecucao = myRSGetUsuario.getDate("dataExecucao");

			CasamentosOferta meuCasamentoOferta= new CasamentosOferta(idOfertaVenda , idOfertaCompra, dataExecucao);
			System.out.println(meuCasamentoOferta);
		}
		System.out.println();
	}
	//-------------------------------------------------//

	public void deBug(String msg,int condicao) throws SQLException{
		CallableStatement  myStmtInserirUsuario = myConn.prepareCall("{call DeBug(?,?)}");
		myStmtInserirUsuario.setString(1,msg);
		myStmtInserirUsuario.setInt(2, condicao);

		myStmtInserirUsuario.execute();
		
	}
	
//	public void setUsuario(String nome,String telefone,String cpf,String email,String senha) throws SQLException{
//		
//	CallableStatement  myStmtInserirUsuario = myConn.prepareCall("{call inserirUsuario(?,?,?,?,?)}");
//	////( Inome VARCHAR(80), Itelefone VARCHAR(20), Icpf VARCHAR(14) , Iemail VARCHAR(40), Isenha VARCHAR(255))
////	myStmtInserirUsuario.setString(1,nome);
////	myStmtInserirUsuario.setString(2,telefone);
////	myStmtInserirUsuario.setString(3,cpf);
////	myStmtInserirUsuario.setString(4,email);
////	myStmtInserirUsuario.setString(5,senha);
////	myStmtInserirUsuario.execute();
////				
////	}
//
//	public void inserirPersonagemTabela(String nome) throws SQLException{
//
//	      String query = " insert into personagens (nome)"
//	    	        + " values (?)";
//	    	      PreparedStatement preparedStmt = (PreparedStatement) myConn.prepareStatement(query);
//	    	      preparedStmt.setString (1,nome);
//	    	      preparedStmt.execute();
//
//					
//		
//	}

//	public void editUsuario(int id,String nome,String telefone,String cpf,String foto) throws SQLException{
//		CallableStatement myStmtEditUsuario = myConn.prepareCall("{call EditarUsuario(?,?,?,?,?)}");
//		//(IidUsuario INTEGER ,Inome VARCHAR(80), Itelefone VARCHAR(20), Icpf VARCHAR(14), Ifoto blob)
//		
//		myStmtEditUsuario.setInt(1,id);
//		myStmtEditUsuario.setString(2,nome);
//		myStmtEditUsuario.setString(3,telefone);
//		myStmtEditUsuario.setString(4,cpf);
//		myStmtEditUsuario.setString(5,foto);
//		myStmtEditUsuario.execute();
//	}

//	public void trocaSenha(int id, String senha) throws SQLException{
//		CallableStatement myStmtTrocaSenha = myConn.prepareCall("{call TrocarSenha(?,?)}");
//		//(IidUsuario int , Isenha VARCHAR(255))
//		myStmtTrocaSenha.setInt(1,id);
//		myStmtTrocaSenha.setString(2,senha);
//		myStmtTrocaSenha.execute();	
//	}

//	public void indicaFalha(int id) throws SQLException{
//		CallableStatement myStmt = myConn.prepareCall("{call IndicarLoginFalha(?)}");
//		myStmt.setInt(1,id);
//		myStmt.execute();
//	}
//	
//	public void indicaSucesso(int id) throws SQLException{
//		CallableStatement myStmt = myConn.prepareCall("{call IndicarLoginSucesso(?)}");
//		myStmt.setInt(1,1);
//		myStmt.execute();
//
//	}

//	public void insereToken(int id,String token,Date validade) throws SQLException{
//		//(IidUsuario VARCHAR(14), Itoken VARCHAR(40), Ivalidade DATE)
//		CallableStatement  myStmt = myConn.prepareCall("{call InserirToken(?,?,?)}");
//		myStmt.setInt(1,id);
//		myStmt.setString(2,token);
//		myStmt.setDate(3,(java.sql.Date) validade);
//		myStmt.execute();	
//
//	}

	public void registaTransferencia(int idUsuario,String numeroBanco,String numeroAgencia,String numeroConta, float valor ) throws SQLException{
		//(IidUsuario INT, Ibanco VARCHAR(3), Iagencia VARCHAR(6), Iconta VARCHAR(10), Ivalor FLOAT)
		CallableStatement myStmt = myConn.prepareCall("{call RegistrarTransferencia(?,?,?,?,?)}");
		myStmt.setInt(1,idUsuario);
		myStmt.setString(2,numeroBanco);
		myStmt.setString(3,numeroAgencia);
		myStmt.setString(4,numeroConta);
		myStmt.setFloat(5,valor);
		myStmt.execute();
	}

	public void adicionaPersonagem(int id ,int idPersonagem,int quantidade) throws SQLException{
		//(IidUsuario int, IidPersonagem int, Iquantidade int)
		CallableStatement myStmt = myConn.prepareCall("{call AdicionarPersonagem(?,?,?)}");
		myStmt.setInt(1,id);
		myStmt.setInt(2,idPersonagem);
		myStmt.setInt(3,quantidade);
		myStmt.execute();	
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

	public void executaCompraIgualVenda(java.util.Date agora,int idPersonagem, int idCompra, int idUsuarioComprador, int QuantidadeCompra, int IdVenda, int IdUsuarioVendedor, int QuantidadeVenda, float PrecoVenda, float PrecoCompra) throws SQLException{
		
		CallableStatement myStmt = myConn.prepareCall("{call ExecutaCompraIgualVenda(?,?,?,?,?,?,?,?,?,?)}");
		myStmt.setDate(1,(java.sql.Date) agora);
		myStmt.setInt(2,idPersonagem);
		myStmt.setInt(3,idCompra);
		myStmt.setInt(4,idUsuarioComprador);
		myStmt.setInt(5,QuantidadeCompra);
		myStmt.setInt(6,IdVenda);
		myStmt.setInt(7,IdUsuarioVendedor);
		myStmt.setInt(8,QuantidadeVenda);
		myStmt.setFloat(9,PrecoVenda );
		myStmt.setFloat(10,PrecoCompra);
		myStmt.execute();
	}
	
	public void executaCompraMaiorVenda(java.util.Date agora,int idPersonagem, int idCompra, int idUsuarioComprador, int QuantidadeCompra, int IdVenda, int IdUsuarioVendedor, int QuantidadeVenda, float PrecoVenda, float PrecoCompra,int error) throws SQLException{
		
		CallableStatement myStmt = myConn.prepareCall("{call ExecutaCompraMaiorVenda(?,?,?,?,?,?,?,?,?,?,?)}");
		myStmt.setDate(1,(java.sql.Date) agora);
		myStmt.setInt(2,idPersonagem);
		myStmt.setInt(3,idCompra);
		myStmt.setInt(4,idUsuarioComprador);
		myStmt.setInt(5,QuantidadeCompra);
		myStmt.setInt(6,IdVenda);
		myStmt.setInt(7,IdUsuarioVendedor);
		myStmt.setInt(8,QuantidadeVenda);
		myStmt.setFloat(9,PrecoVenda );
		myStmt.setFloat(10,PrecoCompra);
		myStmt.setInt(11, error);
		myStmt.execute();
	}

	public void executaVendaMaiorCompra(java.util.Date agora,int idPersonagem, int idCompra, int idUsuarioComprador, int QuantidadeCompra, int IdVenda, int IdUsuarioVendedor, int QuantidadeVenda, float PrecoVenda, float PrecoCompra) throws SQLException{
		
		CallableStatement myStmt = myConn.prepareCall("{call ExecutaVendaMaiorCompra(?,?,?,?,?,?,?,?,?,?)}");
		myStmt.setDate(1,(java.sql.Date) agora);
		myStmt.setInt(2,idPersonagem);
		myStmt.setInt(3,idCompra);
		myStmt.setInt(4,idUsuarioComprador);
		myStmt.setInt(5,QuantidadeCompra);
		myStmt.setInt(6,IdVenda);
		myStmt.setInt(7,IdUsuarioVendedor);
		myStmt.setInt(8,QuantidadeVenda);
		myStmt.setFloat(9,PrecoVenda );
		myStmt.setFloat(10,PrecoCompra);
		myStmt.execute();
	}

	public void executaOrdens(java.util.Date agora,int idPersonagem, int idCompra, int idUsuarioComprador, int QuantidadeCompra, int IdVenda, int IdUsuarioVendedor, int QuantidadeVenda, float PrecoVenda, float PrecoCompra,int error) throws SQLException{
		CallableStatement myStmt = myConn.prepareCall("{call ExecutaOrdens(?,?,?,?,?,?,?,?,?,?,?)}");
		myStmt.setDate(1,(java.sql.Date) agora);
		myStmt.setInt(2,idPersonagem);
		myStmt.setInt(3,idCompra);
		myStmt.setInt(4,idUsuarioComprador);
		myStmt.setInt(5,QuantidadeCompra);
		myStmt.setInt(6,IdVenda);
		myStmt.setInt(7,IdUsuarioVendedor);
		myStmt.setInt(8,QuantidadeVenda);
		myStmt.setFloat(9,PrecoVenda );
		myStmt.setFloat(10,PrecoCompra);
		myStmt.setInt(11, error);
		myStmt.execute();
	}
		
	public void executaLiquidacao(java.util.Date agora,int idPersonagem, int idCompra, int idUsuarioComprador, int QuantidadeCompra, int IdVenda, int IdUsuarioVendedor, int QuantidadeVenda, float PrecoVenda, float PrecoCompra,int QuantidadeNegociada) throws SQLException{
		CallableStatement myStmt = myConn.prepareCall("{call ExecutaLiquidacao(?,?,?,?,?,?,?,?,?,?)}");
		myStmt.setDate(1,(java.sql.Date) agora);
		myStmt.setInt(2,idPersonagem);
		myStmt.setInt(3,idCompra);
		myStmt.setInt(4,idUsuarioComprador);
		myStmt.setInt(5,QuantidadeCompra);
		myStmt.setFloat(6,PrecoCompra);
		myStmt.setInt(7,IdVenda);
		myStmt.setInt(8,IdUsuarioVendedor);
		myStmt.setInt(9,QuantidadeVenda);
		myStmt.setFloat(10,PrecoVenda );
		myStmt.setInt(11, QuantidadeNegociada);

		myStmt.execute();
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
