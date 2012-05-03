package li3java;


import java.util.Comparator;

/**
 * Classe que permite comparar Utilizadores pelo nome
 */
class comparadorNome implements Comparator<Utilizador>{
    @Override
    public int compare(Utilizador primeiro, Utilizador segundo){
        return primeiro.compareNome(segundo);
    }
   
}