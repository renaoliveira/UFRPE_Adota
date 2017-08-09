package negocio;

import excecao.PessoaCadastradaException;
import excecao.PessoaInexistenteException;
import interfaces.IRepositorioPessoa;

public class ControlePessoa{

	private IRepositorioPessoa pessoas;

	public ControlePessoa(IRepositorioPessoa repositorio) {
		this.pessoas = repositorio;
	}

	public void cadastrar(Pessoa pessoa) throws PessoaCadastradaException, PessoaInexistenteException{
		if (pessoa != null) {
			if (!(pessoas.existe(pessoa.getLogin()))) {
				pessoas.inserir(pessoa);
			} else{
				PessoaCadastradaException e = new PessoaCadastradaException(pessoa.getLogin());
				throw e;
			}
			
		} else
			System.out.println("Pessoa Invalida!");
	}

	public Pessoa procurar(String login) throws PessoaInexistenteException {
		return this.pessoas.procurar(login);
	}

	public void remover(String login) throws PessoaInexistenteException{
		// COLOCAR VALIDACAO E REGRA DE NEGOCIO
		this.pessoas.remover(login);
	}

	public void atualizar(Pessoa pessoa) {
		// COLOCAR VALIDACAO E REGRA DE NEGOCIO
		this.pessoas.atualizar(pessoa);
	}
	public boolean existe(String login) throws PessoaInexistenteException{
		return this.pessoas.existe(login);
	}
}
