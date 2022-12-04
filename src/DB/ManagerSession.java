/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author JoeAlpha
 */
public class ManagerSession {
    public static boolean isLogin(String email, String password, JFrame frame){
        try {
            Connection conn = DBConnection.setConnection();
            String mySqlQuery = "SELECT status,operator_id,serial_no,fullname,email,phone,gender FROM tbl_managers WHERE email=? AND password =? ";
            PreparedStatement preparedStatement = conn.prepareStatement(mySqlQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                ManagerCredentials.status      = resultSet.getString("status");
                ManagerCredentials.operator_id = resultSet.getString("operator_id");
                ManagerCredentials.serial_no   = resultSet.getString("serial_no");
                ManagerCredentials.fullname    = resultSet.getString("fullname");
                ManagerCredentials.email       = resultSet.getString("email");
                ManagerCredentials.phone       = resultSet.getString("phone");
                ManagerCredentials.gender      = resultSet.getString("gender");
                
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagerSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
