/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import company.TheTools;
import javax.swing.JTable;
import Process.store;

/**
 *
 * @author HP
 */
public class Importclass {

    int id;
    int iditem;
    String item;
    String weight;
    int imp;
    String mixtureid;
    String mixturename;
    int balance;
   
    int exp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public String getItem() {
        return item;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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

    public String getMixtureid() {
        return mixtureid;
    }

    public void setMixtureid(String mixtureid) {
        this.mixtureid = mixtureid;
    }

    public String getMixturename() {
        return mixturename;
    }

    public void setMixturename(String mixturename) {
        this.mixturename = mixturename;
    }


    public String getAutoNumber() {
        return db.go.getAutoNumber("productsimport", "id");
    }

    // @Override
    public void addinstore() {
        try {
            String  oldbalance = db.go.Getprodbalance(String.valueOf(iditem));
            int oldbalance2 = Integer.parseInt(oldbalance);   
            int balance2 = oldbalance2 + imp;
            
            String Insert = "INSERT INTO `storeproduct` (`iditem`, `item`, `weight`, `imp`, `exp`, `balance`) VALUES ( "
                    + iditem + ", "
                    + "'" + item + "', "
                    + "'" + weight + "', " + imp + ", "
                    + 0 + ", "
                    +  balance2 + ");";

            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة عملية التوريد فى المخزن");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة عملية التوريد فى المخزن");
        }

    }

    public void add() {

        try {
            String Insert = "insert into productsimport values ("
                    + id + ", " + iditem + ", "
                    + "'" + item + "', "
                    + "'" + weight + "', " + imp + ", "
                    + "'" + mixtureid + "', '"
                    + mixturename + "' );";

            boolean isAdded = db.go.runNonQuery(Insert);
            if (isAdded) {
                TheTools.msgBox("تم اضافة العملية");
            }
        } catch (Exception ex) {

            TheTools.msgBox(ex.getMessage());
            TheTools.msgBox("لم يتم اضافة العملية");
        }

    }

    public void addinproductbalance() {
        try {
             String  oldbalance = db.go.Getprodbalance(String.valueOf(iditem));
            int oldbalance2 = Integer.parseInt(oldbalance);
            //      UPDATE `productbalance` SET `balance`= 20 WHERE item = ' كرتونة ريحة كيلو'
           
            int balance2 = oldbalance2 + imp;
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

    //INSERT INTO `store` (`iditem`, `item`, `weight`, `imp`, `exp`, `balance`) VALUES ('4', 'شكارة رادو ابيض', '10ك', '10', '', '10');
    //  @Override
    public void update() {
        try {
            //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
            String Update = "UPDATE `productsimport` SET "
                    + " `iditem`= " + iditem + ", "
                    + "`item`= '" + item + "',"
                    + "`weight`= '" + weight + "' ,"
                    + " `imp`= " + imp + ", "
                    + " `mixtureid`= '" + mixtureid + "', "
                    + "`mixturename`= '" + mixturename + "' "
                  
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
        String delete = " delete from productsimport "
                + "WHERE `id` =" + id;
        boolean isdeleted = db.go.runNonQuery(delete);
        if (isdeleted) {

            TheTools.msgBox("لقد تم حذف عملية التوريد  بنجاح ");
        }
    }

    // @Override
    public void fileimporttable(JTable table) {
        String strSelect = "SELECT `id`, `imp` , `mixtureid` , `mixturename` , `balance` from productsimport";
        db.go.fillToJTable(strSelect, table);
    }

    public void getAllRows(JTable table) {
        db.go.fillToJTable("productsimport", table);
    }
    // @Override

    public void getOneRow(JTable table) {
        String strSelect = "select * from productsimport "
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

        String strSelect = "select id from productsimport "
                + "where item= " + "'" + item + "'";
        String strVal = (String) db.go.getTableData(strSelect).Items[0][0];

        return strVal;

    }

    //@Override
    public String getNameByValue(String Value) {

        String strSelect = " select item from productsimport "
                + "where id = " + Value;

        String strName = (String) db.go.getTableData(strSelect).Items[0][0];

        return strName;

    }

}
