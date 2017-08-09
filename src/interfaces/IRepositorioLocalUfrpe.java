package interfaces;

import negocio.LocalUfrpe;

public interface IRepositorioLocalUfrpe {
    public void inserir(LocalUfrpe local);
    public LocalUfrpe procurar (String id);
    public void remover(String id);
    public void atualizar(LocalUfrpe local);
}
