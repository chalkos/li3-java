package localidade;

import java.util.HashSet;

public class LigacoesHashSet extends Ligacoes{
    private HashSet<Ligacao> ligacoes;

    LigacoesHashSet(){
        this.ligacoes = new HashSet<Ligacao>(8);
    }

    LigacoesHashSet(LigacoesHashSet ligs){
        this.ligacoes = new HashSet<Ligacao>(8);
        for(Ligacao l : ligs.ligacoes)
            this.ligacoes.add(l.clone());
    }

    @Override
    public void insere(Ligacao lig) {
        this.ligacoes.add(lig.clone());
    }

    @Override
    public Ligacao procura(String nomeLig) {
        for( Ligacao actual : this.ligacoes )
            if( actual.equals(new Ligacao(nomeLig)) )
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
        return new LigacoesHashSet(this);
    }
    
}
