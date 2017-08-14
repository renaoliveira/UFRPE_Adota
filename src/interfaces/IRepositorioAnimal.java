package interfaces;

import excecao.AnimalN�oCadastradoException;
import negocio.Animal;

public interface IRepositorioAnimal {
	public void inserir(Animal animal);

	public void remover(String id);

	public void atualizar(Animal animal);

	public Animal procurar(String id) throws AnimalN�oCadastradoException;

	public boolean existe(String id);
}
