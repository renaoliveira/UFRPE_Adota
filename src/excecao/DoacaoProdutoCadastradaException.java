package excecao;

public class DoacaoProdutoCadastradaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String idDoacao;
	
	public DoacaoProdutoCadastradaException(String idDoacao){
		super("DOA��O J� FOI CADASTRADA!");
		this.idDoacao = idDoacao;
	}	
	
	public String getIdDoacao() {
		return idDoacao;
	}

}
