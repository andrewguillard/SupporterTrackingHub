package com.amg.supporttracker.gui.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class STTableRenderer extends DefaultTableCellRenderer {

    ImageIcon icon;
    //TODO: NEEDS MAJOR WORK

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        setText("Loool");
        setToolTipText("This is a Tooltip");
        return c;
    }

    public Icon getIcon(JTable table, int column) {
        String sortSymbol = ((STTableColumnModel) table.getColumnModel()).getHeaders().get(column).getSortSymbol();
        if (sortSymbol == null || sortSymbol.equals("")){
            return null;
        } else if (sortSymbol.equals("+")){
            return (UIManager.getIcon("Table.ascendingSortIcon"));
        } else if (sortSymbol.equals("-")){
            return (UIManager.getIcon("Table.descendingSortIcon"));
        }
        return null;
    }
}
