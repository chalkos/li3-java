package utilizador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class UtilizadoresHashMap extends Utilizadores implements Serializable{
    HashMap<String, Utilizador> nif;
    HashMap<String, Utilizador> nome;
    
    /**
     * Inicializacao da colecção
     */
    private void criar(){
        this.nif = new HashMap<String, Utilizador>(super.getNumDados());
        this.nome = new HashMap<String, Utilizador>(super.getNumDados());
    }
    
    /**
     * Cria um novo objecto UtilizadoresArrayList
     * @param numDados quantidade de dados com que a colecção vai ser iniciada
     */
    public UtilizadoresHashMap(int numDados) {
        super(numDados);
        criar();
    }
    
    /**
     * Cria um novo objecto UtilizadoresArrayList com espaço inicial para 5 utilizadores
     */
    public UtilizadoresHashMap() {
        super();
        criar();
    }

    @Override
    public boolean insere(Utilizador novo) {
        if( !novo.isValid() ) return false;
        novo = novo.clone();
        
        if( !this.nif.containsKey(novo.getNif()) && !this.nome.containsKey(novo.getNome()) ){
            this.nif.put(novo.getNif(), novo);
            this.nome.put(novo.getNome(), novo);
            return true;
        }
        return false;
    }

    @Override
    public Utilizador procuraNif(String nif) {
        Utilizador valor = this.nif.get(nif);
        if( valor!= null )
            return valor.clone();
        return null;
    }

    @Override
    public Utilizador procuraNome(String nome) {
        Utilizador valor = this.nome.get(nome);
        if( valor!= null )
            return valor.clone();
        return null;
    }

    @Override
    public StringBuilder toStringNif() {
        StringBuilder str = new StringBuilder(50);
        Collection<Utilizador> col = this.nif.values();
        
        for( Utilizador u : col ){
            str.append(u.toString()).append("\n");
        }
        return str;
    }

    @Override
    public StringBuilder toStringNome() {
        StringBuilder str = new StringBuilder(50);
        Collection<Utilizador> col = this.nome.values();
        
        for( Utilizador u : col ){
            str.append(u.toString()).append("\n");
        }
        return str;
    }

    @Override
    public String[][] contains(String valor, int campo) {
        String[][] valores;
        ArrayList<Utilizador> lista = new ArrayList<Utilizador>();
        Collection<Utilizador> col;
                
        if( campo != CAMPO_NIF && campo != CAMPO_NOME )
            return null;
        
        if( campo == CAMPO_NOME )
            col = this.nome.values();
        else
            col = this.nif.values();
        
	if (valor.equals("[todos]")) {
	    for (Utilizador u : col)
		lista.add(u);
	} else {
	    //os seguintes if estão assim porque o java entra no
	    //segundo termo de um AND cujo primeiro termo é falso (assim é mais eficiente)
	    for (Utilizador u : col) {
		if (campo == CAMPO_NIF) {
		    if (u.getNif().toUpperCase().contains(valor.toUpperCase())) {
			lista.add(u);
		    }
		} else if (campo == CAMPO_NOME) {
		    if (u.getNome().toUpperCase().contains(valor.toUpperCase())) {
			lista.add(u);
		    }
		}
	    }
	}

        if( campo == CAMPO_NIF )
            Collections.sort(lista, new ComparadorNif());        
        else
            Collections.sort(lista, new ComparadorNome());  
	
        valores = new String[lista.size()][3];
        for(int i=0; i<lista.size(); i++){
            valores[i][0] = lista.get(i).getNome();
            valores[i][1] = lista.get(i).getNif();
            valores[i][2] = lista.get(i).getMorada();
        }
        
        return valores;
    }

    @Override
    public void remove(String nif) {
	Utilizador remover = this.nif.get(nif);
	if( remover != null ){
	    this.nome.remove(remover.getNome());
	    this.nif.remove(nif);
	}
    }

    @Override
    public String escritaUtilizadores() {
	StringBuilder str = new StringBuilder();
	Collection<Utilizador> users = this.nif.values();
	
	for( Utilizador u : users ){
	    str.append(u.getNif())
		    .append(":")
		    .append(u.getNome())
		    .append(":")
		    .append(u.getMorada())
		    .append("\n");
	}
	
	return str.toString();
    }
    
}
