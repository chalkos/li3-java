package li3java;

/**
 * Localidade
 */
public class Localidade {
    private String nome;
    private Ligacoes ligacoes;
    
    Localidade(){
        this.nome="";
        this.ligacoes = null;
    }
    
    Localidade(String nome){
        this.nome=nome;
        this.ligacoes = null;
    }
    
    Localidade(String nome, int tipoLigs){
        this.nome=nome;
        this.ligacoes = null;
        switch( tipoLigs ){
            case 0 : this.ligacoes = new LigacoesArrayList(); break;
            case 1 : this.ligacoes = new LigacoesHashSet(); break;
            case 2 : this.ligacoes = new LigacoesHashMap(); break;
            case 3 : this.ligacoes = new LigacoesTreeMap(); break;
        }
    }
    
    Localidade(Localidade loc){
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