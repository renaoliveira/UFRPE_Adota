package excecao;

public class ProdutoInexistenteException extends Exception {
	
	private static final long serialVersionUID = 1L; /*Campo que define a versão de uma determinada classe durante a serialização e deserialização*/
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
