package negocio;

import java.util.Date;

public class LocalUfrpe {
	
	private String nome;
	private String idLocal; // Locais na UFRPE
	private Date data;
	private double latitude; 
	private double longitute;
	
	public LocalUfrpe(String nome) {
		this.nome = nome;
	}


	public LocalUfrpe() {
		System.out.println("Objeto da classe LocalUfrpe instanciado com sucesso!");
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdLocal() {
		return idLocal;
	}


	public void setId(String id) {
		this.idLocal = id;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitute() {
		return longitute;
	}


	public void setLongitute(double longitute) {
		this.longitute = longitute;
	}
	

}
