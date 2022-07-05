/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

import Customers.*;
import company.TheTools;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class Supplystatement {
   int supplierId;
     String name;
      int take;
    int pay;
    int receiptnum;
    int collectionnum;
    String date;
   
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTake() {
        return take;
    }

    public void setTake(int take) {
        this.take = take;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getReceiptnum() {
        return receiptnum;
    }

    public void setReceiptnum(int receiptnum) {
        this.receiptnum = receiptnum;
    }

    public int getCollectionnum() {
        return collectionnum;
    }

    public void setCollectionnum(int collectionnum) {
        this.collectionnum = collectionnum;
    }

    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    
    
     public void getAllRows(JTable table) { 
        db.go.fillToJTable("supplystatement", table);
    }
     
    
      public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }
    
}
