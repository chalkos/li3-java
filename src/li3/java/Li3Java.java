package li3.java;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Li3Java {
    private static GregorianCalendar timer;
    
    /**
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args) {
        ArrayList<Utilizador> users;
        users = ficheiro.getUtilizadoresArrayList(1000);
        Iterator itr = users.iterator();
        
        System.out.println("Iterating through ArrayList elements...");
        while(itr.hasNext())
            System.out.println(itr.next().toString());
        
        //TODO: inserir um novo utilizador
        
        //TODO: procurar um utilizador por nome e nif
    }
    
    public static void startTimer(){
        timer = new GregorianCalendar();
    }
    
    public static long stopTimer(){
        GregorianCalendar now = new GregorianCalendar();
        return now.getTimeInMillis()-timer.getTimeInMillis();
    }
}
