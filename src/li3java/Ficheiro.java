package li3java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Faz importações de dados a partir de ficheiros
 */
public class Ficheiro {
    private static final String nome_ficheiro_utilizadores = "/sample_utilizadores.txt";
    private static final String nome_ficheiro_localidades = "/sample_localidades.txt";
    private static final String nome_ficheiro_ligacoes = "/sample_ligacoes.txt";
    
    /**
     * Importa dados dos Utilizadores para um ArrayList
     * @param maxItens Número de utilizadores a importar
     * @return Os utilizadores importados
     */
    public static ArrayList<Utilizador> getUtilizadoresArrayList(int maxItens){
        ArrayList<Utilizador> lista = new ArrayList<Utilizador>(maxItens);
        String []partes;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_utilizadores);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<maxItens; i++){
                 partes = br.readLine().split(":");
                 lista.add(new Utilizador( partes[0], partes[1], partes[2]));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return lista;
    }
    
    /**
     * Importa dados dos Utilizadores para um HashMap
     * @param maxItens Número de utilizadores a importar
     * @return Os utilizadores importados
     */
    public static HashMap<String, Utilizador> getUtilizadoresHashMap(int maxItens){
        HashMap<String, Utilizador> hash = new HashMap<String, Utilizador>(maxItens*2);
        String []partes;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_utilizadores);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            Utilizador novo;
            for(int i=0;i<maxItens; i++){
                 partes = br.readLine().split(":");
                 hash.put( partes[0], new Utilizador( partes[0], partes[1], partes[2]) );
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return hash;
    }
    
    /**
     * Importa dados dos Utilizadores para um TreeMap
     * @param maxItens Número de utilizadores a importar
     * @return Os utilizadores importados
     */
    public static TreeMap<String, Utilizador> getUtilizadoresTreeMap(int maxItens){
        TreeMap<String, Utilizador> hash = new TreeMap<String, Utilizador>();
        String []partes;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_utilizadores);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<maxItens; i++){
                 partes = br.readLine().split(":");
                 
                 hash.put( partes[0], new Utilizador( partes[0], partes[1], partes[2]) );
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return hash;
    }
    
    public static ArrayList<LocalidadeArrayList> getLocalidadesArrayList(int maxItens){
        ArrayList<LocalidadeArrayList> loc = new ArrayList<LocalidadeArrayList>(maxItens);
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_localidades);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<maxItens; i++)
                 loc.add(new LocalidadeArrayList(br.readLine()));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return loc;
    }
    
    public static void getLigacoesArrayList(ArrayList<LocalidadeArrayList> loc){
        String []partes;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_ligacoes);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<loc.size(); i++){
                for(int j=0;j<8;j++){
                    partes = br.readLine().split(":");
                    loc.get(i).novaAdjacencia(partes[1]);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public static ArrayList<LocalidadeHashSet> getLocalidadesHashSet(int maxItens){
        ArrayList<LocalidadeHashSet> loc = new ArrayList<LocalidadeHashSet>(maxItens);
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_localidades);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<maxItens; i++)
                loc.add(new LocalidadeHashSet(br.readLine()));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return loc;
    }
    
    public static void getLigacoesHashSet(ArrayList<LocalidadeHashSet> loc){
        String []partes;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_ligacoes);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<loc.size(); i++){
                for(int j=0;j<8;j++){
                    partes = br.readLine().split(":");
                    loc.get(i).novaAdjacencia(partes[1]);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public static HashMap<String, HashMap<String, String>> getLocalidadesHashMap(int maxItens){
        HashMap<String, HashMap<String, String>> loc = new HashMap<String, HashMap<String, String>>(maxItens);
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_localidades);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<maxItens; i++)
                loc.put(br.readLine(), new HashMap<String, String>(8));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return loc;
    }
    
    public static void getLigacoesHashMap(HashMap<String, HashMap<String, String>> loc){
        String []partes;
        String key;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_ligacoes);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            for (Iterator<String> it = loc.keySet().iterator(); it.hasNext();) {
                key = it.next();
                for(int i=0;i<8;i++){
                    partes = br.readLine().split(":");
                    loc.get(key).put(partes[1], null);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public static TreeMap<String, TreeMap<String, String>> getLocalidadesTreeMap(int maxItens){
        TreeMap<String, TreeMap<String, String>> loc = new TreeMap<String, TreeMap<String, String>>();
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_localidades);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(int i=0;i<maxItens; i++)
                loc.put(br.readLine(), new TreeMap<String, String>());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return loc;
    }
    
    public static void getLigacoesTreeMap(TreeMap<String, TreeMap<String, String>> loc){
        String []partes;
        String key;
        try {
            InputStream is = Li3Java.class.getResourceAsStream(nome_ficheiro_ligacoes);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            for (Iterator<String> it = loc.keySet().iterator(); it.hasNext();) {
                key = it.next();
                for(int i=0;i<8;i++){
                    partes = br.readLine().split(":");
                    loc.get(key).put(partes[1], null);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
