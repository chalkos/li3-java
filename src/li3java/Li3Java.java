package li3java;

/**
 * Classe principal da aplicação, contém a main.
 */
public class Li3Java {
    
    
    /**
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args) {
        //Estatisticas estatistica = new Estatisticas(400, true); //testes
        Estatisticas estatistica = new Estatisticas(300, false); //avaliação de desempenho
        
        //estatistica.forceImprime();
        estatistica.comecar();
    }
    
    
}