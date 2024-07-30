
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


public class DeleteBE extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteBE</title>");            
            out.println("</head>");
            out.println("<body>");
        long rno=Long.parseLong(request.getParameter("id"));
            out.println("image id is:"+rno);
            Connection con=DbConnection.getConnectTomovietickets();
            String sql="DELETE FROM image WHERE img_id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setLong(1,rno);
            int i=ps.executeUpdate();
            if(i>0)
               out.println("<script>alert('Record Deleted ');</script>");
               
            else
                out.println("ID doesn't exist");
            con.close();
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
            Logger.getLogger(DeleteBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
