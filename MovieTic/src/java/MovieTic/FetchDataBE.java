package MovieTic;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FetchDataBE extends HttpServlet {

    
   public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = null;
        //JDBC first two steps
        con = DbConnection.getConnectTomovietickets();
        String sql = "SELECT * FROM image";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Details of newly added movie are....");
        System.out.println("--------------------------");
        System.out.println("img_ID \t Name\t img");
        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print("\t"+rs.getString(2));
            System.out.print("\t"+rs.getString(3));
            System.out.println();
//             request.getRequestDispatcher("").include(request, response);
//            
            
            
        }
        con.close();
    }

   
}