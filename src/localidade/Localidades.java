package localidade;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Localidades implements Serializable {
    int numDados;
    
    Localidades(){
        this.numDados = 5;
    }
    
    Localidades(int numDados){
        this.numDados = numDados;
    }
    
    public int getNumDados(){
        return this.numDados;
    }
    
    public abstract boolean insere(Localidade novo);
    public boolean insere(String nome){
        return this.insere( new Localidade(nome));
    }
    public abstract boolean insereLigacao(Localidade loc, Ligacao lig);
    
    public boolean insereLigacao(String nome, Ligacao lig){
        Localidade loc = new Localidade(nome);
        return insereLigacao(loc, lig);
    }
    
    public abstract Ligacao procuraLig(Localidade loc, Ligacao lig);
    
    public Ligacao procuraLig(String nomeLoc, Ligacao lig){
        Localidade loc = new Localidade(nomeLoc);
        return procuraLig(loc, lig);
    }
    
    public Ligacao procuraLig(Localidade loc, String nomeLig){
        Ligacao lig = new Ligacao(nomeLig);
        return procuraLig(loc, lig);
    }
    
    public Ligacao procuraLig(String nomeLoc, String nomeLig){
        Localidade loc = new Localidade(nomeLoc);
        Ligacao lig = new Ligacao(nomeLig);
        return procuraLig(loc, lig);
    }
    
    @Override
    public abstract String toString();
    
    public abstract String[] contains(String value);
    public abstract String[][] listaLigacoes(String origem);
    abstract HashMap<String, Localidade> getLocalidades();
    public abstract String escritaLocalidades();
    public abstract String escritaLigacoes();
}
