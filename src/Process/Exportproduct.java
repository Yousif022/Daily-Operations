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
public class Exportproduct {

    int id;
    int iditem;
    String item;
    String weight;
 
    int  clientid;
    String clientname;
    int exp;
  int balance;
    int imp;

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIditem() {
        return iditem;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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

    

    

   

    public String getAutoNumber() {
        return db.go.getAutoNumber("exportproduct", "id");
    }

    
    // @Override
    public void add() {
        try {
            String Insert = "insert into exportproduct values ("
                    + id + ", " + iditem + ", "   
                    + "'" + item + "', " 
                    + "'" + weight + "', " 
                    +  clientid + ", "
                    + "'" + clientname + "', "
                 
                    + exp + " );";
            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة العملية");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة العملية");
        }

    }
     public void addinthestore() {
        try {
             String  oldbalance = db.go.Getprodbalance(String.valueOf(iditem));
            int oldbalance2 = Integer.parseInt(oldbalance);   
            int balance2 = oldbalance2 - exp;
            String Insert = "insert into `storeproduct` values ("
                     + iditem + ", "   
                    + "'" + item + "', " 
                    + "'" + weight + "', " 
                     +  0 + ", "
                    +  exp + ", "
                    + balance2 + " );";
            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة عملية التوريد فى المخزن");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة عملية التوريد فى المخزن");
        }

    }
 public void addinproductbalance() {
        try {
            //      UPDATE `productbalance` SET `balance`= 20 WHERE item = ' كرتونة ريحة كيلو' 
         String  oldbalance = db.go.Getprodbalance(String.valueOf(iditem));
            int oldbalance2 = Integer.parseInt(oldbalance);   
            int balance2 = oldbalance2 - exp;
            String Update = "UPDATE `productbalance` SET "
                      + "`item`=  '" + item +"',"
                    + "`balance`= " + balance2
                    + " WHERE id = " + iditem + " ;";

            boolean isAdded = db.go.runNonQuery(Update);
            if (isAdded) {
                TheTools.msgBox("تم اضافة  التوريد فى رصيد المنتج");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة المنتج فى المخزن");
        }

    }
    
  //  @Override
    public void update() {
        try {
            //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
            String Update = "UPDATE `exportproduct` SET "
                    + " `iditem`= " + iditem + ", "
                    + "`item`= '" + item + "',"
                    + "`weight`= '" + weight + "' ,"
                  
                    + " `customerid `= '" + clientid + "', "
                    + "`customername`= '" + clientname + "' ,"
                      + " `exp`= " + exp 
                 
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

    //@Override
    public void delete() {
        String delete = " delete from exportproduct "
                + "WHERE `id` =" + id;
        boolean isdeleted = db.go.runNonQuery(delete);
        if (isdeleted) {

            TheTools.msgBox("لقد تم حذف عملية التوريد  بنجاح ");
        }
    }

   // @Override
    public void fileclienttable(JTable table) {
        String strSelect = "SELECT `id`, `clientname` from customer";
        db.go.fillToJTable(strSelect, table);
    }
  public void getAllRows(JTable table) {
        db.go.fillToJTable("exportproduct", table);
    }
   // @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from exportproduct "
                + " where id= " + id;
        db.go.fillToJTable(strSelect, table);
    }
    
     public void fileproducttable(JTable table) {
        String strSelect = "SELECT `id`, `item` , `weight` from product";
        db.go.fillToJTable(strSelect, table);
    }

  //  @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }

   // @Override
    public String getValueByname(String Name) {

        String strSelect = "select id from exportproduct "
                + "where item= " + "'" + item + "'";
        String strVal = (String) db.go.getTableData(strSelect).Items[0][0];

        return strVal;

    }

    //@Override
    public String getNameByValue(String Value) {

        String strSelect = " select item from exportproduct "
                + "where id = " + Value;

        String strName = (String) db.go.getTableData(strSelect).Items[0][0];

        return strName;

    }

}
