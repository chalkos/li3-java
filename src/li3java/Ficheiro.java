package li3java;

import java.io.*;
import java.nio.file.Files;
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
	
	String ext = "";
	if( file.getName().lastIndexOf(".") != -1)
	    ext = file.getName().substring(file.getName().lastIndexOf("."));
	
	if( !ext.equals(".SDO") && !ext.equals(".sdo") ){
	    file = new File(file.getAbsolutePath() + ".sdo");
	}
	
	try {
	    fos = new FileOutputStream(file);
	    out = new ObjectOutputStream(fos);
	    out.writeObject(localidades);
	    out.writeObject(utilizadores);
	    out.close();
	} catch (IOException ex) {
	    
	}
    }
    
    public static Dados lerSDO(File file, Localidades localidades, Utilizadores utilizadores){
	FileInputStream fis;
	ObjectInputStream in;

	Dados d = new Dados(localidades, utilizadores);

	try {
	    fis = new FileInputStream(file);
	    in = new ObjectInputStream(fis);
	    
	    d.setLocalidades((Localidades) in.readObject());
	    d.setUtilizadores((Utilizadores) in.readObject());
	    in.close();
	} catch (IOException ex) {
	    ex.printStackTrace();
	} catch (ClassNotFoundException ex) {
	    ex.printStackTrace();
	}
	return d;
    }
    
    public static void escreverEF(File file, Localidades localidades, Utilizadores utilizadores){
	PrintWriter pw;
	
	String ext = "";
	if( file.getName().lastIndexOf(".") != -1)
	    ext = file.getName().substring(file.getName().lastIndexOf("."));
	
	if( !ext.equals(".EF") && !ext.equals(".ef") ){
	    file = new File(file.getAbsolutePath() + ".ef");
	}
	
	try {
	    pw = new PrintWriter(file);
	    pw.append("valores, bues deles\n");
	    pw.append('\b');
	    pw.append("Localidades\n");
	    //pw.append(localidades.escritaLocalidades());


	    pw.close();
	} catch (FileNotFoundException ex) {
	    //ficheiro nao encontrado
	}
    }
    
    public static void lerEF(File file, Localidades localidades, Utilizadores utilizadores){
	
    }
}
