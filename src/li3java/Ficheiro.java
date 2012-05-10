package li3java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Faz importações de dados a partir de ficheiros
 */
public class Ficheiro {
    private static final String nome_ficheiro_utilizadores = "/sample_utilizadores.txt";
    private static final String nome_ficheiro_localidades = "/sample_localidades.txt";
    private static final String nome_ficheiro_ligacoes = "/sample_ligacoes.txt";
    
    /**
     * Importa dados dos Utilizadores
     * @param maxItens Número de utilizadores a importar
     * @return Os utilizadores importados
     */
    public static Utilizadores getUtilizadores(Utilizadores utilizadores){
        String []partes;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_utilizadores);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<utilizadores.getNumDados(); i++){
                 partes = br.readLine().split(":");
                 utilizadores.insere(new Utilizador(partes[0], partes[1], partes[2]));
            }
            is.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return utilizadores;
    }
    
    public static Localidades getLocalidades(Localidades locs){
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_localidades);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<locs.getNumDados(); i++)
                 locs.insere(new Localidade(br.readLine(), locs.getTipoLigacoes()));
            is.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return locs;
    }
    public static Localidades getLigacoes(Localidades locs){
        String []partes;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_ligacoes);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //origem, destino, km, custo
            while( br.ready() ){
                partes = br.readLine().split(":");
                
                locs.insereLigacao(partes[0], new Ligacao(partes[1], Double.parseDouble(partes[2]), Double.parseDouble(partes[3])));
            }
            is.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return locs;
    }
}
