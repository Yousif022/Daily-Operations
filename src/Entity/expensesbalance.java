/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import company.TheTools;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class expensesbalance {
    int id;
    String details;
    String date;
    int total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
     public void getAllRows(JTable table) {
        db.go.fillToJTable("ExpensesBalance", table);
    }
     
      public void filetable(JTable table) {
        String strSelect = "SELECT  `details` , `Total` from expensesbalance";
        db.go.fillToJTable(strSelect, table);
    }
    
    /* String  total2 = db.go.Gettotal();
            int totalexp = Integer.parseInt(total2);
           // int totalexpenses = money + totalexp;
        String Insert = "insert into ExpensesBalance values (" 
                + id + ", "
                + "'" + details + "', " +
             
                 "'"+ date + "',"   + totalexp + ");";
        
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة المنتج");
                }*/
    
     public void add() {
        
        try{
      String  total2 = db.go.Gettotal();
            int totalexp = Integer.parseInt(total2);
           // int totalexpenses = money + totalexp;
        String Insert = "insert into ExpensesBalance values (" 
                + id + ", "
                + "'" + details + "', " +
             
                 "'"+ date + "',"   + totalexp + ");";
        
        
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة المنتج");
                }
                
                
        }catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافة المنتج اللذيذ يا نجم");
        }
         
    }
     
    
    
    
    
    
    
}
