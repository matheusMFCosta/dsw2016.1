package model;

import java.sql.Date;

public class transferencias {
	
	private int id;
	private int idUsuario;
	private java.util.Date data;
	private String numeroBanco;
	private String numeroAgencia;
	private String numeroConta;
	private float valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public java.util.Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNumeroBanco() {
		return numeroBanco;
	}
	public void setNumeroBanco(String numeroBanco) {
		this.numeroBanco = numeroBanco;
	}
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public transferencias(int id, int idUsuario, java.util.Date data, String numeroBanco, String numeroAgencia,
			String numeroConta, float valor) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.data = data;
		this.numeroBanco = numeroBanco;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "transferencias [id=" + id + ", idUsuario=" + idUsuario + ", data=" + data + ", numeroBanco="
				+ numeroBanco + ", numeroAgencia=" + numeroAgencia + ", numeroConta=" + numeroConta + ", valor=" + valor
				+ "]";
	}
	
	
	

}
