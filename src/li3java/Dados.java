package li3java;

import localidade.Localidades;
import utilizador.Utilizadores;

public class Dados {
    private Localidades localidades;
    private Utilizadores utilizadores;
    
    Dados(){
    }
    
    Dados(Localidades localidades, Utilizadores utilizadores){
	this.localidades = localidades;
	this.utilizadores = utilizadores;
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
