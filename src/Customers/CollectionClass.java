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
public class CollectionClass {
    int idcol;
    int id;
    String name;
    int pay;
    String notes;
    String date;
    int balance;

    public int getIdcol() {
        return idcol;
    }

    public void setIdcol(int idcol) {
        this.idcol = idcol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
     public String getAutoNumber() {
        return db.go.getAutoNumber("collection", "idcol");
    }
     public void filecustomertable(JTable table) {
        String strSelect = "SELECT `id`, `clientname` , `address` from customer";
        db.go.fillToJTable(strSelect, table);
    }
      public void getAllRows(JTable table) {
        db.go.fillToJTable("collection", table);
    }
    
       public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }

     public void add() {

try{
        String Insert = "insert into collection values (" 
                + idcol + ", "
                   + id + ", "
                + "'" + name + "', " 
                     + pay + ", " + 
                 "'" + notes + "', " +
                 "'"+ date + "' "  + ");";
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة عملية التحصيل");
                }
        }catch(Exception ex){
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافة عملية التحصيل");
        }
    }
     public void addinstore() {
        try {
            int empty = 0;
           //  int realbalance = db.go.Getcustbalance(id);
    
            String Insert = "INSERT INTO `customerstatement`  VALUES ( "
                    + id + ", "
                    + "'" + name + "', "
                    + empty + ", "
                    + pay + ", "
                    + empty + ", "
                    + idcol + ", "
                    
                    + "'" + date + "' " 
                   
                     + ")";

            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة عملية التوريد فى المخزن");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة عملية التوريد فى المخزن");
        }

    }
     
       public void addincustbalance() {
        try {
            String  oldbalance = db.go.Getcustbalance(String.valueOf(id));
            int oldbalance2 = Integer.parseInt(oldbalance);
              
              int balance2 = oldbalance2 -  pay;
            String Update = "UPDATE `customerbalance` SET "
                    + "`name`= '" + name +"'," 
                      + "`date`= '" + date + "', "
                      + "`balance`= " + balance2 
                    + " WHERE idcustomer  = " + id + " ";

            boolean isAdded = db.go.runNonQuery(Update);
            if (isAdded) {
                TheTools.msgBox("تم خصم  الدفعة من رصيد العميل");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم خصم  الدفعة من رصيد العميل");
        }

    }
      
     
   /*
    public void update() {

        try{
         //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
        String Update = "UPDATE `collection` SET "+
                  "`id`= " + id + ", "            
                + "`name`= '" + name + "', "                     
                 + " `pay`= " + pay + ", "
                  + "`notes`'= " + notes + "', "  
                 + "`date`'= " + date + "' "  
               + " WHERE `idcol`= " + idcol;
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("لقد تم تعديل  عملية التحصيل");
        }
        }
         catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم تعديل  عملية التحصيل");
        
    }






    }
*/
  
    public void delete() {
String delete = " delete from collection "
               +  "WHERE `idcol` =" + idcol;
        boolean isdeleted =db.go.runNonQuery(delete);
        if(isdeleted){
            
            TheTools.msgBox("لقد تم حذف العملية  بنجاح");
        }    }
    
    
    
    
    
    
}
