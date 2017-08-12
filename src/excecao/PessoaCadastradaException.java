package excecao;

public class PessoaCadastradaException extends Exception{
	
	private static final long serialVersionUID = 1L; /*Campo que define a versão de uma determinada classe durante a serialização e deserialização*/
	private String login;
	private String email;
	
	public PessoaCadastradaException(String login){
		super("PESSOA JÁ FOI CADASTRADA");
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
