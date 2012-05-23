package li3java;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
    private int formato;
    /*
     * formatos:
     * 0 - texto centrado
     */
    
    public StatusColumnCellRenderer(int formato){
	super();
	this.formato = formato;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

	//Células são, por defeito, JLabels
	JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
	
	TableModel tableModel = table.getModel();
	
	if( formato == 0 )
	    l.setHorizontalAlignment(CENTER);
	
	return l;
    }
}