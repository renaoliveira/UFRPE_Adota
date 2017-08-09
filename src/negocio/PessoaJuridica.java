package negocio;

public class PessoaJuridica extends Pessoa {

	private String razaoSocial;
	private String cnpj;

	public PessoaJuridica(String nome) {
		super(nome);
	}

	public PessoaJuridica() {
		System.out.println("Objeto da classe PessoaJuridica instanciado com sucesso!");
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void adotar() {
		System.out.println("Quais as intenções com o bichinho?");
	}

	public void doacaoProduto() {
		System.out.println("Pessoa Juridica doou um produto!");
	}

	public void Lar() {
		System.out.println("Pessoa Juridica é Lar temporário!");
	}
}