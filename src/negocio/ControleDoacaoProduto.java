package negocio;

import excecao.DoacaoProdutoCadastradaException;
import excecao.DoacaoProdutoInexistenteException;
import excecao.SemPosicaoLivreException;
import interfaces.IRepositorioDoacaoProduto;

public class ControleDoacaoProduto {
	private IRepositorioDoacaoProduto doacaoprodutos;
	
	public ControleDoacaoProduto(IRepositorioDoacaoProduto repositorio) {
		this.doacaoprodutos = repositorio;
	}
	
	public void inserir (DoacaoProduto doacaoproduto) throws DoacaoProdutoCadastradaException, SemPosicaoLivreException {
		if(doacaoproduto != null) {
			if(!(this.doacaoprodutos.existe(doacaoproduto.getIdDoacao()))){
				this.doacaoprodutos.inserir(doacaoproduto);
			} else {
				DoacaoProdutoCadastradaException e = new DoacaoProdutoCadastradaException(doacaoproduto.getIdDoacao());
				throw e;
				
			}
		} 
	}
	
	public DoacaoProduto procurar(String idDoacao) throws DoacaoProdutoInexistenteException {
		if(this.doacaoprodutos.existe(idDoacao)) {
			return this.doacaoprodutos.procurar(idDoacao);
		} else {
			DoacaoProdutoInexistenteException e = new  DoacaoProdutoInexistenteException(idDoacao);
			throw e;
		}
			
	}
	
	public void remover(String idDoacao) throws DoacaoProdutoInexistenteException {
		if(this.doacaoprodutos.existe(idDoacao)) {
			this.doacaoprodutos.remover(idDoacao);
		} else {
			DoacaoProdutoInexistenteException e = new  DoacaoProdutoInexistenteException(idDoacao);
			throw e;
		}
	
		
	}
	
	public void atualizar(DoacaoProduto doacaoproduto) throws DoacaoProdutoInexistenteException {
		if(this.doacaoprodutos.existe(doacaoproduto.getIdDoacao())) {
			this.doacaoprodutos.atualizar(doacaoproduto);
		} else {
			DoacaoProdutoInexistenteException e = new  DoacaoProdutoInexistenteException(doacaoproduto.getIdDoacao());
			throw e;
		}
		
	}
	
	public boolean existe(String idDoacao) throws DoacaoProdutoInexistenteException {
		return this.doacaoprodutos.existe(idDoacao);
	}
	
	
}










