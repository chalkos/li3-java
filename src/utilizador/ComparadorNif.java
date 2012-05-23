package utilizador;

import java.util.Comparator;

class ComparadorNif implements Comparator<Utilizador>{
    @Override
    public int compare(Utilizador primeiro, Utilizador segundo){
        return primeiro.compareNif(segundo);
    }
   
}