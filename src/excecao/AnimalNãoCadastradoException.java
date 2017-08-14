package excecao;

public class AnimalN�oCadastradoException extends Exception{
	private String id;
	private String nome;
	private String especie;
	private String cor;
	
	public AnimalN�oCadastradoException(String id){
		super("Animal N�o Existe");
		this.id = id;
	}
	
	public String getId(){
		return id;
	}

}
