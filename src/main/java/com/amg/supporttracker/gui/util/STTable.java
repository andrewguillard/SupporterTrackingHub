package com.amg.supporttracker.gui.util;

import com.amg.supporttracker.gui.util.dto.DonationDTO;
import com.amg.supporttracker.gui.util.dto.PatronDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;

public class STTable extends JTable {

    private ArrayList<STTableHeader> headers;
    private ArrayList<?> tableData;
    private ArrayList<String> activeSort;

    public STTable(){
        super();
        //testSorter();
    }

    public STTable(ArrayList<Object> data, ArrayList<STTableHeader> headers){
        super(new Object[1][], headers.stream().map(e -> e.getDisplay()).toArray());
        this.tableData = data;
        this.headers = headers;
        
        //Set default sort
        this.activeSort = new ArrayList<>();
        activeSort.add("+patronName");
        
        //testSorter();
        //replace data
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
        //Remove Table elements by creating a new table model
        DefaultTableModel newModel = new DefaultTableModel();
        
        //Build headers (should be in order as long as headers list is updated on move)
        for(STTableHeader header : headers){
            newModel.addColumn(header.getDisplay());
        }
        
        //TODO: Whenever headers move, headerNames needs to update.
        //Rebuild the table.
        Object[] rowData;
        if(tableData != null && tableData.size() > 0) {
            for (Object row : tableData) {
                rowData = new Object[headers.size()];
                for (int i = 0; i < headers.size(); i++) {
                    try {
                        System.out.println("[" + i + "] Attempting to get data from get" + headers.get(i).getProperty() + "String()");
                        rowData[i] = STUtil.invokeGetter(row, headers.get(i).getProperty(), "String");
                    }
                    catch (Exception e) {
                        System.out.println("ERROR: Exception while building rowData.");
                        e.printStackTrace();
                    }
                }
                newModel.addRow(rowData);
            }
        }
        this.setModel(newModel);
    }
    
    //Adds a new row to the table. If isSort, add it into the correct spot in the table.
    public void addTableRow(Object newRow, boolean isSort){
        if(!isSort){
            ((ArrayList<Object>) tableData).add(newRow);
            refreshTable();
        } else{
            //TODO: Sort into tableData
            refreshTable();
        }
    }
    
    public void setTableData(ArrayList<?> data){
        this.tableData = sortAll((ArrayList<Object>)data, activeSort);
        refreshTable();
    }

    public ArrayList<?> getTableData() {
        return tableData;
    }

    public void setHeaders(ArrayList<STTableHeader> headers) {
        this.headers = headers;
    }

    public ArrayList<STTableHeader> getHeaders() {
        return headers;
    }

    //Test the sorting algorithm
    public void testSorter(){
        PatronDTO t1 = new PatronDTO(1, "Andrew", 4, 50.0, new Date());
        PatronDTO t2 = new PatronDTO(2, "Joe", 2, 30.0, new Date());
        PatronDTO t3 = new PatronDTO(3, "Bob", 2, 40.20, new Date());
        PatronDTO t4 = new PatronDTO(4, "Alex", 3, 540.0, new Date());
        PatronDTO t5 = new PatronDTO(5, "Momo", 1, 1.0, new Date());
        PatronDTO t6 = new PatronDTO(6, "Gers", 1, 17.0, new Date());
        PatronDTO t7 = new PatronDTO(7, "Simon", 1, 52.0, new Date());
        PatronDTO t8 = new PatronDTO(8, "Garfunkle", 4, 320.0, new Date());
        PatronDTO t9 = new PatronDTO(9, "googo", 1, 7.0, new Date());
        PatronDTO t10 = new PatronDTO(10, "Picaso", 3, 80.0, new Date());
        PatronDTO t11 = new PatronDTO(11, "Andrew", 1, 80.0, new Date());
        PatronDTO t12 = new PatronDTO(12, "Picaso", 4, 80.0, new Date());
        PatronDTO t13 = new PatronDTO(13, "Andrew", 2, 80.0, new Date());
        ArrayList<Object> testPatrons = new ArrayList<>();
        testPatrons.add(t1);
        testPatrons.add(t2);
        testPatrons.add(t3);
        testPatrons.add(t4);
        testPatrons.add(t5);
        testPatrons.add(t6);
        testPatrons.add(t7);
        testPatrons.add(t8);
        testPatrons.add(t9);
        testPatrons.add(t10);
        testPatrons.add(t11);
        testPatrons.add(t12);
        testPatrons.add(t13);
        ArrayList<String> testSort = new ArrayList<>();
        //testSort.add("-patronName");
        testSort.add("+tierNum");
        System.out.println("Testing Sort");
        testPatrons = sortAll(testPatrons, testSort);
        setTableData(testPatrons);
        
        for(Object pat : testPatrons){
            System.out.println("Name: "+((PatronDTO)pat).getPatronNameString()+" Tier: "+((PatronDTO)pat).getTierNumString());
        }
    }
    
    //Use quicksort to sort a DTO by multiple parameters
    public ArrayList<Object> sortAll(ArrayList<Object> data, ArrayList<String> sortParams){
        if(data.size() <= 1){
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
}
