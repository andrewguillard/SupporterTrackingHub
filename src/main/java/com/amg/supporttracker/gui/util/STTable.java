package com.amg.supporttracker.gui.util;

import com.amg.supporttracker.gui.util.dto.PatronDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

public class STTable extends JTable {

    private STTable table;
    private ArrayList<?> allData;
    private ArrayList<?> tableData;
    private ArrayList<String> activeSort;
    private STTableColumnModel columnModel;
    private String filter;

    public STTable(){
        this(null, null);
    }

    public STTable(ArrayList<Object> data, ArrayList<STHeaderData> headers){
        super(new Object[1][], headers.stream().map(e -> e.getDisplay()).toArray());
        STTableModel tableModel = new STTableModel(data, headers);
        this.setModel(tableModel);
        
        columnModel = new STTableColumnModel(headers);
        this.setColumnModel(columnModel);
        this.filter = "all";
        setTableData(data);
        this.table = this;
        
        //Set default sort
        this.activeSort = new ArrayList<>();
        activeSort.add("+patronName");

        //table.setDefaultRenderer(String.class, new STTableRenderer());

        initListeners();
        
        //testSorter();
        //replace data
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
    
    //Sorts the table according to inputs. 1st is primary sort. 2nd is secondary sort. So on and so fourth.
    public void sortTable(String... sort){
        //this.
        for(String header : sort){
            //Sort based on header
        }
    }
    
    //Refresh the table by removing the existing one and rebuilding
    public void refreshTable(){
        //Refresh the headers to be sure we have the right ones.
        ArrayList<STHeaderData> headers = columnModel.getHeaders();
        if(headers == null){
            return;
        }

        //Remove Table elements by creating a new table model
        STTableModel newModel = new STTableModel(tableData, headers);

        //Build headers (should be in order as long as headers list is updated on move)
        for(STHeaderData header : headers){
            newModel.addColumn(header.getDisplay());
        }
        
//        //Rebuild the table.
//        Object[] rowData;
//        if(tableData != null && tableData.size() > 0) {
//            for (Object row : tableData) {
//                rowData = new Object[headers.size()];
//                for (int i = 0; i < headers.size(); i++) {
//                    try {
//                        System.out.println("[" + i + "] Attempting to get data from get" + headers.get(i).getProperty() + "String()");
//                        rowData[i] = STUtil.invokeGetter(row, headers.get(i).getProperty(), "String");
//                    }
//                    catch (Exception e) {
//                        System.out.println("ERROR: Exception while building rowData.");
//                        e.printStackTrace();
//                    }
//                }
//                newModel.addRow(rowData);
//            }
//        }
        this.setModel(newModel);
    }
    
    //Adds a new row to the table. If isSort, add it into the correct spot in the table.
    public void addTableRow(Object newRow, boolean isSort){
        ((ArrayList<Object>) allData).add(newRow);

        String status = (String) STUtil.invokeGetter(newRow, "status", "String");
        if(status != null && status.equals(filter)){
            ((ArrayList<Object>) tableData).add(newRow);
        }

        refreshTable();
    }
    
    public void setTableData(ArrayList<?> data){
        this.allData = data;
        this.tableData = sortAll(filterData(allData, filter), activeSort);
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

//    //Test the sorting algorithm
//    public void testSorter(){
//        PatronDTO t1 = new PatronDTO(1, "Andrew", 4, 50.0, new Date());
//        PatronDTO t2 = new PatronDTO(2, "Joe", 2, 30.0, new Date());
//        PatronDTO t3 = new PatronDTO(3, "Bob", 2, 40.20, new Date());
//        PatronDTO t4 = new PatronDTO(4, "Alex", 3, 540.0, new Date());
//        PatronDTO t5 = new PatronDTO(5, "Momo", 1, 1.0, new Date());
//        PatronDTO t6 = new PatronDTO(6, "Gers", 1, 17.0, new Date());
//        PatronDTO t7 = new PatronDTO(7, "Simon", 1, 52.0, new Date());
//        PatronDTO t8 = new PatronDTO(8, "Garfunkle", 4, 320.0, new Date());
//        PatronDTO t9 = new PatronDTO(9, "googo", 1, 7.0, new Date());
//        PatronDTO t10 = new PatronDTO(10, "Picaso", 3, 80.0, new Date());
//        PatronDTO t11 = new PatronDTO(11, "Andrew", 1, 80.0, new Date());
//        PatronDTO t12 = new PatronDTO(12, "Picaso", 4, 80.0, new Date());
//        PatronDTO t13 = new PatronDTO(13, "Andrew", 2, 80.0, new Date());
//        ArrayList<Object> testPatrons = new ArrayList<>();
//        testPatrons.add(t1);
//        testPatrons.add(t2);
//        testPatrons.add(t3);
//        testPatrons.add(t4);
//        testPatrons.add(t5);
//        testPatrons.add(t6);
//        testPatrons.add(t7);
//        testPatrons.add(t8);
//        testPatrons.add(t9);
//        testPatrons.add(t10);
//        testPatrons.add(t11);
//        testPatrons.add(t12);
//        testPatrons.add(t13);
//        ArrayList<String> testSort = new ArrayList<>();
//        //testSort.add("-patronName");
//        testSort.add("+tierNum");
//        System.out.println("Testing Sort");
//        testPatrons = sortAll(testPatrons, testSort);
//        setTableData(testPatrons);
//
//        for(Object pat : testPatrons){
//            System.out.println("Name: "+((PatronDTO)pat).getPatronNameString()+" Tier: "+((PatronDTO)pat).getTierNumString());
//        }
//    }
    
    //Use quicksort to sort a DTO by multiple parameters
    public ArrayList<?> sortAll(ArrayList<?> data, ArrayList<String> sortParams){
        if(data == null || data.size() <= 1){
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

    public void doFilter(String filter){
        doFilter(allData, filter);
    }

    public void doFilter(ArrayList<?> data, String filter){
        this.filter = filter.toLowerCase();
        tableData = filterData(data, this.filter);
        refreshTable();
    }

    private ArrayList<?> filterData(ArrayList<?> data, String filter){
        this.filter = filter.toLowerCase();

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
