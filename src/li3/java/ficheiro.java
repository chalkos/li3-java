package li3.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ficheiro {
    private static final String nome_ficheiro_utilizadores = "/sample_utilizadores.txt";
    private static final String nome_ficheiro_localidades = "/sample_localidades.txt";
    private static final String nome_ficheiro_ligacoes = "/sample_ligacoes.txt";
    
    public static ArrayList<Utilizador> getUtilizadoresArrayList(int maxItens){
        ArrayList<Utilizador> lista = new ArrayList<Utilizador>(maxItens);
        String []partes;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_utilizadores);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<maxItens; i++){
                 partes = br.readLine().split(":");
                 lista.add(new Utilizador( Integer.parseInt( partes[0] ), partes[1], partes[2]));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return lista;
    }
}
