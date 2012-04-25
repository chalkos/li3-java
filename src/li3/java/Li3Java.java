package li3.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Li3Java {
    private static GregorianCalendar timer;
    
    /**
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args) {
        StringBuilder estatisticas = new StringBuilder("Estatisticas:\n");
        estatisticas.append("--Utilizadores (2 ArrayLists)--\n\tMostrar 5000 utilizadores por nome e por nif: ");
        startTimer();
        utilizadoresArrayList(5000);
        estatisticas.append(stopTimer());
        System.out.print(estatisticas);
    }
    
    public static void utilizadoresArrayList(int numDados){
        //recolher os dados
        ArrayList<Utilizador> usersNome;
        ArrayList<Utilizador> usersNif;
        usersNif = ficheiro.getUtilizadoresArrayList(numDados);
        usersNome = (ArrayList<Utilizador>)usersNif.clone();
        
        //ordenar os dados
        //Collection.sort(usersNif);
        
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        
        
        //escrever as informações
        Iterator itr = usersNif.iterator();
        
        System.out.println("Por nif:");
        while(itr.hasNext())
            System.out.println(itr.next().toString());
        
        itr = usersNome.iterator();
        System.out.println("Por nome:");
        while(itr.hasNext())
            System.out.println(itr.next().toString());
    }
    
    /**
     * Começa a cronometrar
     */
    public static void startTimer(){
        timer = new GregorianCalendar();
    }
    
    /**
     * Obter o tempo desde o inicio do cronómetro
     * @return Tempo, em milisegundos, desde que se começou a cronometrar
     */
    public static long stopTimer(){
        GregorianCalendar now = new GregorianCalendar();
        return timer.getTimeInMillis()-now.getTimeInMillis();
    }
}
