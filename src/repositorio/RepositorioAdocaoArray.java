package repositorio;
import interfaces.IRepositorioAdocao;
import negocio.Adocao;

public class RepositorioAdocaoArray implements IRepositorioAdocao {

    private Adocao[] adocao;
    private int indice;
    private final static int TAMANHO = 100;

    public RepositorioAdocaoArray(){
        this.adocao = new Adocao[TAMANHO];
        this.indice = 0;
    }
    
    private int getIndice(String id){
        int i = 0;
        while(id != adocao[i].getIdAdocao()){
            i++;
            if(i >= indice)
                return indice;
        }
        return i;
    }

    @Override
    public void inserir(Adocao adocao) {
        if(this.adocao[indice] == null) {
            this.adocao[indice] = adocao;
            this.indice = this.indice + 1;
        }
        else {
            for (int i=0; i<this.adocao.length; i++) {
                if (this.adocao[i] == null) {
                    this.adocao[indice] = adocao;
                    this.indice = this.indice + 1;
                    break;
                }
            }
        }
    }

    @Override
    public Adocao procurar (String id) {
        for(int i=0; i < this.adocao.length; i++){
            if(id == this.adocao[i].getIdAdocao()){
                return this.adocao[i];
            }
        }
        return null;
    }

    @Override
    public void remover(String id) {
        for(int i=0; i < this.adocao.length; i++){
            if(id == this.adocao[i].getIdAdocao()){
                this.adocao[i] = null;
                this.indice = this.indice - 1;
                break;
            }
        }
    }

    @Override
    public void atualizar(Adocao adocao) {
        for(int i=0; i < this.adocao.length; i++){
            if(adocao.getIdAdocao() == this.adocao[i].getIdAdocao()){
                this.adocao[i] = adocao;
                break;
            }
        }
    }
    
    

}
