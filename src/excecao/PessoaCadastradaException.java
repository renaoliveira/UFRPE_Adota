package excecao;

public class PessoaCadastradaException extends Exception{
	
	private static final long serialVersionUID = 1L; /*Campo que define a vers�o de uma determinada classe durante a serializa��o e deserializa��o*/
	private String login;
	private String email;
	
	public PessoaCadastradaException(String login){
		super("PESSOA J� FOI CADASTRADA");
		this.login = login;
	}
	
	public PessoaCadastradaException(){
		
	}
	
	public String getLogin(){
		return login;
	}
	
	public String getEmail(){
		return email;
	}

}
