/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForManagers;

import DB.DBConnection;
import DB.ManagerCredentials;
import DB.ManagerPageLogout;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoeAlpha
 */
public class Page6_Report extends javax.swing.JFrame implements Runnable {
    SimpleDateFormat timeFormat;// setting variable for time Format
    SimpleDateFormat dayFormat;// setting variable for day Format
    SimpleDateFormat dateFormat;// setting variable for date Format
    String time; // setting variable for current time
    String day; // setting variable for day
    String date; // setting variable for date

    /**
     * Creates new form Page2_Dashboard
     */
    public Page6_Report() {        
        initComponents();
        tbl_student_report();
        tbl_lecturer_report();

        // center the form
        this.setLocationRelativeTo(this);
        
        Thread t = new Thread(this);
        t.start();
        
        LecReport.setVisible(false);
        
        // displaying users info
        sideBarFname.setText(ManagerCredentials.fullname);
        sideBarOperator.setText(ManagerCredentials.operator_id); 
        topBarSerialNo.setText(ManagerCredentials.serial_no);
    }
    
    PreparedStatement sqlQueryCheck;
    PreparedStatement sqlQueryLogout;
    ResultSet res;
    Connection conn;
    
    DefaultTableModel defaulttbl_query_stud;
    DefaultTableModel defaulttbl_query_lec;
    
