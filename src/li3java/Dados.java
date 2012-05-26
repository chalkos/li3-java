package li3java;

import localidade.Localidades;
import utilizador.Utilizadores;

public class Dados {
    private Localidades localidades;
    private Utilizadores utilizadores;
    public int[] quantidades;
    
    Dados(){
    }
    
    Dados(Localidades localidades, Utilizadores utilizadores){
	this.localidades = localidades;
	this.utilizadores = utilizadores;
	this.quantidades = new int[0];
    }

    public Localidades getLocalidades() {
	return localidades;
    }

    public Utilizadores getUtilizadores() {
	return utilizadores;
    }

    public void setLocalidades(Localidades localidades) {
	this.localidades = localidades;
    }

    public void setUtilizadores(Utilizadores utilizadores) {
	this.utilizadores = utilizadores;
    }
    
    
}
