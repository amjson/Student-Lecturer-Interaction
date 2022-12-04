/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForAdmin;

import DB.AdminCredentials;
import DB.AdminPageLogout;
import DB.Admin_AccessLec_Credentials;
import DB.DBConnection;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoeAlpha
 */
public class Page4_Lecturer extends javax.swing.JFrame implements Runnable {
    SimpleDateFormat timeFormat;// setting variable for time Format
    SimpleDateFormat dayFormat;// setting variable for day Format
    SimpleDateFormat dateFormat;// setting variable for date Format
    String time; // setting variable for current time
    String day; // setting variable for day
    String date; // setting variable for date

    /**
     * Creates new form Page2_Dashboard
     */
    public Page4_Lecturer() {        
        initComponents();
        lecturers_table();
        overview_table();

        // center the form
        this.setLocationRelativeTo(this);
        
        Thread t = new Thread(this);
        t.start();
        
        // creating button group for gender radio buttons
        ButtonGroup bgGroup = new ButtonGroup();
        bgGroup.add(btnMale);
        bgGroup.add(btnFemale);
        
        btnViewLec.setVisible(false);
        btnDelLec.setVisible(false);
        btnGoBackToView.setVisible(false);
        queryInDetail.setVisible(false);
        commentInDetail.setVisible(false);
        
        // displaying users info
        sideBarFname.setText(AdminCredentials.fullname);
        sideBarOperator.setText(AdminCredentials.operator_id); 
        topBarSerialNo.setText(AdminCredentials.serial_no);
    }
    
    // universal variables
    SimpleDateFormat dateofbirth; 
    
    PreparedStatement sqlQueryCheck;
    PreparedStatement sqlQueryInsert;
    PreparedStatement sqlQueryDelCourse;
    PreparedStatement sqlQueryLogout;
    ResultSet res;
    Connection conn;
    
    DefaultTableModel defaulttbl_1_query;
    DefaultTableModel defaulttbl_2_view; 
    DefaultTableModel defaulttbl_3_delete; 
    DefaultTableModel defaulttbl_4_course;
    DefaultTableModel defaulttbl_5_details;    
    DefaultTableModel defaulttbl_6_overview; 
    DefaultTableModel defaulttbl_6_individual;
    
    
    // view all lecturers
    private void lecturers_table() {
        try {
            conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_lecturers");
            res = sqlQueryCheck.executeQuery();
            
            while(res.next()) {
                String lcId     = res.getString("id");
                String lcSerial = res.getString("serial_no");
                String lcFname  = res.getString("fullname");
                String lcPhone  = "0"+res.getString("phone");
                String lcGender = res.getString("gender");
                
                Object[] obj = {lcId, lcSerial, lcFname, lcPhone, lcGender};
                
                defaulttbl_1_query = (DefaultTableModel)tbl_lecturers.getModel();
                defaulttbl_1_query.addRow(obj);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page4_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // view overview of a lecturer
    private void overview_table() {  
        try {
            conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_interaction");
            res = sqlQueryCheck.executeQuery();
            
            while(res.next()) {
                String feedbId   = res.getString("msg_id");
                String studFname = res.getString("stud_fname");
                String lecturer  = res.getString("lec_fname");
                String msgLBL    = res.getString("msg_lbl");
                String sentOn    = res.getString("date_sent");
                String msgStatus = res.getString("msg_status");
                
                Object[] obj = {feedbId, studFname, lecturer, msgLBL, sentOn, msgStatus};
                
                defaulttbl_5_details = (DefaultTableModel)tbl_myOverview.getModel();
                defaulttbl_5_details.addRow(obj);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page4_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel36 = new javax.swing.JPanel();
        txtManager = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        txtLecturer = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        txtStudent = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        txtSettings = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        txtSettings1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        topBarSerialNo = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtDay = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        btnShowAllLec1 = new javax.swing.JButton();
        btnGoToAddLec = new javax.swing.JButton();
        btnViewLec = new javax.swing.JButton();
        btnDelLec = new javax.swing.JButton();
        btnGoBackToView = new javax.swing.JButton();
        queryInDetail = new javax.swing.JButton();
        commentInDetail = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_lecturers = new rojeru_san.complementos.RSTableMetro();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lecSerial = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lecDob = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        lecIdNo = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        lecFname = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        lecGender = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lecEmail = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lecPhone = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        btnGoToRegCourse = new javax.swing.JButton();
        btnGoToMyCourses = new javax.swing.JButton();
        btnGoToOverview = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        regLine = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtSerialNo = new javax.swing.JTextField();
        errorSerial = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        fnameLine = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        errorFname = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        idnoLine = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtIdNo = new javax.swing.JTextField();
        errorId = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        emailLine = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        errorEmail = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        passwordLine = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        errorPassword = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        phoneLine = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        errorPhone = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtDob = new com.toedter.calendar.JDateChooser();
        jPanel52 = new javax.swing.JPanel();
        btnFemale = new javax.swing.JRadioButton();
        btnMale = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        btnCreateAcc = new javax.swing.JButton();
        btnResetAccForm = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        LecInfoFname = new javax.swing.JLabel();
        LecInfoSerial = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        CourseInfoYoc = new com.toedter.calendar.JDateChooser();
        jPanel56 = new javax.swing.JPanel();
        courseBarLine = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        courseInfoName = new javax.swing.JTextField();
        jPanel57 = new javax.swing.JPanel();
        dur_semBarLine = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        courseInfoLevel = new javax.swing.JTextField();
        jPanel58 = new javax.swing.JPanel();
        progBarLine = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        courseInfoProg = new javax.swing.JTextField();
        jPanel59 = new javax.swing.JPanel();
        unitBarLine = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        courseInfoUnit = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        btnRegCourse = new javax.swing.JButton();
        btnResetCourseForm = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_myCourse = new rojeru_san.complementos.RSTableMetro();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_myOverview = new rojeru_san.complementos.RSTableMetro();
        jPanel16 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        replyToQueryMsg = new javax.swing.JTextArea();
        replyToRegQuery = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        replyToFnameQuery = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        queryDateSent = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        queryRetrieveMsg = new javax.swing.JTextArea();
        jLabel84 = new javax.swing.JLabel();
        queryDateSent2 = new javax.swing.JLabel();
        queryRetrievePath = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        replyToCommentMsg = new javax.swing.JTextArea();
        replyToRegComment = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        replyToFnameComment = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        commentDateSent = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        commentRetrieveMsg = new javax.swing.JTextArea();
        jLabel82 = new javax.swing.JLabel();
        commentRepliedOn = new javax.swing.JLabel();

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

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setOpaque(false);
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtManager.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtManager.setForeground(new java.awt.Color(255, 255, 255));
        txtManager.setText("Managers");
        txtManager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtManagerMouseClicked(evt);
            }
        });
        jPanel36.add(txtManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Manager.png"))); // NOI18N
        jPanel36.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 185, 150, 30));

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

        jPanel2.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 240, 150, 30));

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

