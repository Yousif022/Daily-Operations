/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import company.TheTools;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class store {
    
    
    int iditem;
    String item;
    String weight;
    int imp;
    int exp;
    int balance;

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
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

    public int getImp() {
        return imp;
    }

    public void setImp(int imp) {
        this.imp = imp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public void getAllRows(JTable table) {
        db.go.fillToJTable("storeproduct", table);
    }
    
     public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }
    
    
    Importclass ic = new Importclass();
    
    
    
    
    
    
    
    
    
}
