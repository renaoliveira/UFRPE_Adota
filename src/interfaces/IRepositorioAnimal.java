package interfaces;

import negocio.Animal;

public interface IRepositorioAnimal {
	public void inserir(Animal animal);

	public void remover(String id);

	public void atualizar(Animal animal);

	public Animal procurar(String id);

	public boolean existe(String id);
}