        jPanel2.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 295, 150, 30));

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

        jPanel2.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 350, 150, 30));

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

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setOpaque(false);
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSettings1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtSettings1.setForeground(new java.awt.Color(255, 255, 255));
        txtSettings1.setText("Report");
        txtSettings1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSettings1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSettings1MouseClicked(evt);
            }
        });
        jPanel60.add(txtSettings1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings.png"))); // NOI18N
        jPanel60.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 405, 150, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 550));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel12.setText("Manage Lecturers");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 200, 30));

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

        jPanel41.setOpaque(false);
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnShowAllLec1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnShowAllLec1.setText("Show All");
        btnShowAllLec1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowAllLec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllLec1ActionPerformed(evt);
            }
        });
        jPanel41.add(btnShowAllLec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        btnGoToAddLec.setBackground(java.awt.SystemColor.textHighlight);
        btnGoToAddLec.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnGoToAddLec.setForeground(new java.awt.Color(255, 255, 255));
        btnGoToAddLec.setText("Add");
        btnGoToAddLec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoToAddLec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToAddLecActionPerformed(evt);
            }
        });
        jPanel41.add(btnGoToAddLec, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 70, 30));

        btnViewLec.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnViewLec.setText("View");
        btnViewLec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewLec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewLecActionPerformed(evt);
            }
        });
        jPanel41.add(btnViewLec, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 70, 30));

        btnDelLec.setBackground(java.awt.Color.red);
        btnDelLec.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnDelLec.setForeground(new java.awt.Color(255, 255, 255));
        btnDelLec.setText("Delete");
        btnDelLec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelLec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelLecActionPerformed(evt);
            }
        });
        jPanel41.add(btnDelLec, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 70, 30));

        btnGoBackToView.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnGoBackToView.setText("Go Back");
        btnGoBackToView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoBackToView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackToViewActionPerformed(evt);
            }
        });
        jPanel41.add(btnGoBackToView, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 100, 30));

        queryInDetail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        queryInDetail.setText("View in Details");
        queryInDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        queryInDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryInDetailActionPerformed(evt);
            }
        });
        jPanel41.add(queryInDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 110, 30));

        commentInDetail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        commentInDetail.setText("View in Details");
        commentInDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        commentInDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentInDetailActionPerformed(evt);
            }
        });
        jPanel41.add(commentInDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 110, 30));

        jPanel1.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 560, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tbl_lecturers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# ", "Serial", "Full Name", "Phone", "Gender"
            }
        ));
        tbl_lecturers.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tbl_lecturers.setColorBordeHead(new java.awt.Color(0, 112, 192));
        tbl_lecturers.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_lecturers.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_lecturers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_lecturers.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_lecturers.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_lecturers.setFuenteHead(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_lecturers.setGrosorBordeFilas(0);
        tbl_lecturers.setGrosorBordeHead(0);
        tbl_lecturers.setMultipleSeleccion(false);
        tbl_lecturers.setRowHeight(25);
        tbl_lecturers.setShowHorizontalLines(false);
        tbl_lecturers.setShowVerticalLines(false);
        tbl_lecturers.getTableHeader().setReorderingAllowed(false);
        tbl_lecturers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_lecturersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_lecturers);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("View Lecturer Info");

        jPanel45.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel45.setOpaque(false);
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(java.awt.SystemColor.windowBorder);
        jLabel6.setText("Serial No:");
        jPanel45.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lecSerial.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel45.add(lecSerial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, 20));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(java.awt.SystemColor.windowBorder);
        jLabel19.setText("Date of Birth:");
        jPanel45.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        lecDob.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel45.add(lecDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 140, 20));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel50.setForeground(java.awt.SystemColor.windowBorder);
        jLabel50.setText("ID No:");
        jPanel45.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lecIdNo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel45.add(lecIdNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 20));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel52.setForeground(java.awt.SystemColor.windowBorder);
        jLabel52.setText("Full name:");
        jPanel45.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        lecFname.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel45.add(lecFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 320, 20));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel54.setForeground(java.awt.SystemColor.windowBorder);
        jLabel54.setText("Gender:");
        jPanel45.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        lecGender.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel45.add(lecGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 150, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Basic Infomartion");
        jPanel45.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 5, -1, -1));

        jPanel46.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel46.setOpaque(false);
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setForeground(java.awt.SystemColor.windowBorder);
        jLabel18.setText("Email Address:");
        jPanel46.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lecEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel46.add(lecEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, 20));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel40.setForeground(java.awt.SystemColor.windowBorder);
        jLabel40.setText("Phone number:");
        jPanel46.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        lecPhone.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel46.add(lecPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 160, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Contact Infomartion");
        jPanel46.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 5, -1, -1));

        jPanel42.setOpaque(false);
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGoToRegCourse.setBackground(java.awt.SystemColor.textHighlight);
        btnGoToRegCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnGoToRegCourse.setText("Register Course");
        btnGoToRegCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoToRegCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToRegCourseActionPerformed(evt);
            }
        });
        jPanel42.add(btnGoToRegCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 135, 31));

        btnGoToMyCourses.setText("View My Courses");
        btnGoToMyCourses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoToMyCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToMyCoursesActionPerformed(evt);
            }
        });
        jPanel42.add(btnGoToMyCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 140, 30));

        btnGoToOverview.setText("Overview");
        btnGoToOverview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToOverviewActionPerformed(evt);
            }
        });
        jPanel42.add(btnGoToOverview, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 0, 115, 31));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel43.setOpaque(false);
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regLine.setBackground(java.awt.Color.darkGray);
        regLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel43.add(regLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 225, 1));
        jPanel43.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 30, 27));

        txtSerialNo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSerialNo.setForeground(java.awt.Color.gray);
        txtSerialNo.setText("serial no. (mb1234567890)");
        txtSerialNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtSerialNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSerialNoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerialNoFocusLost(evt);
            }
        });
        txtSerialNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerialNoKeyReleased(evt);
            }
        });
        jPanel43.add(txtSerialNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 25));

        errorSerial.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        errorSerial.setForeground(java.awt.Color.red);
        jPanel43.add(errorSerial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 33, 226, 19));

        jPanel44.setOpaque(false);
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fnameLine.setBackground(java.awt.Color.darkGray);
        fnameLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel44.add(fnameLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 225, 1));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user.png"))); // NOI18N
        jPanel44.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 30, 27));

        txtFullname.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtFullname.setForeground(java.awt.Color.gray);
        txtFullname.setText("fullname");
        txtFullname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFullname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFullnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFullnameFocusLost(evt);
            }
        });
        txtFullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFullnameKeyReleased(evt);
            }
        });
        jPanel44.add(txtFullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 25));

        errorFname.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        errorFname.setForeground(java.awt.Color.red);
        jPanel44.add(errorFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 33, 230, 19));

        jPanel47.setOpaque(false);
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idnoLine.setBackground(java.awt.Color.darkGray);
        idnoLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel47.add(idnoLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 225, 1));
        jPanel47.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 30, 27));

        txtIdNo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtIdNo.setForeground(java.awt.Color.gray);
        txtIdNo.setText("id no. (123456789)");
        txtIdNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtIdNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdNoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdNoFocusLost(evt);
            }
        });
        txtIdNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdNoKeyReleased(evt);
            }
        });
        jPanel47.add(txtIdNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 25));

        errorId.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        errorId.setForeground(java.awt.Color.red);
        jPanel47.add(errorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 33, 226, 19));

        jPanel48.setOpaque(false);
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailLine.setBackground(java.awt.Color.darkGray);
        emailLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel48.add(emailLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 225, 1));
        jPanel48.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 30, 27));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtEmail.setForeground(java.awt.Color.gray);
        txtEmail.setText("someone@newmail.com");
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        jPanel48.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 25));

        errorEmail.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        errorEmail.setForeground(java.awt.Color.red);
        jPanel48.add(errorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 33, 226, 19));

        jPanel49.setOpaque(false);
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        passwordLine.setBackground(java.awt.Color.darkGray);
        passwordLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel49.add(passwordLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 225, 1));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Lock.png"))); // NOI18N
        jPanel49.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 30, 27));

        txtPassword.setForeground(java.awt.Color.gray);
        txtPassword.setText("yourpassword");
        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        jPanel49.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 25));

        errorPassword.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        errorPassword.setForeground(java.awt.Color.red);
        jPanel49.add(errorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 33, 250, 19));

        jPanel50.setOpaque(false);
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        phoneLine.setBackground(java.awt.Color.darkGray);
        phoneLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel50.add(phoneLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 225, 1));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/phone.png"))); // NOI18N
        jPanel50.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 30, 27));

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtPhone.setForeground(java.awt.Color.gray);
        txtPhone.setText("07xxxxxxxx");
        txtPhone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneFocusLost(evt);
            }
        });
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });
        jPanel50.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 25));

        errorPhone.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        errorPhone.setForeground(java.awt.Color.red);
        jPanel50.add(errorPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 33, 226, 19));

        jPanel51.setOpaque(false);
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Date Of Birth:");
        jPanel51.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        txtDob.setToolTipText("Date of Birth"); // NOI18N
        txtDob.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDob.setOpaque(false);
        jPanel51.add(txtDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, 30));

        jPanel52.setOpaque(false);
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFemale.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnFemale.setText("Female");
        btnFemale.setOpaque(false);
        jPanel52.add(btnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        btnMale.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnMale.setSelected(true);
        btnMale.setText("Male");
        btnMale.setOpaque(false);
        jPanel52.add(btnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Create New Lecturer Account");

        btnCreateAcc.setBackground(java.awt.SystemColor.textHighlight);
        btnCreateAcc.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateAcc.setText("Create");
        btnCreateAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccActionPerformed(evt);
            }
        });

        btnResetAccForm.setText("Reset");
        btnResetAccForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetAccForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAccFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                    .addComponent(btnCreateAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnResetAccForm, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreateAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnResetAccForm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jPanel53.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel53.setOpaque(false);
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel26.setForeground(java.awt.SystemColor.windowBorder);
        jLabel26.setText("Serial No:");
        jPanel53.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 60, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel41.setForeground(java.awt.SystemColor.windowBorder);
        jLabel41.setText("Fullname:");
        jPanel53.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Lecturer Infomartion");
        jPanel53.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 5, -1, -1));

        LecInfoFname.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel53.add(LecInfoFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 220, 20));

        LecInfoSerial.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel53.add(LecInfoSerial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, 20));

        jPanel54.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel54.setOpaque(false);
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Course Infomartion");
        jPanel54.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 5, -1, -1));

        jPanel55.setOpaque(false);
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel38.setText("Date of Course:");
        jPanel55.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        CourseInfoYoc.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.add(CourseInfoYoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 30));

        jPanel54.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 220, 50));

        jPanel56.setOpaque(false);
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        courseBarLine.setBackground(java.awt.Color.darkGray);
        courseBarLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel56.add(courseBarLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 225, 1));
        jPanel56.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 30, 27));

        courseInfoName.setForeground(java.awt.Color.gray);
        courseInfoName.setText("course name (cit/dit/accounts)");
        courseInfoName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        courseInfoName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                courseInfoNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                courseInfoNameFocusLost(evt);
            }
        });
        jPanel56.add(courseInfoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 25));

        jPanel54.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 220, -1));

        jPanel57.setOpaque(false);
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dur_semBarLine.setBackground(java.awt.Color.darkGray);
        dur_semBarLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel57.add(dur_semBarLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 225, 1));
        jPanel57.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 30, 27));

        courseInfoLevel.setForeground(java.awt.Color.gray);
        courseInfoLevel.setText("semester level (stage 1/stage 2)");
        courseInfoLevel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        courseInfoLevel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                courseInfoLevelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                courseInfoLevelFocusLost(evt);
            }
        });
        jPanel57.add(courseInfoLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 25));

        jPanel54.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 220, -1));

        jPanel58.setOpaque(false);
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progBarLine.setBackground(java.awt.Color.darkGray);
        progBarLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel58.add(progBarLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 225, 1));
        jPanel58.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 30, 27));

        courseInfoProg.setForeground(java.awt.Color.gray);
        courseInfoProg.setText("program (certificate/diploma)");
        courseInfoProg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        courseInfoProg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                courseInfoProgFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                courseInfoProgFocusLost(evt);
            }
        });
        jPanel58.add(courseInfoProg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 25));

        jPanel54.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 40));

        jPanel59.setOpaque(false);
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        unitBarLine.setBackground(java.awt.Color.darkGray);
        unitBarLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel59.add(unitBarLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 225, 1));
        jPanel59.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 30, 27));

        courseInfoUnit.setForeground(java.awt.Color.gray);
        courseInfoUnit.setText("unit name");
        courseInfoUnit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        courseInfoUnit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                courseInfoUnitFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                courseInfoUnitFocusLost(evt);
            }
        });
        jPanel59.add(courseInfoUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 25));

        jPanel54.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 220, 40));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Course Registration");

        btnRegCourse.setBackground(java.awt.SystemColor.textHighlight);
        btnRegCourse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnRegCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnRegCourse.setText("Register");
        btnRegCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegCourseActionPerformed(evt);
            }
        });

        btnResetCourseForm.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnResetCourseForm.setText("Reset");
        btnResetCourseForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetCourseForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetCourseFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btnRegCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnResetCourseForm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                            .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetCourseForm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab4", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        tbl_myCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Program", "Course", "Level", "Unit"
            }
        ));
        tbl_myCourse.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tbl_myCourse.setColorBordeHead(new java.awt.Color(0, 112, 192));
        tbl_myCourse.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_myCourse.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_myCourse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_myCourse.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_myCourse.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_myCourse.setFuenteHead(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_myCourse.setGrosorBordeFilas(0);
        tbl_myCourse.setGrosorBordeHead(0);
        tbl_myCourse.setMultipleSeleccion(false);
        tbl_myCourse.setRowHeight(25);
        tbl_myCourse.setShowHorizontalLines(false);
        tbl_myCourse.setShowVerticalLines(false);
        tbl_myCourse.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_myCourse);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab5", jPanel11);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        tbl_myOverview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "From", "To", "Label", "Date Sent", "Status"
            }
        ));
        tbl_myOverview.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tbl_myOverview.setColorBordeHead(new java.awt.Color(0, 112, 192));
        tbl_myOverview.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_myOverview.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_myOverview.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_myOverview.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_myOverview.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_myOverview.setFuenteHead(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_myOverview.setGrosorBordeFilas(0);
        tbl_myOverview.setGrosorBordeHead(0);
        tbl_myOverview.setMultipleSeleccion(false);
        tbl_myOverview.setRowHeight(25);
        tbl_myOverview.setShowHorizontalLines(false);
        tbl_myOverview.setShowVerticalLines(false);
        tbl_myOverview.getTableHeader().setReorderingAllowed(false);
        tbl_myOverview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_myOverviewMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_myOverview);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab6", jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Replied Query");

        jPanel64.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel64.setOpaque(false);
        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel74.setText("Query Information");
        jPanel64.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel81.setForeground(java.awt.SystemColor.windowBorder);
        jLabel81.setText("Reg No: ");
        jPanel64.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        replyToQueryMsg.setEditable(false);
        replyToQueryMsg.setColumns(20);
        replyToQueryMsg.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        replyToQueryMsg.setLineWrap(true);
        replyToQueryMsg.setRows(5);
        replyToQueryMsg.setBorder(null);
        jScrollPane5.setViewportView(replyToQueryMsg);

        jPanel64.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 490, 70));
        jPanel64.add(replyToRegQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 110, 16));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel77.setForeground(java.awt.SystemColor.windowBorder);
        jLabel77.setText("Student Name:");
        jPanel64.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));
        jPanel64.add(replyToFnameQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 220, 16));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel83.setForeground(java.awt.SystemColor.windowBorder);
        jLabel83.setText("Was sent on:");
        jPanel64.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 30));

        queryDateSent.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel64.add(queryDateSent, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 6, 150, 20));

        jPanel65.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel65.setOpaque(false);

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel85.setText("Reply Section");

        queryRetrieveMsg.setEditable(false);
        queryRetrieveMsg.setColumns(20);
        queryRetrieveMsg.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        queryRetrieveMsg.setLineWrap(true);
        queryRetrieveMsg.setRows(5);
        queryRetrieveMsg.setBorder(null);
        jScrollPane17.setViewportView(queryRetrieveMsg);

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel84.setForeground(java.awt.SystemColor.windowBorder);
        jLabel84.setText("Replied on:");

        queryDateSent2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        queryRetrievePath.setForeground(new java.awt.Color(0, 112, 192));
        queryRetrievePath.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jLabel84)
                .addGap(13, 13, 13)
                .addComponent(queryDateSent2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addComponent(queryRetrievePath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(queryDateSent2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(queryRetrievePath, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab7", jPanel16);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Replied Comment");

        jPanel72.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel72.setOpaque(false);

        jLabel95.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel95.setText("Comment Information");

        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel96.setForeground(java.awt.SystemColor.windowBorder);
        jLabel96.setText("Reg No: ");

        replyToCommentMsg.setEditable(false);
        replyToCommentMsg.setColumns(20);
        replyToCommentMsg.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        replyToCommentMsg.setLineWrap(true);
        replyToCommentMsg.setRows(5);
        replyToCommentMsg.setBorder(null);
        jScrollPane13.setViewportView(replyToCommentMsg);

        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel97.setForeground(java.awt.SystemColor.windowBorder);
        jLabel97.setText("Student Name:");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel76.setForeground(java.awt.SystemColor.windowBorder);
        jLabel76.setText("Was sent on:");

        commentDateSent.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel72Layout.createSequentialGroup()
                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel72Layout.createSequentialGroup()
                                .addComponent(jLabel96)
                                .addGap(5, 5, 5)
                                .addComponent(replyToRegComment, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel95))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel72Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addGap(13, 13, 13)
                                .addComponent(commentDateSent, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel72Layout.createSequentialGroup()
                                .addComponent(jLabel97)
                                .addGap(11, 11, 11)
                                .addComponent(replyToFnameComment, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95)
                    .addComponent(jLabel76)
                    .addComponent(commentDateSent, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel96)
                    .addComponent(replyToRegComment, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97)
                    .addComponent(replyToFnameComment, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel73.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel73.setOpaque(false);
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel99.setText("Reply Section");
        jPanel73.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        commentRetrieveMsg.setEditable(false);
        commentRetrieveMsg.setColumns(20);
        commentRetrieveMsg.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        commentRetrieveMsg.setLineWrap(true);
        commentRetrieveMsg.setRows(5);
        commentRetrieveMsg.setBorder(null);
        jScrollPane16.setViewportView(commentRetrieveMsg);

        jPanel73.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 490, 100));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel82.setForeground(java.awt.SystemColor.windowBorder);
        jLabel82.setText("Replied on:");
        jPanel73.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        commentRepliedOn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel73.add(commentRepliedOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 150, 16));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 370));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab8", jPanel20);

        jPanel6.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 560, 430));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 560, 400));

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

    private void txtManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtManagerMouseClicked
        // Go to managers
        Page3_Manager mgtManage = new Page3_Manager();
        this.dispose();
        mgtManage.setVisible(true);
    }//GEN-LAST:event_txtManagerMouseClicked

    private void txtLecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLecturerMouseClicked
        // Go to lecturer
        Page4_Lecturer mgtLec = new Page4_Lecturer();
        this.dispose();
        mgtLec.setVisible(true);
    }//GEN-LAST:event_txtLecturerMouseClicked

    private void txtStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStudentMouseClicked
        // Go to students
        Page5_Student mgtStud = new Page5_Student();
        this.dispose();
        mgtStud.setVisible(true);
    }//GEN-LAST:event_txtStudentMouseClicked

    private void txtSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSettingsMouseClicked
        // Go to settings
        Page6_Settings pwd = new Page6_Settings();
        this.dispose();
        pwd.setVisible(true);
    }//GEN-LAST:event_txtSettingsMouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // operation for login out
        String serialNo = topBarSerialNo.getText();
        
        try {
            conn = DBConnection.setConnection();
            sqlQueryLogout = conn.prepareStatement("update tbl_admin SET status='Offline' WHERE serial_no=? ");
            sqlQueryLogout.setString(1, serialNo);
            
            //if the logout is successfully the state of executeUpdate() will be 1
            if (sqlQueryLogout.executeUpdate() != 0) {
                // redirect to login
                Page1_Login login = new Page1_Login();

                // logout function
                AdminPageLogout.logMeOut(this, login);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page4_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel25MouseClicked

    private void btnShowAllLec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllLec1ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        btnViewLec.setVisible(false);
        btnDelLec.setVisible(false);
        btnGoBackToView.setVisible(false);
        queryInDetail.setVisible(false);
        commentInDetail.setVisible(false);
    }//GEN-LAST:event_btnShowAllLec1ActionPerformed

    private void btnGoToAddLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToAddLecActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        btnViewLec.setVisible(false);
        btnDelLec.setVisible(false);
        btnGoBackToView.setVisible(false);
        queryInDetail.setVisible(false);
    }//GEN-LAST:event_btnGoToAddLecActionPerformed

    private void btnViewLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLecActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        queryInDetail.setVisible(false);
    }//GEN-LAST:event_btnViewLecActionPerformed

    private void btnDelLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelLecActionPerformed
        // Operation for deleting lecturer account
        String serialNo = lecSerial.getText();
        
        try {
            defaulttbl_3_delete = (DefaultTableModel)tbl_lecturers.getModel();
            int selectIndex = tbl_lecturers.getSelectedRow();

            int id = Integer.parseInt(defaulttbl_3_delete.getValueAt(selectIndex, 0).toString());

            // confirmation message
            JOptionPane.showMessageDialog(null, "Do you want to Delete Account of this Lecturer !!");
            int dialogResult = JOptionPane.showConfirmDialog(null, "All courses registered under this account will be deleted also", "Warnimg", JOptionPane.YES_NO_OPTION);

            if(dialogResult == JOptionPane.YES_OPTION){
                try {
                    Connection conn = DBConnection.setConnection();
                    sqlQueryCheck = conn.prepareStatement("delete from tbl_lecturers where id=?");
                    sqlQueryCheck.setInt(1, id);
                    
                    //if account is deleted successfully also delete courses registered under this account
                    if (sqlQueryCheck.executeUpdate() != 0) {
                        // also delete all courses that the deleted student had already registered
                        sqlQueryDelCourse = conn.prepareStatement("delete from tbl_lecturers_course where serial_no=?");
                        sqlQueryDelCourse.setString(1, serialNo);
                        sqlQueryDelCourse.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Lecturer Account has been Deleted Successfully");
                        
                        lecturers_table();

                        // refreshing the current page
                        new Page4_Lecturer().setVisible(true);
                        this.dispose();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Page4_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No Account has been selected!", "Warnimg", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDelLecActionPerformed

    private void btnGoBackToViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackToViewActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        btnViewLec.setVisible(true);
        btnDelLec.setVisible(true);
        queryInDetail.setVisible(false);
        commentInDetail.setVisible(false);
    }//GEN-LAST:event_btnGoBackToViewActionPerformed

    
    /**
     * Form Validation
     */
    private void txtSerialNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerialNoFocusGained
        if(txtSerialNo.getText().trim().toLowerCase().equals("serial no. (mb1234567890)")){
            txtSerialNo.setText("");
            txtSerialNo.setForeground(Color.black);
            regLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtSerialNoFocusGained

    private void txtSerialNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerialNoFocusLost
        if(txtSerialNo.getText().trim().equals("") || txtSerialNo.getText().trim().equals("serial no. (mb1234567890)")){
            txtSerialNo.setText("serial no. (mb1234567890)");
            txtSerialNo.setForeground(Color.gray);
            regLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtSerialNoFocusLost

    private void txtSerialNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerialNoKeyReleased
        String PATTERN = "^[a-z A-Z0-9/]{0,10}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtSerialNo.getText());

        if(!match.matches()) {
            errorSerial.setText("Invalid Serial No!");
        } else {
            errorSerial.setText(null);
        }
    }//GEN-LAST:event_txtSerialNoKeyReleased

    private void txtFullnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFullnameFocusGained
        if(txtFullname.getText().trim().toLowerCase().equals("fullname")){
            txtFullname.setText("");
            txtFullname.setForeground(Color.black);
            fnameLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtFullnameFocusGained

    private void txtFullnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFullnameFocusLost
        if(txtFullname.getText().trim().equals("") || txtFullname.getText().trim().equals("fullname")){
            txtFullname.setText("fullname");
            txtFullname.setForeground(Color.gray);
            fnameLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtFullnameFocusLost

    private void txtFullnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFullnameKeyReleased
        String PATTERN = "^[a-z A-Z]{0,30}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtFullname.getText());

        if(!match.matches()) {
            errorFname.setText("Invalid fullname!");
        } else {
            errorFname.setText(null);
        }
    }//GEN-LAST:event_txtFullnameKeyReleased

    private void txtIdNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdNoFocusGained
        if(txtIdNo.getText().trim().toLowerCase().equals("id no. (123456789)")){
            txtIdNo.setText("");
            txtIdNo.setForeground(Color.black);
            idnoLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtIdNoFocusGained

    private void txtIdNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdNoFocusLost
        if(txtIdNo.getText().trim().equals("") || txtIdNo.getText().trim().equals("id no. (123456789)")){
            txtIdNo.setText("id no. (123456789)");
            txtIdNo.setForeground(Color.gray);
            idnoLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtIdNoFocusLost

    private void txtIdNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdNoKeyReleased
        String PATTERN = "^[0-9]{0,10}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtIdNo.getText());

        if(!match.matches()) {
            errorId.setText("Invalid ID Number!");
        } else {
            errorId.setText(null);
        }
    }//GEN-LAST:event_txtIdNoKeyReleased

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if(txtEmail.getText().trim().toLowerCase().equals("someone@newmail.com")){
            txtEmail.setText("");
            txtEmail.setForeground(Color.black);
            emailLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if(txtEmail.getText().trim().equals("") || txtEmail.getText().trim().equals("someone@newmail.com")){
            txtEmail.setText("someone@newmail.com");
            txtEmail.setForeground(Color.gray);
            emailLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // validating email field to ensure (@) and (.) symbol are not ommitted
        String PATTERN = "^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{1,10}[.][a-zA-Z0-9]{2,5}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtEmail.getText());

        if(!match.matches()) {
            errorEmail.setText("Invalid email address!");
        } else {
            errorEmail.setText(null);
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        if(txtPassword.getText().trim().toLowerCase().equals("yourpassword")){
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
            passwordLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if(txtPassword.getText().trim().equals("") || txtPassword.getText().trim().equals("yourpassword")){
            txtPassword.setText("yourpassword");
            txtPassword.setForeground(Color.gray);
            passwordLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        String PATTERN = "^[a-zA-Z0-9_!@#$%^&*-?]{10,30}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtPassword.getText());

        if(!match.matches()) {
            errorPassword.setText("Invalid Password/use atleast 10 characters or more!");
        } else {
            errorPassword.setText(null);
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        if(txtPhone.getText().trim().toLowerCase().equals("07xxxxxxxx")){
            txtPhone.setText("");
            txtPhone.setForeground(Color.black);
            phoneLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        if(txtPhone.getText().trim().equals("") || txtPhone.getText().trim().equals("07xxxxxxxx")){
            txtPhone.setText("07xxxxxxxx");
            txtPhone.setForeground(Color.gray);
            phoneLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtPhoneFocusLost

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        String PATTERN = "^[0-9]{0,10}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtPhone.getText());

        if(!match.matches()) {
            errorPhone.setText("Invalid phonenumber!");
        } else {
            errorPhone.setText(null);
        }
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void btnCreateAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccActionPerformed
        // operation of createing a new account
        String status     = "Offline";
        String operator   = "Lecturer";
        String serial_no  = txtSerialNo.getText();
        String id_no      = txtIdNo.getText();
        String fullname   = txtFullname.getText();
        String email      = txtEmail.getText();
        String phone      = txtPhone.getText();

        String gender     = "Male";
        if(btnFemale.isSelected()) { gender  = "Female"; }

        dateofbirth       = new SimpleDateFormat("YYYY-MM-dd");
        String dob        = dateofbirth.format(txtDob.getDate());

        String password   = txtPassword.getText();

        // checking if any field is empty before submitting the form
        if(serial_no.trim().equals("") || serial_no.trim().equals("serial no. (mb1234567890)")){
            JOptionPane.showMessageDialog(null, "Serial Number is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(id_no.trim().equals("") || id_no.trim().equals("123456789")){
            JOptionPane.showMessageDialog(null, "Id Number is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(fullname.trim().equals("") || fullname.trim().equals("full name")){
            JOptionPane.showMessageDialog(null, "Fullname is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(email.trim().equals("") || email.trim().equals("someone@newmail.com")){
            JOptionPane.showMessageDialog(null, "Email Address is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(phone.trim().equals("") || phone.trim().equals("0700 000 000")){
            JOptionPane.showMessageDialog(null, "Phone Number is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(password.trim().equals("") || password.trim().equals("yourpassword")){
            JOptionPane.showMessageDialog(null, "Password is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            try {
                conn = DBConnection.setConnection();
                sqlQueryCheck = conn.prepareStatement("select * from tbl_lecturers where serial_no=? or id_no=? or email=? or phone=?");
                sqlQueryCheck.setString(1, serial_no);
                sqlQueryCheck.setString(2, id_no);
                sqlQueryCheck.setString(3, email);
                sqlQueryCheck.setString(4, phone);
                res = sqlQueryCheck.executeQuery();

                if(res.isBeforeFirst()) {
                    // if the credential already exist display error message
                    JOptionPane.showMessageDialog(this, "These Cridentials have been used by another lecturer", "Please use new Cridentials", JOptionPane.ERROR_MESSAGE);

                    // clearing neccessary fields to allow the admin to re-enter new Cridentials
                    txtSerialNo.setText("");
                    errorSerial.setText(null);
                    if(txtSerialNo.getText().trim().equals("")){
                        txtSerialNo.setText("serial no. (mb1234567890");
                        txtSerialNo.setForeground(Color.gray);
                        regLine.setBackground(Color.black);
                    }

                    txtIdNo.setText("");
                    errorId.setText(null);
                    if(txtIdNo.getText().trim().equals("")){
                        txtIdNo.setText("id no. (123456789)");
                        txtIdNo.setForeground(Color.gray);
                        idnoLine.setBackground(Color.black);
                    }

                    txtEmail.setText("");
                    errorEmail.setText(null);
                    if(txtEmail.getText().trim().equals("")){
                        txtEmail.setText("someone@newmail.com");
                        txtEmail.setForeground(Color.gray);
                        emailLine.setBackground(Color.black);
                    }
                    
                    txtPhone.setText("");
                    errorPhone.setText(null);
                    if(txtPhone.getText().trim().equals("")){
                        txtPhone.setText("07xxxxxxxx");
                        txtPhone.setForeground(Color.gray);
                        phoneLine.setBackground(Color.black);
                    }

                    return;
                }else {
                    sqlQueryInsert = conn.prepareStatement("insert into tbl_lecturers (status,operator_id,serial_no,id_no,fullname,email,phone,gender,date_ofbirth,password) values (?,?,?,?,?,?,?,?,?,?) ");
                    sqlQueryInsert.setString(1, status);
                    sqlQueryInsert.setString(2, operator);
                    sqlQueryInsert.setString(3, serial_no);
                    sqlQueryInsert.setString(4, id_no);
                    sqlQueryInsert.setString(5, fullname);
                    sqlQueryInsert.setString(6, email);
                    sqlQueryInsert.setString(7, phone);
                    sqlQueryInsert.setString(8, gender);
                    sqlQueryInsert.setString(9, dob);
                    sqlQueryInsert.setString(10, password);

                    //if the record is inserted successfully the state of executeUpdate() will be 1
                    if (sqlQueryInsert.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "A New Lecturer Account has been created successfully.");

                        // clearing the form after successfully adding the new record in the database
                        txtSerialNo.setText("");
                        txtIdNo.setText("");
                        txtFullname.setText("");
                        txtEmail.setText("");
                        txtPhone.setText("");
                        txtDob.setDate(null);
                        txtPassword.setText("");

                        // refresh the page
                        new Page4_Lecturer().setVisible(true);
                        this.dispose();

                        return;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Page4_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCreateAccActionPerformed

    private void btnResetAccFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetAccFormActionPerformed
        // operation for reseting account form
        txtSerialNo.setText("");
        errorSerial.setText(null);
        if(txtSerialNo.getText().trim().equals("")){
            txtSerialNo.setText("serial no. (mb1234567890");
            txtSerialNo.setForeground(Color.gray);
            regLine.setBackground(Color.black);
        }

        txtIdNo.setText("");
        errorId.setText(null);
        if(txtIdNo.getText().trim().equals("")){
            txtIdNo.setText("id no. (123456789)");
            txtIdNo.setForeground(Color.gray);
            idnoLine.setBackground(Color.black);
        }

        txtFullname.setText("");
        errorFname.setText(null);
        if(txtFullname.getText().trim().equals("")){
            txtFullname.setText("fullname");
            txtFullname.setForeground(Color.gray);
            fnameLine.setBackground(Color.black);
        }

        txtDob.setDate(null);

        txtEmail.setText("");
        errorEmail.setText(null);
        if(txtEmail.getText().trim().equals("")){
            txtEmail.setText("someone@newmail.com");
            txtEmail.setForeground(Color.gray);
            emailLine.setBackground(Color.black);
        }

        txtPhone.setText("");
        errorPhone.setText(null);
        if(txtPhone.getText().trim().equals("")){
            txtPhone.setText("07xxxxxxxx");
            txtPhone.setForeground(Color.gray);
            phoneLine.setBackground(Color.black);
        }

        txtPassword.setText("");
        errorPassword.setText(null);
        if(txtPassword.getText().trim().equals("")){
            txtPassword.setText("yourpassword");
            txtPassword.setForeground(Color.gray);
            passwordLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_btnResetAccFormActionPerformed

    private void tbl_lecturersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_lecturersMouseClicked
        btnViewLec.setVisible(true);
        btnDelLec.setVisible(true);

        defaulttbl_2_view = (DefaultTableModel)tbl_lecturers.getModel();
        int selectIndex = tbl_lecturers.getSelectedRow();

        int id = Integer.parseInt(defaulttbl_2_view.getValueAt(selectIndex, 0).toString());

        try {
            Connection conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_lecturers where id=?");
            sqlQueryCheck.setInt(1, id);
            res = sqlQueryCheck.executeQuery();

            while(res.next()) {
                Admin_AccessLec_Credentials.serial_no    = res.getString("serial_no");
                Admin_AccessLec_Credentials.id_no        = res.getString("id_no");
                Admin_AccessLec_Credentials.date_ofbirth = res.getString("date_ofbirth");
                Admin_AccessLec_Credentials.fullname     = res.getString("fullname");
                Admin_AccessLec_Credentials.gender       = res.getString("gender");
                Admin_AccessLec_Credentials.email        = res.getString("email");
                Admin_AccessLec_Credentials.phone        = res.getString("phone");
            }
        } catch (Exception ex) {
            Logger.getLogger(Page3_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

        // displaying specific user info
        lecSerial.setText(Admin_AccessLec_Credentials.serial_no);
        lecIdNo.setText(Admin_AccessLec_Credentials.id_no);
        lecDob.setText(Admin_AccessLec_Credentials.date_ofbirth);
        lecFname.setText(Admin_AccessLec_Credentials.fullname);
        lecGender.setText(Admin_AccessLec_Credentials.gender);
        lecEmail.setText(Admin_AccessLec_Credentials.email);
        lecPhone.setText("0"+Admin_AccessLec_Credentials.phone);    
    }//GEN-LAST:event_tbl_lecturersMouseClicked

    private void btnGoToRegCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToRegCourseActionPerformed
        // Go to course registration tab
        jTabbedPane1.setSelectedIndex(3);
        btnViewLec.setVisible(false);
        btnDelLec.setVisible(false);
        btnGoBackToView.setVisible(true);
        queryInDetail.setVisible(false);
        commentInDetail.setVisible(false);

        String serial_no = lecSerial.getText();

        try {
            Connection conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_lecturers where serial_no=?");
            sqlQueryCheck.setString(1, serial_no);
            res = sqlQueryCheck.executeQuery();

            while(res.next()) {
                Admin_AccessLec_Credentials.serial_no = res.getString("serial_no");
                Admin_AccessLec_Credentials.fullname  = res.getString("fullname");
            }

            // displaying specific user info
            LecInfoSerial.setText(Admin_AccessLec_Credentials.serial_no);
            LecInfoFname.setText(Admin_AccessLec_Credentials.fullname);
        } catch (Exception ex) {
            Logger.getLogger(Page4_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGoToRegCourseActionPerformed

    private void btnGoToMyCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToMyCoursesActionPerformed
        // go to my courses tab
        jTabbedPane1.setSelectedIndex(4);
        btnViewLec.setVisible(false);
        btnDelLec.setVisible(false);
        btnGoBackToView.setVisible(true);
        queryInDetail.setVisible(false);
        commentInDetail.setVisible(false);

        String serial_no = lecSerial.getText();

        try {
            conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_lecturers_course where serial_no=?");
            sqlQueryCheck.setString(1, serial_no);
            res = sqlQueryCheck.executeQuery();
            
            while(res.next()) {
                String dateCourse = res.getString("date_ofcourse");
                String progName   = res.getString("program");
                String courseName = res.getString("course_name");
                String semLevel   = res.getString("semester_level");
                String unitName   = res.getString("unit_name");
                
                Object[] obj = {dateCourse, progName, courseName, semLevel, unitName};
                
                defaulttbl_4_course = (DefaultTableModel)tbl_myCourse.getModel();
                defaulttbl_4_course.addRow(obj);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page5_Student.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_btnGoToMyCoursesActionPerformed

    private void btnGoToOverviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToOverviewActionPerformed
        // go to my overview tab
        jTabbedPane1.setSelectedIndex(5);
        btnViewLec.setVisible(false);
        btnDelLec.setVisible(false);
        queryInDetail.setVisible(true);
        commentInDetail.setVisible(false);
    }//GEN-LAST:event_btnGoToOverviewActionPerformed

    private void courseInfoNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseInfoNameFocusGained
        if(courseInfoName.getText().trim().toLowerCase().equals("course name (cit/dit/accounts)")){
            courseInfoName.setText("");
            courseInfoName.setForeground(Color.black);
            courseBarLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_courseInfoNameFocusGained

    private void courseInfoNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseInfoNameFocusLost
        if(courseInfoName.getText().trim().equals("") || courseInfoName.getText().trim().equals("course name (cit/dit/accounts)")){
            courseInfoName.setText("course name (cit/dit/accounts)");
            courseInfoName.setForeground(Color.gray);
            courseBarLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_courseInfoNameFocusLost

    private void courseInfoLevelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseInfoLevelFocusGained
        if(courseInfoLevel.getText().trim().toLowerCase().equals("semester level (stage 1/stage 2)")){
            courseInfoLevel.setText("");
            courseInfoLevel.setForeground(Color.black);
            dur_semBarLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_courseInfoLevelFocusGained

    private void courseInfoLevelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseInfoLevelFocusLost
        if(courseInfoLevel.getText().trim().equals("") || courseInfoLevel.getText().trim().equals("semester level (stage 1/stage 2)")){
            courseInfoLevel.setText("semester level (stage 1/stage 2)");
            courseInfoLevel.setForeground(Color.gray);
            dur_semBarLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_courseInfoLevelFocusLost

    private void courseInfoProgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseInfoProgFocusGained
        if(courseInfoProg.getText().trim().toLowerCase().equals("program (certificate/diploma)")){
            courseInfoProg.setText("");
            courseInfoProg.setForeground(Color.black);
            progBarLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_courseInfoProgFocusGained

    private void courseInfoProgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseInfoProgFocusLost
        if(courseInfoProg.getText().trim().equals("") || courseInfoProg.getText().trim().equals("program (certificate/diploma)")){
            courseInfoProg.setText("program (certificate/diploma)");
            courseInfoProg.setForeground(Color.gray);
            progBarLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_courseInfoProgFocusLost

    private void courseInfoUnitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseInfoUnitFocusGained
        if(courseInfoUnit.getText().trim().toLowerCase().equals("unit name")){
            courseInfoUnit.setText("");
            courseInfoUnit.setForeground(Color.black);
            unitBarLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_courseInfoUnitFocusGained

    private void courseInfoUnitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseInfoUnitFocusLost
        if(courseInfoUnit.getText().trim().equals("") || courseInfoUnit.getText().trim().equals("unit name")){
            courseInfoUnit.setText("unit name");
            courseInfoUnit.setForeground(Color.gray);
            unitBarLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_courseInfoUnitFocusLost

    private void btnRegCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegCourseActionPerformed
        // operation for registering a course
        SimpleDateFormat dateOfCourse;

        String serial_no  = LecInfoSerial.getText();
        String fullname   = LecInfoFname.getText();
        String program    = courseInfoProg.getText();

        dateOfCourse      = new SimpleDateFormat("YYYY-MM-dd");
        String yearCourse = dateOfCourse.format(CourseInfoYoc.getDate());

        String courseName = courseInfoName.getText();
        String duration   = courseInfoLevel.getText();
        String unitName   = courseInfoUnit.getText();

        // checking if any field is empty before submitting the form
        if(program.trim().equals("") || program.trim().equals("program (certificate/diploma)")){
            JOptionPane.showMessageDialog(null, "Program Name is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(courseName.trim().equals("") || courseName.trim().equals("course name (cit/dit/accounts)")){
            JOptionPane.showMessageDialog(null, "Course Name is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(duration.trim().equals("") || duration.trim().equals("semester level (stage 1/stage 2)")){
            JOptionPane.showMessageDialog(null, "Duration/ Semester level is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(unitName.trim().equals("") || unitName.trim().equals("Unit name")){
            JOptionPane.showMessageDialog(null, "Unit name is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            try {
                conn = DBConnection.setConnection();
                sqlQueryInsert = conn.prepareStatement("insert into tbl_lecturers_course (serial_no,fullname,program,date_ofcourse,course_name,semester_level,unit_name) values (?,?,?,?,?,?,?) ");
                sqlQueryInsert.setString(1, serial_no);
                sqlQueryInsert.setString(2, fullname);
                sqlQueryInsert.setString(3, program);
                sqlQueryInsert.setString(4, yearCourse);
                sqlQueryInsert.setString(5, courseName);
                sqlQueryInsert.setString(6, duration);
                sqlQueryInsert.setString(7, unitName);

                //if the record is inserted successfully the state of executeUpdate() will be 1
                if (sqlQueryInsert.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "A New Course has been Registered under "+ fullname +" successfully.");

                    // clearing the form after successfully adding the new record in the database
                    courseInfoProg.setText("");
                    CourseInfoYoc.setDate(null);
                    courseInfoUnit.setText("");
                    courseInfoName.setText("");
                    courseInfoLevel.setText("");

                    // redirect the user to login page
                    new Page4_Lecturer().setVisible(true);
                    this.dispose();

                    return;
                }
            } catch (Exception ex) {
                Logger.getLogger(Page4_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRegCourseActionPerformed

    private void btnResetCourseFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetCourseFormActionPerformed
        // operation for reseting registration form
        courseInfoProg.setText("");
        if(courseInfoProg.getText().trim().equals("")){
            courseInfoProg.setText("program (certificate/diploma)");
            courseInfoProg.setForeground(Color.gray);
            progBarLine.setBackground(Color.black);
        }
        
        CourseInfoYoc.setDate(null);

        courseInfoUnit.setText("");
        if(courseInfoUnit.getText().trim().equals("")){
            courseInfoUnit.setText("unit name");
            courseInfoUnit.setForeground(Color.gray);
            unitBarLine.setBackground(Color.black);
        }

        courseInfoName.setText("");
        if(courseInfoName.getText().trim().equals("")){
            courseInfoName.setText("course name (cit/dit/accounts)");
            courseInfoName.setForeground(Color.gray);
            courseBarLine.setBackground(Color.black);
        }

        courseInfoLevel.setText("");
        if(courseInfoLevel.getText().trim().equals("")){
            courseInfoLevel.setText("semester level (stage 1/stage 2)");
            courseInfoLevel.setForeground(Color.gray);
            dur_semBarLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_btnResetCourseFormActionPerformed

    private void queryInDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryInDetailActionPerformed
        // this button is for tab 7
        jTabbedPane1.setSelectedIndex(6);
        btnViewLec.setVisible(false);
        btnDelLec.setVisible(false);
        btnGoBackToView.setVisible(true);
    }//GEN-LAST:event_queryInDetailActionPerformed

    private void tbl_myOverviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_myOverviewMouseClicked
        String lblQuery = "Query";
        String lblComment = "Comment";

        defaulttbl_6_overview = (DefaultTableModel)tbl_myOverview.getModel();
        int selectIndex = tbl_myOverview.getSelectedRow();

        int id = Integer.parseInt(defaulttbl_6_overview.getValueAt(selectIndex, 0).toString());

        try {
            Connection conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_interaction where msg_id=?");
            sqlQueryCheck.setInt(1, id);
            res = sqlQueryCheck.executeQuery();

            while(res.next()) {
                String sentDate   = res.getString("date_sent");
                String studentID  = res.getString("stud_Identifier");
                String student    = res.getString("stud_fname");
                String content    = res.getString("msg_content");
                String repliedDt  = res.getString("date_replied");
                String repliedMSG = res.getString("replied_msg");
                String dispLbl    = res.getString("msg_lbl");
                String docPathLink = res.getString("link_doc");

                if (dispLbl.equals(lblQuery)){
                    queryInDetail.setVisible(true);
                    commentInDetail.setVisible(false);

                    queryDateSent.setText(sentDate);
                    replyToRegQuery.setText(studentID);
                    replyToFnameQuery.setText(student);
                    replyToQueryMsg.setText(content);
                    queryDateSent2.setText(repliedDt);
                    queryRetrieveMsg.setText(repliedMSG);
                    queryRetrievePath.setText(docPathLink);
                }
                else if (dispLbl.equals(lblComment)){
                    queryInDetail.setVisible(false);
                    commentInDetail.setVisible(true);

                    commentDateSent.setText(sentDate);
                    replyToRegComment.setText(studentID);
                    replyToFnameComment.setText(student);
                    replyToCommentMsg.setText(content);
                    commentRepliedOn.setText(repliedDt);
                    commentRetrieveMsg.setText(repliedMSG);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Page4_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_myOverviewMouseClicked

    private void commentInDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentInDetailActionPerformed
        jTabbedPane1.setSelectedIndex(7);
        btnViewLec.setVisible(false);
        btnDelLec.setVisible(false);
        btnGoBackToView.setVisible(true);
    }//GEN-LAST:event_commentInDetailActionPerformed

    private void txtSettings1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSettings1MouseClicked
        Page7_Report genReport = new Page7_Report();
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
            java.util.logging.Logger.getLogger(Page4_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Page4_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Page4_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Page4_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Page4_Lecturer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CourseInfoYoc;
    private javax.swing.JLabel LecInfoFname;
    private javax.swing.JLabel LecInfoSerial;
    private javax.swing.JButton btnCreateAcc;
    private javax.swing.JButton btnDelLec;
    private javax.swing.JRadioButton btnFemale;
    private javax.swing.JButton btnGoBackToView;
    private javax.swing.JButton btnGoToAddLec;
    private javax.swing.JButton btnGoToMyCourses;
    private javax.swing.JButton btnGoToOverview;
    private javax.swing.JButton btnGoToRegCourse;
    private javax.swing.JRadioButton btnMale;
    private javax.swing.JButton btnRegCourse;
    private javax.swing.JButton btnResetAccForm;
    private javax.swing.JButton btnResetCourseForm;
    private javax.swing.JButton btnShowAllLec1;
    private javax.swing.JButton btnViewLec;
    private javax.swing.JLabel commentDateSent;
    private javax.swing.JButton commentInDetail;
    private javax.swing.JLabel commentRepliedOn;
    private javax.swing.JTextArea commentRetrieveMsg;
    private javax.swing.JTextField courseBarLine;
    private javax.swing.JTextField courseInfoLevel;
    private javax.swing.JTextField courseInfoName;
    private javax.swing.JTextField courseInfoProg;
    private javax.swing.JTextField courseInfoUnit;
    private javax.swing.JTextField dur_semBarLine;
    private javax.swing.JTextField emailLine;
    private javax.swing.JLabel errorEmail;
    private javax.swing.JLabel errorFname;
    private javax.swing.JLabel errorId;
    private javax.swing.JLabel errorPassword;
    private javax.swing.JLabel errorPhone;
    private javax.swing.JLabel errorSerial;
    private javax.swing.JTextField fnameLine;
    private javax.swing.JTextField idnoLine;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lecDob;
    private javax.swing.JLabel lecEmail;
    private javax.swing.JLabel lecFname;
    private javax.swing.JLabel lecGender;
    private javax.swing.JLabel lecIdNo;
    private javax.swing.JLabel lecPhone;
    private javax.swing.JLabel lecSerial;
    private javax.swing.JTextField passwordLine;
    private javax.swing.JTextField phoneLine;
    private javax.swing.JTextField progBarLine;
    private javax.swing.JLabel queryDateSent;
    private javax.swing.JLabel queryDateSent2;
    private javax.swing.JButton queryInDetail;
    private javax.swing.JTextArea queryRetrieveMsg;
    private javax.swing.JLabel queryRetrievePath;
    private javax.swing.JTextField regLine;
    private javax.swing.JTextArea replyToCommentMsg;
    private javax.swing.JLabel replyToFnameComment;
    private javax.swing.JLabel replyToFnameQuery;
    private javax.swing.JTextArea replyToQueryMsg;
    private javax.swing.JLabel replyToRegComment;
    private javax.swing.JLabel replyToRegQuery;
    private javax.swing.JLabel sideBarFname;
    private javax.swing.JLabel sideBarOperator;
    private rojeru_san.complementos.RSTableMetro tbl_lecturers;
    private rojeru_san.complementos.RSTableMetro tbl_myCourse;
    private rojeru_san.complementos.RSTableMetro tbl_myOverview;
    private javax.swing.JLabel topBarSerialNo;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtDay;
    private com.toedter.calendar.JDateChooser txtDob;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtIdNo;
    private javax.swing.JLabel txtLecturer;
    private javax.swing.JLabel txtManager;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSerialNo;
    private javax.swing.JLabel txtSettings;
    private javax.swing.JLabel txtSettings1;
    private javax.swing.JLabel txtStudent;
    private javax.swing.JLabel txtTime;
    private javax.swing.JTextField unitBarLine;
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
