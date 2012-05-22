package localidade;

import java.util.Collection;
import java.util.TreeMap;

public class LigacoesTreeMap extends Ligacoes{
    private TreeMap<String, Ligacao> ligacoes;

    LigacoesTreeMap(){
        this.ligacoes = new TreeMap<String, Ligacao>();
    }

    LigacoesTreeMap(LigacoesTreeMap ligs){
        this.ligacoes = new TreeMap<String, Ligacao>();
        for(Ligacao l : ligs.ligacoes.values())
            this.ligacoes.put(l.getNome(), l.clone());
    }

    @Override
    public void insere(Ligacao lig) {
        if( !this.ligacoes.containsKey(lig.getNome()) )
            this.ligacoes.put(lig.getNome(), lig.clone());
    }

    @Override
    public Ligacao procura(String nomeLig) {
        Ligacao lig = this.ligacoes.get(nomeLig);
        if( lig != null )
            return lig.clone();
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(50);
        Collection<Ligacao> valores = this.ligacoes.values();
        for( Ligacao actual : valores )
            str.append("    ").append(actual.toString()).append("\n");
        return str.toString();
    }

    @Override
    public Ligacoes clone() {
        return new LigacoesTreeMap(this);
    }
    
}
