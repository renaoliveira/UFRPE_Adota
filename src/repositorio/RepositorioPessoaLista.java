package repositorio;

import excecao.PessoaCadastradaException;
import excecao.PessoaInexistenteException;
import interfaces.IRepositorioPessoa;
import negocio.Pessoa;;

public class RepositorioPessoaLista implements IRepositorioPessoa {

	private Pessoa pessoa;
	private RepositorioPessoaLista prox;
	private static RepositorioPessoaLista instance;
	public static int tam; // Tamanho da Lista. Atributo pertence a classe e não
							// ao objeto;
	private int indice; // Respectiva posição na lista. Atributo pertence ao
						// objeto.

	public RepositorioPessoaLista() {
	}
	
	/*private int getIndice(String login) {
		return getNo(login).indice;
	}*/
	
	public int getIndice(){
		return indice;
	}
	
	public Pessoa getPessoa(){
		return pessoa;
	}
	
	public static RepositorioPessoaLista getInstance(){
		if(RepositorioPessoaLista.instance == null)
			RepositorioPessoaLista.instance = new RepositorioPessoaLista();
		
		return RepositorioPessoaLista.instance;
	}
	
	public RepositorioPessoaLista getProx() {
		return prox;
	}

	// Pega uma celula específica na lista
	// Recebe como parametro o login de uma pessoa para encontrar um nó com a
	// respectiva pessoa na lista
	// Retorna o nó que contem a pessoa com o login digitado ou retorna null;
	public RepositorioPessoaLista getNo(String login) {
		RepositorioPessoaLista atual = prox;

		while (login != pessoa.getLogin()) {
			if (atual == null)
				return null;
			else
				return atual.getNo(login);
		}
		return atual;
	}

	public void inserir(Pessoa pessoa) throws PessoaCadastradaException{
		
		if (this.pessoa == null) {
			this.pessoa = pessoa;
			
			tam++;// Aumenta o tamanho da lista;
			prox = new RepositorioPessoaLista();
			indice = tam;// Quando o objeto é instanciado ele armazena sua
			// posição na lista;
		} else {
			prox.inserir(pessoa);
		}
		
	}

	// Procura uma pessoa no Repositorio Lista e Retorna a pessoa procurada
	// Recebe o login da pessoa que será procurada
	// Enquanto não achar a pessoa com o login referente a proxima celular é
	// Checada em busca do login da pessoa.
	public Pessoa procurar(String login)throws PessoaInexistenteException{
		boolean achou = false;
		String n;
		while (!achou && pessoa != null) {
			n = pessoa.getLogin();
			if (n.equals(login)) {
				achou = true;
			} else {
				return prox.procurar(login);
			}
		}
		if(pessoa == null){
			PessoaInexistenteException e = new PessoaInexistenteException(login);
			throw e;
		}
		return pessoa;
	}
	//Remove um elemento do repositório lista
	//Recebe o login da pessoa que sera removida do repositorio
	public void remover(String login) {
		
		if(pessoa != null){
			if(login == pessoa.getLogin()){
				pessoa = getProx().pessoa;
				prox = getProx().prox;
			}
			else{
				getProx().remover(login);
			}
		}
	}

	public void atualizar(Pessoa pessoa) {
		pessoa = getNo(pessoa.getLogin()).pessoa;
	}

	public boolean existe(String login){
		boolean achou = false;
		String n;
		while (!achou && pessoa != null) {
			n = pessoa.getLogin();
			if (n.equals(login)) {
				achou = true;
			} else {
				return prox.existe(login);
			}
		}
		if(pessoa == null)
			return false;
		else return true;
	}

}
