package interfaces;

import excecao.PessoaCadastradaException;
import excecao.PessoaInexistenteException;
import negocio.Pessoa;

public interface IRepositorioPessoa {
	public void inserir(Pessoa pessoa) throws PessoaCadastradaException;

	public Pessoa procurar(String login) throws PessoaInexistenteException;

	public void remover(String login);

	public void atualizar(Pessoa pessoa);

	public boolean existe(String login) throws PessoaInexistenteException;
}
