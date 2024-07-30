
package MovieTic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminLoginBE extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminLoginBE</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet AdminLoginBE at " + request.getContextPath() + "</h1>");
             String anemail = request.getParameter("aemail");
             String apassword = request.getParameter("pwd");
             Connection con = DbConnection.getConnectTomovietickets();
             String sql="SELECT email, password FROM admin WHERE email=? AND password=?";
               PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, anemail);
            ps.setString(2, apassword);
            ResultSet rs=ps.executeQuery();
             if(rs.next())
            {
                request.getRequestDispatcher("Adminhome2.html").include(request, response);
            }
            else
            {
//                out.println("<script>alert('Invalid Useename/Password');</script>");
                 request.getRequestDispatcher("Adminhome2.html").include(request, response);
            }
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
            Logger.getLogger(AdminLoginBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminLoginBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminLoginBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminLoginBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
