package repositorio;

import interfaces.IRepositorioPessoa;
import negocio.Pessoa;

public class RepositorioPessoaArray implements IRepositorioPessoa {
	private Pessoa[] pessoas;
	private int indice;

	private final static int TAMANHO = 100;

	public RepositorioPessoaArray() {
		this.pessoas = new Pessoa[TAMANHO];
		this.indice = 0;
	}

	private int getIndice(String login) {

		String n;
        boolean achou = false;
        int i = 0;
        while ((!achou) && (i < this.indice)) {
            n = pessoas[i].getLogin();
            if (n.equals(login)) {
                achou = true;
            } else {
                i++;
            }
        }
        return i;
	}

	public void inserir(Pessoa pessoa) {
		pessoas[indice] = pessoa;
		indice++;
	}

	public Pessoa procurar(String login) {
		int i = getIndice(login);
		if (pessoas[i] == null) {
			return null;
		}
		return pessoas[i];
	}

	public void remover(String login) {
		int i = getIndice(login);
		pessoas[i] = null;
		pessoas[i] = pessoas[indice - 1];
		indice--;
	}

	public void atualizar(Pessoa pessoa) {
		int i = getIndice(pessoa.getLogin());
		pessoas[i] = pessoa;
	}

	public boolean existe(String login) {
		int i = getIndice(login);

		if (pessoas[i] == null)
			return false;
		else
			return true;

	}

	@Override
	public Pessoa getPessoa() {
		// TODO Auto-generated method stub
		return null;
	}
}
