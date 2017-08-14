package negocio;

import java.util.ArrayList;
import java.util.List;

import excecao.LarNaoCadastradoException;

public class Pessoa {

	private String nome;
	private String login;
	private String senha;
	private String email;
	private String telefone;
	private Endereco endereco;
	private List<Animal> pets = new ArrayList<Animal>();
	private Produto produto;

	public Pessoa(String login) {
		this.login = login;
	}

	public Pessoa(){
		System.out.println("Objeto da classe Pessoa instanciado com sucesso!");		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() throws LarNaoCadastradoException{
		if(endereco != null)
			return endereco;
		else{
			LarNaoCadastradoException e = new LarNaoCadastradoException(endereco);
			throw e;
		}
	}

	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}

	public void setAdocao(Animal pet) {
		pets.add(pet);
	}
	
	public Animal getAdocao(int index){
		return pets.get(index);
	}
	
	public int getNumPets(){
		return pets.size();
	}
	
	public void setDoacao(Produto produto) {
		this.produto = produto;
	}
	
	public Produto getProduto(){
		return this.produto;
	}

}
