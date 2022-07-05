/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import company.TheTools;
import java.util.Collection;
import javax.swing.JTable;


/**
 *
 * @author HP
 */

public class Employee implements main {
   
    private Integer id;
    
    private String employeename;
    
    private String phone;
   
    private String job;
   
    private String address;
   int absence;
   
   
    private int salary;
    private String fullname; 

    public String getFullname() { 
        return fullname;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
   public String getAutoNumber() {
        return db.go.getAutoNumber("employee", "id");
    }
     
     
    @Override
    public void add() {
        try{
        String Insert = "insert into employee values (" 
                + id + ", "
                + "'" + employeename + "', " +
                 "'" + phone + "', " +
                 "'"+ job + "'," + "'" + address +"', " + absence +"', " + salary + ", '" + fullname +"');";
        
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("تم اضافة موظف جديد");
                }
        }catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافةالموظف");
        }
        
    }
    /*
    public void ubdatetheabsence() {
        try{
       String Update = "UPDATE `employee` SET "+
            
        "`employeename`= '" + employeename + "'," 
                + "`phone`= '" + phone + "' ,"                     
                + "`job`= '" + job + "' ," 
                 + " `address`= '" + address + "' ,"
               + "`absence`= " + absence + " ,"
                  + "`salary`= " + salary + " ,"
                + " `fullname`= '" + fullname + "' "
               
               + " WHERE `id` =" + id;
        
        boolean isAdded = db.go.runNonQuery(Update);
                if(isAdded){
                    TheTools.msgBox("تم اضافة موظف جديد");
                }
        }catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم اضافةالموظف");
        }
        
    }

   */
    @Override
    public void update() {
        try{
         //   UPDATE `product` SET `id`='[2]',`item`='[روكسيل]',`weight`='[25]',`place`='[المخزن]',`price`='[70]',`type`='[مسحوق]' WHERE 'id' = 2;
        String Update = "UPDATE `employee` SET "+
            
        "`employeename`= '" + employeename + "'," 
                + "`phone`= '" + phone + "' ,"                     
                + "`job`= '" + job + "' ," 
                 + " `address`= '" + address + "' ,"
                 + "`absence`= " + absence + " ,"
                  + "`salary`= " + salary + " ,"
                + " `fullname`= '" + fullname + "' "
               
               + " WHERE `id` =" + id;
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("لقد تم تعديل بيانات الموظف");
        }
        }
         catch(Exception ex){
            
            TheTools.msgBox(ex.getMessage());
              TheTools.msgBox("لم يتم تعديل بيانات الموظف");
        
    }

    }
    @Override
    public void delete() {
        String delete = " delete from employee "
               +  "WHERE `id` =" + id;
        boolean isdeleted =db.go.runNonQuery(delete);
        if(isdeleted){
            
            TheTools.msgBox("لقد تم حذف الموظف بنجاح");
        }
    }
     
     

    @Override
     public void getAllRows(JTable table) {
        db.go.fillToJTable("employee", table);
    }

  
    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from employee "
                +" where id= " + id;
        db.go.fillToJTable(strSelect, table);
    }

   
    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }

   
    @Override
    public String getValueByname(String Name) {
        
        String strSelect = "select id from employee " +
                "where employeename= " + "'" + employeename  + "'";
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
