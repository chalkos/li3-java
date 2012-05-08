package li3java;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe de Localidades que implementa ArrayList para as adjacencias
 */
public class LocalidadeArrayList extends Localidade{
    private ArrayList<Ligacao> adjacencias;
    
    LocalidadeArrayList(String nome){
        super(nome);
        adjacencias = new ArrayList<Ligacao>(8);
    }
    
    public Iterator<Ligacao> getIterator(){
        return adjacencias.iterator();
    }
    
    public void novaAdjacencia(Ligacao nova){
        boolean encontrou = false;
        for( Ligacao adjacencia : adjacencias ){
            if( adjacencia.getNome().compareToIgnoreCase(nova.getNome()) == 0){
                encontrou = true;
                break;
            }
        }
        if(!encontrou)
            adjacencias.add(nova.clone());
    }
}
