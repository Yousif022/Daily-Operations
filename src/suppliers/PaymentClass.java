/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

import company.TheTools;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class PaymentClass {
    int payementid;
    int supplierid;
    String name;
    int pay;
    String notes;
    String date;
    int balance;

    public int getPayementid() {
        return payementid;
    }

    public void setPayementid(int payementid) {
        this.payementid = payementid;
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
        return db.go.getAutoNumber("payement", "payementid");
    }
     
     public void filesupplytable(JTable table) {
        String strSelect = "SELECT `id`, `suppliername` , `address` from supplier";
        db.go.fillToJTable(strSelect, table);
    }
      public void getAllRows(JTable table) {
        db.go.fillToJTable("payement", table);
    }
    
       public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }

     public void add() {

try{
        String Insert = "insert into payement values (" 
                + payementid + ", "
                   + supplierid + ", "
                + "'" + name + "', " 
                     + pay + ", " + 
                 "'" + notes + "', " +
                 "'"+ date + "' "  + ");";
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("???? ?????????? ?????????? ??????????");
                }
        }catch(Exception ex){
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("???? ?????? ?????????? ?????????? ??????????");
        }
    }
     public void addinstore() {
        try {
            int empty = 0;
           //  int realbalance = db.go.Getcustbalance(id);
    
            String Insert = "INSERT INTO `supplystatement`  VALUES ( "
                    + supplierid + ", "
                    + "'" + name + "', "
                    + empty + ", "
                    + pay + ", "
                    + empty + ", "
                    + payementid + ", "
                    
                    + "'" + date + "' " 
                   
                     + ")";

            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("???? ?????????? ?????????? ?????????????? ???? ????????????");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("???? ?????? ?????????? ?????????? ?????????????? ???? ????????????");
        }

    }
     
       public void addinsupbalance() {
        try {
            String  oldbalance = db.go.Getsupplybalance(String.valueOf(supplierid));
            int oldbalance2 = Integer.parseInt(oldbalance);
              
              int balance2 = oldbalance2 -  pay;
            String Update = "UPDATE `supplybalance` SET "
                    + "`name`= '" + name +"'," 
                      + "`date`= '" + date + "', "
                      + "`balance`= " + balance2 
                    + " WHERE supplierno  = " + supplierid + " ";

            boolean isAdded = db.go.runNonQuery(Update);
            if (isAdded) {
                TheTools.msgBox("???? ??????  ???????????? ???? ???????????? ");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("???? ?????? ??????  ???????????? ???? ???????????? ");
        }

    }
      
     
   /*
    public void update() {

        try{
         //   UPDATE `product` SET `id`='[2]',`item`='[????????????]',`weight`='[25]',`place`='[????????????]',`price`='[70]',`type`='[??????????]' WHERE 'id' = 2;
        String Update = "UPDATE `collection` SET "+
                  "`id`= " + id + ", "            
                + "`name`= '" + name + "', "                     
                 + " `pay`= " + pay + ", "
                  + "`notes`'= " + notes + "', "  
                 + "`date`'= " + date + "' "  
               + " WHERE `idcol`= " + idcol;
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("?????? ???? ??????????  ?????????? ??????????????");
        }
        }
         catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("???? ?????? ??????????  ?????????? ??????????????");
        
    }






    }
*/
  
    public void delete() {
String delete = " delete from payement "
               +  "WHERE `payementid` =" + payementid;
        boolean isdeleted =db.go.runNonQuery(delete);
        if(isdeleted){
            
            TheTools.msgBox("?????? ???? ?????? ??????????????  ??????????");
        }    }
    
    
    
    
    
    
}
