package excecao;

public class DoacaoProdutoInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;
	private String idDoacao;
	
	public DoacaoProdutoInexistenteException(String idDoacao) {
		super("DOA��O INEXISTENTE!");
		this.idDoacao = idDoacao;
	}
	
	public String getIdDoacao() {
		return idDoacao;
	}
}
