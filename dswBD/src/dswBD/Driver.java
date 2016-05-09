package dswBD;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.mysql.fabric.xmlrpc.base.Data;

import model.personagens;
import model.tokens;
import model.transferencias;
import model.usuarios;

import java.sql.*;

public class Driver {
	

	public static void Caso1() throws SQLException{
		
		acesso meuAcesso = new acesso();
		Scanner newScanner = new Scanner(System.in);
		meuAcesso.clearTables();
		
		System.out.println("Insere usuario- Mathues");
		newScanner.next();
		meuAcesso.setUsuario("matheus", "34845190", "11905949600", "mf.costa@live.com", "minhaSenha");
		meuAcesso.getUsuariosTable();
		
		int idUsuario = meuAcesso.getIdentificadorUsuario("mf.costa@live.com");
		
		System.out.println("Edita usuario - telefone para 999");
		newScanner.next();
		meuAcesso.editUsuario(idUsuario, "matheus", "9999", "11905949690", "foto");
		meuAcesso.getUsuariosTable();
		
		System.out.println("Troca senha- para wooooo");
		newScanner.next();
		meuAcesso.trocaSenha(idUsuario, "wooooo");
		meuAcesso.getUsuariosTable();
		
		System.out.println("Indica falha");
		newScanner.next();
		meuAcesso.indicaFalha(idUsuario);
		meuAcesso.getUsuariosTable();
		
		System.out.println("indica sucesso");
		newScanner.next();
		meuAcesso.indicaSucesso(idUsuario);
		meuAcesso.getUsuariosTable();
		
		System.out.println("set token- meuToken");
		newScanner.next();
		meuAcesso.insereToken(idUsuario, "meutoken", new java.sql.Date(0));
		meuAcesso.getTokensTable();
		
		
		
	}
	
	public static void Caso2() throws SQLException{
		int error =-1;	
		acesso meuAcesso = new acesso();
		Scanner newScanner = new Scanner(System.in);
		meuAcesso.clearTables();

		
		System.out.println("Caso 1 - Registro Venda");
		//		-- Insere o vendedor 
		System.out.println("Insere Vendedor - Marcio");
		newScanner.next();
		meuAcesso.setUsuario("Marcio", "", "", "marcio.barros@gmail.com", "");
		meuAcesso.getUsuariosTable();	
		
		//		-- Pega o identificador do vendedor
		int idUsuario = meuAcesso.getIdentificadorUsuario("marcio.barros@gmail.com");
	
		//		-- Insere o personagem vendido
		System.out.println("Insere Personagem- Mikey");
		newScanner.next();
		meuAcesso.inserirPersonagemTabela("MICKEY");
		meuAcesso.getPersonagensTable();
		
		//		-- Pega o identificador do personagem vendido
		int idPersonagem = meuAcesso.getIdentificadorPersonagem("MICKEY");
		
		//		-- credita a conta de personagem do vendedor
		System.out.println("Credita personagem na conta - IdUsuario: "+idUsuario+"idPersonamge: "+idPersonagem);
		newScanner.next();
		meuAcesso.adicionaPersonagem(idUsuario, idPersonagem, 1000);
		meuAcesso.getLancamentosPersonagem();
		
		// verifica se o saldo do ativo no vendedor está correto
		System.out.println("verifica se o saldo do ativo no vendedor está correto");
		newScanner.next();
		System.out.println("saldo: "+ meuAcesso.calculaSaldoDisponivelPersonagem(idUsuario, idPersonagem, 0));
		
		
		//		-- registra uma oferta de venda
		System.out.println("Registra oferta de venda e verifica se a oferta de venda foi registrada");
		newScanner.next();
		error = meuAcesso.registraOrdemVenda(idUsuario, idPersonagem, 1000,100, error);
		meuAcesso.deBug("teste",error);
		
		meuAcesso.getOfertasTable();
		
		System.out.println("verifica se nao foi gerado outro lançamento para o vendedor e verifica se foi realizado o bloqueio do ativo no vendedor");
		newScanner.next();
		meuAcesso.getLancamentosPersonagem();
		
		// verifica se o saldo do ativo no vendedor está correto
		System.out.println("verifica se o saldo do ativo no vendedor está correto");
		newScanner.next();
		System.out.println("saldo: "+ meuAcesso.calculaSaldoDisponivelPersonagem(idUsuario, idPersonagem, 0));
		

	} 
	
