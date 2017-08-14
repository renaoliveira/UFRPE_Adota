package negocio;

import repositorio.RepositorioAnimalLista;
import repositorio.RepositorioDoacaoProdutoArray;
import repositorio.RepositorioPessoaLista;
import repositorio.RepositorioProdutoLista;

import excecao.AnimalNaoCadastradoException;
import excecao.PessoaCadastradaException;
import excecao.PessoaInexistenteException;
import excecao.ProdutoCadastradoException;
import excecao.ProdutoInexistenteException;
import excecao.DoacaoProdutoCadastradaException;
import excecao.DoacaoProdutoInexistenteException;
import excecao.RemocaoNaoConcluidaException;
import excecao.SemPosicaoLivreException;

import interfaces.IRepositorioAnimal;
import interfaces.IRepositorioPessoa;
import interfaces.IRepositorioProduto;
import interfaces.IRepositorioDoacaoProduto;

public class Fachada {

	private ControlePessoa pessoas;
	private ControleAnimal animais;
	private ControleProduto produtos;
	private ControleDoacaoProduto doacaoprodutos;
	
	private static Fachada instance;

	public Fachada() {
		IRepositorioPessoa repositorioPessoas = new RepositorioPessoaLista();
		pessoas = new ControlePessoa(repositorioPessoas);
		IRepositorioAnimal repositorioAnimais = new RepositorioAnimalLista();
		animais = new ControleAnimal(repositorioAnimais);
		IRepositorioProduto repositorioProdutos = new RepositorioProdutoLista();
		produtos = new ControleProduto(repositorioProdutos);
		IRepositorioDoacaoProduto repositorioDoacaoProdutos = new RepositorioDoacaoProdutoArray();
		doacaoprodutos = new ControleDoacaoProduto(repositorioDoacaoProdutos);
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	public Pessoa getPessoa(){
		return pessoas.getPessoa();
	}
	
	public Animal getAnimal(){
		return animais.getAnimal();
	}
	
	public void inserir(Pessoa pessoa) throws PessoaCadastradaException{
		this.pessoas.cadastrar(pessoa);
	}
	
	public void inserir(Animal animal){
		this.animais.cadastrar(animal);
	}
	
	public void inserir(Produto produto) throws ProdutoCadastradoException {
		this.produtos.inserir(produto);
	}
	
	public void inserirDoacaoProduto(DoacaoProduto doacaoproduto) throws DoacaoProdutoCadastradaException, SemPosicaoLivreException {
		this.doacaoprodutos.inserir(doacaoproduto);
	}
	
	public Pessoa procurarPessoa(String login) throws PessoaInexistenteException{
		return this.pessoas.procurar(login);
	}
	
	public Animal procurarAnimal(String id) throws AnimalNaoCadastradoException{
		return this.animais.procurar(id);
	}
	
	public Produto procurarProduto(String idProduto) throws ProdutoInexistenteException {
		return this.produtos.procurar(idProduto);
	}
	
	public DoacaoProduto procurarDoacaoProduto(String idDoacao) throws DoacaoProdutoInexistenteException {
		return this.doacaoprodutos.procurar(idDoacao);
	}
	
	public void removerPessoa(String login) throws PessoaInexistenteException {
		this.pessoas.remover(login);
	}
	
	public void removerAnimal(String id) throws AnimalNaoCadastradoException{
		this.animais.remover(id);
	}
	
	public void removerProduto(String idProduto) throws ProdutoInexistenteException{
		this.produtos.remover(idProduto);
	}
	
	public void removerDoacaoProduto(String idDoacao) throws DoacaoProdutoInexistenteException, RemocaoNaoConcluidaException {
		this.doacaoprodutos.remover(idDoacao);
	}
	
	public void atualizar(Pessoa pessoa) {
		this.pessoas.atualizar(pessoa);
	}
	
	public void atualizar(Animal animal){
		this.animais.atualizar(animal);
	}
	
	public void atualizar(Produto produto){
		this.produtos.atualizar(produto);
	}
	
	public void atualizarDoacaoProduto(DoacaoProduto doacaoproduto) throws DoacaoProdutoInexistenteException {
		this.doacaoprodutos.atualizar(doacaoproduto);
	}
	
	public boolean existePessoa(String login){
		return this.pessoas.existe(login);
	}
	
	public boolean existeAnimal(String id){
		return this.animais.existe(id);
	}
	
	public boolean existeProduto(String idProduto) throws ProdutoInexistenteException{
		return this.produtos.existe(idProduto);
	}
	
	public boolean existeDoacaoProduto(String idDoacao) throws DoacaoProdutoInexistenteException{
		return this.doacaoprodutos.existe(idDoacao);
	}
}
