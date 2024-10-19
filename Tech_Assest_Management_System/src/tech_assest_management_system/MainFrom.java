
package tech_assest_management_system;

import javax.swing.JOptionPane;
import tech_reports.*;

public class MainFrom extends javax.swing.JFrame {

    //This is actually work as a form Load Event
    public MainFrom() {
        initComponents();
        
        setInvisible();
        
    }

    //This is for Set Components for the Invisible
    public void setInvisible()
    {
          btn_AddDevice.setVisible(false);
          btn_Dispose.setVisible(false);
          btn_Handover.setVisible(false);
          btn_Repair.setVisible(false);
          btn_report.setVisible(false);
 
          jMenu1.setEnabled(false);
          jMenu2.setEnabled(false);
          jMenu3.setEnabled(false);

          btn_logout.setEnabled(false);
    }
    
    //This methods for if user login Successfully then hiddne Item Should Visble for the User
    public void enableComponents()
    {
        btn_AddDevice.setVisible(true);
        btn_Dispose.setVisible(true);
        btn_Handover.setVisible(true);
        btn_Repair.setVisible(true);
        btn_report.setVisible(true);

        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);

        btn_logout.setEnabled(true);
        btn_Login.setEnabled(false); // Disable the login button

    }
    
    //This is for Show user Name in the Main Window -- This is pass from the Login form
    public void setUserName(String userName)
    {
        lbl_showSystemUser.setText("Logged in as : " + userName);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_techAssest = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        btn_Login = new javax.swing.JButton();
        btn_AddDevice = new javax.swing.JButton();
        btn_Dispose = new javax.swing.JButton();
        btn_report = new javax.swing.JButton();
        btn_Repair = new javax.swing.JButton();
        btn_Handover = new javax.swing.JButton();
        btn_Exit = new javax.swing.JButton();
        lbl_showSystemUser = new javax.swing.JLabel();
        lbl_company = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_AddSysUser = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MainForm"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_techAssest.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_techAssest.setForeground(new java.awt.Color(0, 102, 255));
        lbl_techAssest.setText("Tech Assets Management System");
        getContentPane().add(lbl_techAssest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 550, 40));

        btn_logout.setBackground(new java.awt.Color(0, 153, 255));
        btn_logout.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(0, 0, 0));
        btn_logout.setText("Logout");
        btn_logout.setBorder(null);
        btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 100, 40));

        btn_Login.setBackground(new java.awt.Color(0, 153, 255));
        btn_Login.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_Login.setForeground(new java.awt.Color(0, 0, 0));
        btn_Login.setText("Login");
        btn_Login.setBorder(null);
        btn_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 100, 40));

        btn_AddDevice.setBackground(new java.awt.Color(204, 204, 204));
        btn_AddDevice.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        btn_AddDevice.setForeground(new java.awt.Color(0, 0, 51));
        btn_AddDevice.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\tech\\Colorful Icon resize\\add device.png")); // NOI18N
        btn_AddDevice.setText("Add Device");
        btn_AddDevice.setBorder(new javax.swing.border.MatteBorder(null));
        btn_AddDevice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AddDevice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_AddDevice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_AddDevice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_AddDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddDeviceActionPerformed(evt);
            }
        });
        getContentPane().add(btn_AddDevice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 170, 205));

        btn_Dispose.setBackground(new java.awt.Color(204, 204, 204));
        btn_Dispose.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        btn_Dispose.setForeground(new java.awt.Color(0, 0, 0));
        btn_Dispose.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\tech\\Colorful Icon resize\\dispose.png")); // NOI18N
        btn_Dispose.setText("Dispose");
        btn_Dispose.setBorder(new javax.swing.border.MatteBorder(null));
        btn_Dispose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Dispose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Dispose.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_Dispose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Dispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DisposeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Dispose, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 170, 205));

        btn_report.setBackground(new java.awt.Color(204, 204, 204));
        btn_report.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        btn_report.setForeground(new java.awt.Color(0, 0, 0));
        btn_report.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\tech\\Colorful Icon resize\\report.png")); // NOI18N
        btn_report.setText("Report");
        btn_report.setBorder(new javax.swing.border.MatteBorder(null));
        btn_report.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_report.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_report.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_report.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });
        getContentPane().add(btn_report, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 170, 205));

        btn_Repair.setBackground(new java.awt.Color(204, 204, 204));
        btn_Repair.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        btn_Repair.setForeground(new java.awt.Color(0, 0, 0));
        btn_Repair.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\tech\\Colorful Icon resize\\repair.png")); // NOI18N
        btn_Repair.setText("Repair");
        btn_Repair.setBorder(new javax.swing.border.MatteBorder(null));
        btn_Repair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Repair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Repair.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_Repair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Repair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RepairActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Repair, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 170, 205));

        btn_Handover.setBackground(new java.awt.Color(204, 204, 204));
        btn_Handover.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        btn_Handover.setForeground(new java.awt.Color(0, 0, 0));
        btn_Handover.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\tech\\Colorful Icon resize\\handover.png")); // NOI18N
        btn_Handover.setText("Handover");
        btn_Handover.setBorder(new javax.swing.border.MatteBorder(null));
        btn_Handover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Handover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Handover.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_Handover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Handover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HandoverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Handover, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 170, 205));

        btn_Exit.setBackground(new java.awt.Color(51, 0, 51));
        btn_Exit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_Exit.setForeground(new java.awt.Color(255, 255, 255));
        btn_Exit.setText("Exit Program");
        btn_Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 600, 150, 50));

        lbl_showSystemUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lbl_showSystemUser.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(lbl_showSystemUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 380, 30));

        lbl_company.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_company.setForeground(new java.awt.Color(0, 153, 255));
        lbl_company.setText("ABCD Company");
        getContentPane().add(lbl_company, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\forMain.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 660));

        jMenu1.setText("System Config");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem_AddSysUser.setText("Add System User");
        jMenuItem_AddSysUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AddSysUserActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_AddSysUser);

        jMenuItem2.setText("Add Employee");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("About");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        getAccessibleContext().setAccessibleName("MainForm");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AddDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddDeviceActionPerformed
        AddDevice_Form ad = new AddDevice_Form();
        this.setVisible(false);
        ad.setVisible(true);
        
        //This is for pass User name for the Add Device Form Window
        String logUser = lbl_showSystemUser.getText().replace("Logged in as : ", "");
        ad.setLoggedInUser(logUser);
        
        // This is for Show Again the Main Form when Close the Add Device Form
        ad.addWindowListener(new java.awt.event.WindowAdapter() 
        {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e)  // when AddDevice_Form windowClosed event if triggered then MainFrom Visible
            {
                MainFrom.this.setVisible(true);
            }
        });
    }//GEN-LAST:event_btn_AddDeviceActionPerformed

    private void btn_HandoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HandoverActionPerformed
        Handover_Form hnd = new Handover_Form();
        this.setVisible(false);
        hnd.setVisible(true);
        
        //This is for pass User name for the Handover Form Window
        String logUser = lbl_showSystemUser.getText().replace("Logged in as : ", "");
        hnd.setLoggedInUser(logUser);
        
        
        //This for show again the Main form when Close the Handover Form
        hnd.addWindowListener(new java.awt.event.WindowAdapter() 
        {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e)
            {
                MainFrom.this.setVisible(true);
            }
        });
    }//GEN-LAST:event_btn_HandoverActionPerformed

    private void btn_DisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DisposeActionPerformed
       
        Dispose_Form df = new Dispose_Form();
        this.setVisible(false);
        df.setVisible(true);
        //This for show again the Main form when Close the Dispose Form
        df.addWindowListener(new java.awt.event.WindowAdapter() 
        {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e)
            {
                MainFrom.this.setVisible(true);
            }
        });
    }//GEN-LAST:event_btn_DisposeActionPerformed

    private void btn_RepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RepairActionPerformed
        Repair_Form rf = new Repair_Form();
        this.setVisible(false);
        rf.setVisible(true);
        
        
        //This is for pass User name for the Add Device Form Window
        String logUser = lbl_showSystemUser.getText().replace("Logged in as : ", "");
        rf.setLoggedInUser(logUser);
        
        
        rf.addWindowListener(new java.awt.event.WindowAdapter()
        {
             @Override
            public void windowClosed(java.awt.event.WindowEvent e)
            {
                MainFrom.this.setVisible(true);
            }
        });
        
        
    }//GEN-LAST:event_btn_RepairActionPerformed

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed

