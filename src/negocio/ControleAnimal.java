package negocio;

import interfaces.IRepositorioAnimal;

public class ControleAnimal {

	private IRepositorioAnimal animais;

	public ControleAnimal(IRepositorioAnimal repositorio) {
		this.animais = repositorio;
	}

	public void cadastrar(Animal animal) {
		if (animal != null) {
			if (!(animais.existe(animal.getId()))) {
				animais.inserir(animal);
			} else
				System.out.println("Conta Ja Cadastrada!");
		} else
			System.out.println("Conta Invalida!");
	}

	public Animal procurar(String id) {
		return this.animais.procurar(id);
	}

	public void remover(String id) {
		// COLOCAR VALIDACAO E REGRA DE NEGOCIO
		this.animais.remover(id);
	}

	public void atualizar(Animal animal) {
		// COLOCAR VALIDACAO E REGRA DE NEGOCIO
		this.animais.atualizar(animal);
	}
	public boolean existe(String id){
		return this.animais.existe(id);
	}
}
