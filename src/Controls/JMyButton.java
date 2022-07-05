
package Controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JTextField;
import static javax.swing.text.StyleConstants.Bold;


public class JMyButton extends JButton {
    public  JMyButton(){
       
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFont(new java.awt.Font("Dialog", 1, 12));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
         super.paintComponent(g);
        
    }
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(new Color (40 ,100 , 80));
        g.drawRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        //super.paintBorder(g);
    }

    
            
           
    
}
