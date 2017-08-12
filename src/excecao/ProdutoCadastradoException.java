package excecao;

public class ProdutoCadastradoException extends Exception {

	private static final long serialVersionUID = 1L; /*Campo que define a vers�o de uma determinada classe durante a serializa��o e deserializa��o*/
	private String idProduto;
	
	public ProdutoCadastradoException(String idProduto){
		super("PRODUTO J� FOI CADASTRADO!");
		this.idProduto = idProduto;
	}	
	
	public ProdutoCadastradoException(){
		
	}
	
	public String getIdProduto() {
		return idProduto;
	}
	
	
}
