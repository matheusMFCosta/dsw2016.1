package model;



import java.util.Date;

import lombok.Data;

public @Data class usuarios {
	
	
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private String senha;
	private String Foto;
	private boolean administrator;
	private Date ultimoLogin;
	private int numeroLogins;
	
	
	
	public usuarios(int id, String nome,String email, String telefone, String cpf, String senha, String foto, boolean administrator,
			Date ultimoLogin, int numeroLogins) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.senha = senha;
		Foto = foto;
		this.administrator = administrator;
		this.ultimoLogin = ultimoLogin;
		this.numeroLogins = numeroLogins;
	}


	public int getNumeroLogins() {
		return numeroLogins;
	}


	public void setNumeroLogins(int numeroLogins) {
		this.numeroLogins = numeroLogins;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return Foto;
	}
	public void setFoto(String foto) {
		Foto = foto;
	}
	public boolean isAdministrator() {
		return administrator;
	}
	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}
	public Date getUltimoLogin() {
		return ultimoLogin;
	}
	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}


	@Override
	public String toString() {
		return "usuarios [id=" + id + ",email="+email+" nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf + ", senha=" + senha
				+ ", Foto=" + Foto + ", administrator=" + administrator + ", ultimoLogin=" + ultimoLogin
				+ ", numeroLogins=" + numeroLogins + "]";
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	


}
