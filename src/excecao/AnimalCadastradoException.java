package excecao;

public class AnimalCadastradoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	
	public AnimalCadastradoException(String id){
		super("ANIMAL JÀ CADASTRADO!");
		this.id = id;
	}
	
	public String getId(){
		return id;
	}

}
