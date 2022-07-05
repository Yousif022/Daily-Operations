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
public class ExpensesClass {
   int id;
   String details;
   int money;
   String date;
   int total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public void getAllRows(JTable table) {
        db.go.fillToJTable("expenses", table);
    }
    
   public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }
     
    public String getAutoNumber() {
        return db.go.getAutoNumber("expenses", "id");
    }
                             
   
     public void add() {
        
        try{
        String Insert = "insert into expenses values (" 
                + id + ", "
                + "'" + details + "', " +
                money +", " +
                 "'"+ date + "');";
        
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة المنتج");
                }
                
                
        }catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافة المنتج اللذيذ يا نجم");
        }
         
    }
     
      public void update() {
        
        try{
      String  total2 = db.go.Gettotal();
            int totalexp = Integer.parseInt(total2);
           // int totalexpenses = money + totalexp;
      String Update = "UPDATE `expensesbalance` SET " +
                
              "`details`= 'اجمالى المصروفات'," 
                + "`Total`= " + totalexp + " " 
                 + " WHERE `id` = 1";
        
        
        
        boolean isAdded = db.go.runNonQuery(Update);
                if(isAdded){
                    TheTools.msgBox("تم تعديل الرصيد");
                }
                
                
        }catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم تعديل الرصيد");
        }
         
    }
    /*
      public void update() {
        try{
         //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
        String Update = "UPDATE `product` SET "+
             
        "`item`= '" + item + "'," 
                + "`weight`= '" + weight + "' ," 
                + "`place`= '" + place + "' ," 
                  + "`price`= " + price + " ,"c 
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
*
      public void delete() {
        String delete = " delete from expenses "
               +  "WHERE `id` =" + id;
        boolean isdeleted =db.go.runNonQuery(delete);
        
        if(isdeleted){
            
            TheTools.msgBox("لقد تم حذف المنتج بنجاح");
        }
        
         String Update = "UPDATE `expenses` SET "+
             
        "`item`= '" + item + "'," 
                + "`weight`= '" + weight + "' ," 
                + "`place`= '" + place + "' ," 
                  + "`price`= " + price + " ,"
                + " `type`= '" + type + "' "
               + " WHERE `id` =" + id;
        
        boolean isUbdated = db.go.runNonQuery(delete);
        
        if(isUbdated){
            TheTools.msgBox("لقد تم تعديل المنتج");
        }
    }
    */
    
     public void delete() {
        String delete = " delete from expenses "
               +  "WHERE `id` =" + id;
        boolean isdeleted =db.go.runNonQuery(delete);
        if(isdeleted){
            
            TheTools.msgBox("لقد تم حذف العملية بنجاح");
        }
    }
    
    
    
    
    /*
    String idbal = db.go.getAutoNumber("expensesbalance", "id");
     int idbal2 = Integer.parseInt(idbal);
     int idbal3 = idbal2 - 1;
*/
     
     public void UPDATETHEBALANCE() {
         
           String  total2 = db.go.GetBalanceex("1");
            int totalexp = Integer.parseInt(total2);
            
            int uptotal = totalexp - money;
         
  String Update = "UPDATE `expensesbalance` SET "+
             
        "`details`= 'اجمالى المصروفات',"  +
         
              
                   "`Total`= " + uptotal + " "
           
               + " WHERE `id` = 1";
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("لقد تم تعديل المنتج");
        }
    }
    
}
