
package company;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class TheTools {
    public static int number;

    public static void EXP(){
        int number = 2;
        System.out.println("Welcome " + number);
    }
    
    
      public static void msgBox(String message){

       JOptionPane.showMessageDialog(null, message);


    }
      
      
      public static void CreateFolder(String folderName , String Path){

        File f = new File(Path +"/" + folderName);
        f.mkdir();
    }
      public static void OpenForm(JFrame form){
          
        try {
            form.setLocationRelativeTo(null);
            Image img = ImageIO.read(TheTools.class.getResource("Cowboy.png"));
            form.setIconImage(img);
            form.setDefaultCloseOperation(2);
            form.getContentPane().setBackground(new Color(50, 0, 50));
            form.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(TheTools.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
      }
      public static void clearText(Container form){
          for(Component c : form.getComponents()){
              
              if(c instanceof JTextField){
              JTextField txt = (JTextField)c;
              txt.setText(" ");
              }
              else if (c instanceof Container){
                  clearText( (Container) c);
              }
             
              
          }
          
          
          
      }
       public static void CreateEmptyFile(String fileName){
                  
        try {
            File f = new File(fileName);
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(TheTools.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
                  
       }

       public static void CreateFile(String fileName , Object Data[]){
           
        try {
            PrintWriter p = new PrintWriter(fileName);
            for(Object obj : Data){
                p.println(obj);
            }
            p.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TheTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       }
       public static void createfiles (String filenames[] , Object alldata[][]){
           for(int x = 0 ; x < filenames.length ; x++){
               
               CreateFile(filenames[x] , alldata[x]);
           }
       }
           public static boolean confirmMsg(String Message){
             int magC =   JOptionPane.showConfirmDialog( null , Message);
               if(magC == JOptionPane.YES_OPTION) return true;
               else return false;
           }
           
       
       
       
       public static Object InputBox(String title){
           Object myobj = JOptionPane.showInputDialog(title, null);
           return myobj;
       }
       public static String getNumber(String text){
           String val = "";
           for(char c : text.toCharArray()){
               if( c == '0' || c == '1' || c == '2' || c == '3' ){
                   
                   val += c;
               }
           }
           return (val);

       }
        public static String removeNumber(String text){
           String val = "";
           for(char c : text.toCharArray()){
               if( !(c == '0' || c == '1' || c == '2' || c == '3' )){
                   
                   val += c;
               }
           }
           return (val);

       }
        public static void PrintScreen (String ImageName , JFrame form){
        try {
            form.setState(1);
            Robot r = new Robot();
            Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage img = r.createScreenCapture(rec);
          ImageIO.write(img, "jpg", new File (ImageName + ".jpg"));
          form.setState(0);
        } catch (Exception ex) {
            Logger.getLogger(TheTools.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
        public static void Translateclass(String className , TheTools p){
           
        try {
            PrintWriter r = new PrintWriter(className);
            r.println(p);
            r.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TheTools.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        public  class MyTable{
    
    public int columns;
   public Object[][] Items;
    
    
    public MyTable(int columns){
        
        this.columns = columns;
        Items = new Object[0][columns];
        
    }
    
    public  void addNewRow(Object Row[]){
        //وضع البيانات في متغير مؤقت 
       Object TempItems[][] = Items;
       //زيادة المتغير الاساسي بعنصر اضافي 
        Items = new Object[Items.length +1][columns];
        //تعبئة العناصر القديمة في العنصر الاساسي 
        for(int x = 0 ; x < TempItems.length ; x++){
            Items[x] = TempItems[x];
            
        }
        //اضافة الصف الجديد للعنصر الاساسي
        Items [Items.length -1] = Row;
        
    }
            public void printItems(){
                
                for(Object[] objs: Items){
                    for(Object obj :objs){
                        
                        System.out.println(obj);
                    }
                    System.out.println();
                }
            }
                public void editRow(int rowindex , int columnsindex , Object newData){
                    Items[rowindex][columnsindex] = newData;
                }
                public void deleteRow(int rowindex){
            
            Object TempItems[][] = Items;
            Items = new Object[Items.length -1][columns];
            int y = 0;
            for( int x =0 ; x < TempItems.length ; x++){
                if( x != rowindex){
                Items[y] = TempItems[x];
                y++;
                }
            }
                }
            public Object getvalue(int RowIndex , int ColumnsIndex){
                
                return Items[RowIndex][ColumnsIndex];
            }
            public Object[] getrow(int rowIndex){
                
                return Items[rowIndex];
            }
             
         

        
    }    
    

}


