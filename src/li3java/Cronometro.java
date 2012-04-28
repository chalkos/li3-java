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
        tempos = new long[5];
    }
    
    /**
     * Obtem o tempo actual para determinada operação
     * @param posicao 
     */
    public long getTempo(int posicao){
        return this.tempos[posicao];
    }
    
    public void calculaMedias(int repeticoes){
        for( int i=0; i<tempos.length; i++ ){
            tempos[i] /= repeticoes;
        }
    }
}
