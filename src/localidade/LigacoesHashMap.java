package localidade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class LigacoesHashMap extends Ligacoes{
    private HashMap<String, Ligacao> ligacoes;

    LigacoesHashMap(){
        this.ligacoes = new HashMap<String, Ligacao>(8);
    }
    
    LigacoesHashMap(LigacoesHashMap ligs){
        this.ligacoes = new HashMap<String, Ligacao>(8);
        for(Ligacao l : ligs.ligacoes.values())
            this.ligacoes.put(l.getNome(), l.clone());
    }

    @Override
    public boolean insere(Ligacao lig) {
        if( !this.ligacoes.containsKey(lig.getNome()) ){
            this.ligacoes.put(lig.getNome(), lig.clone());
	    return true;
	}
	return false;
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
        return new LigacoesHashMap(this);
    }

    @Override
    public String[][] listaLigacoes() {
	ArrayList<String[]> strs = new ArrayList<String[]>(this.ligacoes.size());
	Collection col = this.ligacoes.values();
	
	for( Object l : col )
	    strs.add( ((Ligacao)l).toStringArray() );
	
	Collections.sort(strs, new ComparadorArrayLigacoes());
	
	return strs.toArray(new String[0][0]); //para o toArray dar strings e nao objects
    }
    
}
