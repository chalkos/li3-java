package localidade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class LocalidadesHashMap extends Localidades{
    HashMap<String, Localidade> localidades;
    
    private void criar(){
        this.localidades = new HashMap<String, Localidade>(super.getNumDados());
    }
    
    public LocalidadesHashMap(int numDados) {
        super(numDados);
        criar();
    }
    
    public LocalidadesHashMap() {
        super();
        criar();
    }

    @Override
    public boolean insere(Localidade novo) {
        if( !this.localidades.containsKey(novo.getNome()) ){
            this.localidades.put(novo.getNome(), novo.clone());
            return true;
        }
        return false;
    }

    @Override
    public boolean insereLigacao(Localidade loc, Ligacao lig) {
        Localidade l = this.localidades.get(loc.getNome());
        if( l != null && this.localidades.get(lig.getNome()) != null){
            return l.insereLigacao(lig);
        }
        return false;
    }

    @Override
    public Ligacao procuraLig(Localidade loc, Ligacao lig) {
        Localidade l = this.localidades.get(loc.getNome());
        if( l != null )
            return l.procuraLigacao(lig.getNome());
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(50);
        for( Localidade actual : this.localidades.values() )
            str.append(actual.toString());
        return str.toString();
    }

    @Override
    public String[] contains(String value) {
	Collection col = this.localidades.values();
	ArrayList<String> strs = new ArrayList<String>(col.size());
	
	if( value.equals("[todas]") )
	    for(Object l : col)
		strs.add( ((Localidade)l).getNome() );
	else
	    for(Object l : col)
		if( ((Localidade)l).getNome().contains(value) )
		    strs.add( ((Localidade)l).getNome() );
	
	Collections.sort(strs, String.CASE_INSENSITIVE_ORDER);
	
	return strs.toArray(new String[0]); //para o toArray dar strings e nao objects
    }

    @Override
    public String[][] listaLigacoes(String origem) {
	Localidade l = this.localidades.get(origem);
	return l.listaLigacoes();
    }
    
}
