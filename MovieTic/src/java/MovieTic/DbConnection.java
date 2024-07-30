/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieTic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rakes
 */
public class DbConnection {
    public static Connection getConnectTomovietickets() throws SQLException, ClassNotFoundException
   {
       Class.forName("com.mysql.jdbc.Driver");
       Connection con=null;
       String url="jdbc:mysql://localhost:3306/";
       String dbName="movietickets";
       String userName="root";
       String password="Akku@2603";
       con=DriverManager.getConnection(url+dbName,userName, password);
       return con; 
}

    static Connection getConnectToStudAttd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
