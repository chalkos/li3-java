package localidade;

import java.util.Comparator;

public class ComparadorArrayLigacoes implements Comparator<String[]>{
    @Override
    public int compare(String[] primeiro, String[] segundo){
        return primeiro[0].compareTo(segundo[0]);
    }
}
