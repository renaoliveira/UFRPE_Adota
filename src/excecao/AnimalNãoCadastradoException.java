package excecao;

public class AnimalNãoCadastradoException extends Exception{
	private String id;
	private String nome;
	private String especie;
	private String cor;
	
	public AnimalNãoCadastradoException(String id){
		super("Animal Não Existe");
		this.id = id;
	}
	
	public String getId(){
		return id;
	}

}
