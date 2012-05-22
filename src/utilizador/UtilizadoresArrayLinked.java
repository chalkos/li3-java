package utilizador;

import java.util.ArrayList;
import java.util.LinkedList;

public class UtilizadoresArrayLinked extends Utilizadores{
    ArrayList<Utilizador> nif;
    LinkedList<Utilizador> nome;
    
    /**
     * Inicializacao da colecção
     */
    private void criar(){
        this.nif = new ArrayList<Utilizador>(super.getNumDados());
        this.nome = new LinkedList<Utilizador>();
    }
    
    /**
     * Cria um novo objecto UtilizadoresArrayLinked
     * @param numDados quantidade de dados com que a colecção vai ser iniciada
     */
    public UtilizadoresArrayLinked(int numDados) {
        super(numDados);
        criar();
    }
    
    /**
     * Cria um novo objecto UtilizadoresArrayLinked com espaço inicial para 5 utilizadores
     */
    public UtilizadoresArrayLinked() {
        super();
        criar();
    }
    
    @Override
    public void insere(Utilizador novo) {
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
                    if( !inseriu )
                        this.nome.add(novo);
            }
        }
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
    
}
