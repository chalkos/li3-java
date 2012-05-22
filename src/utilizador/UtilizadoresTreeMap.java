package utilizador;

import java.util.Collection;
import java.util.TreeMap;

public class UtilizadoresTreeMap extends Utilizadores {
    TreeMap<String, Utilizador> nif;
    TreeMap<String, Utilizador> nome;
    
    /**
     * Inicializacao da colecção
     */
    private void criar(){
        this.nif = new TreeMap<String, Utilizador>();
        this.nome = new TreeMap<String, Utilizador>();
    }
    
    /**
     * Cria um novo objecto UtilizadoresArrayList
     * @param numDados quantidade de dados com que a colecção vai ser iniciada
     */
    public UtilizadoresTreeMap(int numDados) {
        super(numDados);
        criar();
    }
    
    /**
     * Cria um novo objecto UtilizadoresArrayList com espaço inicial para 5 utilizadores
     */
    public UtilizadoresTreeMap() {
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
