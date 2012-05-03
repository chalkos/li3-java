package li3java;

import java.util.HashSet;

/**
 * Classe de Localidades que implementa HashSet para as adjacencias
 */
public class LocalidadeHashSet extends Localidade{
    private HashSet<String> adjacencias;
    
    LocalidadeHashSet(String nome){
        this.nome = nome;
        adjacencias = new HashSet<String>(8);
    }
    
    public HashSet<String> getAdjacencias(){
        return adjacencias;
    }
    
    public void novaAdjacencia(String nova){
        if( !adjacencias.contains(nova) )
            adjacencias.add(nova);
    }
}
