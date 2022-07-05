/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import Entity.Product;
import Forms.EntityForms.Entry;
import Forms.EntityForms.product;
import java.awt.Color;


/**
 *
 * @author framawy
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Entry emp = new Entry();
        
       
       emp.setLocationRelativeTo(null);
       emp.setDefaultCloseOperation(2);
       emp.getContentPane().setBackground(new Color(0, 0, 100));
       emp.setVisible(true);

       // new Entry().setVisible(true);  
       
    }
    
}
