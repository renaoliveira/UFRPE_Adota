package repositorio;
import interfaces.IRepositorioLarTemporario;
import negocio.LarTemporario;

public class RepositorioLarTemporarioArray implements IRepositorioLarTemporario {

    private LarTemporario[] lar;
    private int indice;
    private final static int TAMANHO = 100;

    public RepositorioLarTemporarioArray(){
        this.lar = new LarTemporario[TAMANHO];
        this.indice = 0;
    }
    
    private int getIndice(String id){
        int i = 0;
        while(id != lar[i].getIdLar()){
            i++;
            if(i >= indice)
                return indice;
        }
        return i;
    }

    @Override
    public void inserir(LarTemporario lar) {
        if(this.lar[indice] == null) {
            this.lar[indice] = lar;
            this.indice = this.indice + 1;
        }
        else {
            for (int i=0; i<this.lar.length; i++) {
                if (this.lar[i] == null) {
                    this.lar[indice] = lar;
                    this.indice = this.indice + 1;
                    break;
                }
            }
        }
    }

    @Override
    public LarTemporario procurar (String id) {
        for(int i=0; i < this.lar.length; i++){
            if(id == this.lar[i].getIdLar()){
                return this.lar[i];
            }
        }
        return null;
    }

    @Override
    public void remover(String id) {
        for(int i=0; i < this.lar.length; i++){
            if(id == this.lar[i].getIdLar()){
                this.lar[i] = null;
                this.indice = this.indice - 1;
                break;
            }
        }
    }

    @Override
    public void atualizar(LarTemporario lar) {
        for(int i=0; i < this.lar.length; i++){
            if(lar.getIdLar() == this.lar[i].getIdLar()){
                this.lar[i] = lar;
                break;
            }
        }
    }
    
    

}