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

public class Product implements main{


   
    private Integer id;
    
    private String item;
    
    private String weight;
    
    private String place;
   
    private int price;
   
    private String type;
    int balance;

    //import
    //export
    //notes(from whome or to whome)
    //balance
    
    
    //customer
    //store for
    

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
        return db.go.getAutoNumber("product", "id");
    }
     
     
    @Override
    public void add() {
        try{
        String Insert = "insert into product values (" 
                + id + ", "
                + "'" + item + "', " +
                 "'" + weight + "', " +
                 "'"+ place + "',"  + price +", '" + type + "');";
        
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة المنتج");
                }
        }catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافة المنتج اللذيذ يا نجم");
        }
        
    }
    
    public void addinproductbalance() {
        try{
       String Insert = "INSERT INTO `productbalance` (`id` , `item`, `balance`) VALUES ( " +
                + id + ", " +
            "'" + item + "', "
          + balance + ");";
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة المنتج فى المخزن");
                }
        }catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافة المنتج فى المخزن");
        }
        
    }

      @Override
    public void update() {
        try{
         //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
        String Update = "UPDATE `product` SET "+
             
        "`item`= '" + item + "'," 
                + "`weight`= '" + weight + "' ," 
                + "`place`= '" + place + "' ," 
                  + "`price`= " + price + " ,"
                + " `type`= '" + type + "' "
               + " WHERE `id` =" + id;
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("لقد تم تعديل المنتج");
        }
        }
         catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم تعديل المنتج اللذيذ يا نجم");
        
    }

    }
     public void updateinstore() {
        try{
         //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
        String Update = "UPDATE `product` SET "+
             
                 "`item`= '" + item + "'" 
               + " WHERE `id` =" + id;
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("لقد تم تعديل المنتج فى المخزن");
        }
        }
         catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم تعديل المنتج اللذيذ يا نجم");
        
    }

    }
      @Override
    public void delete() {
        String delete = " delete from product "
               +  "WHERE `id` =" + id;
        boolean isdeleted =db.go.runNonQuery(delete);
        if(isdeleted){
            
            TheTools.msgBox("لقد تم حذف المنتج بنجاح");
        }
    }
     
     public void deleteinstore() {
        String delete = " delete from productbalance "
               +  "WHERE `id` =" + id;
        boolean isdeleted =db.go.runNonQuery(delete);
        if(isdeleted){
            
            TheTools.msgBox("لقد تم حذف المنتج من المخزن");
        }
    }
     
  @Override
     public void getAllRows(JTable table) {
        db.go.fillToJTable("product", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from product "
                +" where id= " + id;
        db.go.fillToJTable(strSelect, table);
    }

     @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }

     @Override
    public String getValueByname(String Name) {
        
        String strSelect = "select id from product " +
                "where item= " + "'" + item  + "'";
         String strVal = (String)db.go.getTableData(strSelect).Items[0][0];

        return strVal;

    }

      @Override
    public String getNameByValue(String Value) {
        
        
       String strSelect = " select item from product " +
                "where id = " + Value;
       
     String strName =  (String) db.go.getTableData(strSelect).Items[0][0];


     return strName;

    }
     
     
     
     
     
     
     
     
     
     
     
     
     
    
    
}
