package li3java;

public abstract class Utilizadores {
    private int numDados;
    
    Utilizadores(){
        this.numDados = 5;
    }
    
    Utilizadores(int numDados){
        this.numDados = numDados;
    }
    
    public abstract void insere(Utilizador novo);
    public abstract Utilizador procuraNif(String nif);
    public abstract Utilizador procuraNome(String nome);
    public abstract StringBuilder toStringNif();
    public abstract StringBuilder toStringNome();
    
}
