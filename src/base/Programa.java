package base;

import excecao.PessoaCadastradaException;
import excecao.PessoaInexistenteException;
import excecao.ProdutoCadastradoException;
import excecao.ProdutoInexistenteException;

import negocio.Animal;
import negocio.Fachada;
import negocio.Pessoa;
import negocio.Produto;
import repositorio.RepositorioAnimalArray;
import repositorio.RepositorioPessoaArray;
import repositorio.RepositorioProdutoLista;

public class Programa {

	public static void main(String[] args){
		Fachada f = Fachada.getInstance();

		Pessoa p1 = new Pessoa("Renato.Oliveira");
		Pessoa p2 = new Pessoa("Lidiane.Monteiro");

		Pessoa p3 = new Pessoa("Klebson.Luiz");
		Pessoa p4 = new Pessoa("Klebson.Luiz");
		
		Produto prod1 = new Produto("Comprimido");
		Produto prod2 = new Produto("Comprimido");
		
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
		
		try{
			f.inserir(prod1);
			f.inserir(prod2);
		}catch(ProdutoCadastradoException e){
			//e.printStackTrace();
			System.out.println("Já existe um produto cadastrado com esse tipo " +e.getIdProduto() +" Tente outro por favor!");
		}
		
	}

}
