  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buy;

import sell.*;
import company.TheTools;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class Buyclass {
    int id;
     int supplierid;
    String name;
     String address;
     int productid;
      String item;
       String weight;
       
       int quantity;
       int unitprice;
      
       String date;
       String employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

   

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public int getEmpty() {
        return empty;
    }

    public void setEmpty(int empty) {
        this.empty = empty;
    }
      

   
    public String getAutoNumber() {
        return db.go.getAutoNumber("buyproccess", "id");
    }
       
       public void fileclienttable(JTable table) {
        String strSelect = "SELECT `id`, `suppliername` , `address`  from supplier";
        db.go.fillToJTable(strSelect, table);
    }
       
         public void fileproducttable(JTable table) {
        String strSelect = "SELECT `id`, `item` , `weight` , `price` , `type` from product";
        db.go.fillToJTable(strSelect, table);
    }
         public void filereceipttable(JTable table) {
        String strSelect = "SELECT `id`, `item` ,  `productid` ,  `weight` , `quantity` , `unitprice` from buyproccess where `id`=" + id;
        db.go.fillToJTable(strSelect, table);
    }
         public void getAllRows(JTable table) {
        db.go.fillToJTable("customerstatement", table);
    }
          public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }
          int empty = 0;
          
          public void add() {
        try { 
          //  INSERT INTO `receipt` (`id`, `customername`, `customeraddress`, `productname`, `productweight`, `quantity`, `unitprice`, `pay`, `date`, `employee`, `total`, `receipttotal`) VALUES ('1', '', '', 'sdkd mdsls', '21k', '21', '22', '', '', '', '324', '');
            int total2 = quantity * unitprice;
            int tot = db.go.gettotal(id);
            int receipttot = tot + total2; 
            
            String Insert = "insert into `buyproccess` values ("
                     + id + ", "    
                    + supplierid + ", "    
                    + "'" + name + "', " 
                     + "'" + address + "', " 
                    + productid + ", " 
                     + "'" + item + "', " 
                       + "'" + weight + "', " 
                    +  quantity + ", "
                     + unitprice + ", " 
                     + total2 + ", "
                   
                     + "'" + date + "', " 
                    + "'" + employee + "'"
                     + " )";
            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة صنف للفاتورة");
            }
            
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة الصنف");
        }

    }
       /*
        int id;
     int supplierid;
    String name;
     String address;
     int productid;
      String item;
       String weight;
       
       int quantity;
       int unitprice;
       int pay;
       String date;
       String employee;
          */
           
      
      
       public void addinthestore() {
        try {
              int total2 = quantity * unitprice;
            String Insert = "insert into supplystatement values ("
                    + supplierid + ", "    
                    + "'" + name + "', " 
                    + total2 + ", " 
                    +  0 + ", "
                     + id + ", " 
                    +  0 + ", "
                    + "'" + date + "'"
                     + " )";
            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة الطلبية فى كشف الحساب");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة الطلبية فى كشف الحسابة");
        }

    }
     
      public void addincustbalance() {
        try {
            String  oldbalance = db.go.Getsupplybalance(String.valueOf(supplierid));
            int oldbalance2 = Integer.parseInt(oldbalance);
              int total2 = quantity * unitprice;
              int balance2 = oldbalance2 + total2;
            String Update = "UPDATE `supplybalance` SET "
                    + "`name`= '" + name +"'," 
                      + "`date`= '" + date + "', "
                      + "`balance`= " + balance2 
                    + " WHERE supplierno  = " + supplierid + " ";

            boolean isAdded = db.go.runNonQuery(Update);
            if (isAdded) {
                TheTools.msgBox("تم اضافة  اجمالى رصيد الطلبية فى رصيد المورد");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة  اجمالى رصيد الطلبية فى رصيد المورد");
        }

    }
      
      
      
          
               
       /*
       
           public void addinthetake() {
        try {
             int total2 = quantity * unitprice;
              int total3 = pay - total2; 
           
            String Insert = "insert into `takeproduct` values ("
                    
                     + id + ", "   
                    + "'" + customername + "', " 
                    + "'" + productname + "', " 
                     + "'" + productweight + "', " 
                   
                    +  unitprice + ", "
                    + quantity +", "
                     
                      + "'" + date + "', " 
               
                      + total3 +  
                    " );";
            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة  الطلبية فى المكان المخصص لها");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة  الطلبية فى المكان المخصص لها");
        }

    }
          
         
            public void addinthestore() {
        try {
            
             int total2 = quantity * unitprice;
              int total3 = pay - total2; 
            String Insert = "insert into `customerstatement` values ("
                   
                     + idcustomer + ", "   
                    + "'" + customername + "', "              
                      + "'" + date + "', " 
                      + total3 +  
                    " );";
            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة  الاوردر فى كشف حساب العميل");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة  الاوردر فى كشف حساب العميل");
        }

    }
         public void update() {
        try {
            //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
            String Update = "UPDATE `receipt` SET "
                    + " `id`= " + id + ", "
                    + "`customername`= '" + name + "',"
                    + "`customeraddress`= '" + address + "' ,"
                  
                    + " `productname `= '" + item + "', "
                    + "`productid`= " + productid + " ,"
                 
                   + " `productweight `= '" + weight + "', "
                   + "`quantity`= " + quantity + " ,"
                      + "`unitprice`= " + unitprice + " ,"
                     
                      + "`date`= '" + date + "' ,"
                    
                      + "`employee`= '" + employee + "' "
                      
                    
                    + " WHERE `productid` =" + supplierid;
           
            boolean isUbdated = db.go.runNonQuery(Update);

            if (isUbdated) {
                TheTools.msgBox("لقد تم تعديل بيانات المورد");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم تعديل بيانات المورد");

        }

    }
           */
        

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
          
          public void delete() {
        String delete = " delete from `buyproccess` "
                + "WHERE `id` =" + id;
        boolean isdeleted = db.go.runNonQuery(delete); 
       // delete from customerstatement.
         String delete2 = " delete from `supplystatement` "
                + "WHERE `receiptnum` =" + id;
                 db.go.runNonQuery(delete2); 
                 
                 // update the balance
                   String  oldbalance = db.go.Getsupplybalance(String.valueOf(supplierid));
            int oldbalance2 = Integer.parseInt(oldbalance);
              int total2 = quantity * unitprice;
              int baln = oldbalance2 - total2;
            String Update = "UPDATE `supplybalance` SET "   
                    + "`name`= '" +  name +"'," 
                      + "`date`= '" + date + "', "   
                      + "`balance`= " + baln 
                    + " WHERE  	supplierno  = " + supplierid + " ";

                  db.go.runNonQuery(Update);
            
            
        if (isdeleted) {
            TheTools.msgBox("لقد تم حذف المنتج بنجاح ");
        }
    }
                   
}
