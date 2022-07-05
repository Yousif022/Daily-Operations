/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import company.TheTools;
import javax.swing.JTable;



/**
 *
 * @author HP
 */

public class Customer implements main{

   
    private Integer id;
   
    private String name;
    private String storename;

    
    private String address;
    
    private String phone;
   
     int ourmoney;
 
    int balance;
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getOurmoney() {
        return ourmoney;
    }

    public void setOurmoney(int ourmoney) {
        this.ourmoney = ourmoney;
    }
public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }
    @Override
    public void add() {

try{
        String Insert = "insert into customer values (" 
                + id + ", "
                + "'" + name + "', " +
                  "'" + storename + "', " +
                 "'" + address + "', " +
                 "'"+ phone + "', "  + ourmoney + ");";
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة عميل جديد");
                }
        }catch(Exception ex){
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافة العميل");
        }
    }
 String date = "";
    public void addincustomerbalance() {
        try{
       String Insert = "INSERT INTO `customerbalance` (`idcustomer` , `name`, `date` , `balance` ) VALUES ( " +
                + id + ", " +
            "'" + name + "', "
               +  "'" + date + "', "
          + ourmoney + ");";
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تمت الاضافة فى جدول العملاء");
                }
        }catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافة العميل فى ارصدة العملاء");
        }
        
    }
   
    @Override
    public void update() {

        try{
         //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
        String Update = "UPDATE `customer` SET "+
        "`clientname`= '" + name + "', " 
                 + "`storename`= '" + storename + "', "      
                + "`address`= '" + address + "', "                     
                 + " `phone`= '" + phone + "', "
                  + "`ourmoney`= " + ourmoney + " "  
               + " WHERE `id`= " + id;
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("لقد تم تعديل بيانات العميل");
        }
        }
         catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم تعديل بيانات العميل");
        
    }






    }

    @Override
    public void delete() {
String delete = " delete from customer "
               +  "WHERE `id` =" + id;
        boolean isdeleted =db.go.runNonQuery(delete);
        if(isdeleted){
            
            TheTools.msgBox("لقد تم حذف العميل  بنجاح");
        }    }

    
    
    @Override
    public String getAutoNumber() {
  return db.go.getAutoNumber("customer", "id");    }

    @Override
     public void getAllRows(JTable table) {
        db.go.fillToJTable("customer", table);
    }

  
    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from customer "
                +" where id= " + id;
        db.go.fillToJTable(strSelect, table);
    }

   
    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }

   
    @Override
    public String getValueByname(String Name) {
        
        String strSelect = "select id from customer " +
                "where clientname= " + "'" + name  + "'";
         String strVal = (String)db.go.getTableData(strSelect).Items[0][0];

        return strVal;

    }

    
    @Override
    public String getNameByValue(String Value) {
        
        
       String strSelect = " select clientname from employeename " +
                "where id = " + id;
       
     String strName =  (String) db.go.getTableData(strSelect).Items[0][0];


     return strName;

    }
    
    
    
}
