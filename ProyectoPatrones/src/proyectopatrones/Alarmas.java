/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 *
 * @author Alejandro
 */
public class Alarmas extends DefaultTableCellRenderer {
    private ArrayList AlertY;
    private ArrayList AlertO;
    private ArrayList AlertR;
    
    public Alarmas(ArrayList AlertY, ArrayList AlertO, ArrayList AlertR){
        this.AlertY = AlertY;
        this.AlertO = AlertO;
        this.AlertR = AlertR;
    }

    @Override
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            
        setEnabled(table == null || table.isEnabled()); 

        if (AlertY.contains(row))
            setBackground(Color.yellow);
        else{
            if(AlertO.contains(row))
                setBackground(Color.orange);
            else{
                if(AlertR.contains(row))
                    setBackground(Color.red);
                else
                    setBackground(null);
            }
        }
            
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);

        return this;
    }
}
