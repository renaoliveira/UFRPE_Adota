package negocio;

import java.util.Date;

public class Adocao {

	private String idAdocao;
	private String idAnimal;
	private String status;
	private Date data;
	private Pessoa tutor;
	private Endereco endereco;

	public Adocao(Pessoa tutor) {
		this.tutor = tutor;
	}

	public Adocao() {
		System.out.println("Objeto da classe Adocao instanciado com sucesso!");
	}

	public String getIdAdocao() {
		return idAdocao;
	}

	public void setIdAdocao(String idAdocao) {
		this.idAdocao = idAdocao;

	}

	public String getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(String idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pessoa getTutor() {
		return tutor;
	}

	public void setTutor(Pessoa tutor) {
		this.tutor = tutor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
