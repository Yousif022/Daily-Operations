  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sell;

import company.TheTools;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class receiptclass {
    int id;
     int idcustomer;
    String customername;
     String customeraddress;
     int productid;
      String productname;
       String productweight;
       
       int quantity;
       int unitprice;
       int pay;
       String date;
       String employee;
       int total;
       int receipttotal;

    public int getReceipttotal() {
        return receipttotal;
    }

    public void setReceipttotal(int receipttotal) {
        this.receipttotal = receipttotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 public int getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }
    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductweight() {
        return productweight;
    }

    public void setProductweight(String productweight) {
        this.productweight = productweight;
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

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public String getAutoNumber() {
        return db.go.getAutoNumber("receipt", "id");
    }
       
       public void fileclienttable(JTable table) {
        String strSelect = "SELECT `id`, `clientname` , `address` , `phone` from customer";
        db.go.fillToJTable(strSelect, table);
    }
       
         public void fileproducttable(JTable table) {
        String strSelect = "SELECT `id`, `item` , `weight` , `price` from product";
        db.go.fillToJTable(strSelect, table);
    }
         public void filereceipttable(JTable table) {
        String strSelect = "SELECT `id`, `productname` ,  `productid` ,  `productweight` , `quantity` , `unitprice` , `total`   from receipt where `id`=" + id;
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
            /*
            int tot = db.go.gettotal(id);
            int receipttot = tot + total2; 
            */
            String Insert = "INSERT INTO `receipt` "
                    + "(`id`, `idcustomer` , `customername`, `customeraddress`, `productname`, `productid` , `productweight`,"
                    + " `quantity`, `unitprice`, `pay`, `date`, `employee`, `total` ) VALUES ("
                    + id + ", "+ idcustomer+" , '"+customername+"' ,'"+customeraddress+"' , '" + productname + "', "   + productid + "," 
                    + "'" + productweight + "', " 
                     + quantity + ", " 
                    +  unitprice + ", "+ empty + "," +  "' ' ," + "' ' ," 
                     + total2 + " "  
                       + ");";
            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة صنف للفاتورة");
            }
            
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة الصنف");
        }

    }
       
            public void addinthestore() {
        try {
              int total2 = quantity * unitprice;
            String Insert = "insert into customerstatement values ("
                    + idcustomer + ", "    
                    + "'" + customername + "', " 
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
     
      public void addincustbalancegoods() {
        try {
            String  oldbalance = db.go.Getcustbalance(String.valueOf(idcustomer));
            int oldbalance2 = Integer.parseInt(oldbalance);
              int total2 = quantity * unitprice;
              int baln = oldbalance2 + total2;
            String Update = "UPDATE `customerbalance` SET "
                    + "`name`= '" + customername +"'," 
                      + "`date`= '" + date + "', "
                      + "`balance`= " + baln 
                    + " WHERE idcustomer  = " + idcustomer + " ";

            boolean isAdded = db.go.runNonQuery(Update);
            if (isAdded) {
                TheTools.msgBox("تم تعديل  رصيد فى رصيد العميل");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم تعديل رصيد العميل");
        }

    }
      
      
          
               
       /*
       
       public void addincustbalancepay() {
        try {
             String  oldbalance = db.go.Getcustbalance(String.valueOf(idcustomer));
            int oldbalance2 = Integer.parseInt(oldbalance);
           
                 //int total2 = quantity * unitprice;
              //int balance2 = total2 - pay;
          
               
              int balance3 = oldbalance2 - pay;  
            
                
              
            String Update = "UPDATE `customerbalance` SET "
                    + "`name`= '" + customername +"'," 
                      + "`date`= '" + date + "', "
                      + "`balance`= " + balance3 
                    + " WHERE idcustomer  = " + idcustomer + " ";

            boolean isAdded = db.go.runNonQuery(Update);
            if (isAdded) {
                TheTools.msgBox("تم تعديل  رصيد فى رصيد العميل");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم تعديل رصيد العميل");
        }

    }
      
      
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
     
           */
           

//حسن العلاقة واحدة واحدة
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
           public void update() {
        try {
            //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
            String Update = "UPDATE `receipt` SET "
                    + " `id`= " + id + ", "
                    + "`customername`= '" + customername + "',"
                    + "`customeraddress`= '" + customeraddress + "' ,"
                  
                    + " `productname `= '" + productname + "', "
                    + "`productid`= " + productid + " ,"
                 
                   + " `productweight `= '" + productweight + "', "
                   + "`quantity`= " + quantity + " ,"
                      + "`unitprice`= " + unitprice + " ,"
                      + "`pay`= " + pay + " ,"
                      + "`date`= '" + date + "' ,"
                    
                      + "`employee`= '" + employee + "' ,"
                      + "`total`= " + total + " "
                    
                    
                    + " WHERE `id` =" + id;
           
            boolean isUbdated = db.go.runNonQuery(Update);

            if (isUbdated) {
                TheTools.msgBox("لقد تم تعديل بيانات المورد");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم تعديل بيانات المورد");

        }

    }
           /*
             public void updateThecustState() {
        try {
            //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
           
              int total2 = quantity * unitprice;
            String Update = "UPDATE `customerstatement` SET "
                  
                    + "`name`= '" + customername + "',"
                    + "`take`= " + total2 + ","
                  
                    + " `pay `= " + pay + ", "
                    + "`receiptnum`= " + receiptnum + " ,"
                    + "`receiptnum`= " + collectionnum + " ,"
                    + "`date`= '" + date + "' ,"
                    
                      + " `balance`= " + balance 
                 
                    + " WHERE `idcustomer` =" + idcustomer;
           
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
           
          public void delete() {
        String delete = " delete from `receipt` "
                + "WHERE `id` =" + id;
        boolean isdeleted = db.go.runNonQuery(delete); 
       // delete from customerstatement.
         String delete2 = " delete from `customerstatement` "
                + "WHERE `receiptno` =" + id;
                 db.go.runNonQuery(delete2); 
                 
                 // update the balance
                   String  oldbalance = db.go.Getcustbalance(String.valueOf(idcustomer));
            int oldbalance2 = Integer.parseInt(oldbalance);
              int total2 = quantity * unitprice;
              int baln = oldbalance2 - total2;
            String Update = "UPDATE `customerbalance` SET "
                    + "`name`= '" + customername +"'," 
                      + "`date`= '" + date + "', "
                      + "`balance`= " + baln 
                    + " WHERE idcustomer  = " + idcustomer + " ";

                  db.go.runNonQuery(Update);
            
            
        if (isdeleted) {
            TheTools.msgBox("لقد تم حذف المنتج بنجاح ");
        }
    }
          
                   
}
