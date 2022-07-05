/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import company.TheTools;

import java.util.Date;
import javax.persistence.Basic;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JTable;

/**
 *
 * @author HP
 */

public class Supplier implements main {

  

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "suppliername")
    private String suppliername;
     private String details;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    
    @Temporal(TemporalType.DATE)
    private int hismoney;
    @Basic(optional = false)
    @Column(name = "employee")
    private String employee;

    public int getHismoney() {
        return hismoney;
    }

    public void setHismoney(int hismoney) {
        this.hismoney = hismoney;
    }
    

  
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

     @Override
   public String getAutoNumber() {
        return db.go.getAutoNumber("supplier", "id");
    }
     
     
    @Override
    public void add() {
        try{
        String Insert = "insert into supplier values (" 
                + id + ", "
                + "'" + suppliername + "', " 
                + "'" + details + "', " +
                 "'" + address + "', " +
                 "'"+ phone + "'," + "'" + type +"', " + hismoney + ", '" + employee +"');";
        
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة المورد");
                }
        }catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافة المورد");
        }
        
    }

     String date = "";
    public void addinsupplybalance() {
        try{
       String Insert = "INSERT INTO `supplybalance` (`supplierno` , `name`, `date` , `balance` ) VALUES ( " +
                + id + ", " +
            "'" + suppliername + "', "
               +  "'" + date + "', "
          + hismoney + ");";
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة المورد فى ارصدة المورديين");
                }
        }catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافة المورد فى ارصدة المورديين");
        }
        
    }
   
    
    @Override
    public void update() {
        try{
         //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
        String Update = "UPDATE `supplier` SET "+
            
        "`suppliername`= '" + suppliername + "'," +
                 "`details`= '" + details + "'," 
                + "`address`= '" + address + "' ,"                     
                + "`phone`= '" + phone + "' ," 
                 + " `type`= '" + type + "' ,"
                  + "`hismoney`= '" + hismoney + "' ,"
                + " `employee`= '" + employee + "' "
                + " WHERE `id` =" + id;
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("لقد تم تعديل بيانات المورد");
        }
        }
         catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم تعديل بيانات المورد");
        
    }

    }
     public void updateforbalance() {
        try{
        String Update = "UPDATE `supplier` SET "+
            
        "`suppliername`= '" + suppliername + "'," +
                 "`details`= '" + details + "'," 
                + "`address`= '" + address + "' ,"                     
                + "`phone`= '" + phone + "' ," 
                 + " `type`= '" + type + "' ,"
                  + "`hismoney`= '" + Getbalance() + "' ,"
                + " `employee`= '" + employee + "' "
                + " WHERE `id` =" + id;
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("لقد تم تعديل رصيد المورد");
        }
        }
         catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم تعديل رصيد المورد");
        
    }

    }
    @Override
    public void delete() {
        String delete = " delete from supplier "
               +  "WHERE `id` =" + id;
        boolean isdeleted =db.go.runNonQuery(delete);
        if(isdeleted){
            
            TheTools.msgBox("لقد تم حذف المورد بنجاح ");
        }
    }
     
     public int Getbalance() {
        
            String  oldbalance = db.go.Getsupplybalance(String.valueOf(id));
            int oldbalance2 = Integer.parseInt(oldbalance); 
        return oldbalance2;
     }
    @Override
     public void getAllRows(JTable table) {
        db.go.fillToJTable("supplier", table);
    }

  
    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from supplier "
                +" where id= " + id;
        db.go.fillToJTable(strSelect, table);
    }

   
    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }

   
    @Override
    public String getValueByname(String Name) {
        
        String strSelect = "select id from supplier " +
                "where suppliername= " + "'" + suppliername  + "'";
         String strVal = (String)db.go.getTableData(strSelect).Items[0][0];

        return strVal;

    }

    
    @Override
    public String getNameByValue(String Value) {
        
        
       String strSelect = " select suppliername from supplier " +
                "where id = " + Value;
       
     String strName =  (String) db.go.getTableData(strSelect).Items[0][0];


     return strName;

    }
    
    
}
