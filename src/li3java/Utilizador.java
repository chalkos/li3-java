package li3java;

import java.util.Comparator;

/**
 * Classe que permite gerir um utilizador
 */
public class Utilizador {
    private String nome;
    private String morada;
    private String nif;
    
    /**
     * Inicializa um novo utilizador com dados inúteis
     */
    Utilizador(){
        this.nome="";
        this.morada="";
        this.nif="";
    }
    
    /**
     * Inicializa um novo utilizador com os dados fornecidos
     * @param nif O número de contribuinte do utilizador
     * @param nome O nome do Utilizador
     * @param morada A morada do Utilizador
     */
    Utilizador(String nif, String nome, String morada){
        this.nif = nif;
        this.nome = nome;
        this.morada = morada;
    }
    
    /**
     * Inicializa um novo utilizador com o nif/nome indicado
     * @param n O número de contribuinte do utilizador
     * @param nif Verdade se n é um numero de contribuinte, false se n é um nome
     */
    Utilizador(String n, boolean nif){
        this.morada = "";
        if(nif){
            this.nome = "";
            this.nif = n;
        }else{
            this.nome = n;
            this.nif = "";
        }
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
    String getNif(){
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
        return (this.getNif().compareTo(u.getNif()));
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
    
    /**
     * Muda a morada do utilizador para a indicada
     * @param morada A nova morada do utilizador
     */
    public void changeMorada(String morada){
        this.morada = morada;
    }
    
    /**
     * Obtém uma representação simplista da informação sobre o utilizador
     * @return A informação do utilizador
     */
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

/**
 * Classe que permite comparar Utilizadores pelo nome
 */
class comparadorNome implements Comparator<Utilizador>{
    @Override
    public int compare(Utilizador primeiro, Utilizador segundo){
        return primeiro.compareNome(segundo);
    }
   
}

/**
 * Classe que permite comparar Utilizadores pelo nif
 */
class comparadorNif implements Comparator<Utilizador>{
    @Override
    public int compare(Utilizador primeiro, Utilizador segundo){
        return primeiro.compareNif(segundo);
    }
   
}