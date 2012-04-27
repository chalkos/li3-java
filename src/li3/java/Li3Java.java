package li3.java;


import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;


public class Li3Java {
    private static GregorianCalendar timer;
    private static StringBuilder estatisticas;
    
    /**
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args) {
        Integer quantidades[] = {5000, 10000, 15000, 18000};
        
        estatisticas = new StringBuilder("Estatisticas de Utilizadores:\n");
        estatisticas.append("                               | Ler  | Inserir | P. Nome | P. Nif | Imprimir |\n");
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------|\n");
        
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" 2 ArrayLists (%5d)          |", quantidade));
            utilizadoresArrayList(quantidade);
        }
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------+\n");
        System.out.print(estatisticas);
    }
    
    public static void utilizadoresArrayList(int numDados){
        Iterator itr;
        int comparacao = new Integer(-1);
        
        //recolher os dados 
        startTimer();
        ArrayList<Utilizador> usersNome;
        ArrayList<Utilizador> usersNif;
        usersNif = ficheiro.getUtilizadoresArrayList(numDados);
        usersNome = (ArrayList<Utilizador>)usersNif.clone();
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        estatisticas.append(String.format(" %4d |", stopTimer()));
        
        //inserir um novo registo
        startTimer();
        usersNif.add(new Utilizador(123456789, "Joaquim", "Rua das flores"));
        usersNome = (ArrayList<Utilizador>)usersNif.clone();
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        estatisticas.append(String.format(" %7d |", stopTimer()));
        
        //procurar por nome
        startTimer();
        Utilizador procura = new Utilizador("Não existe");
        for( Utilizador tmp : usersNome ){
            comparacao = procura.compareNome(tmp);
            if( comparacao >= 0 )
                break;
        }
        
        if( comparacao == 0 )
            System.out.println("existe");
        else
            System.out.println("não existe");
        estatisticas.append(String.format(" %7d |", stopTimer()));
        
        //procurar por nif
        startTimer();
        procura = new Utilizador(123456789);
        for( Utilizador tmp : usersNif ){
            comparacao = procura.compareNif(tmp);
            if( comparacao >= 0 )
                break;
        }
        
        if( comparacao == 0 )
            System.out.println("existe");
        else
            System.out.println("não existe");
        estatisticas.append(String.format(" %6d |", stopTimer()));
        
        //imprimir os dados dos utilizadores
        startTimer();
        itr = usersNif.iterator();
        
        System.out.println("Por nif:");
        while(itr.hasNext())
            System.out.println(itr.next().toString());
        
        itr = usersNome.iterator();
        System.out.println("Por nome:");
        while(itr.hasNext())
            System.out.println(itr.next().toString());
        estatisticas.append(String.format(" %8d |\n", stopTimer()));
    }
    
    public static void utilizadoresArrayLinked(int numDados){
        Iterator itr;
        int comparacao = new Integer(-1);
        
        //recolher os dados
        startTimer();
        ArrayList<Utilizador> usersNome;
        ArrayList<Utilizador> usersNif;
        usersNif = ficheiro.getUtilizadoresArrayList(numDados);
        usersNome = (ArrayList<Utilizador>)usersNif.clone();
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        estatisticas.append(String.format(" %4d |", stopTimer()));
        
        //inserir um novo registo
        startTimer();
        usersNif.add(new Utilizador(123456789, "Joaquim", "Rua das flores"));
        usersNome = (ArrayList<Utilizador>)usersNif.clone();
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        estatisticas.append(String.format(" %7d |", stopTimer()));
        
        //procurar por nome
        startTimer();
        Utilizador procura = new Utilizador("Não existe");
        for( Utilizador tmp : usersNome ){
            comparacao = procura.compareNome(tmp);
            if( comparacao >= 0 )
                break;
        }
        
        if( comparacao == 0 )
            System.out.println("existe");
        else
            System.out.println("não existe");
        estatisticas.append(String.format(" %7d |", stopTimer()));
        
        //procurar por nif
        startTimer();
        procura = new Utilizador(123456789);
        for( Utilizador tmp : usersNif ){
            comparacao = procura.compareNif(tmp);
            if( comparacao >= 0 )
                break;
        }
        
        if( comparacao == 0 )
            System.out.println("existe");
        else
            System.out.println("não existe");
        estatisticas.append(String.format(" %6d |", stopTimer()));
        
        //imprimir os dados dos utilizadores
        startTimer();
        itr = usersNif.iterator();
        
        System.out.println("Por nif:");
        while(itr.hasNext())
            System.out.println(itr.next().toString());
        
        itr = usersNome.iterator();
        System.out.println("Por nome:");
        while(itr.hasNext())
            System.out.println(itr.next().toString());
        estatisticas.append(String.format(" %8d |\n", stopTimer()));
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
        return now.getTimeInMillis()-timer.getTimeInMillis();
    }
}
