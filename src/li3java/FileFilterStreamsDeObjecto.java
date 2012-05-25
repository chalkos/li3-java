package li3java;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class FileFilterStreamsDeObjecto extends FileFilter {
    public static final String descricao = "Streams de Objecto (*.sdo,*.SDO)";
    
    @Override
    public boolean accept(File f) {
	if (f.isDirectory()) {
	    return true;
	}

	String s = f.getName();

	return s.endsWith(".sdo") || s.endsWith(".SDO");
    }

    @Override
    public String getDescription() {
	return FileFilterStreamsDeObjecto.descricao;
    }
}