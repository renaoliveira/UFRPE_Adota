package interfaces;
import negocio.Adocao;

public interface IRepositorioAdocao {
    public void inserir(Adocao adocao);
    public Adocao procurar (String id);
    public void remover(String id);
    public void atualizar(Adocao adocao);
}
