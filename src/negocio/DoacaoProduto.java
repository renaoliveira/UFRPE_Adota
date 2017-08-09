package negocio;

import java.util.Date;

public class DoacaoProduto {

	private String idDoacao;
	private Date data;
	private Pessoa doador;
	private Produto produto;

	public DoacaoProduto(Produto produto) {
		this.produto = produto;
	}

	public DoacaoProduto() {
		System.out.println("Objeto da classe DoacaoProduto instanciado com sucesso!");
	}

	public String getIdDoacao() {
		return idDoacao;
	}

	public void setId_doacao(String idDoacao) {
		this.idDoacao = idDoacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pessoa getDoador() {
		return doador;
	}

	public void setDoador(Pessoa doador) {
		this.doador = doador;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
