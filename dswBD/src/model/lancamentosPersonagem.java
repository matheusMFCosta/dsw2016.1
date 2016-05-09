package model;

import java.sql.Date;


public class lancamentosPersonagem {
	
	private int id;
	private int idPersonagem;
	private int idusuario;
	private java.util.Date data;
	private String historico;
	private int quantidade;
	private float percounitario;
	private int operacao;
	public lancamentosPersonagem(int id, int idPersonagem, int idusuario, java.util.Date data, String historico, int quantidade,
			float percounitario, int operacao) {
		super();
		this.id = id;
		this.idPersonagem = idPersonagem;
		this.idusuario = idusuario;
		this.data = data;
		this.historico = historico;
		this.quantidade = quantidade;
		this.percounitario = percounitario;
		this.operacao = operacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPersonagem() {
		return idPersonagem;
	}
	public void setIdPersonagem(int idPersonagem) {
		this.idPersonagem = idPersonagem;
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getPercounitario() {
		return percounitario;
	}
	public void setPercounitario(float percounitario) {
		this.percounitario = percounitario;
	}
	public int getOperacao() {
		return operacao;
	}
	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}
	@Override
	public String toString() {
		return "lancamentosPersonagem [id=" + id + ", idPersonagem=" + idPersonagem + ", idusuario=" + idusuario
				+ ", data=" + data + ", historico=" + historico + ", quantidade=" + quantidade + ", percounitario="
				+ percounitario + ", operacao=" + operacao + "]";
	}


}
