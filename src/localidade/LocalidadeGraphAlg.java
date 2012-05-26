
package localidade;


import java.util.HashMap;
import java.util.Iterator;

public class LocalidadeGraphAlg extends LocalidadeGraph {
    HashMap<String, LocalidadeGraph> graph;

   public LocalidadeGraphAlg() {
        this.graph = new HashMap<String,LocalidadeGraph>();
    }
   
   
   public LocalidadeGraph chooseNextVertice(LocalidadeGraph proxVertice)
   {
       for (LocalidadeGraph localidade : this.graph.values())
       {
           
           if(localidade.getEstado()!=VISITADO && ((proxVertice==null)|| localidade.getDistancia()< proxVertice.getDistancia()))
                proxVertice=localidade.clone();    
       }  
       return proxVertice;
   }
   
   public int buildPath (Ligacao ligacao, LocalidadeGraph vertice, int naOrla)
   {
       int novaDistancia = vertice.getDistancia() + 1;
       if (this.graph.get(ligacao.getNome())==null)
       {
           LocalidadeGraph novoVertice = new LocalidadeGraph(ligacao.getNome(), vertice.getNome(), novaDistancia, NAORLA);
           naOrla++;
           this.graph.put(novoVertice.getNome(), novoVertice.clone());
       }
       else
       {
           LocalidadeGraph novoVertice = this.graph.get(ligacao.getNome());
           if(novoVertice.getEstado()!=VISITADO && novaDistancia < novoVertice.getDistancia() )
           {
               novoVertice.setAnterior(vertice.getNome());
               novoVertice.setDistancia(novoVertice.getDistancia()+1);
           }
       }
    return naOrla;
   }   
   
    
    public int buildGraph(Localidades locs, String nomeOrigem, String nomeDestino){
	HashMap<String, Localidade> localidades = locs.getLocalidades();
        LocalidadeGraph origem = new LocalidadeGraph(nomeOrigem);
        LocalidadeGraph proxVertice;
        this.graph.put(nomeOrigem, origem);
        int naOrla= 1;
        do{
            proxVertice = chooseNextVertice(null);
	    for (Iterator<Ligacao> it = localidades.get(proxVertice.getNome()).Ligacoes().getLigacoes().iterator(); it.hasNext();)
                naOrla=buildPath(it.next(), proxVertice, naOrla);
            this.graph.get(proxVertice.getNome()).setEstado(VISITADO);
            naOrla--;
        }while(naOrla>0 && (proxVertice.getNome().compareTo(nomeDestino))!=0);
  
        if(this.graph.containsKey(nomeDestino))
            return this.graph.get(nomeDestino).getDistancia()-1;
        return 0;

    }    
    
}


