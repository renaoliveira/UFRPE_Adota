package repositorio;

import excecao.AnimalNãoCadastradoException;
import excecao.ProdutoCadastradoException;
import excecao.ProdutoInexistenteException;
import interfaces.IRepositorioProduto;
import negocio.Produto;

public class RepositorioProdutoLista implements IRepositorioProduto{
	private Produto produto;
	private RepositorioProdutoLista prox;
	private static RepositorioProdutoLista instance;
	public static int tam; /* Tamanho da lista, atributo pertence a classe.*/
	private int indice; /* Respectiva posição da lista, atributo pertence ao objeto */
	
	public RepositorioProdutoLista(){
		
	}
	
	/* Verifica a instancia do repositório. 
	 * Se existir, retorna a instância. Se for nula, ele cria uma instancia do repositório. 
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
	
	
	/* Pega uma célula específico da lista. Recebe como paramêtro id do produto
	 * e procura um nó com o respectivo idProduto na lista. Retorna o nó que contém o idProduto
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
	
	
	/* Insere um produto no RepositórioProdutoLista.
	 * Recebe como paramêtro o produto a ser inserido. Verifica se o produto já foi cadastrado na lista. 
	 * Se não existir, insere o produto, aumenta o tamanho da lista, instancia um novo objeto prox e armazena sua posição na lista. 
	 * Se o produto já estiver cadastrado na lista, insere na próxima posição nula. 
	*/
	public void inserir(Produto produto) throws ProdutoCadastradoException{
		if(this.produto == null){
			this.produto = produto;
			tam++; /* Aumenta o tamanho da lista*/
			prox = new RepositorioProdutoLista();
			indice = tam; /* Quando o objeto é instanciado, armazena sua posição na lista */
		} else {
			prox.inserir(produto);
		}
	} 
	public Produto getProduto(){
		return produto;
	}
	
	/* Procura um produto no RepositórioProdutoLista e retorna o produto procurado. 
	 * Recebe como o parâmetro o id do produto e enquanto não encontrar o produto com o referido id, 
	 * faz a busca na próxima célula. 
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
	
	/* Remove um elemento do RepositórioProdutoLista. 
	 * Recebe como parâmetro o id do produto que será excluído do repositório e faz a remoção. 
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
	 * Recebe como parâmetro o id do produto, retorna true se existir e false caso não existir. 
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

