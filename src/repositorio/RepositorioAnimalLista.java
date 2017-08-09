package repositorio;

import interfaces.IRepositorioAnimal;
import negocio.Animal;;

public class RepositorioAnimalLista implements IRepositorioAnimal {

	private Animal animal;
	private RepositorioAnimalLista prox;
	public static int tam; // Tamanho da Lista. Atributo pertence a classe e não
							// ao objeto;
	private int indice; // Respectiva posição na lista. Atributo pertence ao
						// objeto.

	public RepositorioAnimalLista() {
	}
	
	/*private int getIndice(String id) {
		return getNo(id).indice;
	}*/

	public RepositorioAnimalLista getProx() {
		return prox;
	}

	public RepositorioAnimalLista getNo(String id) {
		RepositorioAnimalLista atual = prox;

		while (id != animal.getId()) {
			if (atual == null)
				return null;
			else
				return atual.getNo(id);
		}
		return atual;
	}

	public void inserir(Animal pessoa) {
		if (this.animal == null) {
			this.animal = animal;
			tam++;// Aumenta o tamanho da lista;
			prox = new RepositorioAnimalLista();
			indice = tam;// Quando o objeto é instanciado ele armazena sua
							// posição na lista;
		} else {
			prox.inserir(animal);
		}
	}

	public Animal procurar(String id) {
		boolean achou = false;
		String n;
		while (!achou && animal != null) {
			n = animal.getId();
			if (n.equals(id)) {
				achou = true;
			} else {
				return prox.procurar(id);
			}
		}
		return animal;
	}
	
	public void remover(String id) {
		
		if(animal != null){
			if(id == animal.getId()){
				animal = getProx().animal;
				prox = getProx().prox;
			}
			else{
				getProx().remover(id);
			}
		}
	}

	public void atualizar(Animal animal) {
		animal = getNo(animal.getId()).animal;
	}

	public boolean existe(String id) {
		if (procurar(id) != null)
			return true;
		else
			return false;
	}

}