	public static void Caso3() throws SQLException {
		
		System.out.println("Caso 2 - Registro Compra ");
		
		int error =-1;
		acesso meuAcesso = new acesso();
		Scanner newScanner = new Scanner(System.in);
		meuAcesso.clearTables();
		
		//		-- Insere o vendedor 
		System.out.println("Insere Vendedor - Marcio");
		newScanner.next();
		meuAcesso.setUsuario("Marcio", "", "", "marcio.barros@gmail.com", "");
		meuAcesso.getUsuariosTable();	
		
		//		-- Pega o identificador do vendedor
		int idUsuario = meuAcesso.getIdentificadorUsuario("marcio.barros@gmail.com");
		
		//		-- Insere o personagem vendido
		System.out.println("Insere Personagem- Mikey");
		newScanner.next();
		meuAcesso.inserirPersonagemTabela("MICKEY");
		meuAcesso.getPersonagensTable();
		
		//		-- Pega o identificador do personagem vendido
		int idPersonagem = meuAcesso.getIdentificadorPersonagem("MICKEY");
		
		

		//-- credita a conta de moeda do comprador
		System.out.println("credita a conta de moeda do comprador");
		newScanner.next();
		meuAcesso.registaTransferencia(idUsuario, "123", "123", "123", 100000);
		meuAcesso.getLancamentosDinheiro();

		//-- registra uma oferta de compra
		System.out.println("-- registra uma oferta de compra e verifica se a oferta de compra esta aberta");
		newScanner.next();
		meuAcesso.registraOrdemCompra(idUsuario, idPersonagem, 100, 90 , error);
		meuAcesso.getOfertasTable();


		//-- verifica se o saldo do ativo no comprador está correto
		System.out.println("-- verifica se o saldo do ativo no comprador está correto");
		newScanner.next();
		System.out.println("Saldo: "+meuAcesso.calculaSaldoDisponivelDinheiro(idUsuario, 0));


	}
	
	public static void Caso4() throws SQLException{
		
		int error =-1;
		acesso meuAcesso = new acesso();
		Scanner newScanner = new Scanner(System.in);
		meuAcesso.clearTables();
		
		//		-- Insere o vendedor 
		System.out.println("Insere Vendedor - Marcio");
		newScanner.next();
		meuAcesso.setUsuario("Marcio", "1", "1", "marcio.barros@gmail.com", "1");
		meuAcesso.getUsuariosTable();	
		
		//		-- Pega o identificador do vendedor
		int idVendedor = meuAcesso.getIdentificadorUsuario("marcio.barros@gmail.com");
		
		//		-- Insere o Comprador 
		System.out.println("Insere Comprador - Matheus");
		newScanner.next();
		meuAcesso.setUsuario("Matheus", "2", "2", "mf.costa@live.com", "2");
		meuAcesso.getUsuariosTable();	
		
		//		-- Pega o identificador do vendedor
		int idComprador = meuAcesso.getIdentificadorUsuario("mf.costa@live.com");
		
		//		-- Insere o personagem vendido
		System.out.println("Insere Personagem- Mikey");
		newScanner.next();
		meuAcesso.inserirPersonagemTabela("MICKEY");
		meuAcesso.getPersonagensTable();
		
		//		-- Pega o identificador do personagem vendido
		int idPersonagem = meuAcesso.getIdentificadorPersonagem("MICKEY");
		


		//-- credita a conta de ativo do vendedor
		System.out.println("credita a conta de ativo do vendedor ");
		newScanner.next();
		meuAcesso.adicionaPersonagem(idVendedor, idPersonagem, 1000);
		meuAcesso.getLancamentosPersonagem();

		//-- credita a conta de moeda do comprador
		System.out.println("credita a conta de ativo do comprador");
		newScanner.next();
		meuAcesso.registaTransferencia(idComprador, "123", "123", "123", 100000);
		meuAcesso.getLancamentosDinheiro();

		//-- registra uma oferta de venda
		System.out.println("registra uma oferta de venda");
		newScanner.next();
		meuAcesso.registraOrdemVenda(idVendedor, idPersonagem, 1000, 100, error);
		meuAcesso.getOfertasTable();

		//-- registra uma oferta de compra
		System.out.println("registra uma oferta de compra");
		System.out.println("verifica se a oferta de venda e compra  foi marcada como executada");
		newScanner.next();
		meuAcesso.registraOrdemCompra(idComprador, idPersonagem, 1000, 100, error);
		meuAcesso.getOfertasTable();

		System.out.println("verifica se foi criado um registro de casamento das ordens");
		newScanner.next();
		meuAcesso.getCasamentosOfertaTable();
		
		System.out.println("verifica se foram gerados lançamento para o vendedor");
		newScanner.next();
		meuAcesso.getLancamentosPersonagem();
		
		System.out.println("verifica se foi realizado o depósito do dinheiro no vendedor");
		newScanner.next();
		meuAcesso.getLancamentosDinheiro();
		
		System.out.println("verifica se o saldo do ativo no vendedor está correto");
		newScanner.next();
		System.out.println("Saldo Dinheiro: "+meuAcesso.calculaSaldoDisponivelDinheiro(idVendedor, 0));
		System.out.println("Saldo Personagens: "+meuAcesso.calculaSaldoDisponivelPersonagem(idVendedor,idPersonagem, 0));
		
		System.out.println("verifica se o saldo do ativo no comprador está correto");
		newScanner.next();
		System.out.println("Saldo Dinheiro: "+meuAcesso.calculaSaldoDisponivelDinheiro(idComprador, 0));
		System.out.println("Saldo Personagens: "+meuAcesso.calculaSaldoDisponivelPersonagem(idComprador,idPersonagem, 0));
		
	}
	
