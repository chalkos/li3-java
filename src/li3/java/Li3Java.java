package li3.java;


import java.util.*;


public class Li3Java {
    private static GregorianCalendar timer;
    private static StringBuilder estatisticas;
    private static long tempos[];
    
    /**
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args) {
        tempos = new long[5]; //número de tempos medidos (ler, inserir, procurar nome, procurar nif, imprimir)
        
        //Integer quantidades[] = {5};
        Integer quantidades[] = {5000, 10000, 15000, 18000}; //quantidade de dados a inserir para cada teste de desempenho
        int repeticoes = 60; // numero de vezes que se repetem os testes
        
        estatisticas = new StringBuilder(String.format("\nEstatisticas de Utilizadores (tempo médio, em milisegundos, de %d repetições)\n",repeticoes));
        
        estatisticas.append("                               | Ler  | Inserir | P. Nome | P. Nif | Imprimir |\n");
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------|\n");
        
        System.out.print("Progresso ");
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" 2 ArrayLists (%5d)          |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                utilizadoresArrayList(quantidade);
           estatisticas.append(String.format(" %4d |", tempos[0]/repeticoes));
           estatisticas.append(String.format(" %7d |", tempos[1]/repeticoes));
           estatisticas.append(String.format(" %7d |", tempos[2]/repeticoes));
           estatisticas.append(String.format(" %6d |", tempos[3]/repeticoes));
           estatisticas.append(String.format(" %8d |\n", tempos[4]/repeticoes));
           limpaTempo();
           System.out.print(":");
        }
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------|\n");
        
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" ArrayList/Linked List (%5d) |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                utilizadoresArrayLinked(quantidade);
           estatisticas.append(String.format(" %4d |", tempos[0]/repeticoes));
           estatisticas.append(String.format(" %7d |", tempos[1]/repeticoes));
           estatisticas.append(String.format(" %7d |", tempos[2]/repeticoes));
           estatisticas.append(String.format(" %6d |", tempos[3]/repeticoes));
           estatisticas.append(String.format(" %8d |\n", tempos[4]/repeticoes));
           limpaTempo();
           System.out.print(".");
        }
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------|\n");
        
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" HashMap (%5d)               |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                utilizadoresHashMap(quantidade);
           estatisticas.append(String.format(" %4d |", tempos[0]/repeticoes));
           estatisticas.append(String.format(" %7d |", tempos[1]/repeticoes));
           estatisticas.append(String.format(" %7d |", tempos[2]/repeticoes));
           estatisticas.append(String.format(" %6d |", tempos[3]/repeticoes));
           estatisticas.append(String.format(" %8d |\n", tempos[4]/repeticoes));
           limpaTempo();
           System.out.print(":");
        }
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------|\n");
        
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" TreeMap (%5d)               |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                utilizadoresTreeMap(quantidade);
           estatisticas.append(String.format(" %4d |", tempos[0]/repeticoes));
           estatisticas.append(String.format(" %7d |", tempos[1]/repeticoes));
           estatisticas.append(String.format(" %7d |", tempos[2]/repeticoes));
           estatisticas.append(String.format(" %6d |", tempos[3]/repeticoes));
           estatisticas.append(String.format(" %8d |\n", tempos[4]/repeticoes));
           limpaTempo();
           System.out.print(".");
        }
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------'\n");
        System.out.print(estatisticas);
    }
    
    /**
     * Função que faz o teste de desempenho com ArrayList
     * @param numDados Número de dados que devem ser lidos
     * @param posQ Indice do array de quantidades
     */
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
        adicionarTempo(0);
        
        //inserir um novo registo
        startTimer();
        usersNif.add(new Utilizador(123456789, "Joaquim", "Rua das flores"));
        usersNome.add( usersNif.get(usersNif.size()-1) );// = (ArrayList<Utilizador>)usersNif.clone();
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        adicionarTempo(1);
        
        //procurar por nome
        startTimer();
        Utilizador procura = new Utilizador("Não existe");
        for( Utilizador tmp : usersNome ){
            comparacao = procura.compareNome(tmp);
            if( comparacao >= 0 )
                break;
        }
        
        if( comparacao == 0 )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        adicionarTempo(2);
        
        //procurar por nif
        startTimer();
        procura = new Utilizador(123456789);
        for( Utilizador tmp : usersNif ){
            comparacao = procura.compareNif(tmp);
            if( comparacao >= 0 )
                break;
        }
        
        if( comparacao == 0 )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        adicionarTempo(3);
        
        //imprimir os dados dos utilizadores
        startTimer();
        itr = usersNif.iterator();
        
        //System.out.println("Por nif:");
        while(itr.hasNext())
            //System.out.println(itr.next().toString());
            itr.next().toString();
        
