package excecao;

public class RemocaoNaoConcluidaException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public RemocaoNaoConcluidaException (){
		super("Remo��o n�o conclu�da!!");
	}
}
