/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForStudents;

import DB.DBConnection;
import DB.StudentCredentials;
import DB.StudentPageLogout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoeAlpha
 */
public class Page2_Dashboard extends javax.swing.JFrame implements Runnable {
    SimpleDateFormat timeFormat;// setting variable for time Format
    SimpleDateFormat dayFormat;// setting variable for day Format
    SimpleDateFormat dateFormat;// setting variable for date Format
    String time; // setting variable for current time
    String day; // setting variable for day
    String date; // setting variable for date

    /**
     * Creates new form Page2_Dashboard
     */
    public Page2_Dashboard() {        
        initComponents();

        // center the form
        this.setLocationRelativeTo(this);
        
        Thread t = new Thread(this);
        t.start();
        
        // displaying users info
        sideBarFname.setText(StudentCredentials.fullname);
        sideBarOperator.setText(StudentCredentials.operator_id); 
        topBarRegNo.setText(StudentCredentials.reg_no);
        bodyFname.setText(StudentCredentials.fullname);
        bodyOperatorId.setText(StudentCredentials.operator_id);
        bodyEmail.setText(StudentCredentials.email);
        bodyPhone.setText("0"+StudentCredentials.phone);
        bodyRegNo.setText(StudentCredentials.reg_no);
    }
    
    PreparedStatement sqlQueryCheck;
    PreparedStatement sqlQueryLogout;
    ResultSet res;
    Connection conn;
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sideBarOperator = new javax.swing.JLabel();
        sideBarFname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        txtDashboard = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        txtInteract = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        txtFeedback = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        txtSettings = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        topBarRegNo = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtDay = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bodyOperatorId = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        bodyRegNo = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        bodyEmail = new javax.swing.JLabel();
        bodyPhone = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        bodyFname = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(java.awt.SystemColor.textHighlight);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Masomo");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel20.setText("Bora");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 0, 50, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 17, 150, -1));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/holder1.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 40, 40));

