package excecao;

public class ProdutoCadastradoException extends Exception {
	private String idProduto;
	
	public ProdutoCadastradoException(String idProduto){
		super("PRODUTO JÁ FOI CADASTRADO!");
		this.idProduto = idProduto;
	}	
	
	public ProdutoCadastradoException(){
		
	}
	
	public String getIdProduto() {
		return idProduto;
	}
	
	
}
