package excecao;

import negocio.Endereco;

public class LarNaoCadastradoException extends Exception{
	
	private Endereco casa;
	
	public LarNaoCadastradoException(Endereco casa){
		super("Lar Não Cadastrado!");
		this.casa = casa;
	}
	
	public Endereco getEndereco(){
		return casa;
	}
}
