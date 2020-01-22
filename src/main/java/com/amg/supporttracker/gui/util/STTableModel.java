package com.amg.supporttracker.gui.util;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class STTableModel extends DefaultTableModel {

    private ArrayList<?> tableData;
    private ArrayList<STHeaderData> tableHeaders;

    public STTableModel(ArrayList<?> data, ArrayList<STHeaderData> headers) {
        super();
        if(data == null){
            data = new ArrayList<>();
        }
        this.tableData = data;
        this.tableHeaders = headers;
        setTableData(tableData, tableHeaders);
    }

    @Override
    public String getColumnName(int column) {
        return tableHeaders.get(column).getDisplay();
    }

    public STHeaderData getColumnHeader(int column) {
        return tableHeaders.get(column);
    }

    @Override
    public int getColumnCount() {
        return tableHeaders.size();
    }

    @Override
    public int getRowCount() {
        return tableData != null ? tableData.size() : 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object row = tableData.get(rowIndex);
        return STUtil.invokeGetter(row, tableHeaders.get(columnIndex).getProperty(), "String");
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return tableHeaders.get(columnIndex).isEditable();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Object row = tableData.get(rowIndex);
        String initialValue = (String) STUtil.invokeGetter(row, tableHeaders.get(columnIndex).getProperty(), "String");
        if(!initialValue.equals((String) aValue)) {
            STUtil.invokeSetter(row, tableHeaders.get(columnIndex).getProperty(), "", aValue);
            XMLParser.saveList(tableData);
        }
    }
    
    //Set the table data.
    public void setTableData(ArrayList<?> dataList, ArrayList<STHeaderData> headerList){
        Object[][] data = new Object[dataList.size()][headerList.size()];
        Object cellData;
        for(int i =0; i < dataList.size(); i++){
            for(int j = 0; j < headerList.size(); j++){
                cellData = STUtil.invokeGetter(dataList.get(i), headerList.get(j).getProperty(), "String");
                data[i][j] = cellData;
            }
        }
        super.setDataVector(data, headerList.stream().map(e -> e.getDisplay()).toArray());
    }
    
    public ArrayList<?> getTableData(){
        return tableData;
    }

}