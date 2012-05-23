package utilizador;

import java.util.Comparator;

class ComparadorNome implements Comparator<Utilizador>{
    @Override
    public int compare(Utilizador primeiro, Utilizador segundo){
        return primeiro.compareNome(segundo);
    }
   
}