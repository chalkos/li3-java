package li3java;

import java.util.GregorianCalendar;

/**
 * Classe responsável pela cronometragem de acções
 */
public class Cronometro {
    private GregorianCalendar timer;
    private long[] tempos;
    private int tamanho;
    
    /**
     * Inicializar um novo cronómetro com capacidade para 5 tempos diferentes
     */
    Cronometro(){
        this.tamanho = 5;
        tempos = new long[tamanho];
    }
    
    /**
     * Inicializar um novo cronómetro
     * @param tamanho O número de tempos diferentes
     */
    Cronometro(int tamanho){
        this.tamanho = tamanho;
        tempos = new long[tamanho];
    }
    
    /**
     * Começa a cronometrar
     */
    public void startTimer(){
        timer = new GregorianCalendar();
    }
    
    /**
     * Obter o tempo desde o inicio do cronómetro
     * @return Tempo, em milisegundos, desde que se começou a cronometrar
     */
    public long stopTimer(){
        GregorianCalendar now = new GregorianCalendar();
        return now.getTimeInMillis()-timer.getTimeInMillis();
    }
    
    /**
     * Adiciona tempo ao array de tempos
     * @param accao Accao cronometrada
     */
    public void adicionarTempo(int accao){
        tempos[accao] += stopTimer();
    }
    
    /**
     * Reinicia o array de tempos
     */
    public void limpaTempo(){
        tempos = new long[this.tamanho];
    }
    
    /**
     * Obtem o tempo actual para determinada operação
     * @param posicao Especifica a operação
     */
    public long getTempo(int posicao){
        return this.tempos[posicao];
    }
}
