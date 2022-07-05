package company;

public  class Table{
    
    public int columns;
   public Object[][] Items;
    
    
    public Table(int columns){
        
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
    