package model;

import java.sql.Date;

public class Ofertas {
	
	private int id;
	private int tipo;
	private int idPersonagem;
	private int idUsuario;
	private java.util.Date data;
	private float quantidade;
	private float quantidadeOriginal;
	private float precoUnitario;
	private int status;
	private int idOrdemOriginal;
	
	
	public Ofertas(int id, int tipo, int idPersonagem, int idUsuario, java.util.Date data, float quantidade,float quantidadeOriginal, float precoUnitario, int status, int idOrdemOriginal) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.idPersonagem = idPersonagem;
		this.idUsuario = idUsuario;
		this.data = data;
		this.quantidade = quantidade;
		this.quantidadeOriginal = quantidadeOriginal;
		this.precoUnitario = precoUnitario;
		this.status = status;
		this.idOrdemOriginal = idOrdemOriginal;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getIdPersonagem() {
		return idPersonagem;
	}
	public void setIdPersonagem(int idPersonagem) {
		this.idPersonagem = idPersonagem;
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
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public float getQuantidadeOriginal() {
		return quantidadeOriginal;
	}
	public void setQuantidadeOriginal(float quantidadeOriginal) {
		this.quantidadeOriginal = quantidadeOriginal;
	}
	public float getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIdOrdemOriginal() {
		return idOrdemOriginal;
	}
	public void setIdOrdemOriginal(int idOrdemOriginal) {
		this.idOrdemOriginal = idOrdemOriginal;
	}
	@Override
	public String toString() {
		return "ofertas [id=" + id + ", tipo=" + tipo + ", idPersonagem=" + idPersonagem + ", idUsuario=" + idUsuario
				+ ", data=" + data + ", quantidade=" + quantidade + ", quantidadeOriginal=" + quantidadeOriginal
				+ ", precoUnitario=" + precoUnitario + ", status=" + status + ", idOrdemOriginal=" + idOrdemOriginal
				+ "]";
	}
	
	
}
