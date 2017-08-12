package interfaces;

import excecao.ProdutoCadastradoException;
import excecao.ProdutoInexistenteException;
import negocio.Produto;
public interface IRepositorioProduto {
	
	public void inserir(Produto produto) throws ProdutoCadastradoException;
	
	public Produto procurar(String idProduto) throws ProdutoInexistenteException;
	
	public void remover(String idProduto);
	
	public void atualizar(Produto produto);
	
	public boolean existe (String idProduto);

}
