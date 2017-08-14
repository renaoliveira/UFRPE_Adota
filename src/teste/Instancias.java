package teste;

import negocio.Animal;
import negocio.Endereco;
import negocio.Pessoa;

public class Instancias {
	
	private static Pessoa instancePessoa;
	private static Animal instanceAnimal;
	private static Endereco instanceEndereco;
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
	
	public static Animal getInstanceAnimal(){
		if(Instancias.instanceAnimal == null)
			Instancias.instanceAnimal = new Animal();

		Instancias.instanceAnimal.setEspecie("Cachorro");
		Instancias.instanceAnimal.setId("dog01");
		Instancias.instanceAnimal.setNome("Negao");
		Instancias.instanceAnimal.setPeso(50);
		Instancias.instanceAnimal.setCastracao(true);
		Instancias.instanceAnimal.setCor("Preto");
		
		return Instancias.instanceAnimal;
		
	}

	public static Endereco getInstanceEndereco(){
		if(Instancias.instanceEndereco == null)
			Instancias.instanceEndereco = new Endereco();
		
		Instancias.instanceEndereco.setCidade("Recife");
		Instancias.instanceEndereco.setBairro("Dois Irmãos");
		Instancias.instanceEndereco.setRua("Av. Dois Irmãos");
		Instancias.instanceEndereco.setNumero(1);
		
		return Instancias.instanceEndereco;
	}
	
}
