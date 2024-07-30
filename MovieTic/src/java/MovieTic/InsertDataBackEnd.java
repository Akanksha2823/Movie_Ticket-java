
package MovieTic;

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



public class InsertDataBackEnd extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertDataBackEnd</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet InsertDataBackEnd at " + request.getContextPath() + "</h1>");
             String mn = request.getParameter("Moviename");
            String mp = request.getParameter("path");
             Connection con = DbConnection.getConnectTomovietickets();
            String sql="INSERT INTO image(img_name,img) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,mn);
                ps.setString(2, mp);
                 int i=ps.executeUpdate();
                if(i>0)
                {
                    out.println("Movie has updated ");
                     request.getRequestDispatcher("InsertFe.html").include(request, response);
                     out.println("<script>alert('Movie Updated ');</script>");
                    
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
            Logger.getLogger(InsertDataBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertDataBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
//       
        } catch (SQLException ex) {
            Logger.getLogger(InsertDataBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertDataBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
