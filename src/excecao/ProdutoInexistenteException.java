package excecao;

public class ProdutoInexistenteException extends Exception {
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
