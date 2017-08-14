package repositorio;

import excecao.DoacaoProdutoInexistenteException;
import excecao.RemocaoNaoConcluidaException;
import excecao.SemPosicaoLivreException;
import interfaces.IRepositorioDoacaoProduto;
import negocio.DoacaoProduto;

public class RepositorioDoacaoProdutoArray implements IRepositorioDoacaoProduto {
	
	private DoacaoProduto[] doacaoprodutos;
	private int indice;
	private final static int TAMANHO = 100;
	
	public RepositorioDoacaoProdutoArray() {
		this.doacaoprodutos = new DoacaoProduto[TAMANHO];
		this.indice = 0;
	}
	
	private int getIndice(String id) {
		int i = 0;
		while (id != doacaoprodutos[i].getIdDoacao()) {
			i++;
			if (i >= indice)
				return indice;
		}
		return i;
	}

	@Override
	public void inserir(DoacaoProduto doacaoproduto) throws SemPosicaoLivreException {
		boolean achou = false;
		if (this.doacaoprodutos[indice] == null) {
			this.doacaoprodutos[indice] = doacaoproduto;
			achou = true;
			this.indice = this.indice + 1;
		} else {
			for (int i = 0; i < this.doacaoprodutos.length; i++) {
				if (this.doacaoprodutos[i] == null) {
					this.doacaoprodutos[indice] = doacaoproduto;
					this.indice = this.indice + 1;
					achou = true;
					break;
				}
			}
		}
		if(!achou) { 
			SemPosicaoLivreException e = new SemPosicaoLivreException();
			throw e;
		}
		
	}

	@Override
	public DoacaoProduto procurar(String idDoacao) throws DoacaoProdutoInexistenteException {
		for (int i = 0; i < this.doacaoprodutos.length; i++) {
			if (this.doacaoprodutos[i].getIdDoacao().equals(idDoacao)) {
				return this.doacaoprodutos[i];
			}
		}
		
		DoacaoProdutoInexistenteException e = new DoacaoProdutoInexistenteException(idDoacao);
		throw e;
		
		// throw new DoacaoInexistenteException(idDoacao);
		
	}

	
	@Override
	public void remover(String idDoacao) throws RemocaoNaoConcluidaException {
		boolean achou = false;
		for (int i = 0; i < this.doacaoprodutos.length; i++) {
			if (this.doacaoprodutos[i].getIdDoacao().equals(idDoacao)) {
				achou = true;
				this.doacaoprodutos[i] = null;
				this.indice = this.indice - 1;
				break;
			}
		}
		if(!achou) {
			RemocaoNaoConcluidaException e = new RemocaoNaoConcluidaException();
			throw e;
		}
		
	}

	@Override
	public void atualizar(DoacaoProduto doacaoproduto) throws DoacaoProdutoInexistenteException {
		boolean achou = false;
		for (int i = 0; i < this.doacaoprodutos.length; i++) {
			if (this.doacaoprodutos[i].getIdDoacao().equals(doacaoproduto.getIdDoacao())) {
				this.doacaoprodutos[i] = doacaoproduto;
				achou = true;
				break;
			}
		}
		
		if(!achou) { 
			DoacaoProdutoInexistenteException e = new DoacaoProdutoInexistenteException(doacaoproduto.getIdDoacao());
			throw e;
		}
		
	}

	@Override
	public boolean existe(String idDoacao) {
		int i = getIndice(idDoacao);
		if (doacaoprodutos[i] == null) {
			return false;
		}
		else
			return true;
	}

}
