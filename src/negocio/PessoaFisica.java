package negocio;

public class PessoaFisica extends Pessoa {

	private String cpf;
	private String rg;

	public PessoaFisica(String nome) {
		super(nome);
	}

	public PessoaFisica() {
		System.out.println("Objeto da classe PessoaJuridica instanciado com sucesso!");
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void adotar() {
		System.out.println("Voc� adotou Um bichinho!");
	}

	public void doacaoProduto() {
		System.out.println("Pessoa F�sica doou um produto!");
	}

	public void Lar() {
		System.out.println("Pessoa F�sica pegou animal para Lar tempor�rio!");
	}

}
