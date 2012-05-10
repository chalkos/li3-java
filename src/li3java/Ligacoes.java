package li3java;

public abstract class Ligacoes {
    public abstract void insere(Ligacao lig);
    public void insere(String nome, double distancia, double custo){
        this.insere( new Ligacao(nome, distancia, custo) );
    }
    
    public abstract Ligacao procura(String nomeLig);
    
    @Override
    public abstract String toString();
    
    @Override
    public abstract Ligacoes clone();
}