//        Report_Form rpt = new Report_Form();
        
        Get_Report rpt = new Get_Report();
        this.setVisible(false);
        rpt.setVisible(true);
        rpt.addWindowListener(new java.awt.event.WindowAdapter() 
        {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e)
            {
                MainFrom.this.setVisible(true);
            }
        });
    }//GEN-LAST:event_btn_reportActionPerformed

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        Login_Form lgf = new Login_Form(this);
        lgf.setVisible(true);
        lgf.addWindowListener(new java.awt.event.WindowAdapter() 
        {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e)
            {
                MainFrom.this.setVisible(true);
            }
        });
    }//GEN-LAST:event_btn_LoginActionPerformed

    private void jMenuItem_AddSysUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AddSysUserActionPerformed
        AddSystemUser adsys = new AddSystemUser();
        this.setVisible(false);
        adsys.setVisible(true);
        adsys.addWindowListener( new java.awt.event.WindowAdapter() 
        {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e)
            {
                MainFrom.this.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem_AddSysUserActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        logoutConfirmation();
        btn_Login.setEnabled(true);
        
        lbl_showSystemUser.setText("");
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed
        exitConfirmation();
    }//GEN-LAST:event_btn_ExitActionPerformed

    private void exitConfirmation()
    {
        int extConfirm;
        extConfirm = JOptionPane.showConfirmDialog(this, "Are you sure want to Exit from the Program" , "Exit Confirmation" , JOptionPane.YES_NO_OPTION);
        
        if(extConfirm == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    
    private void logoutConfirmation()
    {
        int confirm;
        confirm = JOptionPane.showConfirmDialog(this, "Are you sure want to Logout" , "Logout Confirmation" , JOptionPane.YES_NO_OPTION);
        
        if(confirm == JOptionPane.YES_OPTION)
        {
            setInvisible();
        }
    }
    
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
            java.util.logging.Logger.getLogger(MainFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddDevice;
    private javax.swing.JButton btn_Dispose;
    private javax.swing.JButton btn_Exit;
    private javax.swing.JButton btn_Handover;
    private javax.swing.JButton btn_Login;
    private javax.swing.JButton btn_Repair;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_report;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem_AddSysUser;
    private javax.swing.JLabel lbl_company;
    private javax.swing.JLabel lbl_showSystemUser;
    private javax.swing.JLabel lbl_techAssest;
    // End of variables declaration//GEN-END:variables
}



