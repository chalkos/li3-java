package li3java;

import localidade.*;
import utilizador.*;

/**
 * Calcula e imprime as estatísticas pedidas para a primeira fase do projecto
 */
public class Estatisticas {
    private StringBuilder estatisticas;
    private StringBuilder output;
    private Cronometro cronometro;
    private Integer quantidades[];
    private boolean imprime;
    private Utilizador[] sampleUsers;
    private Localidade[] sampleLocal;
    private Ligacao[] sampleLigacao;
    private int ntestes;
    private long[][] tempos;
    
    
    /**
     * Inicializa um novo objecto da classe Estatisticas
     * @param nTestes Número de testes a correr em inserções e pesquisas.
     * @param rapido Se verdadeiro, apenas importa 5 valores. Se falso, importa 5000, 10000, 15000 e 1800 valores.
     */
    Estatisticas(int nTestes, boolean rapido){
        this.imprime = false;
        this.ntestes = nTestes;
        this.tempos = new long[10][5];
        
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
        sampleUsers = new Utilizador[this.ntestes];
        for(int i=0; i<this.ntestes; i++)
            sampleUsers[i] = new Utilizador( String.format("%09d", i), String.format("nome comprido nr%d", i), "morada" );
        
        sampleLocal = new Localidade[this.ntestes];
        for(int i=0; i<this.ntestes; i++)
            sampleLocal[i] = new Localidade("lig"+i, 0);
        
        sampleLigacao = new Ligacao[this.ntestes];
        for(int i=0; i<this.ntestes; i++)
                sampleLigacao[i] = new Ligacao("lig"+i, i*10, i);
        
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
     * Realiza as acções pretendidas, cronometra-as e mostra as médias e desvios padrão
     */
    public void comecar(){
        cronometro = new Cronometro(); //ler, inserir, p.nome, p.nif, imprimir = 5 tempos diferentes
        cronometro.limpaTempo();
        
        output = new StringBuilder(200);
        String[] formatos = new String[4];
        double[][] mdp = new double[2][this.tempos[0].length];
        
        
        formatos[0] = " 2 ArrayLists (%5d)";
        formatos[1] = " ArrayList/Linked List (%5d)";
        formatos[2] = " HashMap (%5d)";
        formatos[3] = " TreeMap (%5d)";
        
        estatisticas = new StringBuilder("\nEstatisticas de Utilizadores");
        
        //estatisticas.append("                               | Ler         | Inserir        | P. Nome        | P. Nif        | Imprimir        |\n");
        //estatisticas.append("-------------------------------+-------------+----------------+----------------+---------------+-----------------|\n");
        
        for (int i = 0; i < 4; i++) {
            //correr 1 vez
            System.out.println("\nwarm up");
            for (int quantidade : quantidades) {
                utilizadores(quantidade, i);
                cronometro.limpaTempo();
            }
            
            //cronometrar as seguintes:
            System.out.println("\nmedições");
            for (int quantidade : quantidades) {
                estatisticas.append(String.format(formatos[i], quantidade)).append("\n");
                for(int j=0; j<this.tempos.length; j++){
                    utilizadores(quantidade, i);
                    guardaTempos(j);
                    cronometro.limpaTempo();
                }
                imprimeTempos(calculaTempos());
            }
            
            //estatisticas.append("-------------------------------+-------------+----------------+----------------+---------------+-----------------|\n");
            estatisticas.append("-------------------------------------------------------------------------------------------------------\n");
        }
        
        // começar a estatistica de localidades
        cronometro = new Cronometro(5); //ler, inserir local, inserir ligacao, procurar ligacoes, imprimir
        cronometro.limpaTempo();
        
        
        formatos[0] = "2 ArrayList (%5d)";
        formatos[1] = "ArrayList/Hash Set (%5d)";
        formatos[2] = "2 HashMap (%5d)";
        formatos[3] = "2 TreeMap (%5d)";
        
        
        
        estatisticas.append("\n\nEstatisticas de Localidades\n");
        
        //estatisticas.append("                            | Ler         | Ins. Local        | Ins. Lig.        | P. Lig.        | Imprimir        |\n");
        //estatisticas.append("----------------------------+-------------+-------------------+------------------+----------------+-----------------|\n");
        
        for (int i = 0; i < 4; i++) {
            //correr 1 vez
            System.out.println("\nwarm up");
            for (int quantidade : quantidades) {
                localidades(quantidade, i);
                cronometro.limpaTempo();
            }
            
            //cronometrar as seguintes:
            System.out.println("\nmedições");
            for (int quantidade : quantidades) {
                estatisticas.append(String.format(formatos[i], quantidade)).append("\n");
                for(int j=0; j<this.tempos.length; j++){
                    localidades(quantidade, i);
                    guardaTempos(j);
                    cronometro.limpaTempo();
                }
                imprimeTempos(calculaTempos());
            }
            
            estatisticas.append("-------------------------------------------------------------------------------------------------------\n");
            //estatisticas.append("----------------------------+-------------+-------------------+------------------+----------------+-----------------|\n");
        }
        
        System.out.print(estatisticas);
    }
    
    /**
     * Imprime os tempos e reinicia o cronómetro
     */
    private void imprimeTempos(){
            for(int i=0; i<5; i++)
                estatisticas.append(cronometro.getTempo(i)).append("\n");
            cronometro.limpaTempo();
    }
    
    /**
     * Imprime os tempos médios das várias acções sobre Localidades e re-inicializa o cronómetro
     * @param mdp as medias e desvios padrão dos tempos
     */
    private void imprimeTempos(double[][] mdp){
        for(int i=0; i<mdp[0].length; i++)
            estatisticas.append("M").append(mdp[0][i]).append("  DP").append(mdp[1][i]).append("\n");
        cronometro.limpaTempo();
    }
    
    /**
     * Guarda os tempos na matriz de tempos para depois ser possível calcular o desvio padrão
     * @param actual indicador da posição a escrever
     */
    private void guardaTempos(int actual){
        for( int i=0; i<5; i++ )
            tempos[actual][i] = cronometro.getTempo(i);
    }
    
    /**
     * Calcula médias e desvios padrão
     * @return [0] médias, [1] desvios padrão
     */
    private double[][] calculaTempos(){
        int maxI = tempos.length;
        int maxJ = tempos[0].length;
        double[] dp = new double[maxJ];
        double[] media = new double[maxJ];
        double acumulador;
        double[][] ret;
        
        for( int i=0; i<maxI; i++)
            for( int j=0; j<maxJ; j++)
                media[j] += tempos[i][j];
        
        for(int i=0; i<maxJ; i++)
            media[i] /= maxI;
        
        for(int j=0; j<maxJ; j++){
            acumulador = 0;
            for( int i=0; i<maxI; i++){
                acumulador += Math.pow(( tempos[i][j] - media[j] ), 2);
            }
            dp[j] = Math.sqrt( (acumulador/(maxI-1))  );
        }
        
        ret = new double[2][maxJ];
        ret[0] = media;
        ret[1] = dp;
        return ret;
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
        for(int i=0; i<sampleUsers.length; i++)
            utilizadores.insere( sampleUsers[i] );
        cronometro.adicionarTempo(1);
        
        System.out.print(".");
        //procurar por nome
        cronometro.startTimer();
        String procura;
        for(int i=0; i<sampleUsers.length; i++){
            procura = Integer.valueOf(i).toString();

            if( utilizadores.procuraNome(procura) != null )
                ;//output.append("[Por Nome]O utilizador ").append(procura).append(" existe\n");
            else
                ;//output.append("[Por Nome]O utilizador ").append(procura).append(" não existe\n");
        }
        cronometro.adicionarTempo(2);
        
        System.out.print(".");
        //procurar por nif
        cronometro.startTimer();
        for(int i=0; i<sampleUsers.length; i++){
            procura = Integer.valueOf(i).toString();
        
            if( utilizadores.procuraNif(procura) != null )
                ;//output.append("[Por Nif ]O nif ").append(procura).append(" existe\n");
            else
                ;//output.append("[Por Nif ]O nif ").append(procura).append(" não existe\n");
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
    
    /**
     * Função que faz o teste de desempenho de Localidades
     * @param numDados Número de dados que devem ser lidos
     * @param tipo 0 ArrayList para Localidades e ArrayList para as adjacências
     * @param tipo 1 ArrayList para Localidades e HashSet para as adjacências
     * @param tipo 2 HashMap para Localidades e HashMap para as adjacências
     * @param tipo 3 TreeMap para Localidades e TreeMap para as adjacências
     */
    private void localidades(int numDados, int tipo){
        Localidades locs = null;
        
        switch(tipo){
            case 0 : locs = new LocalidadesArrayList(numDados, 0); break;
            case 1 : locs = new LocalidadesArrayList(numDados, 1); break;
            case 2 : locs = new LocalidadesHashMap(numDados, 2); break;
            case 3 : locs = new LocalidadesTreeMap(numDados, 3); break;
        }
        
        //recolher os dados
        cronometro.startTimer();
        locs = Ficheiro.getLocalidades(locs);
        locs = Ficheiro.getLigacoes(locs);
        cronometro.adicionarTempo(0);
        System.out.print(".");
        
        //nova localidade
        cronometro.startTimer();
        for(int i=0; i<sampleLocal.length; i++)
            locs.insere(sampleLocal[i]);
        cronometro.adicionarTempo(1);
        System.out.print(".");
        
        //nova ligacao
        cronometro.startTimer();
        for(int i=0; i<this.sampleLocal.length; i++)
            for(int j=0; j<this.sampleLigacao.length; j++)
                locs.insereLigacao(sampleLocal[i], sampleLigacao[j]);
        cronometro.adicionarTempo(2);
        System.out.print(".");
        
        //procurar as ligações de uma localidade
        cronometro.startTimer();
        for(int j=0; j<sampleLigacao.length; j++)
            for(int i=0; i<this.sampleLocal.length; i++)
                if( locs.procuraLig(sampleLocal[i], sampleLigacao[j]) != null )
                    ;/*output.append("A localidade ")
                            .append(sampleLocal[i].getNome())
                            .append(" tem ligação a ")
                            .append(sampleLigacao[j])
                            .append("\n");*/
                else
                    ;/*output.append("A localidade ")
                            .append(sampleLocal[i].getNome())
                            .append(" não tem ligação a ")
                            .append(sampleLigacao[j])
                            .append("\n");*/
        
        cronometro.adicionarTempo(3);
        System.out.print(".");

        //imprimir os dados
        cronometro.startTimer();
        output.append(locs.toString()).append("\n");
        imprime();
        cronometro.adicionarTempo(4);
        System.out.print(":");
    }
}
