package localidade;

import java.util.TreeMap;

public class LocalidadesTreeMap extends Localidades{
    TreeMap<String, Localidade> localidades;
    
    private void criar(){
        this.localidades = new TreeMap<String, Localidade>();
    }
    
    public LocalidadesTreeMap(int numDados) {
        super(numDados);
        criar();
    }
    
    public LocalidadesTreeMap(int numDados, int tipoLigacoes) {
        super(numDados, tipoLigacoes);
        criar();
    }
    
    public LocalidadesTreeMap() {
        super();
        criar();
    }

    @Override
    public void insere(Localidade novo) {
        if( !this.localidades.containsKey(novo.getNome()) )
            this.localidades.put(novo.getNome(), novo.clone());
    }

    @Override
    public void insereLigacao(Localidade loc, Ligacao lig) {
        Localidade l = this.localidades.get(loc.getNome());
        if( l != null && this.localidades.get(lig.getNome()) != null){
            l.insereLigacao(lig);
        }
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
    
}
