package base;

import excecao.PessoaCadastradaException;
import excecao.PessoaInexistenteException;
import negocio.Animal;
import negocio.Fachada;
import negocio.Pessoa;
import repositorio.RepositorioAnimalArray;
import repositorio.RepositorioPessoaArray;

public class Programa {

	public static void main(String[] args) throws PessoaCadastradaException, PessoaInexistenteException {
		Fachada f = Fachada.getInstance();

		Pessoa p1 = new Pessoa("Renato.Oliveira");
		Pessoa p2 = new Pessoa("Lidiane.Monteiro");

		Pessoa p3 = new Pessoa("Klebson.Luiz");
		Pessoa p4 = new Pessoa("Klebson.Luiz");
		///PESQUISAR SOBRE
		try{
			f.inserir(p1);
			f.inserir(p2);
			f.inserir(p3);
			f.inserir(p4);
		}catch(PessoaCadastradaException e){
			//e.printStackTrace();
			System.out.println("Já existe uma pessoa cadastrada com o login " +e.getLogin() +" Tente outro por favor!");
		}
		
	}

}
