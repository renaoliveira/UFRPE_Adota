package repositorio;

import interfaces.IRepositorioAnimal;
import negocio.Animal;

public class RepositorioAnimalArray implements IRepositorioAnimal {

	private Animal[] animais;
	private int indice;
	private final static int TAMANHO = 100;

	public RepositorioAnimalArray() {
		this.animais = new Animal[TAMANHO];
		this.indice = 0;
	}

	private int getIndice(String id) {
		int i = 0;
		while (id != animais[i].getId()) {
			i++;
			if (i >= indice)
				return indice;
		}
		return i;
	}

	@Override
	public void inserir(Animal animal) {
		if (this.animais[indice] == null) {
			this.animais[indice] = animal;
			this.indice = this.indice + 1;
		} else {
			for (int i = 0; i < this.animais.length; i++) {
				if (this.animais[i] == null) {
					this.animais[indice] = animal;
					this.indice = this.indice + 1;
					break;
				}
			}
		}
	}

	@Override
	public Animal procurar(String id) {
		for (int i = 0; i < this.animais.length; i++) {
			if (id == this.animais[i].getId()) {
				return this.animais[i];
			}
		}
		return null;
	}

	@Override
	public void remover(String id) {
		for (int i = 0; i < this.animais.length; i++) {
			if (id == this.animais[i].getId()) {
				this.animais[i] = null;
				this.indice = this.indice - 1;
				break;
			}
		}
	}

	@Override
	public void atualizar(Animal animal) {
		for (int i = 0; i < this.animais.length; i++) {
			if (animal.getId() == this.animais[i].getId()) {
				this.animais[i] = animal;
				break;
			}
		}
	}

	public boolean existe(String id) {
		int i = getIndice(id);

		if (animais[i] == null)
			return false;
		else
			return true;

	}

	/*
	 * public boolean existe (String id) { int i; for (i=0; i<animais.length;
	 * i++) { if (animais[i] == null) { break; } else { if
	 * (animais[i].getId().equalsIgnoreCase(id)) { break; } } } if (animais[i]
	 * != null) { return true; } else { return false; } }
	 */

}
