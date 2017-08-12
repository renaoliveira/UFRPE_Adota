package excecao;

public class PessoaInexistenteException extends Exception{
	
	private static final long serialVersionUID = 1L; /*Campo que define a versão de uma determinada classe durante a serialização e deserialização*/
	private String login;
	private String email;	
	
	public PessoaInexistenteException(String login){
		super("PESSOA INEXISTENTE");
		this.login = login;
	}
	
	public String getLogin(){
		return login;
	}
	
	public String getEmail(){
		return email;
	}

}
