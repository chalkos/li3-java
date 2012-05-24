
package localidade;


import java.util.HashMap;

public class LocalidadeGraphAlg extends LocalidadeGraph {
    HashMap<String, LocalidadeGraph> graph;
    
    private void criar()
    {
        this.graph = new HashMap<String,LocalidadeGraph>(20000);
    }

   public LocalidadeGraphAlg() {
        criar();
    }
   
   
   public LocalidadeGraph chooseNextVertice(LocalidadeGraph proxVertice)
   {
       for (LocalidadeGraph localidade : this.graph.values())
       {
           if((localidade.getEstado()!=VISITADO && (proxVertice==null))|| localidade.getDistancia()< proxVertice.getDistancia())
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
   
    
    public int buildGraph(HashMap<String, Localidade> localidades, String nomeOrigem, String nomeDestino)
    {
        LocalidadeGraph origem = new LocalidadeGraph(nomeOrigem);
        this.graph.put(nomeOrigem, origem);
        int naOrla= 1;
        do{
            LocalidadeGraph proxVertice = chooseNextVertice(null);
            Localidade auxL = localidades.get(proxVertice.getNome()).clone();//
            Ligacoes lig = auxL.ligacoes.clone(); // Preciso iterar sobre as ligações
            for(Ligacao ligacao :  lig)
                naOrla=buildPath(ligacao, proxVertice, naOrla);
            proxVertice.setEstado(VISITADO);
            naOrla--;
        }while(naOrla>0 && proxVertice.getNome()!= nomeDestino);
  
        if(this.graph.containsKey(nomeDestino))
            return this.graph.get(nomeDestino).getDistancia();
        else return 0;
    }
}
