package li3java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import localidade.Ligacao;
import localidade.Localidade;
import localidade.Localidades;
import utilizador.Utilizador;
import utilizador.Utilizadores;

/**
 * Faz importações de dados a partir de ficheiros
 */
public class Ficheiro {
    public static int getUtilizadores(Utilizadores utilizadores, File ficheiro){
        String []partes;
        int c = 0;
        
        try {
            FileReader fr = new FileReader(ficheiro);
            BufferedReader br =  new BufferedReader(fr);
            while( br.ready() ){
                 partes = br.readLine().split(":");
                 if( utilizadores.insere(new Utilizador(partes[0], partes[1], partes[2])) )
                    c++;
            }
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return c;
    }
    
    public static int getLocalidades(Localidades localidades, File ficheiro){
        int c = 0;
        try {
            FileReader fr = new FileReader(ficheiro);
            BufferedReader br =  new BufferedReader(fr);
            while( br.ready() ){
                 if( localidades.insere(new Localidade(br.readLine())))
                    c++;
            }
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return c;
    }
    
    public static int getLigacoes(Localidades localidades, File ficheiro){
        String []partes;
        int c = 0;
        
        try {
            FileReader fr = new FileReader(ficheiro);
            BufferedReader br =  new BufferedReader(fr);
            while( br.ready() ){
                partes = br.readLine().split(":");
                if( localidades.insereLigacao(partes[0], new Ligacao(partes[1], Double.parseDouble(partes[2]), Double.parseDouble(partes[3]))) )
                    c++;
            }
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return c;
    }
}
