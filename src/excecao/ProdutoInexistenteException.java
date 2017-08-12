package excecao;

public class ProdutoInexistenteException extends Exception {
	
	private static final long serialVersionUID = 1L; /*Campo que define a vers�o de uma determinada classe durante a serializa��o e deserializa��o*/
	private String idProduto;
	
	public ProdutoInexistenteException (String idProduto){
		super("PRODUTO INEXISTENTE!");
		this.idProduto = idProduto;
	}
	
	public ProdutoInexistenteException(){
		
	}
	
	public String getIdProduto() {
		return idProduto;
	}

}
