/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

import Customers.*;
import Forms.EntityForms.*;
import Entity.Customer;
import Entity.Product;
import company.TheTools;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author framawy
 */
public class supply extends javax.swing.JFrame {

    /**
     * Creates new form DepartmentForm
     */
    public supply() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMyButton1 = new Controls.JMyButton();
        jMyButton8 = new Controls.JMyButton();
        btnGroub = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltake = new javax.swing.JTable();
        rdocustid = new javax.swing.JRadioButton();
        bdnclear1 = new javax.swing.JButton();
        bdnsearch1 = new javax.swing.JButton();
        bdnback1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        item1 = new javax.swing.JRadioButton();
        rdoemp = new javax.swing.JRadioButton();
        rdoName1 = new javax.swing.JRadioButton();
        txtSearch1 = new Controls.JTextBox(10);
        date1 = new javax.swing.JRadioButton();
        back2 = new javax.swing.JButton();
        rdoNum = new javax.swing.JRadioButton();

        jMyButton1.setText("jMyButton1");

        jMyButton8.setText("jMyButton8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("???????????? ????????????");

        total.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("????????????????");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        tbltake.setAutoCreateRowSorter(true);
        tbltake.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tbltake.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "?????????? ????????????????", "?????? ????????????", "?????? ????????????", "?????????? ????????????", "?????? ????????????", "?????? ????????????", "?????? ????????????", "????????????", "?????? ????????????", "??????????????", "??????????????", "???????????? ??????????????"
            }
        ));
        tbltake.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltakeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbltake);

        rdocustid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdocustid.setForeground(new java.awt.Color(255, 255, 255));
        rdocustid.setText("?????? ????????????");
        rdocustid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdocustidActionPerformed(evt);
            }
        });

        bdnclear1.setBackground(new java.awt.Color(255, 255, 255));
        bdnclear1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bdnclear1.setForeground(new java.awt.Color(0, 0, 0));
        bdnclear1.setText("??????????");
        bdnclear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdnclear1ActionPerformed(evt);
            }
        });

        bdnsearch1.setBackground(new java.awt.Color(153, 255, 153));
        bdnsearch1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bdnsearch1.setForeground(new java.awt.Color(0, 0, 0));
        bdnsearch1.setText(" ??????");
        bdnsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdnsearch1ActionPerformed(evt);
            }
        });

        bdnback1.setBackground(new java.awt.Color(255, 255, 255));
        bdnback1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bdnback1.setForeground(new java.awt.Color(0, 0, 0));
        bdnback1.setText("????????????");
        bdnback1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdnback1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("???????? ????????????????");

        item1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        item1.setForeground(new java.awt.Color(255, 255, 255));
        item1.setText("????????????");
        item1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item1ActionPerformed(evt);
            }
        });

        rdoemp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoemp.setForeground(new java.awt.Color(255, 255, 255));
        rdoemp.setText("????????????");
        rdoemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoempActionPerformed(evt);
            }
        });

        rdoName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoName1.setForeground(new java.awt.Color(255, 255, 255));
        rdoName1.setText("?????? ????????????");
        rdoName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoName1ActionPerformed(evt);
            }
        });

        txtSearch1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch1.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });

        date1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date1.setForeground(new java.awt.Color(255, 255, 255));
        date1.setText("??????????????");
        date1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date1ActionPerformed(evt);
            }
        });

        back2.setBackground(new java.awt.Color(255, 255, 255));
        back2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        back2.setForeground(new java.awt.Color(0, 0, 0));
        back2.setText("???????????? ?????????????? ??????????????");
        back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back2ActionPerformed(evt);
            }
        });

        rdoNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNum.setForeground(new java.awt.Color(255, 255, 255));
        rdoNum.setSelected(true);
        rdoNum.setText("?????? ????????????????");
        rdoNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(403, 403, 403))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bdnsearch1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoemp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(item1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdocustid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoNum))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back2)
                        .addGap(18, 18, 18)
                        .addComponent(bdnclear1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bdnback1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(338, 338, 338)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bdnclear1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bdnback1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bdnsearch1)
                    .addComponent(rdoNum)
                    .addComponent(rdoName1)
                    .addComponent(rdoemp)
                    .addComponent(date1)
                    .addComponent(item1)
                    .addComponent(rdocustid)
                    .addComponent(total))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(250, 250, 250))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    
        btnGroub.add(rdoNum);
      btnGroub.add(rdocustid);
      btnGroub.add(rdoName1);
      btnGroub.add(total);
      btnGroub.add(item1);
       btnGroub.add(rdoemp);
     
       btnGroub.add(date1);
      cleardata();
      
             
      txtSearch1.setText("0");
    
      tbltake.getTableHeader().setReorderingAllowed(true);
    }//GEN-LAST:event_formWindowOpened

           SupplyClass ct = new SupplyClass();
    
    private void cleardata(){
        TheTools.clearText(this);
          ct.getAllRows(tbltake);
         
         txtSearch1.setText("0"); 
        
    }
    
    
    
    
    private void tbltakeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltakeMouseClicked
        

    }//GEN-LAST:event_tbltakeMouseClicked
 
    private void rdocustidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdocustidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdocustidActionPerformed

    private void bdnclear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdnclear1ActionPerformed
        // TODO add your handling code here:
        cleardata();
        //  tblbalance.setSelectionMode(0);
    }//GEN-LAST:event_bdnclear1ActionPerformed

    private void bdnsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdnsearch1ActionPerformed
        // TODO add your handling code here:

        String strSearch = "select * from buyproccess where ";
        if(rdoNum.isSelected()){
            strSearch += "id";
        }
        else if(rdocustid.isSelected()){
            strSearch += "supplierid";
        }
        else if(rdoName1.isSelected()){
            strSearch += " name";
        }
        else if(total.isSelected()){
            strSearch += "total";
        }
        else if(item1.isSelected()){
            strSearch += "item";
        }

        else if(rdoemp.isSelected()){
            strSearch += "employee";
        }

        // else if(rdodetails.isSelected()){
            //      strSearch += "storename";
            //}
        else{
            strSearch += "date";
        }
        strSearch += " like '%"+  txtSearch1.getText()  +"%'";
        ct.getCustomRows(strSearch, tbltake);
    }//GEN-LAST:event_bdnsearch1ActionPerformed

    private void bdnback1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdnback1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Entry en = new Entry();

        en.setLocationRelativeTo(null);
        en.setDefaultCloseOperation(2);
        en.setVisible(true);
    }//GEN-LAST:event_bdnback1ActionPerformed

    private void item1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item1ActionPerformed

    private void rdoempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoempActionPerformed

    private void rdoName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoName1ActionPerformed

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed

    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void date1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date1ActionPerformed

    private void back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        suppliers.EnrollSupply emp = new   suppliers.EnrollSupply();

        emp.setLocationRelativeTo(null);
        emp.setDefaultCloseOperation(2);
        emp.getContentPane().setBackground(new Color(50, 100, 50));
        emp.setVisible(true);
    }//GEN-LAST:event_back2ActionPerformed

    private void rdoNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNumActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(supply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supply().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back2;
    private javax.swing.JButton bdnback1;
    private javax.swing.JButton bdnclear1;
    private javax.swing.JButton bdnsearch1;
    private javax.swing.ButtonGroup btnGroub;
    private javax.swing.JRadioButton date1;
    private javax.swing.JRadioButton item1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private Controls.JMyButton jMyButton1;
    private Controls.JMyButton jMyButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoName1;
    private javax.swing.JRadioButton rdoNum;
    private javax.swing.JRadioButton rdocustid;
    private javax.swing.JRadioButton rdoemp;
    private javax.swing.JTable tbltake;
    private javax.swing.JRadioButton total;
    private javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables
}
