package li3java;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FileFilterEscritaFormatada extends FileFilter {
    public static final String descricao = "Escrita Formatada (*.ef, *.EF)";
    
    @Override
    public boolean accept(File f) {
	if (f.isDirectory()) {
	    return true;
	}

	String s = f.getName();

	return s.endsWith(".ef") || s.endsWith(".EF");
    }

    @Override
    public String getDescription() {
	return FileFilterEscritaFormatada.descricao;
    }
}
