package negocio;

public class LarTemporario {

	private String idLar;
	private Pessoa voluntario;
	private Endereco endereco;
	private String status;
	private String capacidade;

	public LarTemporario(Pessoa voluntario) {
		this.voluntario = voluntario;
	}

	public LarTemporario() {
		System.out.println("Objeto da classe LarTemporario instanciado com sucesso!");
	}

	public String getIdLar() {
		return idLar;
	}

	public void setId_lar(String idLar) {
		this.idLar = idLar;
	}

	public Pessoa getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(Pessoa voluntario) {
		this.voluntario = voluntario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

}
