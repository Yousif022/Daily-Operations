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
public class Customerstatement {
   int idcustomer;
     String name;
      int take;
    int pay;
    int receiptno;
    int collectionno;
    String date;
   
    public int getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

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

    public int getReceiptno() {
        return receiptno;
    }

    public void setReceiptno(int receiptno) {
        this.receiptno = receiptno;
    }

    public int getCollectionno() {
        return collectionno;
    }

    public void setCollectionno(int collectionno) {
        this.collectionno = collectionno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    
    
     public void getAllRows(JTable table) { 
        db.go.fillToJTable("customerstatement", table);
    }
     
    
      public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }
    
}
