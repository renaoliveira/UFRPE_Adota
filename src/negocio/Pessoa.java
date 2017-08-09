package negocio;

public class Pessoa {

	private String nome;
	private String login;
	private String senha;
	private String email;
	private String telefone;
	private Endereco endereco;

	public Pessoa(String login) {
		this.login = login;
	}

	public Pessoa() {
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void adotar() {
	}

	public void doacaoProduto() {
	}

	public void Lar() {
	}

}
