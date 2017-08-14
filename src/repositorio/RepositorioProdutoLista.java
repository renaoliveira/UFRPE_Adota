package repositorio;

import excecao.AnimalN�oCadastradoException;
import excecao.ProdutoCadastradoException;
import excecao.ProdutoInexistenteException;
import interfaces.IRepositorioProduto;
import negocio.Produto;

public class RepositorioProdutoLista implements IRepositorioProduto{
	private Produto produto;
	private RepositorioProdutoLista prox;
	private static RepositorioProdutoLista instance;
	public static int tam; /* Tamanho da lista, atributo pertence a classe.*/
	private int indice; /* Respectiva posi��o da lista, atributo pertence ao objeto */
	
	public RepositorioProdutoLista(){
		
	}
	
	/* Verifica a instancia do reposit�rio. 
	 * Se existir, retorna a inst�ncia. Se for nula, ele cria uma instancia do reposit�rio. 
	*/
	public static RepositorioProdutoLista getInstance(){
		if(RepositorioProdutoLista.instance == null)
			RepositorioProdutoLista.instance = new RepositorioProdutoLista();
		
		return RepositorioProdutoLista.instance;
	}
	
	public int getIndice(){
		return indice;
	}
	
	public RepositorioProdutoLista getProx(){
		return prox;
	}
	
	
	/* Pega uma c�lula espec�fico da lista. Recebe como param�tro id do produto
	 * e procura um n� com o respectivo idProduto na lista. Retorna o n� que cont�m o idProduto
	 * ou retorna null; 
	*/
	public RepositorioProdutoLista getNo(String idProduto){
		RepositorioProdutoLista atual = prox;
		
		while(idProduto != produto.getIdProduto()){
			if(atual == null){
				return null;
			} else {
				return atual.getNo(idProduto);
			}
		}
		return atual;
	}
	
	
	/* Insere um produto no Reposit�rioProdutoLista.
	 * Recebe como param�tro o produto a ser inserido. Verifica se o produto j� foi cadastrado na lista. 
	 * Se n�o existir, insere o produto, aumenta o tamanho da lista, instancia um novo objeto prox e armazena sua posi��o na lista. 
	 * Se o produto j� estiver cadastrado na lista, insere na pr�xima posi��o nula. 
	*/
	public void inserir(Produto produto) throws ProdutoCadastradoException{
		if(this.produto == null){
			this.produto = produto;
			tam++; /* Aumenta o tamanho da lista*/
			prox = new RepositorioProdutoLista();
			indice = tam; /* Quando o objeto � instanciado, armazena sua posi��o na lista */
		} else {
			prox.inserir(produto);
		}
	} 
	public Produto getProduto(){
		return produto;
	}
	
	/* Procura um produto no Reposit�rioProdutoLista e retorna o produto procurado. 
	 * Recebe como o par�metro o id do produto e enquanto n�o encontrar o produto com o referido id, 
	 * faz a busca na pr�xima c�lula. 
	 * 
	*/
	public Produto procurar(String idProduto) throws ProdutoInexistenteException {
		String n;
		if(produto != null){
			n = produto.getIdProduto();
			while (!n.equals(idProduto)) 			
				return prox.procurar(idProduto);			
		}else{
			ProdutoInexistenteException e = new ProdutoInexistenteException(idProduto);
			throw e;
		}
		return produto;
	}
	
	/* Remove um elemento do Reposit�rioProdutoLista. 
	 * Recebe como par�metro o id do produto que ser� exclu�do do reposit�rio e faz a remo��o. 
	*/
	public void remover(String idProduto) { 
		if(produto != null){
			if(idProduto == produto.getIdProduto()){
				produto = getProx().produto;
				prox = getProx().prox;
			}
			else{
				getProx().remover(idProduto);
			}			
		}
	}
	
	public void atualizar(Produto produto) {
		produto = getNo(produto.getIdProduto()).produto;
	}
	
	/* Verifica se o produto existe no RepositorioProdutoLista. 
	 * Recebe como par�metro o id do produto, retorna true se existir e false caso n�o existir. 
	*/
	public boolean existe(String idProduto){
		String n;
		if(produto != null){
			n = produto.getIdProduto();
			while (!n.equals(idProduto)) 			
				return prox.existe(idProduto);			
		}
		if(produto == null)
			return false;
		else return true;
	}
}

