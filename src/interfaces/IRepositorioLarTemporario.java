package interfaces;

import negocio.LarTemporario;

public interface IRepositorioLarTemporario {
	public void inserir(LarTemporario lar);
    public LarTemporario procurar (String id);
    public void remover(String id);
    public void atualizar(LarTemporario lar);
}
