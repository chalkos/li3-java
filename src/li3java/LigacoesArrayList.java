package li3java;

import java.util.ArrayList;

public class LigacoesArrayList extends Ligacoes{
    private ArrayList<Ligacao> ligacoes;

    LigacoesArrayList(){
        this.ligacoes = new ArrayList<Ligacao>(8);
    }

    LigacoesArrayList(LigacoesArrayList ligs){
        this.ligacoes = new ArrayList<Ligacao>(8);
        for(Ligacao lig : ligs.ligacoes){
            this.ligacoes.add(lig.clone());
        }
    }
    
    @Override
    public void insere(Ligacao lig) {
        boolean existe = false;
        boolean inseriu = false;
        lig = lig.clone();
        
        for( Ligacao actual : this.ligacoes )
            if( actual.getNome().compareTo(lig.getNome()) == 0){
                existe = true;
                break;
            }
        
        if( !existe ){
            for(int i=0; i<this.ligacoes.size();i++)
                if(this.ligacoes.get(i).getNome().compareTo(lig.getNome()) > 0){
                    this.ligacoes.add(i, lig);
                    inseriu = true;
                    break;
                }
            
            if( !inseriu )
                this.ligacoes.add(lig);
        }
    }

    @Override
    public Ligacao procura(String nomeLig) {
        for( Ligacao actual : this.ligacoes )
            if( actual.getNome().compareTo(nomeLig) == 0)
                return actual.clone();
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(50);
        for( Ligacao actual : this.ligacoes )
            str.append("    ").append(actual.toString()).append("\n");
        return str.toString();
    }

    @Override
    public Ligacoes clone() {
        return new LigacoesArrayList(this);
    }
    
    
}
