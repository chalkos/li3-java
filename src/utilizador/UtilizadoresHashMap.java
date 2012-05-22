package utilizador;

import java.util.Collection;
import java.util.HashMap;

public class UtilizadoresHashMap extends Utilizadores{
    HashMap<String, Utilizador> nif;
    HashMap<String, Utilizador> nome;
    
    /**
     * Inicializacao da colecção
     */
    private void criar(){
        this.nif = new HashMap<String, Utilizador>(super.getNumDados());
        this.nome = new HashMap<String, Utilizador>(super.getNumDados());
    }
    
    /**
     * Cria um novo objecto UtilizadoresArrayList
     * @param numDados quantidade de dados com que a colecção vai ser iniciada
     */
    public UtilizadoresHashMap(int numDados) {
        super(numDados);
        criar();
    }
    
    /**
     * Cria um novo objecto UtilizadoresArrayList com espaço inicial para 5 utilizadores
     */
    public UtilizadoresHashMap() {
        super();
        criar();
    }

    @Override
    public void insere(Utilizador novo) {
        novo = novo.clone();
        
        if( !this.nif.containsKey(novo.getNif()) && !this.nome.containsKey(novo.getNome()) ){
            this.nif.put(novo.getNif(), novo);
            this.nome.put(novo.getNome(), novo);
        }
    }

    @Override
    public Utilizador procuraNif(String nif) {
        Utilizador valor = this.nif.get(nif);
        if( valor!= null )
            return valor.clone();
        return null;
    }

    @Override
    public Utilizador procuraNome(String nome) {
        Utilizador valor = this.nome.get(nome);
        if( valor!= null )
            return valor.clone();
        return null;
    }

    @Override
    public StringBuilder toStringNif() {
        StringBuilder str = new StringBuilder(50);
        Collection<Utilizador> col = this.nif.values();
        
        for( Utilizador u : col ){
            str.append(u.toString()).append("\n");
        }
        return str;
    }

    @Override
    public StringBuilder toStringNome() {
        StringBuilder str = new StringBuilder(50);
        Collection<Utilizador> col = this.nome.values();
        
        for( Utilizador u : col ){
            str.append(u.toString()).append("\n");
        }
        return str;
    }
    
}
