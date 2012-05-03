package li3java;

import java.util.ArrayList;

/**
 * Classe de Localidades que implementa ArrayList para as adjacencias
 */
public class LocalidadeArrayList extends Localidade{
    private ArrayList<String> adjacencias;
    
    LocalidadeArrayList(String nome){
        this.nome = nome;
        adjacencias = new ArrayList<String>(8);
    }
    
    public ArrayList<String> getAdjacencias(){
        return adjacencias;
    }
    
    public void novaAdjacencia(String nova){
        if( !adjacencias.contains(nova) )
            adjacencias.add(nova);
    }
}
