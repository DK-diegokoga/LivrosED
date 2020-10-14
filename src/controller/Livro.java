package controller;

public class Livro {
	
	private Listinha livrinhos;
	private Livro depois;
	private Livro antes;
	
	public Livro(Listinha livrinhos) {
		this.livrinhos = livrinhos;
		this.depois = null;
		this.antes = null;
	}
	
	public Listinha getLivritos() {
		return livrinhos;
	}
	
	public void setLivritos(Listinha livrinhos) {
		this.livrinhos = livrinhos;
	}
	
	public Livro getDepois() {
		return depois;
	}
	
	public void setDepois(Livro depois) {
		this.depois = depois;
	}
	
	public Livro getAntes() {
		return antes;
	}
	
	public void setAntes(Livro antes) {
		this.antes = antes;
	}
}