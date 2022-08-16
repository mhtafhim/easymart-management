/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.sql.*;
/**
 *
 * @author AsifRahman
 */
public class connectionProvider {
    public static Connection getCon(){
        try{
          class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306");
        }
            catch(Exception e){
                return null;
            }
    }
    
}
