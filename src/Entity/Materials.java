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

public class Materials implements main{

    
     private Integer id;
    private String item;
    private String weight;
    private float price;
    private String type;
   
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

     @Override
   public String getAutoNumber() {
        return db.go.getAutoNumber("materials", "id");
    }
     
     
    @Override
    public void add() {
        try{
        String Insert = "insert into materials values (" 
                + id + ", "
                + "'" + item + "', " +
                 "'" + weight + "', "+
                price + ","+
                 "'"+ type + "' " +");";
        
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة منتج جديد");
                }
        }catch(Exception ex){
            
             
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافة المنتج");
           
        }
        
    }

    
    @Override
    public void update() {
        try{
         //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
        String Update = "UPDATE `materials` SET "+
            
        "`item`= '" + item + "'," 
                + "`weight`= '" + weight + "' ," 
                + "`price` = " + price + " ,"
                + "`type`= '" + type + "' " 
               
               + " WHERE `id` =" + id;
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("لقد تم تعديل بيانات  المنتج");
        }
        }
         catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم تعديل بيانات المنتج");
        
    }

    }
    @Override
    public void delete() {
        String delete = " delete from materials "
               +  "WHERE `id` = " + id;
        boolean isdeleted =db.go.runNonQuery(delete);
        if(isdeleted){
            
            TheTools.msgBox("لقد تم حذف المنتج بنجاح");
        }
    }
     
     

    @Override
     public void getAllRows(JTable table) {
        db.go.fillToJTable("materials", table);
    }

  
    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from materials "
                +" where id= " + id;
        db.go.fillToJTable(strSelect, table);
    }

   
    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }

   
    @Override
    public String getValueByname(String Name) {
        
        String strSelect = "select id from materials " +
                "where item = " + "'" + item  + "'";
         String strVal = (String)db.go.getTableData(strSelect).Items[0][0];

        return strVal;

    }

    
    @Override
    public String getNameByValue(String Value) {
        
        
       String strSelect = " select item from employeename " +
                "where id = " + Value;
       
     String strName =  (String) db.go.getTableData(strSelect).Items[0][0];


     return strName;

    }
    
    
    
    
}
