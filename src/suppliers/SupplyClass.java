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
public class SupplyClass {
    
    int receiptId;
    int supplierid;
    String name;
    String item;
    String weight;
    int unitprice;
    int quantity;
    String date;

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  
    
   
     public void getAllRows(JTable table) { 
        db.go.fillToJTable("buyproccess", table);
    }
    
      public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }
     
    
        public void add() {
        try {
            
              int total2 = quantity * unitprice;
            String Insert = "insert into `supplygoods` values ("
                    
                     + receiptId + ", "   
                    + supplierid + ", "   
                    + "'" + name + "', " 
                    + "'" + item + "', " 
                     + "'" + weight + "', " 
                   
                    +  unitprice + ", "
                    + quantity +", "
                     
                      + "'" + date + "', " 
               
                      + total2 +  
                    " );";
            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة  الاوردر ");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة  الاوردر");
        }

    }
      /*
         int realbalance = db.go.Getcustbalance(idreceipt);
              int balance2 = realbalance - exp;
      */
        
       public void addinthestore() {
        try {
              int total2 = quantity * unitprice;
            String Insert = "insert into supplystatement values ("
                    + supplierid + ", "    
                    + "'" + name + "', " 
                    + total2 + ", " 
                    +  0 + ", "
                     + receiptId + ", " 
                    +  0 + ", "
                    + "'" + date + "'"
                     + " )";
            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة الطلبية فى كشف الحساب");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة الطلبية فى كشف الحسابة");
        }

    }
     
      public void addincustbalance() {
        try {
            String  oldbalance = db.go.Getsupplybalance(String.valueOf(supplierid));
            int oldbalance2 = Integer.parseInt(oldbalance);
              int total2 = quantity * unitprice;
              int balance2 = oldbalance2 + total2;
            String Update = "UPDATE `supplybalance` SET "
                    + "`name`= '" + name +"'," 
                      + "`date`= '" + date + "', "
                      + "`balance`= " + balance2 
                    + " WHERE supplierno  = " + supplierid + " ";

            boolean isAdded = db.go.runNonQuery(Update);
            if (isAdded) {
                TheTools.msgBox("تم اضافة  اجمالى رصيد الطلبية فى رصيد المورد");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة  اجمالى رصيد الطلبية فى رصيد المورد");
        }

    }
      
      
      
      
      
      
      
      
      
      
    
    
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
