package li3java;

import java.io.*;
import localidade.Ligacao;
import localidade.Localidade;
import localidade.Localidades;
import utilizador.Utilizador;
import utilizador.Utilizadores;

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
    
    public static void escreverSDO(File file, Localidades localidades, Utilizadores utilizadores){
	ObjectOutputStream out;
	FileOutputStream fos;
	try {
	    fos = new FileOutputStream(file);
	    out = new ObjectOutputStream(fos);
	    out.writeObject(localidades);
	    out.writeObject(utilizadores);
	    out.close();
	} catch (IOException ex) {
	    
	}
    }
    
    public static void lerSDO(File file, Localidades localidades, Utilizadores utilizadores){
	ObjectOutputStream out;
	FileOutputStream fos;
	try {
	    fos = new FileOutputStream(file);
	    out = new ObjectOutputStream(fos);
	    out.writeObject(localidades);
	    out.writeObject(utilizadores);
	    out.close();
	} catch (IOException ex) {
	    
	}
    }
    
    public static void escreverEF(File file, Localidades localidades, Utilizadores utilizadores){
	PrintWriter pw;
	try {
	    pw = new PrintWriter(file);

	    pw.append("Localidades\n");
	    pw.append(localidades.escritaLocalidades());


	    pw.close();
	} catch (FileNotFoundException ex) {
	    //ficheiro nao encontrado
	}
    }
}
