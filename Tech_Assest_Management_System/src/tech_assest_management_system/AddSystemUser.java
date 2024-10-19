
package tech_assest_management_system;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;

public class AddSystemUser extends javax.swing.JFrame {

 
    public AddSystemUser() 
    {
        initComponents();
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
        this.setLocationRelativeTo(null);
        
        lbl_AutoSysID.setText(getMaxSysID());
    }

    
    // This is the Method for Get Maximum System ID for the User
    //In here there should be return type - Max ID
    private String getMaxSysID()
    {
        String maxSysID = "SYS001";
        
        try
        {
            String dbloc ="jdbc:mysql://localhost/techassest";
            String uname = "root";
            String dbpw = "";
            
            Connection conn = DriverManager.getConnection(dbloc , uname , dbpw);
            Statement stmt = conn.createStatement();
            
            //Result Set is use for Store values which are retrive from the data base
            ResultSet rs = stmt.executeQuery("select max(sysid) as maxSysID from systemuser");
            
            if(rs.next())
            {
                String result = rs.getString("maxSysID");
                
                if(result != null)
                {
                    int number  = Integer.parseInt(result.substring(3));
                    number++;
                    maxSysID = String.format("SYS%03d", number); // This meaning is format as SYS001 , SYS002 ...
                }
            }
            
            conn.close();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return maxSysID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_AutoSysID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_nic = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbo_SystemPo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_uName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JTextField();
        btn_addSysUser = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Add System User");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("System ID");

        lbl_AutoSysID.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        lbl_AutoSysID.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Name");

        txt_name.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("NIC Number");

        txt_nic.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("System Position");

        cmbo_SystemPo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        cmbo_SystemPo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Super Admin", "Admin", "Testing User", "User" }));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("User Name");

        txt_uName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Password");

        txt_Password.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        btn_addSysUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btn_addSysUser.setText("Add System User");
        btn_addSysUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addSysUserActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\ICON\\addUser.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(lbl_AutoSysID, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(93, 93, 93)
                                                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel5)
                                .addGap(51, 51, 51)
                                .addComponent(txt_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(30, 30, 30)
                                .addComponent(cmbo_SystemPo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(61, 61, 61)
                                .addComponent(txt_uName, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(71, 71, 71)
                                .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_addSysUser, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lbl_AutoSysID))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4))
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cmbo_SystemPo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7))
                            .addComponent(txt_uName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(btn_addSysUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addSysUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addSysUserActionPerformed
        
        String id , name , nic , sysPostion , username , password ; 
    
        id = this.lbl_AutoSysID.getText();
        name  = this.txt_name.getText();
        nic = this.txt_nic.getText();
        
        //This how from getting Selected Item From the User
        sysPostion = cmbo_SystemPo.getSelectedItem().toString();
        
        username = this.txt_uName.getText();
        password = this.txt_Password.getText();
        
        if (txt_name.getText().trim().isEmpty() || txt_nic.getText().trim().isEmpty() || txt_uName.getText().trim().isEmpty() || txt_Password.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please Enter Records", "Data not insert", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            try
            {
                String dbloc = "jdbc:mysql://localhost/techassest";
                String dbuname = "root";
                String dbpw = "";

                Connection conn = DriverManager.getConnection(dbloc , dbuname , dbpw);
                Statement  stmt = conn.createStatement();

                int rowAffected = stmt.executeUpdate("insert into systemuser (sysid , name , nic , username , password , sysPosition , status , sysdate ) Values ( '"+id+"' , '"+name+"' , '"+nic+"' , '"+username+"' , '"+password+"' , '"+sysPostion+"' , '1' ,now());");

                if(rowAffected >=0)
                {
                    JOptionPane.showMessageDialog(this, "System User Added Successfully");

                    //This is for Clear Records after Adding data to ther Database
                    txt_name.setText("");
                    txt_nic.setText("");
                    txt_uName.setText("");
                    txt_Password.setText("");
                    cmbo_SystemPo.setSelectedIndex(0); // This is the way for Reset Combo box for First Value
                    
                    //And You should implement when added user SysID auto generated automatically
                    lbl_AutoSysID.setText(getMaxSysID());
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "The System User Did not Added to the System", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                
                conn.close();
            
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
            
        }

    }//GEN-LAST:event_btn_addSysUserActionPerformed

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
            java.util.logging.Logger.getLogger(AddSystemUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSystemUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSystemUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSystemUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSystemUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addSysUser;
    private javax.swing.JComboBox<String> cmbo_SystemPo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbl_AutoSysID;
    private javax.swing.JTextField txt_Password;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_nic;
    private javax.swing.JTextField txt_uName;
    // End of variables declaration//GEN-END:variables
}
