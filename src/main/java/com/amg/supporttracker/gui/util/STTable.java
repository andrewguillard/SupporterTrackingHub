package com.amg.supporttracker.gui.util;

import com.amg.supporttracker.gui.util.dto.PatronDTO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

public class STTable extends JTable {

    private STTable table;
    private ArrayList<?> allData;
    private ArrayList<?> tableData;
    private STTableColumnModel columnModel;
    private STTableModel tableModel;
    private String filter;

    public STTable(){
        this(null, null);
    }

    public STTable(ArrayList<Object> data, ArrayList<STHeaderData> headers){
        super(new Object[1][], headers.stream().map(e -> e.getDisplay()).toArray());
        this.table = this;
        initTableComponents(data, headers);
        columnModel.setSort(0);
        if(data != null && data.get(0) instanceof PatronDTO){
            //Set the filter
            this.filter = "active";
        }
        setTableData(data);

        //table.setDefaultRenderer(String.class, new STTableRenderer());
        initListeners();
    }
    
    private void initTableComponents(ArrayList<Object> data, ArrayList<STHeaderData> headers){
        //Create column model
        columnModel = new STTableColumnModel(headers);
        table.setColumnModel(columnModel);
        
        //Create the table model (handles data)
        tableModel = new STTableModel(data, headers);
        table.setModel(tableModel);
        
        table.setRowHeight(25);
        
        //TODO: Put these in the screen's look and feel settings.
        table.setGridColor(new Color(0,0,0));
        //table.setShowGrid(false);
        Border b = BorderFactory.createMatteBorder(0,0,2,0, new Color(0,0,0));
        table.setBorder(b);
        
        table.getTableHeader().setBorder(b);
    }

    private void initListeners(){
        this.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = table.columnAtPoint(e.getPoint());
                System.out.println("Column clicked: "+col);

                if(e.getClickCount() == 2){
                    ((STTableColumnModel) table.getColumnModel()).setSort(col);
                } else{
                    ((STTableColumnModel) table.getColumnModel()).toggleSort(col);
                }
                tableData = sortAll(tableData, ((STTableColumnModel) table.getColumnModel()).getSorts());
                refreshTable();
                super.mouseClicked(e);
            }
        });
    }
    
    //Refresh the table by removing the existing one and rebuilding
    public void refreshTable(){
        //Refresh the headers to be sure we have the right ones.
        ArrayList<STHeaderData> headers = ((STTableColumnModel)table.getColumnModel()).getHeaders();
//        for(STHeaderData header : headers){
//            System.out.println("SORTING Header: "+ header.getDisplay());
//        }
        if(headers == null){
            return;
        }

        //Remove Table elements by creating a new table model
        STTableModel newModel = new STTableModel(tableData, headers);

        //Build headers (should be in order as long as headers list is updated on move)
        for(STHeaderData header : headers){
            newModel.addColumn(header.getDisplay());
        }

        this.setModel(newModel);
    }
    
    //Adds a new row to the table. (This could be more efficient by just adding the row directly into tableData if it fits)
    public void addTableRow(Object newRow){
        ((ArrayList<Object>) allData).add(newRow);
        setTableData(allData);
    }
    
    public void addTableRows(ArrayList<?> newRows){
        ((ArrayList<Object>) allData).addAll(newRows);
        setTableData(allData);
    }
    
    //Sets all data and then builds table data from that.
    public void setTableData(ArrayList<?> data){
        this.allData = data;
        this.tableData = sortAll(filterData(allData, filter), columnModel.getSorts());
        refreshTable();
    }

    public ArrayList<?> getTableData() {
        return tableData;
    }

    public ArrayList<?> getAllData() {
        return allData;
    }

    public void setHeaders(ArrayList<STHeaderData> headers) {
        STTableColumnModel newColumnModel = new STTableColumnModel(headers);
        this.setColumnModel(newColumnModel);
    }

    public ArrayList<STHeaderData> getHeaders() {
        return ((STTableColumnModel)this.getColumnModel()).getHeaders();
    }
    
    //Use quicksort to sort a DTO by multiple parameters
    public ArrayList<?> sortAll(ArrayList<?> data, ArrayList<String> sortParams){
        if(data == null || data.size() <= 1 || sortParams == null || sortParams.isEmpty()){
            return data;
        }
        int pivotPointer = data.size() / 2;
        ArrayList<Object> sortedArray = new ArrayList<>();
        ArrayList<Object> greaterThan = new ArrayList<>();
        ArrayList<Object> lessThan = new ArrayList<>();
        Object pivot = data.get(pivotPointer);
        for(int i = 0; i < data.size(); i++){
            if(i != pivotPointer){ //Skip pivot
                if(compareDTOs(data.get(i), pivot, sortParams) >= 1){
                    greaterThan.add(data.get(i));
                } else{
                    lessThan.add(data.get(i));
                }
            }
        }
        sortedArray.addAll(sortAll(lessThan, sortParams));
        sortedArray.add(pivot);
        sortedArray.addAll(sortAll(greaterThan, sortParams));
        return sortedArray;
    }
    
    //Compare two DTOs. These DTOs must have variables with getters that match sortingParams.
    //NOTE: sortingParams are listed as {"+patronName", "-tierNum", "-pledgeAmount"} where the first char denotes ASC or DESC
    private int compareDTOs(Object data1, Object data2, ArrayList<String> sortParams){
        for(String sortParam : sortParams){
            //Sort param is sent in like this: "+patronName" for ASC and "-patronId" for DESC
            char asc = sortParam.charAt(0);
            String param = sortParam.substring(1);
            Object data1Val = STUtil.invokeGetter(data1, param, "");
            Object data2Val = STUtil.invokeGetter(data2, param, "");
            int comp = 0;
            if(data1Val instanceof String){
                comp = ((String) data1Val).compareToIgnoreCase((String) data2Val);
            } else if(data1Val instanceof Integer) {
                comp = Integer.compare((Integer) data1Val, (Integer) data2Val);
            } else if(data1Val instanceof Double) {
                comp = Double.compare((Double) data1Val, (Double) data2Val);
            } else if(data1Val instanceof Date) {
                comp = ((Date) data1Val).after((Date) data2Val) ? 1 : (((Date) data1Val).before((Date) data2Val) ? -1 : 0 );
            } 
            
            //If comp is not 0, we can skip the other sort params because this one made the sort!
            if(comp != 0){
                return Character.compare(asc, '+') == 0 ? comp : -1*comp;
            }
        }
        //If we've gotten this far, they are the same record thus far as sorting can tell. 
        return 0;
    }

    //Set the filter and call setTableData on all of the data which will re-filter the data.
    public void doFilter(String filter){
        String oldFilter = this.filter;
        this.filter = filter;
        if(this.filter != null && !this.filter.equals(oldFilter)) {
            setTableData(allData); // This will call filterData and sort on the data.
        }
    }

    private ArrayList<?> filterData(ArrayList<?> data, String filter){
        this.filter = filter != null ? filter.toLowerCase() : null;

        //If the filter is all, just return all of the data
        if(this.filter == null || this.filter.equals("all")){
            return allData;
        }

        ArrayList<Object> filteredData = new ArrayList<>();
        String status;

        if(data != null) {
            for (Object dataObj : data) {
                status = (String) STUtil.invokeGetter(dataObj, "status", "String");
                if (status != null && status.equals(this.filter)) {
                    filteredData.add(dataObj);
                }
            }
        }
        return filteredData;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }
}
