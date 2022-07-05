/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

import Customers.*;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class SupplyBalance {
     
    
    
     int supplierno;
    String name;
    
    String date;
    int balance;

    public int getSupplierno() {
        return supplierno;
    }

    public void setSupplierno(int supplierno) {
        this.supplierno = supplierno;
    }
    
    
    
    
   
    

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
            
   
     public void getAllRows(JTable table) { 
        db.go.fillToJTable("supplybalance", table);
    }
     
    
      public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }
    
    /*
     public void update() {
        try {
            //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
            String Update = "UPDATE `customerstatement` SET "
                    + " `idcustomer`= " + idcustomer + ", "
                    + "`name`= '" + name + "',"
                    + "`take`= " + take + ","
                  
                    + " `pay `= " + pay + ", "
                    + "`receiptnum`= " + receiptnum + " ,"
                    + "`receiptnum`= " + collectionnum + " ,"
                    + "`date`= '" + date + "' ,"
                    
                      + " `balance`= " + balance 
                 
                    + " WHERE `idcustomer` =" + idcustomer;
           
            boolean isUbdated = db.go.runNonQuery(Update);

            if (isUbdated) {
                TheTools.msgBox("لقد تم تعديل بيانات المورد");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم تعديل بيانات المورد");

        }

    }
    
    
    
      public void delete() {
        String delete = " delete from customerstatement "
                + "WHERE `idcustomer` =" + idcustomer;
        boolean isdeleted = db.go.runNonQuery(delete);
        if (isdeleted) {

            TheTools.msgBox("لقد تم حذف عملية   بنجاح ");
        }
    }

    
    
    */

    
    
    
}
