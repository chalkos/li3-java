package li3java;

import java.util.*;

/**
 * Calcula e imprime as estatísticas pedidas para a primeira fase do projecto
 */
public class Estatisticas {
    private StringBuilder estatisticas;
    private StringBuilder output;
    private Cronometro cronometro;
    private int repeticoes;
    private Integer quantidades[];
    private boolean imprime;
    private Utilizador[] sampleUsers;
    
    /**
     * Inicializa um novo objecto da classe Estatisticas
     * @param repeticoes Número de repetições para cada acção
     * @param rapido Se verdadeiro, apenas importa 5 valores. Se falso, importa 5000, 10000, 15000 e 1800 valores.
     */
    Estatisticas(int repeticoes, boolean rapido){
        this.repeticoes = repeticoes;
        this.imprime = false;
        
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
        sampleUsers = new Utilizador[repeticoes];
        for(int i=0; i<repeticoes; i++)
            sampleUsers[i] = new Utilizador( String.format("%09d", i), String.format("nome comprido nr%d", i), "morada" );
    }
    
    /**
     * Força a flag de impressão de texto de debug a ser verdade
     */
    public void forceImprime(){
        this.imprime = true;
    }
    
    /**
     * Escreve o output de debug da aplicação
     */
    private void imprime(){
        if( this.imprime )
            System.out.print(output);
        output = new StringBuilder(200);
    }
    
    /**
     * Realiza as acções pretendidas e a cronometra-as
     */
    public void comecar(){
        cronometro = new Cronometro(); //ler, inserir, p.nome, p.nif, imprimir = 5 tempos diferentes
        cronometro.limpaTempo();
        
        output = new StringBuilder(200);
        String[] formatos = new String[4];
        formatos[0] = " 2 ArrayLists (%5d)          |";
        formatos[1] = " ArrayList/Linked List (%5d) |";
        formatos[2] = " HashMap (%5d)               |";
        formatos[3] = " TreeMap (%5d)               |";
        
        estatisticas = new StringBuilder(
            String.format("\nEstatisticas de Utilizadores (tempo, em milisegundos, de %d repetições)\n",repeticoes)
        );
        
        estatisticas.append("                               | Ler     | Inserir    | P. Nome    | P. Nif    | Imprimir    |\n");
        estatisticas.append("-------------------------------+---------+------------+------------+-----------+-------------|\n");
        
        for (int i = 0; i < 4; i++) {
            //correr 1 vez
            System.out.println("\nwarm up");
            for (int quantidade : quantidades) {
                System.out.print(quantidade);
                utilizadores(quantidade, i);
                cronometro.limpaTempo();
            }
            
            //cronometrar as seguintes:
            System.out.println("\nmedições");
            for (int quantidade : quantidades) {
                System.out.print(quantidade);
                estatisticas.append(String.format(formatos[i], quantidade));
                utilizadores(quantidade, i);
                imprimeTemposUtilizador();
            }
            
            estatisticas.append("-------------------------------+------+---------+---------+--------+----------|\n");
        }
        
        
        
        
        
        /*
        
        // começar a estatistica de localidades
        cronometro = new Cronometro(5); //ler, inserir local, inserir ligacao, procurar ligacoes, imprimir
        cronometro.limpaTempo();
        
        estatisticas.append(
            String.format("\n\nEstatisticas de Localidades (tempo médio, em milisegundos, de %d repetições)\n",repeticoes)
        );
        
        estatisticas.append("                            | Ler  | Ins. Local | Ins. Lig. | P. Lig. | Imprimir |\n");
        estatisticas.append("----------------------------+------+------------+-----------+---------+----------|\n");
        
        //System.out.print("Progresso (Localidades):\n2 ArrayLists");
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" 2 ArrayList (%5d)        |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                localidadesArrayList(quantidade);
            imprimeTemposLocalidade();
            //System.out.print(".");
        }
        estatisticas.append("----------------------------+------+------------+-----------+---------+----------|\n");
        //System.out.print("OK\nArrayList/Hash Set");
        
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" ArrayList/Hash Set (%5d) |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                localidadesHashSet(quantidade);
            imprimeTemposLocalidade();
            cronometro.limpaTempo();
            //System.out.print(".");
        }
        estatisticas.append("----------------------------+------+------------+-----------+---------+----------|\n");
        //System.out.print("OK\n2 HashMap");
        
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" 2 HashMap (%5d)          |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                localidadesHashMap(quantidade);
            imprimeTemposLocalidade();
            cronometro.limpaTempo();
            //System.out.print(".");
        }
        estatisticas.append("----------------------------+------+------------+-----------+---------+----------|\n");
        //System.out.print("OK\n2 TreeMap");
        
        for( int quantidade : quantidades ){
            estatisticas.append(String.format(" 2 TreeMap (%5d)          |", quantidade));
            for( int j=0; j<repeticoes; j++ )
                utilizadoresTreeMap(quantidade);
            imprimeTemposLocalidade();
            cronometro.limpaTempo();
            //System.out.print(".");
        }
        estatisticas.append("----------------------------+------+------------+-----------+---------+----------'\n");
        //System.out.println("OK");*/
        System.out.print(estatisticas);
    }
    
