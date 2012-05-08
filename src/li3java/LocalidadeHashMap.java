package li3java;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Classe de Localidades que implementa HashSet para as adjacencias
 */
public class LocalidadeHashMap extends Localidade{
    private HashMap<String, Ligacao> adjacencias;
    
    LocalidadeHashMap(String nome){
        super(nome);
        
        adjacencias = new HashMap<String, Ligacao>(8);
    }
    
    public void novaAdjacencia(Ligacao nova){
        if( !adjacencias.containsKey(nova.getNome()) )
            adjacencias.put(nova.getNome(), nova);
    }
}
