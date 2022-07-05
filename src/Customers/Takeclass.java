/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers;

import company.TheTools;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class Takeclass {
    
    int idreceipt;
    int idcust;
    String customername;
    String item;
    String weight;
    int unitprice;
    int quantity;
    String date;

    public int getIdcust() {
        return idcust;
    }

    public void setIdcust(int idcust) {
        this.idcust = idcust;
    }
   


    public int getIdreceipt() {
        return idreceipt;
    }

    public void setIdreceipt(int idreceipt) {
        this.idreceipt = idreceipt;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
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
        db.go.fillToJTable("receipt", table);
    }
     
      public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }
     
        /*
    
        public void add() {
        try {
            
              int total2 = quantity * unitprice;
            String Insert = "insert into `takeproduct` values ("
                    
                     + idreceipt + ", "   
                    + idcust + ", "   
                    + "'" + customername + "', " 
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
      /*
       public void addinthestore() {
        try {
              int total2 = quantity * unitprice;
            String Insert = "insert into customerstatement values ("
                    + idcust + ", "    
                    + "'" + customername + "', " 
                    + total2 + ", " 
                    +  0 + ", "
                     + idreceipt + ", " 
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
            String  oldbalance = db.go.Getcustbalance(String.valueOf(idcust));
            int oldbalance2 = Integer.parseInt(oldbalance);
              int total2 = quantity * unitprice;
              int balance2 = oldbalance2 + total2;
            String Update = "UPDATE `customerbalance` SET "
                    + "`name`= '" + customername +"'," 
                      + "`date`= '" + date + "', "
                      + "`balance`= " + balance2 
                    + " WHERE idcustomer  = " + idcust + " ";

            boolean isAdded = db.go.runNonQuery(Update);
            if (isAdded) {
                TheTools.msgBox("تم اضافة  التوريد فى رصيد المنتج");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة المنتج فى المخزن");
        }

    }
      
      
      */
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
        
    
    
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
