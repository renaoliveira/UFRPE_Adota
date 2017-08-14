package interfaces;

import excecao.SemPosicaoLivreException;
import excecao.DoacaoProdutoInexistenteException;
import negocio.DoacaoProduto;

public interface IRepositorioDoacaoProduto {

	    public void inserir(DoacaoProduto doacaoproduto) throws SemPosicaoLivreException;
	    
	    public DoacaoProduto procurar (String idDoacao) throws DoacaoProdutoInexistenteException;
	    
	    public void remover(String idDoacao) throws DoacaoProdutoInexistenteException;
	    
	    public void atualizar(DoacaoProduto doacaoproduto) throws DoacaoProdutoInexistenteException;
	    
	    public boolean existe(String idDoacao);
}