        itr = usersNome.iterator();
        //System.out.println("Por nome:");
        while(itr.hasNext())
            //System.out.println(itr.next().toString());
            itr.next().toString();
        adicionarTempo(4);
    }
    
    /**
     * Função que faz o teste de desempenho com ArrayList com uma LinkedList auxiliar
     * @param numDados Número de dados que devem ser lidos
     * @param posQ Indice do array de quantidades
     */
    public static void utilizadoresArrayLinked(int numDados){
        Iterator itr;
        int comparacao = new Integer(-1);
        
        //recolher os dados
        startTimer();
        ArrayList<Utilizador> usersNif;
        usersNif = ficheiro.getUtilizadoresArrayList(numDados);
        LinkedList<Utilizador> usersNome = new LinkedList<Utilizador>(usersNif);
        
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        adicionarTempo(0);
        
        //inserir um novo registo
        startTimer();
        usersNif.add(new Utilizador(123456789, "Joaquim", "Rua das flores"));
        usersNome.addFirst(usersNif.get(usersNif.size()-1));
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        adicionarTempo(1);
        
        //procurar por nome
        startTimer();
        Utilizador procura = new Utilizador("Não existe");
        for( Utilizador tmp : usersNome ){
            comparacao = procura.compareNome(tmp);
            if( comparacao >= 0 )
                break;
        }
        
        if( comparacao == 0 )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        adicionarTempo(2);
        
        //procurar por nif
        startTimer();
        procura = new Utilizador(123456789);
        for( Utilizador tmp : usersNif ){
            comparacao = procura.compareNif(tmp);
            if( comparacao >= 0 )
                break;
        }
        
        if( comparacao == 0 )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        adicionarTempo(3);
        
        //imprimir os dados dos utilizadores
        startTimer();
        itr = usersNif.iterator();
        
        //System.out.println("Por nif:");
        while(itr.hasNext())
            //System.out.println(itr.next().toString());
            itr.next().toString();
        
        itr = usersNome.iterator();
        //System.out.println("Por nome:");
        while(itr.hasNext())
            //System.out.println(itr.next().toString());
            itr.next().toString();
        adicionarTempo(4);
    }
    
    /**
     * Função que faz o teste de desempenho com HashMap
     * @param numDados Número de dados que devem ser lidos
     * @param posQ Indice do array de quantidades
     */
    public static void utilizadoresHashMap(int numDados){
        Iterator itr;
        int comparacao = new Integer(-1);
        
        //recolher os dados
        startTimer();
        HashMap<Integer, Utilizador> usersNif;
        HashMap<String, Utilizador> usersNome = new HashMap<String, Utilizador>(numDados*2);
        usersNif = ficheiro.getUtilizadoresHashMap(numDados);
        
        Collection<Utilizador> users = usersNif.values();
        for( Utilizador user : users ){
            usersNome.put(user.getNome(), user);
        }
        adicionarTempo(0);
        
        //inserir um novo registo
        startTimer();
        Integer novo_nif = 123456789;
        String novo_nome = "Joaquim";
        Utilizador novo_user = new Utilizador(novo_nif, novo_nome, "Rua das flores");
        usersNif.put(novo_nif, novo_user);
        usersNome.put(novo_nome, novo_user);
        
        adicionarTempo(1);
        
        //procurar por nome
        startTimer();
        if( usersNome.containsKey("Joaquim") )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        adicionarTempo(2);
        
        //procurar por nif
        startTimer();
        if( usersNif.containsKey( 123456789 ) )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        adicionarTempo(3);
        
        //imprimir os dados dos utilizadores
        startTimer();
        
        ArrayList<Utilizador> usersNifOrdenado = new ArrayList<Utilizador>(usersNif.values());
        ArrayList<Utilizador> usersNomeOrdenado = new ArrayList<Utilizador>(usersNome.values());
        
        Collections.sort(usersNifOrdenado,new comparadorNif());
        Collections.sort(usersNomeOrdenado, new comparadorNome());
        
        itr = usersNifOrdenado.iterator();
        
        //System.out.println("Por nif:");
        while(itr.hasNext())
            //System.out.println(itr.next().toString());
            itr.next().toString();
        
        itr = usersNomeOrdenado.iterator();
        //System.out.println("Por nome:");
        while(itr.hasNext())
            //System.out.println(itr.next().toString());
            itr.next().toString();
        adicionarTempo(4);
    }
    
    /**
     * Função que faz o teste de desempenho com TreeMap
     * @param numDados Número de dados que devem ser lidos
     */
    public static void utilizadoresTreeMap(int numDados){
        Iterator itr;
        int comparacao = new Integer(-1);
        
        //recolher os dados
        startTimer();
        TreeMap<Integer, Utilizador> usersNif;
        TreeMap<String, Utilizador> usersNome = new TreeMap<String, Utilizador>();
        usersNif = ficheiro.getUtilizadoresTreeMap(numDados);
        
        Collection<Utilizador> users = usersNif.values();
        for( Utilizador user : users ){
            usersNome.put(user.getNome(), user);
        }
        
        adicionarTempo(0);
        
        //inserir um novo registo
        startTimer();
        Integer novo_nif = 123456789;
        String novo_nome = "Joaquim";
        Utilizador novo_user = new Utilizador(novo_nif, novo_nome, "Rua das flores");
        usersNif.put(novo_nif, novo_user);
        usersNome.put(novo_nome, novo_user);
        
        adicionarTempo(1);
        
        
        //procurar por nome
        startTimer();
        if( usersNome.containsKey("Joaquim") )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        adicionarTempo(2);
        
        //procurar por nif
        startTimer();
        if( usersNif.containsKey( 123456789 ) )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        adicionarTempo(3);
        
        //imprimir os dados dos utilizadores
        startTimer();
        
        itr = usersNif.keySet().iterator();
        
        //System.out.println("Por nif:");
        while(itr.hasNext())
            //System.out.println(usersNif.get( itr.next() ).toString());
            usersNif.get( itr.next() ).toString();
        
        itr = usersNome.keySet().iterator();
        //System.out.println("Por nome:");
        while(itr.hasNext())
            //System.out.println(usersNome.get( itr.next() ).toString());
            usersNome.get( itr.next() ).toString();
        adicionarTempo(4);
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
    
    /**
     * Adiciona tempo ao array de tempos
     * @param accao Accao cronometrada
     * @param valor milisegundos a adicionar
     */
    public static void adicionarTempo(int accao){
        tempos[accao] += stopTimer();
    }
    
    public static void limpaTempo(){
        tempos = new long[5];
    }
}