    /**
     * Imprime os tempos médios das várias acções sobre Utilizadores e re-inicializa o cronometro
     */
    private void imprimeTemposUtilizador(){
            estatisticas.append(String.format(" %7d |", cronometro.getTempo(0)));
            estatisticas.append(String.format(" %10d |", cronometro.getTempo(1)));
            estatisticas.append(String.format(" %10d |", cronometro.getTempo(2)));
            estatisticas.append(String.format(" %9d |", cronometro.getTempo(3)));
            estatisticas.append(String.format(" %11d |\n", cronometro.getTempo(4)));
            cronometro.limpaTempo();
    }
    
    /**
     * Imprime os tempos médios das várias acções sobre Localidades e re-inicializa o cornometro
     */
    private void imprimeTemposLocalidade(){
            estatisticas.append(String.format(" %4d |", cronometro.getTempo(0)));
            estatisticas.append(String.format(" %10d |", cronometro.getTempo(1)));
            estatisticas.append(String.format(" %9d |", cronometro.getTempo(2)));
            estatisticas.append(String.format(" %7d |", cronometro.getTempo(3)));
            estatisticas.append(String.format(" %8d |\n", cronometro.getTempo(4)));
            cronometro.limpaTempo();
    }
    
    /**
     * Função que faz o teste de desempenho de Utilizadores
     * @param numDados Número de dados que devem ser lidos
     * @param tipo 0 Utiliza 2 ArrayList
     * @param tipo 1 Utiliza ArrayList para NIF e LinkedList para os nomes
     * @param tipo 2 Utiliza 2 HashMap
     * @param tipo 3 Utiliza 2 TreeMap
     */
    private void utilizadores(int numDados, int tipo){
        Utilizadores utilizadores = null; //para não dar warning que pode não estar inicializado
        
        switch(tipo){
            case 0 : utilizadores = new UtilizadoresArrayList(numDados); break;
            case 1 : utilizadores = new UtilizadoresArrayLinked(numDados); break;
            case 2 : utilizadores = new UtilizadoresHashMap(numDados); break;
            case 3 : utilizadores = new UtilizadoresTreeMap(numDados); break;
        }
        
        //recolher os dados
        cronometro.startTimer();
        utilizadores = Ficheiro.getUtilizadores(utilizadores);
        cronometro.adicionarTempo(0);
        
        System.out.print(".");
        //inserir um novo registo
        cronometro.startTimer();
        for(int i=0; i<this.repeticoes; i++)
            utilizadores.insere( sampleUsers[i] );
        cronometro.adicionarTempo(1);
        
        System.out.print(".");
        //procurar por nome
        cronometro.startTimer();
        String procura;
        for(int i=0; i<this.repeticoes; i++){
            procura = Integer.valueOf(i).toString();

            if( utilizadores.procuraNome(procura) != null )
                output.append("[Por Nome]O utilizador ").append(procura).append(" existe\n");
            else
                output.append("[Por Nome]O utilizador ").append(procura).append(" não existe\n");
        }
        cronometro.adicionarTempo(2);
        
        System.out.print(".");
        //procurar por nif
        cronometro.startTimer();
        for(int i=0; i<this.repeticoes; i++){
            procura = Integer.valueOf(i).toString();
        
            if( utilizadores.procuraNif(procura) != null )
                output.append("[Por Nif ]O nif ").append(procura).append(" existe\n");
            else
                output.append("[Por Nif ]O nif ").append(procura).append(" não existe\n");
        }
        cronometro.adicionarTempo(3);
        
        System.out.print(".");
        //imprimir os dados dos utilizadores
        cronometro.startTimer();
        output.append("Por nif:\n").append(utilizadores.toStringNif());
        output.append("Por nome:\n").append(utilizadores.toStringNome());
        imprime();
        cronometro.adicionarTempo(4);
        System.out.print(":");
    }
    
    private void localidadesArrayList(int numDados){
        Ligacao lnova;
        
        //recolher os dados
        cronometro.startTimer();
        ArrayList<LocalidadeArrayList> locs = Ficheiro.getLocalidadesArrayList(numDados);
        Ficheiro.getLigacoesArrayList(locs);
        cronometro.adicionarTempo(0);
        
        //nova localidade
        cronometro.startTimer();
        locs.add(new LocalidadeArrayList("Marte"));
        cronometro.adicionarTempo(1);
        
        //nova ligacao
        cronometro.startTimer();
        lnova = new Ligacao("Taipa", 10, 20);
        for(int i=0; i<locs.size();i++)
            if(locs.get(i).getNome().equals("Marte")){
                locs.get(i).novaAdjacencia(lnova);
                break;
            }
        cronometro.adicionarTempo(2);
        
        //procurar as ligações de uma localidade
        cronometro.startTimer();
        for(int i=0; i<locs.size();i++)
            if(locs.get(i).getNome().equals("Marte")){
                for(Iterator<Ligacao> itr = locs.get(i).getIterator(); itr.hasNext(); lnova = itr.next() )
                    ;//fazer qualquer coisa com as adjacencias que encontrou
            }
        cronometro.adicionarTempo(3);

        //imprimir os dados
        cronometro.startTimer();
        for(LocalidadeArrayList local : locs){
            //System.out.print(local.getNome());
            local.getNome();
            for(Iterator<Ligacao> itr = local.getIterator(); itr.hasNext(); lnova = itr.next() )
                ;//System.out.print(String.format(":%s", ligacao));
            //System.out.println();
        }
        cronometro.adicionarTempo(4);
    }
    
