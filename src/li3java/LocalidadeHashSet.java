package li3java;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Classe de Localidades que implementa HashSet para as adjacencias
 */
public class LocalidadeHashSet extends Localidade{
    private HashSet<Ligacao> adjacencias;
    
    LocalidadeHashSet(String nome){
        super(nome);
        adjacencias = new HashSet<Ligacao>(8);
    }
    
    public Iterator<Ligacao> getIterator(){
        return adjacencias.iterator();
    }
    
    public void novaAdjacencia(Ligacao nova){
        adjacencias.add(nova);
    }
}
