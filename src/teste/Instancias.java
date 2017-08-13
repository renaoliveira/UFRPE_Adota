package teste;

import negocio.Pessoa;

public class Instancias {
	
	private static Pessoa instancePessoa;
	private static Instancias instance;
	
	public static Instancias getInstance(){
		if(Instancias.instance == null)
			Instancias.instance = new Instancias();
		return Instancias.instance;
	}
	
	public static Pessoa getInstancePessoa(){
		
		if(Instancias.instancePessoa == null)
			Instancias.instancePessoa = new Pessoa();
		
		
		Instancias.instancePessoa.setLogin("Teste");
		Instancias.instancePessoa.setEmail("teste@teste.com");
		Instancias.instancePessoa.setSenha("teste123");
		return Instancias.instancePessoa;
	}

}
