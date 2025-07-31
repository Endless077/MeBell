package Utility;

import javax.swing.table.DefaultTableModel;

public class ModelloTabella extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column){
	return false;
    }


}
