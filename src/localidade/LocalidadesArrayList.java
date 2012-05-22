package localidade;

import java.util.ArrayList;

public class LocalidadesArrayList extends Localidades{
    ArrayList<Localidade> localidades;
    
    private void criar(){
        this.localidades = new ArrayList<Localidade>(super.getNumDados());
    }
    
    public LocalidadesArrayList(int numDados) {
        super(numDados);
        criar();
    }
    
    public LocalidadesArrayList(int numDados, int tipoLigacoes) {
        super(numDados, tipoLigacoes);
        criar();
    }
    
    public LocalidadesArrayList() {
        super();
        criar();
    }
    
    @Override
    public void insere(Localidade novo) {
        boolean existe = false;
        boolean inseriu = false;
        novo = novo.clone();
        
        for( Localidade actual : this.localidades )
            if( actual.getNome().compareTo(novo.getNome()) == 0){
                existe = true;
                break;
            }
        
        if( !existe ){
            for(int i=0; i<this.localidades.size();i++)
                if(this.localidades.get(i).getNome().compareTo(novo.getNome()) > 0){
                    this.localidades.add(i, novo);
                    inseriu = true;
                    break;
                }
            
            if( !inseriu )
                this.localidades.add(novo);
        }
    }

    @Override
    public void insereLigacao(Localidade loc, Ligacao lig) {
        for( int i = 0; i<this.localidades.size(); i++ )
            if( this.localidades.get(i).getNome().compareTo(loc.getNome()) == 0)
                for( int j = 0; j<this.localidades.size(); j++ )
                    if( this.localidades.get(j).getNome().compareTo(lig.getNome()) == 0)
                        this.localidades.get(i).insereLigacao(lig);
    }

    @Override
    public Ligacao procuraLig(Localidade loc, Ligacao lig) {
        for( int i = 0; i<this.localidades.size(); i++ )
            if( this.localidades.get(i).getNome().compareTo(loc.getNome()) == 0)
                return this.localidades.get(i).procuraLigacao(lig.getNome());
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(50);
        for( Localidade actual : this.localidades )
            str.append(actual.toString());
        return str.toString();
    }
    
}
