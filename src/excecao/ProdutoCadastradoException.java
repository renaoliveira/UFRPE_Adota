package excecao;

import negocio.Produto;

public class ProdutoCadastradoException extends Exception {

	private static final long serialVersionUID = 1L; /*Campo que define a vers�o de uma determinada classe durante a serializa��o e deserializa��o*/
	private String idProduto;
	private Produto produto;
	public ProdutoCadastradoException(String produtoId){
		super("PRODUTO J� FOI CADASTRADO!");
		this.idProduto = produtoId;
		
	}	
	
	public String getIdProduto() {
		return idProduto;
	}
	
	public Produto getProduto(){
		return produto;
	}
	
	
}
