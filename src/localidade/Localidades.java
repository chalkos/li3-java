package localidade;

public abstract class Localidades {
    int numDados;
    int tipoLigs;
    
    Localidades(){
        this.numDados = 5;
        this.tipoLigs = 0;
    }
    
    Localidades(int numDados){
        this.numDados = numDados;
    }
    
    Localidades(int numDados, int tipoLigacoes){
        this.numDados = numDados;
        this.tipoLigs = tipoLigacoes;
    }
    
    public int getNumDados(){
        return this.numDados;
    }
    
    public int getTipoLigacoes(){
        return this.tipoLigs;
    }
    
    public abstract void insere(Localidade novo);
    public void insere(String nome){
        this.insere( new Localidade(nome, this.getTipoLigacoes()));
    }
    public abstract void insereLigacao(Localidade loc, Ligacao lig);
    
    public void insereLigacao(String nome, Ligacao lig){
        Localidade loc = new Localidade(nome);
        insereLigacao(loc, lig);
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
}
