package li3java;


import java.util.Comparator;

/**
 * Classe que permite comparar Utilizadores pelo nif
 */
class comparadorNif implements Comparator<Utilizador>{
    @Override
    public int compare(Utilizador primeiro, Utilizador segundo){
        return primeiro.compareNif(segundo);
    }
}