package excecao;

public class PessoaInexistenteException extends Exception{
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