	public static void Caso5() throws SQLException{
		
		int error =-1;
		acesso meuAcesso = new acesso();
		Scanner newScanner = new Scanner(System.in);
		meuAcesso.clearTables();
		
		//		-- Insere o vendedor 
		System.out.println("Insere Vendedor - Marcio");
		newScanner.next();
		meuAcesso.setUsuario("Marcio", "1", "1", "marcio.barros@gmail.com", "1");
		meuAcesso.getUsuariosTable();	
		
		//		-- Pega o identificador do vendedor
		int idVendedor = meuAcesso.getIdentificadorUsuario("marcio.barros@gmail.com");
		
		//		-- Insere o Comprador 
		System.out.println("Insere Comprador - Matheus");
		newScanner.next();
		meuAcesso.setUsuario("Matheus", "2", "2", "mf.costa@live.com", "2");
		meuAcesso.getUsuariosTable();	
		
		//		-- Pega o identificador do vendedor
		int idComprador = meuAcesso.getIdentificadorUsuario("mf.costa@live.com");
		
		//		-- Insere o personagem vendido
		System.out.println("Insere Personagem- Mikey");
		newScanner.next();
		meuAcesso.inserirPersonagemTabela("MICKEY");
		meuAcesso.getPersonagensTable();
		
		//		-- Pega o identificador do personagem vendido
		int idPersonagem = meuAcesso.getIdentificadorPersonagem("MICKEY");
		


		//-- credita a conta de ativo do vendedor
		System.out.println("credita a conta de ativo do vendedor ");
		newScanner.next();
		meuAcesso.adicionaPersonagem(idVendedor, idPersonagem, 2000);
		meuAcesso.getLancamentosPersonagem();

		//-- credita a conta de moeda do comprador
		System.out.println("credita a conta de ativo do comprador");
		newScanner.next();
		meuAcesso.registaTransferencia(idComprador, "123", "123", "123", 100000);
		meuAcesso.getLancamentosDinheiro();

		//-- registra uma oferta de venda
		System.out.println("registra uma oferta de venda");
		newScanner.next();
		meuAcesso.registraOrdemVenda(idVendedor, idPersonagem, 2000, 100, error);
		meuAcesso.getOfertasTable();

		//-- registra uma oferta de compra
		System.out.println("registra uma oferta de compra");
		System.out.println("verifica se a oferta de venda e compra  foi marcada como executada");
		newScanner.next();
		meuAcesso.registraOrdemCompra(idComprador, idPersonagem, 1000, 100, error);
		meuAcesso.getOfertasTable();

		System.out.println("verifica se foi criado um registro de casamento das ordens");
		newScanner.next();
		meuAcesso.getCasamentosOfertaTable();
		
		System.out.println("verifica se foram gerados lançamento para o vendedor");
		newScanner.next();
		meuAcesso.getLancamentosPersonagem();
		
		System.out.println("verifica se foi realizado o depósito do dinheiro no vendedor");
		newScanner.next();
		meuAcesso.getLancamentosDinheiro();
		
		System.out.println("verifica se o saldo do ativo no vendedor está correto");
		newScanner.next();
		System.out.println("Saldo Dinheiro: "+meuAcesso.calculaSaldoDisponivelDinheiro(idVendedor, 0));
		System.out.println("Saldo Personagens: "+meuAcesso.calculaSaldoDisponivelPersonagem(idVendedor,idPersonagem, 0));
		
		System.out.println("verifica se o saldo do ativo no comprador está correto");
		newScanner.next();
		System.out.println("Saldo Dinheiro: "+meuAcesso.calculaSaldoDisponivelDinheiro(idComprador, 0));
		System.out.println("Saldo Personagens: "+meuAcesso.calculaSaldoDisponivelPersonagem(idComprador,idPersonagem, 0));
		
		System.out.println("Cancela oferta restante do vendedor ");
		newScanner.next();
		meuAcesso.CancelaOrdemVenda(3);
		
		System.out.println("verifica se o saldo do ativo no vendedor está correto");
		newScanner.next();
		System.out.println("Saldo Dinheiro: "+meuAcesso.calculaSaldoDisponivelDinheiro(idVendedor, 0));
		System.out.println("Saldo Personagens: "+meuAcesso.calculaSaldoDisponivelPersonagem(idVendedor,idPersonagem, 0));
		
		
	}

	public static void main(String[] args) {
		
	
		try {
			

			Caso5();

			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}



