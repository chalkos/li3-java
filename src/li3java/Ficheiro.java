package li3java;

import java.io.*;
import localidade.Ligacao;
import localidade.Localidade;
import localidade.Localidades;
import localidade.LocalidadesHashMap;
import utilizador.Utilizador;
import utilizador.Utilizadores;
import utilizador.UtilizadoresHashMap;

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
    
    public static boolean escreverSDO(File file, Localidades localidades, Utilizadores utilizadores){
	boolean res = true;
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
	    res = false;
	}
	return res;
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
    
    public static boolean escreverEF(File file, Localidades localidades, Utilizadores utilizadores){
	boolean res = true;
	PrintWriter pw;
	String ext = "";
	
	if( file.getName().lastIndexOf(".") != -1)
	    ext = file.getName().substring(file.getName().lastIndexOf("."));
	
	if( !ext.equals(".EF") && !ext.equals(".ef") ){
	    file = new File(file.getAbsolutePath() + ".ef");
	}
	
	try {
	    pw = new PrintWriter(file);
	    pw.append("\bLocalidades\n");
	    pw.append(localidades.escritaLocalidades());
	    pw.append("\bLigações\n");
	    pw.append(localidades.escritaLigacoes());
	    pw.append("\bUtilizadores\n");
	    pw.append(utilizadores.escritaUtilizadores());


	    pw.close();
	} catch (FileNotFoundException ex) {
	    res = false;
	}
	return res;
    }
    
    public static Dados lerEF(File file, Localidades localidades, Utilizadores utilizadores){
	/*
	 * indica se se está a ler localidades, ligações ou utilizadores
	 */
	int fase = 0;
	String []partes;
	String linha;
	
	Dados d = new Dados(localidades, utilizadores);
	
	Localidades locs = new LocalidadesHashMap();
	Utilizadores users = new UtilizadoresHashMap();
	
	/*
	 * quantidades:
	 * [0] - localidades inseridas
	 * [1] - localidades totais
	 * [2] - ligações inseridas
	 * [3] - ligações totais
	 * [4] - utilizadores inseridos
	 * [5] - utilizadores totais
	 */
	int[] qtd = new int[6]; //inicializa tudo a zero
	
	try {
            FileReader fr = new FileReader(file);
            BufferedReader br =  new BufferedReader(fr);
            while( br.ready() ){
		linha = br.readLine();
		if( linha.charAt(0) == '\b' ){
		    if( linha.equals("\bLocalidades") )
			fase = 1;
		    else if( linha.equals("\bLigações") )
			fase = 2;
		    else if( linha.equals("\bUtilizadores") )
			fase = 3;
		}else{
		    switch(fase){
			case 1:
			    if( locs.insere(new Localidade(linha)))
				qtd[0]++;
			    qtd[1]++;
			    break;
			case 2:
			    partes = linha.split(":");
			    if( locs.insereLigacao(partes[0], new Ligacao(partes[1], Double.parseDouble(partes[2]), Double.parseDouble(partes[3]))) )
				qtd[2]++;
			    qtd[3]++;
			    break;
			case 3:
			    partes = linha.split(":");
			    if( users.insere(new Utilizador(partes[0], partes[1], partes[2])) )
				qtd[4]++;
			    qtd[5]++;
			    break;
		    }
		}
            }
            fr.close();
        } catch (java.io.FileNotFoundException ex) {
            d.quantidades = new int[1]; //para reportar o erro
	    return d;
        } catch (Exception ex){
	    d.quantidades = new int[2]; //para reportar o erro
	    return d;
	}
	
	d = new Dados(locs, users);
	d.quantidades = qtd;
	return d;
    }
}
