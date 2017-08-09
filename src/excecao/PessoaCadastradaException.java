package excecao;

public class PessoaCadastradaException extends Exception{
	
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