    private void tbl_student_report() {  
        try {
            conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_students");
            res = sqlQueryCheck.executeQuery();
            
            while(res.next()) {
                String studReg    = res.getString("reg_no");
                String studID     = res.getString("id_no");
                String studName   = res.getString("fullname");
                String studEmail  = res.getString("email");
                String studPhone  = "0"+res.getString("phone");
                String studGender = res.getString("gender");
                String studDob    = res.getString("date_ofbirth");
                
                Object[] obj = {studReg, studID, studName, studEmail, studPhone, studGender, studDob};
                
                defaulttbl_query_stud = (DefaultTableModel)tbl_student.getModel();
                defaulttbl_query_stud.addRow(obj);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page6_Report.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    
    private void tbl_lecturer_report() {  
        try {
            conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_lecturers");
            res = sqlQueryCheck.executeQuery();
            
            while(res.next()) {
                String lecSerial = res.getString("serial_no");
                String lecID     = res.getString("id_no");
                String lecName   = res.getString("fullname");
                String lecEmail  = res.getString("email");
                String lecPhone  = "0"+res.getString("phone");
                String lecGender = res.getString("gender");
                String lecDob    = res.getString("date_ofbirth");
                
                Object[] obj = {lecSerial, lecID, lecName, lecEmail, lecPhone, lecGender, lecDob};
                
                defaulttbl_query_lec = (DefaultTableModel)tbl_lecturer.getModel();
                defaulttbl_query_lec.addRow(obj);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page6_Report.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }

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
        txtLecturer = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        txtStudent = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        txtSettings1 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtSettings = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        topBarSerialNo = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtDay = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_student = new rojeru_san.complementos.RSTableMetro();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_lecturer = new rojeru_san.complementos.RSTableMetro();
        jPanel8 = new javax.swing.JPanel();
        StudReport = new javax.swing.JButton();
        LecReport = new javax.swing.JButton();
        tab_lecturer = new javax.swing.JButton();
        tab_student = new javax.swing.JButton();

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

        txtLecturer.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtLecturer.setForeground(new java.awt.Color(255, 255, 255));
        txtLecturer.setText("Lecturer");
        txtLecturer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtLecturer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLecturerMouseClicked(evt);
            }
        });
        jPanel37.add(txtLecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Lecturer.png"))); // NOI18N
        jPanel37.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 185, 150, 30));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setOpaque(false);
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStudent.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtStudent.setForeground(new java.awt.Color(255, 255, 255));
        txtStudent.setText("Students");
        txtStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStudentMouseClicked(evt);
            }
        });
        jPanel38.add(txtStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Student.png"))); // NOI18N
        jPanel38.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 240, 150, 30));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setOpaque(false);
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSettings1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtSettings1.setForeground(new java.awt.Color(255, 255, 255));
        txtSettings1.setText("Report");
        txtSettings1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSettings1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSettings1MouseClicked(evt);
            }
        });
        jPanel39.add(txtSettings1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 30));

        jPanel2.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 150, 30));

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

        jPanel2.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 480, 150, 30));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setOpaque(false);
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings.png"))); // NOI18N
        jPanel41.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        txtSettings.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtSettings.setForeground(new java.awt.Color(255, 255, 255));
        txtSettings.setText("Settings");
        txtSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSettingsMouseClicked(evt);
            }
        });
        jPanel41.add(txtSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        jPanel2.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 295, 150, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 550));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel12.setText("My Dashboard");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 160, 30));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setForeground(java.awt.SystemColor.windowBorder);
        jLabel8.setText("Serial No:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        topBarSerialNo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel5.add(topBarSerialNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 60, 100, 17));

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

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbl_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg No", "Id No", "Name", "Email", "Phone", "Gender", "DOB"
            }
        ));
        tbl_student.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_student.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_student.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_student.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_student.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_student.setFuenteHead(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_student.setGrosorBordeFilas(0);
        tbl_student.setGrosorBordeHead(0);
        tbl_student.setMultipleSeleccion(false);
        tbl_student.setRowHeight(25);
        jScrollPane1.setViewportView(tbl_student);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tbl_lecturer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg No", "Id No", "Name", "Email", "Phone", "Gender", "DOB"
            }
        ));
        tbl_lecturer.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_lecturer.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_lecturer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_lecturer.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_lecturer.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_lecturer.setFuenteHead(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_lecturer.setGrosorBordeFilas(0);
        tbl_lecturer.setGrosorBordeHead(0);
        tbl_lecturer.setMultipleSeleccion(false);
        tbl_lecturer.setRowHeight(25);
        jScrollPane2.setViewportView(tbl_lecturer);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel7);

        jPanel40.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 560, 430));

        jPanel1.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 560, 400));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StudReport.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        StudReport.setText("Generate Report");
        StudReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudReportActionPerformed(evt);
            }
        });
        jPanel8.add(StudReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 130, 30));

        LecReport.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        LecReport.setText("Generate Report");
        LecReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LecReportActionPerformed(evt);
            }
        });
        jPanel8.add(LecReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 130, 30));

        tab_lecturer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tab_lecturer.setText("Lecturers");
        tab_lecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab_lecturerActionPerformed(evt);
            }
        });
        jPanel8.add(tab_lecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 100, 30));

        tab_student.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tab_student.setText("Students");
        tab_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab_studentActionPerformed(evt);
            }
        });
        jPanel8.add(tab_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 100, 560, 40));

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

    private void txtLecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLecturerMouseClicked
        // Go to lecturer
        Page3_Lecturer mgtLec = new Page3_Lecturer();
        this.dispose();
        mgtLec.setVisible(true);
    }//GEN-LAST:event_txtLecturerMouseClicked

    private void txtStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStudentMouseClicked
        // Go to students
        Page4_Student mgtStud = new Page4_Student();
        this.dispose();
        mgtStud.setVisible(true);
    }//GEN-LAST:event_txtStudentMouseClicked

    private void txtSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSettingsMouseClicked
        // Go to settings
        Page5_Settings pwd = new Page5_Settings();
        this.dispose();
        pwd.setVisible(true);
    }//GEN-LAST:event_txtSettingsMouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // operation for login out
        String serialNo = topBarSerialNo.getText();
        
        try {
            conn = DBConnection.setConnection();
            sqlQueryLogout = conn.prepareStatement("update tbl_managers SET status='Offline' WHERE serial_no=? ");
            sqlQueryLogout.setString(1, serialNo);
            
            //if the logout is successfully the state of executeUpdate() will be 1
            if (sqlQueryLogout.executeUpdate() != 0) {
                // redirect to login
                Page1_Login login = new Page1_Login();

                // logout function
                ManagerPageLogout.logMeOut(this, login);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page6_Report.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel25MouseClicked

    private void StudReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudReportActionPerformed
        // Generate student report
        String path = "";
        
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        
        Document doc = new Document(); 

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+"student_report.pdf"));
            
            doc.open();
            PdfPTable tbl = new PdfPTable(7);
            
            // adding header
            tbl.addCell("Reg No");
            tbl.addCell("ID No");
            tbl.addCell("Name");
            tbl.addCell("Email");
            tbl.addCell("Phone");
            tbl.addCell("Gender");
            tbl.addCell("DOB");
            
            for (int i = 0; i < tbl_student.getRowCount(); i++) {
                String Reg    = tbl_student.getValueAt(i, 0).toString();
                String ID     = tbl_student.getValueAt(i, 1).toString();
                String Name   = tbl_student.getValueAt(i, 2).toString();
                String Email  = tbl_student.getValueAt(i, 3).toString();
                String Phone  = tbl_student.getValueAt(i, 4).toString();
                String Gender = tbl_student.getValueAt(i, 5).toString();
                String DOB    = tbl_student.getValueAt(i, 6).toString();
                
                tbl.addCell(Reg);
                tbl.addCell(ID);
                tbl.addCell(Name);
                tbl.addCell(Email);
                tbl.addCell(Phone);
                tbl.addCell(Gender);
                tbl.addCell(DOB);
            }
            
            doc.add(tbl);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Page6_Report.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Page6_Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doc.close();
    }//GEN-LAST:event_StudReportActionPerformed

    private void LecReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LecReportActionPerformed
        // Generate Lecturer Report
        String path = "";
        
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        
        Document doc = new Document(); 

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+"lecturer_report.pdf"));
            
            doc.open();
            PdfPTable tbl = new PdfPTable(7);
            
            // adding header
            tbl.addCell("Serial No");
            tbl.addCell("ID No");
            tbl.addCell("Name");
            tbl.addCell("Email");
            tbl.addCell("Phone");
            tbl.addCell("Gender");
            tbl.addCell("DOB");
            
            for (int i = 0; i < tbl_lecturer.getRowCount(); i++) {
                String Serial = tbl_lecturer.getValueAt(i, 0).toString();
                String ID     = tbl_lecturer.getValueAt(i, 1).toString();
                String Name   = tbl_lecturer.getValueAt(i, 2).toString();
                String Email  = tbl_lecturer.getValueAt(i, 3).toString();
                String Phone  = tbl_lecturer.getValueAt(i, 4).toString();
                String Gender = tbl_lecturer.getValueAt(i, 5).toString();
                String DOB    = tbl_lecturer.getValueAt(i, 6).toString();
                
                tbl.addCell(Serial);
                tbl.addCell(ID);
                tbl.addCell(Name);
                tbl.addCell(Email);
                tbl.addCell(Phone);
                tbl.addCell(Gender);
                tbl.addCell(DOB);
            }
            
            doc.add(tbl);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Page6_Report.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Page6_Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doc.close();
    }//GEN-LAST:event_LecReportActionPerformed

    private void tab_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab_studentActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        StudReport.setVisible(true);
        LecReport.setVisible(false);
    }//GEN-LAST:event_tab_studentActionPerformed

    private void tab_lecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab_lecturerActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        StudReport.setVisible(false);
        LecReport.setVisible(true);
    }//GEN-LAST:event_tab_lecturerActionPerformed

    private void txtSettings1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSettings1MouseClicked
        Page6_Report genReport = new Page6_Report();
        this.dispose();
        genReport.setVisible(true);
    }//GEN-LAST:event_txtSettings1MouseClicked

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
            java.util.logging.Logger.getLogger(Page6_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Page6_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Page6_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Page6_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Page6_Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LecReport;
    private javax.swing.JButton StudReport;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel sideBarFname;
    private javax.swing.JLabel sideBarOperator;
    private javax.swing.JButton tab_lecturer;
    private javax.swing.JButton tab_student;
    private rojeru_san.complementos.RSTableMetro tbl_lecturer;
    private rojeru_san.complementos.RSTableMetro tbl_student;
    private javax.swing.JLabel topBarSerialNo;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtDay;
    private javax.swing.JLabel txtLecturer;
    private javax.swing.JLabel txtSettings;
    private javax.swing.JLabel txtSettings1;
    private javax.swing.JLabel txtStudent;
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