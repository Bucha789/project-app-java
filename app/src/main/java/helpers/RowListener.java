/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import ProyectoFinal.Views.EditTask;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author juanhernandez
 */
public class RowListener implements ListSelectionListener {
    private JTable table;
    
    public RowListener(JTable table) {
        this.table = table;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = table.getSelectedRow();
            // Aquí puedes manejar la lógica cuando se selecciona una fila específica
            // Ejemplo: Obtener los valores de las celdas seleccionadas
            Object value1 = table.getValueAt(selectedRow, 0);
            Object value2 = table.getValueAt(selectedRow, 1);
            Object value3 = table.getValueAt(selectedRow, 2);
            Object value4 = table.getValueAt(selectedRow, 3);
            
            // Ejemplo: Imprimir los valores en la consola
            EditTask.setTable(table);
            EditTask.main(new String[]{value1.toString(), value2.toString(), value3.toString(), value4.toString()});
            table.setEnabled(false);
            // Puedes realizar cualquier acción adicional según tus necesidades
        }
    }
}