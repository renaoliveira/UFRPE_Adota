package negocio;

public class Animal {

	private String id;
	private String nome;
	private int idade;
	private String raca;
	private String cor;
	private String especie;
	private double tamanho;
	private double peso;
	private String porte;
	private String pelagem;
	private LocalUfrpe abandono;
	private boolean castracao;
	private LocalUfrpe local;
	private String foto;
	private String historico;

	public Animal(String nome, String id) {
		this.nome = nome;
		this.id = id;
	}

	public Animal() {
		System.out.println("Objeto da classe Animal instanciado com sucesso!");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}

	public boolean isCastracao() {
		return castracao;
	}

	public void setCastracao(boolean castracao) {
		this.castracao = castracao;
	}

	public LocalUfrpe getLocal() {
		return local;
	}

	public void setLocal(LocalUfrpe local) {
		this.local = local;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public LocalUfrpe getAbandono() {
		return abandono;
	}

	public void setAbandono(LocalUfrpe abandono) {
		this.abandono = abandono;
	}

}
