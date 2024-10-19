
package tech_reports;

import dbconnection.ConnectionString;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Get_Report extends javax.swing.JFrame {


    public Get_Report() {
        initComponents();
        
        
        //This is for Close and Center the Position
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
        this.setLocationRelativeTo(null);
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_AvailableDevices = new javax.swing.JButton();
        btn_RepairReport = new javax.swing.JButton();
        btn_HandOverReport = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Tech Assets Management - System Generted Reports");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 24, 670, 47));

        btn_AvailableDevices.setBackground(new java.awt.Color(0, 204, 102));
        btn_AvailableDevices.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_AvailableDevices.setForeground(new java.awt.Color(0, 0, 0));
        btn_AvailableDevices.setText("<html>Report on<br>Available<br>Devices<br>Summery<br>Report</html>");
        btn_AvailableDevices.setBorder(null);
        btn_AvailableDevices.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AvailableDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AvailableDevicesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_AvailableDevices, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 160, 230));

        btn_RepairReport.setBackground(new java.awt.Color(0, 204, 102));
        btn_RepairReport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_RepairReport.setForeground(new java.awt.Color(0, 0, 0));
        btn_RepairReport.setText("<html>Report on<br>Devices<br>Undergoing<br>Repair and<br>Maintenance</html>");
        btn_RepairReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_RepairReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RepairReportActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RepairReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 160, 230));

        btn_HandOverReport.setBackground(new java.awt.Color(0, 204, 102));
        btn_HandOverReport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_HandOverReport.setForeground(new java.awt.Color(0, 0, 0));
        btn_HandOverReport.setText("<html>Report on<br>Overview of<br>Devices<br>Handover<br>Records</html>");
        btn_HandOverReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_HandOverReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HandOverReportActionPerformed(evt);
            }
        });
        getContentPane().add(btn_HandOverReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 160, 230));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Pick Your Customized Reports");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 270, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\05.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AvailableDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AvailableDevicesActionPerformed
       
        try
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";
            
            Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);
            
            JasperDesign jasperdesign = JRXmlLoader.load("D:\\Tech Asset Managemen System\\Tech_Assest_Management_System\\src\\tech_reports\\available_device.jrxml");
            
            JRDesignQuery jrdQuery = new JRDesignQuery();
            jrdQuery.setText("SELECT Category , DeCode , Brand , DeCondition FROM devicemaster WHERE Status = '3' Order by Category");
            
            jasperdesign.setQuery(jrdQuery);
            
            //Compile the report
            JasperReport available_device = JasperCompileManager.compileReport(jasperdesign);
     
            //Fill the Report
            JasperPrint print1 = JasperFillManager.fillReport(available_device , null , con);
            
            //View the Report in Non Model ----> when we are using this , all program not close when close the report
            //That Meaning is only report is Close. program not close
            JasperViewer.viewReport(print1 , false);

            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Available Device Report Exception " + e , "Error" , JOptionPane.ERROR_MESSAGE);
        }
        

        
    }//GEN-LAST:event_btn_AvailableDevicesActionPerformed

    private void btn_HandOverReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HandOverReportActionPerformed
        
        try
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";
            
            Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);
            
            JasperDesign jasperdesign = JRXmlLoader.load("D:\\Tech Asset Managemen System\\Tech_Assest_Management_System\\src\\tech_reports\\handover_device.jrxml");
            
            JRDesignQuery jrdQuery = new JRDesignQuery();
            jrdQuery.setText("SELECT DeCode , Category , Department , EmpNo ,EmpName FROM `handoverdetails` WHERE Status = '4' ORDER by Department");
            
            jasperdesign.setQuery(jrdQuery);
            
            //Compile the report
            JasperReport handover_device = JasperCompileManager.compileReport(jasperdesign);
     
            //Fill the Report
            JasperPrint print1 = JasperFillManager.fillReport(handover_device , null , con);
            
            //View the Report in Non Model
            JasperViewer.viewReport(print1 , false);

            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Available Device Report Exception " + e , "Error" , JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_HandOverReportActionPerformed

    private void btn_RepairReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RepairReportActionPerformed
        
        try
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";
            
            Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);
            
            JasperDesign jasperdesign = JRXmlLoader.load("D:\\Tech Asset Managemen System\\Tech_Assest_Management_System\\src\\tech_reports\\repair_device.jrxml");
            
            JRDesignQuery jrdQuery = new JRDesignQuery();
            jrdQuery.setText("SELECT DeCode , Category , Department , EmpName , Reason FROM `repair` WHERE Status = '5' order by Category;");
            
            jasperdesign.setQuery(jrdQuery);
            
            //Compile the report
            JasperReport repair_device = JasperCompileManager.compileReport(jasperdesign);
     
            //Fill the Report
            JasperPrint print1 = JasperFillManager.fillReport(repair_device , null , con);
            
            //View the Report in Non Model
            JasperViewer.viewReport(print1 , false);

            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Available Device Report Exception " + e , "Error" , JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_RepairReportActionPerformed

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
            java.util.logging.Logger.getLogger(Get_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Get_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Get_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Get_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Get_Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AvailableDevices;
    private javax.swing.JButton btn_HandOverReport;
    private javax.swing.JButton btn_RepairReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
