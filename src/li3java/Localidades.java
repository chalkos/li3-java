package li3java;

public abstract class Localidades {
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
    
    public abstract void insere(Localidade novo);
    //public abstract Utilizador procuraNif(String nif);
    //public abstract Utilizador procuraNome(String nome);
    //public abstract StringBuilder toStringNif();
    //public abstract StringBuilder toStringNome();
}
