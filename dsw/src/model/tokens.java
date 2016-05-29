package model;

import java.sql.Date;

public class tokens {
	private int id ;
	private int idUsuario;
	private String token;
	private java.util.Date validade;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public java.util.Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public tokens(int id, int idUsuario, String token, java.util.Date minhaData) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.token = token;
		this.validade = minhaData;
	}
	@Override
	public String toString() {
		return "tokens [id=" + id + ", idUsuario=" + idUsuario + ", token=" + token + ", validade=" + validade + "]";
	}
	
	

}
