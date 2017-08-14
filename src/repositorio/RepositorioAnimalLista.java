package repositorio;

import excecao.AnimalNãoCadastradoException;
import interfaces.IRepositorioAnimal;
import negocio.Animal;;

public class RepositorioAnimalLista implements IRepositorioAnimal {

	private Animal animal;
	private RepositorioAnimalLista prox;
	private static RepositorioAnimalLista instance;
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

	public void inserir(Animal animal) {
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

	public Animal procurar(String id) throws AnimalNãoCadastradoException{
		String n;
		if(animal != null){
			n = animal.getId();
			while (!n.equals(id)) 			
				return prox.procurar(id);			
		}else{
			AnimalNãoCadastradoException e = new AnimalNãoCadastradoException(id);
			throw e;
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
		String n;
		if(animal != null){
			n = animal.getId();
			while (!n.equals(id)) 			
				return prox.existe(id);			
		}
		if(animal == null)
			return false;
		else return true;
	}

	public static RepositorioAnimalLista getInstance() {
		// TODO Auto-generated method stub
		if(RepositorioAnimalLista.instance == null)
			RepositorioAnimalLista.instance = new RepositorioAnimalLista();
		
		return RepositorioAnimalLista.instance;
	}

	@Override
	public Animal getAnimal() {
		// TODO Auto-generated method stub
		return animal;
	}

}
