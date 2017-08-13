package negocio;

import excecao.ProdutoCadastradoException;
import excecao.ProdutoInexistenteException;
import interfaces.IRepositorioProduto;

public class ControleProduto {
	
	private IRepositorioProduto produtos;
	
	public ControleProduto(IRepositorioProduto repositorio) {
		this.produtos = repositorio;
	}
	
	public void inserir(Produto produto) throws ProdutoCadastradoException {
		if (produto != null) {
			if (!(produtos.existe(produto.getIdProduto()))) {
				produtos.inserir(produto);
			} else{
				ProdutoCadastradoException e = new ProdutoCadastradoException(produto.getIdProduto());
				throw e;
			}
			
		} else
			System.out.println("Produto Inválido!");
	}
	
	public Produto procurar(String idProduto) throws ProdutoInexistenteException {
		return this.produtos.procurar(idProduto);
	}
	
	public void remover(String idProduto) throws ProdutoInexistenteException {
		this.produtos.remover(idProduto);
	}
	
	public void atualizar(Produto produto){
		this.produtos.atualizar(produto);
	}
	
	public boolean existe(String idProduto) throws ProdutoInexistenteException {
		return this.produtos.existe(idProduto);
	}
	

	
}
