package excecao;

public class ProdutoCadastradoException extends Exception {

	private static final long serialVersionUID = 1L; /*Campo que define a versão de uma determinada classe durante a serialização e deserialização*/
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
