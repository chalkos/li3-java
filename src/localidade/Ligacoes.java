package localidade;

public abstract class Ligacoes {
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
}
