package negocio;

import repositorio.RepositorioAnimalLista;
//import repositorio.RepositorioPessoaArray;
import repositorio.RepositorioPessoaLista;
import excecao.PessoaCadastradaException;
import excecao.PessoaInexistenteException;
import interfaces.IRepositorioAnimal;
import interfaces.IRepositorioPessoa;

public class Fachada {

	private ControlePessoa pessoas;
	private ControleAnimal animais;
	private static Fachada instance;

	public Fachada() {
		IRepositorioPessoa repositorioPessoas = new RepositorioPessoaLista();
		pessoas = new ControlePessoa(repositorioPessoas);
		IRepositorioAnimal repositorioAnimais = new RepositorioAnimalLista();
		animais = new ControleAnimal(repositorioAnimais);
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}

		return instance;

	}

	public void inserir(Pessoa pessoa) throws PessoaCadastradaException, PessoaInexistenteException {
		this.pessoas.cadastrar(pessoa);
	}
	
	public void inserir(Animal animal){
		this.animais.cadastrar(animal);
	}
	
	public Pessoa procurarPessoa(String login) throws PessoaInexistenteException{
		return this.pessoas.procurar(login);
	}
	
	public Animal procurarAnimal(String id){
		return this.animais.procurar(id);
	}
	
	public void removerPessoa(String login) throws PessoaInexistenteException {
		this.pessoas.remover(login);
	}
	
	public void removerAnimal(String id){
		this.animais.remover(id);
	}
	
	public void atualizar(Pessoa pessoa) {
		this.pessoas.atualizar(pessoa);
	}
	
	public void atualizar(Animal animal){
		this.animais.atualizar(animal);
	}
	
	public boolean existePessoa(String login) throws PessoaInexistenteException{
		return this.pessoas.existe(login);
	}
	
	public boolean existeAnimal(String id){
		return this.animais.existe(id);
	}
}
