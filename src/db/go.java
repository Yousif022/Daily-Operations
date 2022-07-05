
package db;

import company.TheTools;
import company.TheTools.MyTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class go {
    
 private static String url = "";
 private static Connection con;
 
 public static void setUrl(){
     
     url="jdbc:mysql://localhost:3306/elrihab" +
             "?useUnicode=true&characterEncoding = UTF-8";
      
     
 }
 public static void setConnection(){
     
     try {
         setUrl();
         con = DriverManager.getConnection(url, "root", "");
     } catch (SQLException ex) {
        TheTools.msgBox(ex.getMessage());
     }
     
     
 }
 public static boolean checkUserAndPass(String username , String Password){
     
     setConnection();
     try {
         Statement  stmt =  con.createStatement();
         String strCheck = "select * from users where " 
                 + "username='" +  username +"' and " + "pass= '" + Password + "'";
         stmt.executeQuery(strCheck);
         while( stmt.getResultSet().next()){
          con.close();
          return  true;   
         }
                   con.close();

     } catch (SQLException ex) {
         TheTools.msgBox(ex.getMessage());
     }
     
    return false;
 }
 
 public static boolean runNonQuery(String  sqlStatement){
    
     try {
         setConnection();
        Statement stmt = con.createStatement();
        stmt.execute(sqlStatement);
        con.close();
        return true;
     } catch (SQLException ex) {
         
         TheTools.msgBox(ex.getMessage());
        
         
              return false;
                             
     }
     
 }
 public static String getAutoNumber(String TableName , String ColumnName ){
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
         String strAuto = "select max(" + ColumnName + ") + 1 as autonum" + " from " + TableName;
        stmt.executeQuery(strAuto);
        String Num = "";
        while(stmt.getResultSet().next()){
            Num=stmt.getResultSet().getString("autonum");
            
        }
        con.close();
        if( Num == null || "".equals(Num)){
            return "1";
            
        }
        else{
            return Num;
        }
                
     } catch (SQLException ex) {
      TheTools.msgBox(ex.getMessage());
      return "0";
     }
     
     
     
     
 }
 
 public static String Getprodbalance(String id){
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
        
         String str = "SELECT `balance` as oldprodbalance FROM `productbalance` WHERE `id`= " + id+";";
        stmt.executeQuery(str);
        String Num = "";
        while(stmt.getResultSet().next()){
            Num =stmt.getResultSet().getString("oldprodbalance");
            
        }
        con.close();
      
            return Num;
        
                
     } catch (SQLException ex) {
      TheTools.msgBox(ex.getMessage());
      return "0";
     }
         
 }
  
 
 
  /*
  public static String Getcustbalance(String id){
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
        
         String str = "SELECT `balance` as bbb FROM `customerbalance` WHERE `idcustomer`= " + id;
        stmt.executeQuery(str);
        String Num = "";
        while(stmt.getResultSet().next()){
            Num =stmt.getResultSet().getString("bbb");
            
        }
        con.close();
      
            return Num;
        
                
     } catch (SQLException ex) {
      TheTools.msgBox(ex.getMessage());
      return "0";
     }
         
 }
  */
  ///عااااااااااااااااش اووووووووووووووى
  public static String Getcustbalance(String id){
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
        
         String str = "SELECT `balance` as oldbalance FROM `customerbalance` WHERE `idcustomer`= " + id+";";
        stmt.executeQuery(str);
        String Num = "";
        while(stmt.getResultSet().next()){
            Num =stmt.getResultSet().getString("oldbalance");
            
        }
        con.close();
      
            return Num;
        
                
     } catch (SQLException ex) {
      TheTools.msgBox(ex.getMessage());
      return "0";
     }
         
  }

  
  public static String Getsupplybalance(String id){
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
        
         String str = "SELECT `balance` as oldbalance FROM `supplybalance` WHERE `supplierno`= " + id+";";
        stmt.executeQuery(str);
        String Num = "";
        while(stmt.getResultSet().next()){
            Num =stmt.getResultSet().getString("oldbalance");
            
        }
        con.close();
      
            return Num;
        
                
     } catch (SQLException ex) {
      TheTools.msgBox(ex.getMessage());
      return "0";
     }
         
 }
  
  public static int gettotal(int id){
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
       
         String str = "SELECT SUM(total) FROM receipt where id = " + id;
        stmt.executeQuery(str);
        int Num = 0;
        while(stmt.getResultSet().next()){
            Num = stmt.getResultSet().getInt(str);
            
        }
        con.close();
       
        
            return Num;
        
                
     } catch (SQLException ex) {
    
      return 0;
     }
  }
  public static String Gettotal(){
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
        
         String str = "SELECT SUM(money) as totalexp FROM expenses";
        stmt.executeQuery(str);
        String Num = "";
        while(stmt.getResultSet().next()){
            Num =stmt.getResultSet().getString("totalexp");
            
        }
        con.close();
      
            return Num;
        
                
     } catch (SQLException ex) {
      TheTools.msgBox(ex.getMessage());
      return "0";
     }
         
  }
  
  
  public static String GetBalanceex(String id){
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
        
         String str = "SELECT Total as balanceexp FROM expensesbalance WHERE id = "+ id ;
        stmt.executeQuery(str);
        String Num = "";
        while(stmt.getResultSet().next()){
            Num =stmt.getResultSet().getString("balanceexp");
            
        }
        con.close();
      
            return Num;
        
                
     } catch (SQLException ex) {
      TheTools.msgBox(ex.getMessage());
      return "0";
     }
         
  }

 public static MyTable getTableData(String statement){
     TheTools t = new TheTools();
     try{
             setConnection();
             Statement  stmt = con.createStatement();
             ResultSet rs;
             rs= stmt.executeQuery(statement);
             ResultSetMetaData rsmd = rs.getMetaData();
             int c = rsmd.getColumnCount();
             MyTable table = t.new MyTable(c);
             
             ///املاء الجدول 
             while(rs.next()){
                 Object row[] = new Object[c];
                 for(int i = 0 ; i < c ; i ++){
                     
                     row[i] = rs.getString(i+1);
                 }
                 
                 table.addNewRow(row);
                 
             }
             con.close();
             return table;
             }
         catch(SQLException ex){
                 
                 TheTools.msgBox(ex.getMessage());
                 return t.new MyTable(0);
                 }
     
     
 }
 /*
 public static void fillCombo(String tableName , String columnName , JComboBox combo){
    
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
         ResultSet rs;
         
         String strSelect = "select " +columnName+" from " + tableName;
       rs= stmt.executeQuery(strSelect);
       
       rs.last();
       int c = rs.getRow();
       rs.beforeFirst();
       
       String Values[] = new String[c];
       
       int i = 0; 
       while (rs.next()){
           Values[i]  = rs.getString(1);
           i++;
       }
       con.close();
       combo.setModel(new DefaultComboBoxModel(Values));
     } catch (SQLException ex) {
         Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
     }
          
     
     
 }
*/
 public static void fillComboBox (String tableName , String ColumnName , JComboBox combo){
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
         ResultSet rs;
         String strSelect = "SELECT `" + ColumnName + "` FROM  `" + tableName +"`";
         rs = stmt.executeQuery(strSelect);
         rs.last();
         int c = rs.getRow();
         
         String Values[] = new String[c];
         
        rs.beforeFirst();
        
        int i = 0;
        while(rs.next()){
            Values[i] = rs.getString(1);
            i++;
        }
        con.close();
        combo.setModel(new DefaultComboBoxModel(Values));
         
     } catch (SQLException ex) {
       Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex); 
     }
 }
 
 public static void fillToJTable(String tableNameOrSelectStatement , JTable table){
     try {
         setConnection();
         Statement stmt = con.createStatement();
         ResultSet rs;
         String SPart = tableNameOrSelectStatement.substring(0, 7).toLowerCase();
         String strSelect;
         if("select ".equals(SPart)){
             strSelect = tableNameOrSelectStatement;
             
         }
         else{
             strSelect = "select * from " + tableNameOrSelectStatement;
         }
         rs = stmt.executeQuery(strSelect);
         
         ResultSetMetaData rsmd = rs.getMetaData();
         int c = rsmd.getColumnCount();
         
         DefaultTableModel MODEL =(DefaultTableModel) table.getModel();
         
         
         Vector  row = new Vector();
         MODEL.setRowCount(0);
         
         while(rs.next()){
             row = new Vector(c);
             for(int i = 1 ; i <= c ; i++){
                 row.add(rs.getString(i));
             }
             MODEL.addRow(row);
             
             
             if(table.getColumnCount() != c){
                 TheTools.msgBox("JTable Columns Count Not Equal to Query Columns Count \n  JTable Columns Count Is :  " + table.getColumnCount() + "\nQuery Columns Count Is :" + c);
             }
         }
     } catch (SQLException ex) {
         TheTools.msgBox(ex.getMessage());
     }
     
 }

 
}
