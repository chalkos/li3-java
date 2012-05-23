package utilizador;

import java.util.ArrayList;

public class UtilizadoresArrayList extends Utilizadores{
    ArrayList<Utilizador> nif;
    ArrayList<Utilizador> nome;
    
    /**
     * Inicializacao da colecção
     */
    private void criar(){
        this.nif = new ArrayList<Utilizador>(super.getNumDados());
        this.nome = new ArrayList<Utilizador>(super.getNumDados());
    }
    
    /**
     * Cria um novo objecto UtilizadoresArrayList
     * @param numDados quantidade de dados com que a colecção vai ser iniciada
     */
    public UtilizadoresArrayList(int numDados) {
        super(numDados);
        criar();
    }
    
    /**
     * Cria um novo objecto UtilizadoresArrayList com espaço inicial para 5 utilizadores
     */
    public UtilizadoresArrayList() {
        super();
        criar();
    }
    
    @Override
    public boolean insere(Utilizador novo) {
        if( !novo.isValid() ) return false;
        boolean existe = false;
        boolean inseriu = false;
        novo = novo.clone();
        
        for( Utilizador actual : this.nif )
            if( actual.compareNif(novo) == 0 ){
                existe = true;
                break;
            }
        
        if( !existe )
            for( Utilizador actual : this.nome )
                if( actual.compareNome(novo) == 0 ){
                    existe = true;
                    break;
                }
        
        if( !existe ){
            for(int i=0; i<this.nif.size();i++)
                if(this.nif.get(i).compareNif(novo) > 0){
                    this.nif.add(i, novo);
                    for(int j=0; j<this.nome.size();j++)
                        if(this.nome.get(j).compareNome(novo) > 0){
                            this.nome.add(j, novo);
                            inseriu = true;
                            break;
                        }
                    if( !inseriu )
                        this.nome.add(novo);
                    inseriu = true;
                    break;
                }
            
            if( !inseriu ){
                this.nif.add(novo);
                for(int j=0; j<this.nome.size();j++)
                        if(this.nome.get(j).compareNome(novo) > 0){
                            this.nome.add(j, novo);
                            inseriu = true;
                            break;
                        }
                    if( !inseriu ){
                        this.nome.add(novo);
                        inseriu = true;
                    }
            }
        }
        return inseriu;
    }

    @Override
    public Utilizador procuraNif(String nif) {
        for( Utilizador u : this.nif )
            if( u.compareNif(nif) == 0 )
                return u.clone();
        return null;
    }

    @Override
    public Utilizador procuraNome(String nome) {
        for( Utilizador u : this.nome )
            if( u.compareNome(nome) == 0 )
                return u.clone();
        return null;
    }

    @Override
    public StringBuilder toStringNif() {
        StringBuilder str = new StringBuilder(50);
        
        for( Utilizador utilizador : this.nif )
            str.append(utilizador.toString()).append("\n");
        
        return str;
    }

    @Override
    public StringBuilder toStringNome() {
        StringBuilder str = new StringBuilder(50);
        
        for( Utilizador utilizador : this.nome )
            str.append(utilizador.toString()).append("\n");
        
        return str;
    }

    @Override
    public String[][] contains(String valor, int campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(String nif) {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
