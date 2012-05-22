package utilizador;

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
    public Utilizador(){
        this.nome="";
        this.morada="";
        this.nif="";
    }
    
    /**
     * Inicializa um novo utilizador com dados de um utilizador existente
     * @param existente 
     */
    public Utilizador(Utilizador existente){
        this.nome = existente.getNome();
        this.morada = existente.getMorada();
        this.nif = existente.getNif();
    }
    
    /**
     * Inicializa um novo utilizador com os dados fornecidos
     * @param nif O número de contribuinte do utilizador
     * @param nome O nome do Utilizador
     * @param morada A morada do Utilizador
     */
    public Utilizador(String nif, String nome, String morada){
        this.nif = nif;
        this.nome = nome;
        this.morada = morada;
    }
    
    /**
     * Inicializa um novo utilizador com o nif/nome indicado
     * @param n O número de contribuinte do utilizador
     * @param nif Verdade se n é um numero de contribuinte, false se n é um nome
     */
    public Utilizador(String n, boolean nif){
        this.morada = "";
        if(nif){
            this.nome = "";
            this.nif = n;
        }else{
            this.nome = n;
            this.nif = "";
        }
    }
    
    @Override
    public Utilizador clone(){
        return new Utilizador(this);
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
     * Compara dois numeros de contribuinte.
     * @param u O segundo numero de contribuinte
     * @return <0 Se o nif do primeiro utilizador for menor que o do segundo
     * @return  0 Se os nif forem iguais
     * @return >0 Se o nif do primeiro utilizador for maior que o do segundo
     */
    public int compareNif(String nif){
        return (this.getNif().compareTo(nif));
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
     * Compara dois nomes de utilizador.
     * @param u O segundo nome de utilizador
     * @return <0 Se o nome do primeiro utilizador for considerado menor que o do segundo
     * @return  0 Se os nomes forem iguais
     * @return >0 Se o nome do primeiro utilizador for considerado maior que o do segundo
     */
    public int compareNome(String nome){
        return (this.getNome().compareTo(nome));
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
        return String.format("{ %s | %s | %s }", this.getNif(), this.getNome(), this.getMorada());
    }
}