        sideBarOperator.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sideBarOperator.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(sideBarOperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 21, 130, 20));

        sideBarFname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sideBarFname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(sideBarFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1, 130, 20));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setOpaque(true);
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 50, 160, 1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 60));

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setOpaque(false);
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDashboard.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtDashboard.setForeground(new java.awt.Color(255, 255, 255));
        txtDashboard.setText("Dashboard");
        txtDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDashboardMouseClicked(evt);
            }
        });
        jPanel34.add(txtDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home.png"))); // NOI18N
        jPanel34.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 130, 150, 30));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setOpaque(false);
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtInteract.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtInteract.setForeground(new java.awt.Color(255, 255, 255));
        txtInteract.setText("Interact");
        txtInteract.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtInteract.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtInteractMouseClicked(evt);
            }
        });
        jPanel37.add(txtInteract, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/interact.png"))); // NOI18N
        jPanel37.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 185, 150, 30));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setOpaque(false);
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFeedback.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtFeedback.setForeground(new java.awt.Color(255, 255, 255));
        txtFeedback.setText("Feedback");
        txtFeedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFeedbackMouseClicked(evt);
            }
        });
        jPanel38.add(txtFeedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/feedback.png"))); // NOI18N
        jPanel38.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 240, 150, 30));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setOpaque(false);
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSettings.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtSettings.setForeground(new java.awt.Color(255, 255, 255));
        txtSettings.setText("Settings");
        txtSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSettingsMouseClicked(evt);
            }
        });
        jPanel39.add(txtSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings.png"))); // NOI18N
        jPanel39.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 295, 150, 30));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setOpaque(false);
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Logout");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel32.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Logout.png"))); // NOI18N
        jPanel32.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 460, 150, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 550));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel12.setText("My Dashboard");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 160, 30));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setForeground(java.awt.SystemColor.windowBorder);
        jLabel8.setText("Reg No:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        topBarRegNo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel5.add(topBarRegNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 60, 100, 17));

        txtTime.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jPanel5.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 90, 17));

        txtDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 120, 17));

        txtDay.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        txtDay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel5.add(txtDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 100, 17));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 1, 600, 90));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));
        jPanel75.setOpaque(false);
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));
        jPanel83.setOpaque(false);
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel84.setBackground(new java.awt.Color(255, 255, 255));
        jPanel84.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel114.setText("3");
        jPanel84.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 35, 130, 20));

        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel115.setText("Manager Accounts");
        jPanel84.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 15, 130, 20));

        jPanel83.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 180, 70));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(java.awt.SystemColor.windowBorder);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Operator ID :");
        jPanel83.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 130, 150, 20));

        bodyOperatorId.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        bodyOperatorId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel83.add(bodyOperatorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 150, 150, 20));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logoBig.png"))); // NOI18N
        jPanel83.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 130));

        jPanel75.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 155, 190));

        jPanel85.setBackground(new java.awt.Color(255, 255, 255));
        jPanel85.setOpaque(false);
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel116.setText("3");
        jPanel86.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 35, 130, 20));

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel117.setText("Manager Accounts");
        jPanel86.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 15, 130, 20));

        jPanel85.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 180, 70));

        bodyRegNo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jPanel85.add(bodyRegNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, 20));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel23.setForeground(java.awt.SystemColor.windowBorder);
        jLabel23.setText("Phone number:");
        jPanel85.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        bodyEmail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jPanel85.add(bodyEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 320, 20));

        bodyPhone.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jPanel85.add(bodyPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 130, 20));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel34.setForeground(java.awt.SystemColor.windowBorder);
        jLabel34.setText("Full name:");
        jPanel85.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel35.setForeground(java.awt.SystemColor.windowBorder);
        jLabel35.setText("Email Address:");
        jPanel85.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        bodyFname.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jPanel85.add(bodyFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 170, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setForeground(java.awt.SystemColor.windowBorder);
        jLabel21.setText("Reg No:");
        jPanel85.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel75.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 345, 190));

        jLabel13.setBackground(java.awt.Color.lightGray);
        jLabel13.setOpaque(true);
        jPanel75.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 10, 1, 190));

        jPanel40.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 200));

        jPanel1.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 560, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDashboardMouseClicked
        // Go to dashboard
        Page2_Dashboard dash = new Page2_Dashboard();
        this.dispose();
        dash.setVisible(true);
    }//GEN-LAST:event_txtDashboardMouseClicked

    private void txtInteractMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtInteractMouseClicked
        // Go to lecturer
        Page3_Interact startInt = new Page3_Interact();
        this.dispose();
        startInt.setVisible(true);
    }//GEN-LAST:event_txtInteractMouseClicked

    private void txtFeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFeedbackMouseClicked
        // Go to students
        Page4_Feedback feedb = new Page4_Feedback();
        this.dispose();
        feedb.setVisible(true);
    }//GEN-LAST:event_txtFeedbackMouseClicked

    private void txtSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSettingsMouseClicked
        // Go to settings
        Page5_Settings pwd = new Page5_Settings();
        this.dispose();
        pwd.setVisible(true);
    }//GEN-LAST:event_txtSettingsMouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // operation for login out
        String regNo = topBarRegNo.getText();
        
        try {
            conn = DBConnection.setConnection();
            sqlQueryLogout = conn.prepareStatement("update tbl_students SET status='Offline' WHERE reg_no=? ");
            sqlQueryLogout.setString(1, regNo);
            
            //if the logout is successfully the state of executeUpdate() will be 1
            if (sqlQueryLogout.executeUpdate() != 0) {
                // redirect to login
                Page1_Login login = new Page1_Login();

                // logout function
                StudentPageLogout.logMeOut(this, login);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page2_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel25MouseClicked

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
            java.util.logging.Logger.getLogger(Page2_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Page2_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Page2_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Page2_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Page2_Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bodyEmail;
    private javax.swing.JLabel bodyFname;
    private javax.swing.JLabel bodyOperatorId;
    private javax.swing.JLabel bodyPhone;
    private javax.swing.JLabel bodyRegNo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JLabel sideBarFname;
    private javax.swing.JLabel sideBarOperator;
    private javax.swing.JLabel topBarRegNo;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtDay;
    private javax.swing.JLabel txtFeedback;
    private javax.swing.JLabel txtInteract;
    private javax.swing.JLabel txtSettings;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true) {
            try {
                timeFormat = new SimpleDateFormat("hh:mm:ss a");
                time = timeFormat.format(Calendar.getInstance().getTime());
                txtTime.setText(time);

                dayFormat = new SimpleDateFormat("EEEE");
                day = dayFormat.format(Calendar.getInstance().getTime());
                txtDay.setText(day);

                dateFormat = new SimpleDateFormat("dd MMM yyyy"); // setting the time
                date = dateFormat.format(Calendar.getInstance().getTime());// getting current date
                txtDate.setText(date);// displaying the date to the user
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
