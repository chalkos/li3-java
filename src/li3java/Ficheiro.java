package li3java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import localidade.Ligacao;
import localidade.Localidade;
import localidade.Localidades;
import utilizador.Utilizador;
import utilizador.Utilizadores;

/**
 * Faz importações de dados a partir de ficheiros
 */
public class Ficheiro {
    /**
     * Importa dados dos Utilizadores
     * @param maxItens Número de utilizadores a importar
     * @return Os utilizadores importados
     */
    public static Utilizadores getUtilizadores(Utilizadores utilizadores, String nomeFicheiro){
        String []partes;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nomeFicheiro);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            while( br.ready() ){
                 partes = br.readLine().split(":");
                 utilizadores.insere(new Utilizador(partes[0], partes[1], partes[2]));
            }
            is.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return utilizadores;
    }
    
    /**
     * Importa dados das Localidades
     * @param maxItens Número de localidades a importar
     * @return Os localidades importados
     */
    public static Localidades getLocalidades(Localidades locs, String nomeFicheiro){
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nomeFicheiro);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while( br.ready() )
                 locs.insere(new Localidade(br.readLine(), locs.getTipoLigacoes()));
            is.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return locs;
    }
    
    /**
     * Importa dados das Ligações
     * @param maxItens Número de utilizadores a importar
     * @return Os utilizadores importados
     */
    public static Localidades getLigacoes(Localidades locs, String nomeFicheiro){
        String []partes;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nomeFicheiro);
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
