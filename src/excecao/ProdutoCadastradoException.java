package excecao;

import negocio.Produto;

public class ProdutoCadastradoException extends Exception {

	private static final long serialVersionUID = 1L; /*Campo que define a versão de uma determinada classe durante a serialização e deserialização*/
	private String idProduto;
	private Produto produto;
	public ProdutoCadastradoException(String produtoId){
		super("PRODUTO JÁ FOI CADASTRADO!");
		this.idProduto = produtoId;
		
	}	
	
	public String getIdProduto() {
		return idProduto;
	}
	
	public Produto getProduto(){
		return produto;
	}
	
	
}
