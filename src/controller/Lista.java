package controller;



public class Lista {
	
	private Livro inicio;
	
	public Lista() {
		this.inicio = null;	
	} 
	
	public void adicionaInicio(Listinha livrinhos) {
		Livro nos = new Livro(livrinhos);
		nos.setDepois(this.inicio);
		if(this.inicio != null) {
			this.inicio.setAntes(nos);
		}
		this.inicio = nos;
	}
		
	public void adicionaFinal(Listinha livrinhos) {
		Livro nos = new Livro(livrinhos);
		if(this.inicio == null) {
			this.inicio = nos;
		}else {
			Livro aux = this.inicio;
			while(aux.getDepois()!=null) {
				aux = aux.getDepois();
			}
			aux.setDepois(nos);
			nos.setAntes(aux);
		}
	}
	
	public void adicionaMeio(Listinha livritos , int posicao) {
		if (posicao == 1) {
			adicionaInicio(livritos);
		}else if(posicao == size()+1) {
			adicionaFinal(livritos);
		}else if(posicao <= size() && posicao > 0) {
			Livro nos = new Livro(livritos);
			Livro aux = Posicao(posicao-1);
			Livro aux2 = aux.getAntes();
			aux2.setDepois(nos);
			aux.setAntes(nos);
			nos.setDepois(aux);
			nos.setAntes(aux2);
		}else {
			System.out.println("Posição inválida");
		}
	}
	
	public void removeInicio() {
		if (this.inicio == null) {
			System.out.println("A lista está vazio");
		}else {
			this.inicio = this.inicio.getDepois();
			if (this.inicio != null) {
				this.inicio.setAntes(null);
			}
		}
	}
	
	public void removeFinal() {
		if (this.inicio == null) {
			System.out.println("A lista está vazia");
		}else {
			Livro aux = this.inicio;
			while (aux.getDepois()!=null);{
				aux = aux.getDepois();
			}
			aux = aux.getAntes();
			if(aux!=null) {
				aux.setDepois(null);
			}
		}	
	}
	
	public void removeMeio(int posicao) {
		if (this.inicio == null) {
			System.out.println("Lista está vazia :/");
		}else if(posicao == 1) {
			removeInicio();
		}else if(posicao == size()) {
			removeFinal();
		}else if(posicao <= size() && posicao > 0) {
			Livro aux = Posicao(posicao-1);
			Livro aux2 = aux.getDepois();
			aux = aux.getAntes();
			aux.setDepois(aux2);
			aux2.setAntes(aux);
		}else {
			System.out.println("Posição inválida :/");
		}
	}
	
	public	String apresenta() {
			String mostra ;
			if(this.inicio == null) {
				mostra = ("Lista vazia :/");
			}else {
				StringBuffer x = new StringBuffer("Lista de Livros : \n");
				Livro aux = this.inicio;
				while(aux != null) {
					x.append("Livro: " + aux.getLivritos().getNome() + " | Data: "+ aux.getLivritos().toString()  +" | Preço: R$" + aux.getLivritos().getPreco() + "\n" );
					aux = aux.getDepois();
				}
				mostra = x.toString();
			}
	return mostra;
	}
		
	private Livro Posicao(int x) {
		Livro aux = this.inicio;
		for (int i = 0; i < x; i++) {
			aux = aux.getDepois();
		}
		return aux;
	}
	
	private int size() {
		int x = 0;
		Livro aux = this.inicio;
		while(aux != null) {
			aux = aux.getDepois();
			x++;
		}
		return x;
	}
}