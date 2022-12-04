/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import ForStudents.Page1_Login;
import javax.swing.JFrame;

/**
 *
 * @author JoeAlpha
 */
public class StudentPageLogout {
    public static void logMeOut(JFrame context, Page1_Login LoginScreen) {
        StudentCredentials.isloggedIn = false;
        context.setVisible(false);
        LoginScreen.setVisible(true);
    }
}
