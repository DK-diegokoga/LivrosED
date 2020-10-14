package view;
	
import javax.swing.JOptionPane;
import controller.Lista;
import controller.Listinha;
	
public class Principal {
	
private int listinha;
	
	public Principal() {
		listinha = 0;
	}
	
	public static void main(String[] args) {
		Lista listaS = new Lista();
		int menu = 0;
		while(menu!=9) {
			Principal menuS = new Principal();
			
			menu = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n"
					+ "1-Ir para lista de livros \n"
					+ "9-Sair\n"));
			switch(menu) {
				case 1: listaS = menuS.menu(listaS);
					break;
				case 9: JOptionPane.showMessageDialog(null,"Listinha de livros!");
					break;
				default: JOptionPane.showMessageDialog(null,"Valor inválido");
			}
		}
	}
	public Lista menu(Lista lista) {
		JOptionPane.showMessageDialog(null,"Bora listar os livros!");
		int pos;
		while(this.listinha!=9) {
			this.listinha = Integer.parseInt(JOptionPane.showInputDialog("Lista de Livros \n"
					+ "1-Adicionar Inicio\n"
					+ "2-Adicionar Final\n"
					+ "3-Adicionar Meio\n"
					+ "4-Remover Inicio\n"
					+ "5-Remover Final\n"
					+ "6-Remover Meio\n"
					+ "7-Mostrar Lista\n"
					+ "9-Sair\n"));
			switch(listinha) {
			case 1: lista.adicionaInicio(Adiciona());
				break;
			case 2: lista.adicionaFinal(Adiciona());
				break;
			case 3: pos = Integer.parseInt(JOptionPane.showInputDialog("Insira a posição que deseja colocar"));
					lista.adicionaMeio(Adiciona(), pos);
					break;
			case 4: lista.removeInicio();
					break;
			case 5: lista.removeFinal();
					break;
			case 6: pos = Integer.parseInt(JOptionPane.showInputDialog("Insira a posição que deseja retirar"));
					lista.removeMeio(pos);
					break;
			case 7: JOptionPane.showMessageDialog(null, lista.apresenta());
				break;
			case 9: JOptionPane.showMessageDialog(null,"Listinha feita :3 ");
					JOptionPane.showMessageDialog(null,"Pera aí!!");
					JOptionPane.showMessageDialog(null,"Não acredito que tu esqueceu!!!");
					JOptionPane.showMessageDialog(null,"Faltou o Cinquenta Tons de Cinza afff");
					break;
			default: System.out.println("Valor inválido!");
			}
		}
		return lista;
	}
	
	private Listinha Adiciona() {
		Listinha livros;
		String nome = JOptionPane.showInputDialog("Insira o nome do livro : ");
		String ano = JOptionPane.showInputDialog("Insira a data do livro : ");
		double preco = Double.parseDouble(JOptionPane.showInputDialog("Insira o preço do livro : "));
		livros = new Listinha(nome , ano, preco);
		return livros;
	}
	
}