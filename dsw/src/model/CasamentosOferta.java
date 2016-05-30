package model;

import java.sql.Date;

public class CasamentosOferta {
	
	private int idOfertavenda;
	private int idOfertaCompra;
	private java.util.Date  data;
	public CasamentosOferta(int idOfertavenda, int idOfertaCompra, java.util.Date  data) {
		super();
		this.idOfertavenda = idOfertavenda;
		this.idOfertaCompra = idOfertaCompra;
		this.data = data;
	}
	public int getIdOfertavenda() {
		return idOfertavenda;
	}
	public void setIdOfertavenda(int idOfertavenda) {
		this.idOfertavenda = idOfertavenda;
	}
	public int getIdOfertaCompra() {
		return idOfertaCompra;
	}
	public void setIdOfertaCompra(int idOfertaCompra) {
		this.idOfertaCompra = idOfertaCompra;
	}
	public java.util.Date  getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "casamentosOferta [idOfertavenda=" + idOfertavenda + ", idOfertaCompra=" + idOfertaCompra + ", data="
				+ data + "]";
	} 
	
	

}
