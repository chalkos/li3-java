package li3java;

import java.util.Comparator;

public class Utilizador {
    private String nome;
    private String morada;
    private int nif;
    
    Utilizador(){
        this.nome="";
        this.morada="";
        this.nif=-1;
    }
    
    Utilizador(int nif, String nome, String morada){
        this.nif = nif;
        this.nome = nome;
        this.morada = morada;
    }
    
    Utilizador(int nif){
        this.morada = "";
        this.nome = "";
        this.nif = nif;
    }
    
    Utilizador(String nome){
        this.morada="";
        this.nif=-1;
        this.nome = nome;
    }
    
    /**
     * Obter o nome do Utilizador
     * @return O nome do Utilizador
     */
    String getNome(){
        return this.nome;
    }
    
    /**
     * Obter a morada do Utilizador
     * @return A morada do Utilizador
     */
    String getMorada(){
        return this.morada;
    }
    
    /**
     * Obter o nif do Utilizador
     * @return O nif do Utilizador
     */
    int getNif(){
        return this.nif;
    }
    
    /**
     * Clona um Utilizador
     * @return Um utilizador com os mesmos conteúdos do original
     */
    @Override
    public Utilizador clone(){
        return new Utilizador(this.getNif(), this.getNome(), this.getMorada());
    }
    
    /**
     * Verifica se o Utilizador é igual a um segundo Utilizador
     * @param u O segundo Utilizador
     * @return True Caso sejam iguais
     * @return False Caso não sejam iguais
     */
    public boolean equals(Utilizador u){
        return (this.getNif() == u.getNif()
                && this.getNome().contentEquals(u.getNome())
                && this.getMorada().contentEquals(u.getMorada()));
    }
    /**
     * Compara dois numeros de contribuinte.
     * @param u O segundo Utilizador
     * @return <0 Se o nif do primeiro utilizador for menor que o do segundo
     * @return  0 Se os nif forem iguais
     * @return >0 Se o nif do primeiro utilizador for maior que o do segundo
     */
    public int compareNif(Utilizador u){
        return this.getNif() - u.getNif();
    }
    
    /**
     * Compara dois nomes de utilizador.
     * @param u O segundo Utilizador
     * @return <0 Se o nome do primeiro utilizador for considerado menor que o do segundo
     * @return  0 Se os nomes forem iguais
     * @return >0 Se o nome do primeiro utilizador for considerado maior que o do segundo
     */
    public int compareNome(Utilizador u){
        return (this.getNome().compareTo(u.getNome()));
    }
    
    public void changeMorada(String morada){
        this.morada = morada;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        sb.append(this.getNif());
        sb.append(" | ");
        sb.append(this.getNome());
        sb.append(" | ");
        sb.append(this.getMorada());
        sb.append("}");
        return sb.toString();
    }
}

class comparadorNome implements Comparator<Utilizador>{
    @Override
    public int compare(Utilizador primeiro, Utilizador segundo){
        return primeiro.compareNome(segundo);
    }
   
}

class comparadorNif implements Comparator<Utilizador>{
    @Override
    public int compare(Utilizador primeiro, Utilizador segundo){
        return primeiro.compareNif(segundo);
    }
   
}