    private void localidadesHashSet(int numDados){
        Ligacao lnova;
        
        //recolher os dados
        cronometro.startTimer();
        ArrayList<LocalidadeHashSet> locs = Ficheiro.getLocalidadesHashSet(numDados);
        Ficheiro.getLigacoesHashSet(locs);
        cronometro.adicionarTempo(0);
        
        //nova localidade
        cronometro.startTimer();
        locs.add(new LocalidadeHashSet("Marte"));
        cronometro.adicionarTempo(1);
        
        //nova ligacao
        cronometro.startTimer();
        for(int i=0; i<locs.size();i++)
            if(locs.get(i).getNome().equals("Marte")){
                locs.get(i).novaAdjacencia(new Ligacao("Taipa", 10, 200));
                break;
            }
        cronometro.adicionarTempo(2);
        
        //procurar as ligações de uma localidade
        cronometro.startTimer();
        for(int i=0; i<locs.size();i++)
            if(locs.get(i).getNome().equals("Marte")){
                for(Iterator<Ligacao> itr = locs.get(i).getIterator(); itr.hasNext(); lnova = itr.next() )
                    ;//fazer qualquer coisa com as adjacencias que encontrou
            }
        cronometro.adicionarTempo(3);

        //imprimir os dados
        cronometro.startTimer();
        for(LocalidadeHashSet local : locs){
            //System.out.print(local.getNome());
            local.getNome();
            for(Iterator<Ligacao> itr = local.getIterator(); itr.hasNext(); lnova = itr.next() )
                ;//System.out.print(String.format(":%s", ligacao));
            //System.out.println();
        }
        cronometro.adicionarTempo(4);
    }
    
    private void localidadesHashMap(int numDados){
        //recolher os dados
        cronometro.startTimer();
        HashMap<String, HashMap<String, String>> locs = Ficheiro.getLocalidadesHashMap(numDados);
        Ficheiro.getLigacoesHashMap(locs);
        cronometro.adicionarTempo(0);
        
        //nova localidade
        cronometro.startTimer();
        locs.put("Marte", new HashMap<String, String>(8));
        cronometro.adicionarTempo(1);
        
        //nova ligacao
        cronometro.startTimer();
        HashMap<String, String> encontrado = locs.get("Marte");
        if( encontrado != null ){
            encontrado.put("Taipas", null);
        }
        cronometro.adicionarTempo(2);
        
        //procurar as ligações de uma localidade
        cronometro.startTimer();
        
        encontrado = locs.get("Marte");
        for( String lig : encontrado.keySet() )
            ;//fazer qualquer coisa com as adjacencias que encontrou
        cronometro.adicionarTempo(3);

        //imprimir os dados
        cronometro.startTimer();
        String key;
        for (Iterator<String> it = locs.keySet().iterator(); it.hasNext();){
            key = it.next();
            //System.out.print(key);
            for( String lig : locs.get(key).keySet() )
                ;//System.out.print(String.format(":%s", lig));
            //System.out.println();
        }
        cronometro.adicionarTempo(4);
    }
    
    private void localidadesTreeMap(int numDados){
        //recolher os dados
        cronometro.startTimer();
        TreeMap<String, TreeMap<String, String>> locs = Ficheiro.getLocalidadesTreeMap(numDados);
        Ficheiro.getLigacoesTreeMap(locs);
        cronometro.adicionarTempo(0);
        
        //nova localidade
        cronometro.startTimer();
        locs.put("Marte", new TreeMap<String, String>());
        cronometro.adicionarTempo(1);
        
        //nova ligacao
        cronometro.startTimer();
        TreeMap<String, String> encontrado = locs.get("Marte");
        if( encontrado != null ){
            encontrado.put("Taipas", null);
        }
        cronometro.adicionarTempo(2);
        
        //procurar as ligações de uma localidade
        cronometro.startTimer();
        
        encontrado = locs.get("Marte");
        for( String lig : encontrado.keySet() )
            ;//fazer qualquer coisa com as adjacencias que encontrou
        cronometro.adicionarTempo(3);

        //imprimir os dados
        cronometro.startTimer();
        String key;
        for (Iterator<String> it = locs.keySet().iterator(); it.hasNext();){
            key = it.next();
            //System.out.print(key);
            for( String lig : locs.get(key).keySet() )
                ;//System.out.print(String.format(":%s", lig));
            //System.out.println();
        }
        cronometro.adicionarTempo(4);
    }
}
