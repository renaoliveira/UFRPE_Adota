package excecao;

public class SemPosicaoLivreException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public SemPosicaoLivreException() {
		super("Não existe posição livre para inserir!");
	}
}
