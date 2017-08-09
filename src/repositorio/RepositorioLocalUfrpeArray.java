package repositorio;
import interfaces.IRepositorioLocalUfrpe;
import negocio.LocalUfrpe;

public class RepositorioLocalUfrpeArray implements IRepositorioLocalUfrpe {

    private LocalUfrpe[] local;
    private int indice;
    private final static int TAMANHO = 100;

    public RepositorioLocalUfrpeArray(){
        this.local = new LocalUfrpe[TAMANHO];
        this.indice = 0;
    }
    
    private int getIndice(String id){
        int i = 0;
        while(id != local[i].getIdLocal()){
            i++;
            if(i >= indice)
                return indice;
        }
        return i;
    }

    @Override
    public void inserir(LocalUfrpe local) {
        if(this.local[indice] == null) {
            this.local[indice] = local;
            this.indice = this.indice + 1;
        }
        else {
            for (int i=0; i<this.local.length; i++) {
                if (this.local[i] == null) {
                    this.local[indice] = local;
                    this.indice = this.indice + 1;
                    break;
                }
            }
        }
    }

    @Override
    public LocalUfrpe procurar (String id) {
        for(int i=0; i < this.local.length; i++){
            if(id == this.local[i].getIdLocal()){
                return this.local[i];
            }
        }
        return null;
    }

    @Override
    public void remover(String id) {
        for(int i=0; i < this.local.length; i++){
            if(id == this.local[i].getIdLocal()){
                this.local[i] = null;
                this.indice = this.indice - 1;
                break;
            }
        }
    }

    @Override
    public void atualizar(LocalUfrpe local) {
        for(int i=0; i < this.local.length; i++){
            if(local.getIdLocal() == this.local[i].getIdLocal()){
                this.local[i] = local;
                break;
            }
        }
    }
    
    

}
