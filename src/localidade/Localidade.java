package localidade;

/**
 * Localidade
 */
public class Localidade {
    public static final int LIGACOES_ARRAYLIST = 0;
    public static final int LIGACOES_HASHSET = 1;
    public static final int LIGACOES_HASHMAP = 2;
    public static final int LIGACOES_TREEMAP = 3;
    private String nome;
    private Ligacoes ligacoes;
    
    public Localidade(){
        this.nome="";
        this.ligacoes = null;
    }
    
    public Localidade(String nome){
        this.nome=nome;
        this.ligacoes = null;
    }
    
    public Localidade(String nome, int tipoLigs){
        this.nome=nome;
        this.ligacoes = null;
        
        if( tipoLigs == LIGACOES_ARRAYLIST )
            this.ligacoes = new LigacoesArrayList();
        else if( tipoLigs == LIGACOES_HASHSET )
            this.ligacoes = new LigacoesHashSet();
        else if( tipoLigs == LIGACOES_HASHMAP )
            this.ligacoes = new LigacoesHashMap();
        else if( tipoLigs == LIGACOES_TREEMAP )
            this.ligacoes = new LigacoesTreeMap();
    }
    
    public Localidade(Localidade loc){
        this.nome = loc.getNome();
        this.ligacoes = loc.ligacoes.clone();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    @Override
    public Localidade clone(){
        return new Localidade(this);
    }
    
    public void insereLigacao(Ligacao lig){
        if( this.ligacoes.procura(nome) == null )
            this.ligacoes.insere(lig.clone());
    }
    
    public Ligacao procuraLigacao(String nome){
        return this.ligacoes.procura(nome);
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder(50);
        str.append(this.getNome()).append("\n").append(this.ligacoes.toString());
        return str.toString();
    }
}