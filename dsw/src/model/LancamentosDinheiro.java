package model;

import java.sql.Date;

public class LancamentosDinheiro {
	private int id;
	private int idusuario;
	private java.util.Date data;
	private String historico;
	private float valor;
	private int operacao;
	public LancamentosDinheiro(int id, int idusuario, java.util.Date data, String historico, float valor, int operacao) {
		super();
		this.id = id;
		this.idusuario = idusuario;
		this.data = data;
		this.historico = historico;
		this.valor = valor;
		this.operacao = operacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public java.util.Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getOperacao() {
		return operacao;
	}
	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}
	@Override
	public String toString() {
		return "lancamentosDinheiro [id=" + id + ", idusuario=" + idusuario + ", data=" + data + ", historico="
				+ historico + ", valor=" + valor + ", operacao=" + operacao + "]";
	}

	
	
}
