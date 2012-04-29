package li3java;

import java.util.*;

/**
 * Calcula e imprime as estatísticas pedidas para a primeira fase do projecto
 */
public class Estatisticas {
    private StringBuilder estatisticas;
    private Cronometro cronometro;
    private int repeticoes;
    private Integer quantidades[];
    
    /**
     * Inicializa um novo objecto da classe Estatisticas
     * @param repeticoes Número de repetições para cada acção
     * @param rapido Se verdadeiro, apenas importa 5 valores. Se falso, importa 5000, 10000, 15000 e 1800 valores.
     */
    Estatisticas(int repeticoes, boolean rapido){
        this.repeticoes = repeticoes;
        
        //quantidade de dados a inserir para cada teste de desempenho
        if(rapido){
            quantidades = new Integer[1];
            quantidades[0] = 5;
        }else{
            quantidades = new Integer[4];
            quantidades[0] = 5000;
            quantidades[1] = 10000;
            quantidades[2] = 15000;
            quantidades[3] = 18000;
        }
        
    }
    
    /**
     * Realiza as acções pretendidas e a cronometra-as
     */
    public void comecar(){
        cronometro = new Cronometro(5); //ler, inserir, p.nome, p.nif, imprimir = 5 tempos diferentes
        cronometro.limpaTempo();
        
        estatisticas = new StringBuilder(
            String.format("\nEstatisticas de Utilizadores (tempo médio, em milisegundos, de %d repetições)\n",repeticoes)
        );
        
        estatisticas.append("                               | Ler  | Inserir | P. Nome | P. Nif | Imprimir |\n");
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------|\n");
        
        System.out.print("Progresso:\n2 ArrayLists");
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" 2 ArrayLists (%5d)          |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                utilizadoresArrayList(quantidade);
            imprimeTemposUtilizador();
            System.out.print(".");
        }
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------|\n");
        System.out.print("OK\nArrayList/Linked List");
        
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" ArrayList/Linked List (%5d) |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                utilizadoresArrayLinked(quantidade);
            imprimeTemposUtilizador();
            cronometro.limpaTempo();
            System.out.print(".");
        }
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------|\n");
        System.out.print("OK\nHashMap");
        
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" HashMap (%5d)               |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                utilizadoresHashMap(quantidade);
            imprimeTemposUtilizador();
            cronometro.limpaTempo();
            System.out.print(".");
        }
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------|\n");
        System.out.print("OK\nTreeMap");
        
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" TreeMap (%5d)               |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                utilizadoresTreeMap(quantidade);
            imprimeTemposUtilizador();
            cronometro.limpaTempo();
            System.out.print(".");
        }
        estatisticas.append("-------------------------------+------+---------+---------+--------+----------'\n");
        System.out.println("OK");
        System.out.print(estatisticas);
    }
    
    /**
     * Imprime os tempos médios das várias acções e re-inicializa o cornometro
     */
    private void imprimeTemposUtilizador(){
            cronometro.calculaMedias(repeticoes);
            estatisticas.append(String.format(" %4d |", cronometro.getTempo(0)));
            estatisticas.append(String.format(" %7d |", cronometro.getTempo(1)));
            estatisticas.append(String.format(" %7d |", cronometro.getTempo(2)));
            estatisticas.append(String.format(" %6d |", cronometro.getTempo(3)));
            estatisticas.append(String.format(" %8d |\n", cronometro.getTempo(4)));
            cronometro.limpaTempo();
    }
    
    /**
     * Função que faz o teste de desempenho com ArrayList
     * @param numDados Número de dados que devem ser lidos
     */
    private void utilizadoresArrayList(int numDados){
        Iterator itr;
        int comparacao = new Integer(-1);
        
        //recolher os dados
        cronometro.startTimer();
        ArrayList<Utilizador> usersNome;
        ArrayList<Utilizador> usersNif;
        usersNif = Ficheiro.getUtilizadoresArrayList(numDados);
        usersNome = (ArrayList<Utilizador>)usersNif.clone();
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        cronometro.adicionarTempo(0);
        
        //inserir um novo registo
        cronometro.startTimer();
        usersNif.add(new Utilizador(123456789, "Joaquim", "Rua das flores"));
        usersNome.add( usersNif.get(usersNif.size()-1) );// = (ArrayList<Utilizador>)usersNif.clone();
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        cronometro.adicionarTempo(1);
        
        //procurar por nome
        cronometro.startTimer();
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
        cronometro.adicionarTempo(2);
        
        //procurar por nif
        cronometro.startTimer();
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
        cronometro.adicionarTempo(3);
        
        //imprimir os dados dos utilizadores
        cronometro.startTimer();
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
        cronometro.adicionarTempo(4);
    }
    
    /**
     * Função que faz o teste de desempenho com ArrayList com uma LinkedList auxiliar
     * @param numDados Número de dados que devem ser lidos
     */
    private void utilizadoresArrayLinked(int numDados){
        Iterator itr;
        int comparacao = new Integer(-1);
        
        //recolher os dados
        cronometro.startTimer();
        ArrayList<Utilizador> usersNif;
        usersNif = Ficheiro.getUtilizadoresArrayList(numDados);
        LinkedList<Utilizador> usersNome = new LinkedList<Utilizador>(usersNif);
        
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        cronometro.adicionarTempo(0);
        
        //inserir um novo registo
        cronometro.startTimer();
        usersNif.add(new Utilizador(123456789, "Joaquim", "Rua das flores"));
        usersNome.addFirst(usersNif.get(usersNif.size()-1));
        Collections.sort(usersNif,new comparadorNif());
        Collections.sort(usersNome, new comparadorNome());
        cronometro.adicionarTempo(1);
        
        //procurar por nome
        cronometro.startTimer();
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
        cronometro.adicionarTempo(2);
        
        //procurar por nif
        cronometro.startTimer();
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
        cronometro.adicionarTempo(3);
        
        //imprimir os dados dos utilizadores
        cronometro.startTimer();
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
        cronometro.adicionarTempo(4);
    }
    
    /**
     * Função que faz o teste de desempenho com HashMap
     * @param numDados Número de dados que devem ser lidos
     */
    private void utilizadoresHashMap(int numDados){
        Iterator itr;
        int comparacao = new Integer(-1);
        
        //recolher os dados
        cronometro.startTimer();
        HashMap<Integer, Utilizador> usersNif;
        HashMap<String, Utilizador> usersNome = new HashMap<String, Utilizador>(numDados*2);
        usersNif = Ficheiro.getUtilizadoresHashMap(numDados);
        
        Collection<Utilizador> users = usersNif.values();
        for( Utilizador user : users ){
            usersNome.put(user.getNome(), user);
        }
        cronometro.adicionarTempo(0);
        
        //inserir um novo registo
        cronometro.startTimer();
        Integer novo_nif = 123456789;
        String novo_nome = "Joaquim";
        Utilizador novo_user = new Utilizador(novo_nif, novo_nome, "Rua das flores");
        usersNif.put(novo_nif, novo_user);
        usersNome.put(novo_nome, novo_user);
        
        cronometro.adicionarTempo(1);
        
        //procurar por nome
        cronometro.startTimer();
        if( usersNome.containsKey("Joaquim") )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        cronometro.adicionarTempo(2);
        
        //procurar por nif
        cronometro.startTimer();
        if( usersNif.containsKey( 123456789 ) )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        cronometro.adicionarTempo(3);
        
        //imprimir os dados dos utilizadores
        cronometro.startTimer();
        
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
        cronometro.adicionarTempo(4);
    }
    
    /**
     * Função que faz o teste de desempenho com TreeMap
     * @param numDados Número de dados que devem ser lidos
     */
    private void utilizadoresTreeMap(int numDados){
        Iterator itr;
        int comparacao = new Integer(-1);
        
        //recolher os dados
        cronometro.startTimer();
        TreeMap<Integer, Utilizador> usersNif;
        TreeMap<String, Utilizador> usersNome = new TreeMap<String, Utilizador>();
        usersNif = Ficheiro.getUtilizadoresTreeMap(numDados);
        
        Collection<Utilizador> users = usersNif.values();
        for( Utilizador user : users ){
            usersNome.put(user.getNome(), user);
        }
        
        cronometro.adicionarTempo(0);
        
        //inserir um novo registo
        cronometro.startTimer();
        Integer novo_nif = 123456789;
        String novo_nome = "Joaquim";
        Utilizador novo_user = new Utilizador(novo_nif, novo_nome, "Rua das flores");
        usersNif.put(novo_nif, novo_user);
        usersNome.put(novo_nome, novo_user);
        
        cronometro.adicionarTempo(1);
        
        
        //procurar por nome
        cronometro.startTimer();
        if( usersNome.containsKey("Joaquim") )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        cronometro.adicionarTempo(2);
        
        //procurar por nif
        cronometro.startTimer();
        if( usersNif.containsKey( 123456789 ) )
            ;//System.out.println("existe");
        else
            ;//System.out.println("não existe");
        cronometro.adicionarTempo(3);
        
        //imprimir os dados dos utilizadores
        cronometro.startTimer();
        
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
        cronometro.adicionarTempo(4);
    }
}
