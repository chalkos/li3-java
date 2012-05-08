package li3java;

/**
 * Localidade (abstracta)
 */
public abstract class Localidade {
    private String nome;
    
    Localidade(){
        this.nome="";
    }
    
    Localidade(String nome){
        this.nome=nome;
    }
    
    public String getNome(){
        return this.nome;
    }
}