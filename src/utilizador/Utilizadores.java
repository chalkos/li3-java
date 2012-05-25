package utilizador;

import java.io.Serializable;

public abstract class Utilizadores implements Serializable{
    public static final int CAMPO_NIF = 0;
    public static final int CAMPO_NOME = 1;
    private int numDados;
    
    Utilizadores(){
        this.numDados = 5;
    }
    
    Utilizadores(int numDados){
        this.numDados = numDados;
    }
    
    public int getNumDados(){
        return this.numDados;
    }
    
    public abstract boolean insere(Utilizador novo);
    public abstract Utilizador procuraNif(String nif);
    public abstract Utilizador procuraNome(String nome);
    public abstract StringBuilder toStringNif();
    public abstract StringBuilder toStringNome();
    public abstract String[][] contains(String valor, int campo);
    public abstract void remove(String nif);
}
