package li3java;

/**
 * Classe principal da aplicação, contém a main.
 */
public class Li3Java {
    
    
    /**
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args) {
        Estatisticas estatistica = new Estatisticas(1, true); //testes
        //Estatisticas estatistica = new Estatisticas(10, false); //avaliação de desempenho
        estatistica.comecar();
    }
    
    
}