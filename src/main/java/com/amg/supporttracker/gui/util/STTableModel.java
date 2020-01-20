package com.amg.supporttracker.gui.util;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class STTableModel extends AbstractTableModel {

    private ArrayList<?> tableData;
    private ArrayList<STTableHeader> tableHeaders;

    public STTableModel(ArrayList<?> data, ArrayList<STTableHeader> headers) {
        this.tableData = data;
        this.tableHeaders = headers;
    }

    @Override
    public String getColumnName(int column) {
        return tableHeaders.get(column).getDisplay();
    }

    public STTableHeader getColumnHeader(int column) {
        return tableHeaders.get(column);
    }

    @Override
    public int getColumnCount() {
        return tableHeaders.size();
    }

    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object row = tableData.get(rowIndex);
        return STUtil.invokeGetter(row, tableHeaders.get(columnIndex).getProperty(), "");
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return tableHeaders.get(columnIndex).isEditable();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Object row = tableData.get(rowIndex);
        STUtil.invokeSetter(row, tableHeaders.get(columnIndex).getProperty(), "", aValue);

    }

}