package li3java;

import javax.swing.JTable;

public class CustomJTable extends JTable{

    @Override
    public boolean isCellEditable(int row, int column) {
	/*
	 * is faz com que nunca se possa alterar as células de uma CustomJTable
	 */
	return false;
    }
    
    
}
