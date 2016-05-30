package model;


public class Personagens {
	private int id;
	private String nome;
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
	public Personagens(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "personagens [id=" + id + ", nome=" + nome + "]";
	}
	
}


