package localidade;

import java.io.Serializable;
import java.util.Collection;

public abstract class Ligacoes implements Serializable {
    public abstract boolean insere(Ligacao lig);
    public boolean insere(String nome, double distancia, double custo){
        return this.insere( new Ligacao(nome, distancia, custo) );
    }
    
    public abstract Ligacao procura(String nomeLig);
    public abstract String[][] listaLigacoes();
    
    @Override
    public abstract String toString();
    
    @Override
    public abstract Ligacoes clone();
    
    abstract Collection<Ligacao> getLigacoes();
}
