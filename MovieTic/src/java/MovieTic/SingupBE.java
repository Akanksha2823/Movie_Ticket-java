/*
 * 
 */
package MovieTic;

import MovieTic.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SingupBE extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SingupBE</title>");            
            out.println("</head>");
            out.println("<body>");
            String fn = request.getParameter("firstname");
            String ln = request.getParameter("lastname");
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            Connection con = DbConnection.getConnectTomovietickets();
            String sql="INSERT INTO user(FIRSTNAME,LASTNAME,EMAIL,PASSWORD) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,fn);
                ps.setString(2, ln);
                ps.setString(3, email);
                ps.setString(4, pwd);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    out.println("your successfully signed In!");
                     request.getRequestDispatcher("Home.html").include(request, response);
                    
                }
       //     out.println("<h1>Servlet SingupBE at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SingupBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SingupBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SingupBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SingupBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
