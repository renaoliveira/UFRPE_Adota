package excecao;

public class SemPosicaoLivreException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public SemPosicaoLivreException() {
		super("N�o existe posi��o livre para inserir!");
	}
}
