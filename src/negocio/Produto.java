package negocio;

public class Produto {

	private String idProduto;
	private String descricao;
	private String tipo;
	private int quantidade;
	private double preco;

	public Produto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Produto() {
		System.out.println("Objeto da classe Produto instanciado com sucesso!");
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double valorDoacao(int quantidade, double preco){		
		return preco*quantidade;
	}
	
	public void agregaQuantidade(int quantidade){
		setQuantidade(this.getQuantidade()+quantidade);
	}
}
