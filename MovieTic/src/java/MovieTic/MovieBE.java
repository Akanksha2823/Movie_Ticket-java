package MovieTic;


import MovieTic.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MovieBE extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MovieBE</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet MovieBE at " + request.getContextPath() + "</h1>");
          String Moviess = request.getParameter("Movi");
            String seatCount = request.getParameter("Count");
           String TotalPrice = request.getParameter("tp");
            String selectedLocation = request.getParameter("locate");
        String selectedDate = request.getParameter("Dates");
        String selectedTime = request.getParameter("Times");
       

        // You can process the data as needed, for example, store it in a database or perform some business logic
        // For simplicity, we'll just print the data to the console in this example
       System.out.println("Movie: " + Moviess);
        System.out.println("Number of Seats: " + seatCount);
         System.out.println("Number of Seats: " + TotalPrice);
         System.out.println("Selected Location: " + selectedLocation);
        System.out.println("Selected Date: " + selectedDate);
        System.out.println("Selected Time: " + selectedTime);
       
        
      
       out.println("<button onclick=\"downloadPageContent()\" >Download</button>");
        out.println("<center><h2>Booking Successful!</h2></center>");
        out.println("<center><p>Movie: " + Moviess + "</p></center>");
        out.println("<center><p>Number of Seats: " + seatCount + "</p></center>");
        out.println("<center><p>Total Ticket Price: " + TotalPrice + "</p></center>");
        out.println("<center><p>Selected location: " + selectedLocation + "</p></center>");
        out.println("<center><p>Selected Date: " + selectedDate + "</p></center>");
        out.println("<center><p>Selected Time: " + selectedTime + "</p></center>");
        
      out.println("<script>");
out.println("function downloadPageContent() {");
out.println("  var content = 'Movie: " + Moviess + "\\n'");
out.println("             + 'Number of Seats: " + seatCount + "\\n'");
out.println("             + 'Total Ticket Price: " + TotalPrice + "\\n'");
out.println("             + 'Selected location: " + selectedLocation + "\\n'");
out.println("             + 'Selected Date: " + selectedDate + "\\n'");
out.println("             + 'Selected Time: " + selectedTime + "';");
out.println("  var blob = new Blob([content], { type: 'text/plain' });"); // Change the MIME type to 'text/plain'
out.println("  var link = document.createElement('a');");
out.println("  link.href = window.URL.createObjectURL(blob);");
out.println("  link.download = 'booking_details.txt';"); // Change the file name and extension to '.txt'
out.println("  link.click();");
out.println("}");
out.println("</script>");

        
        
           try (//out.println("<h1>Servlet AddAttdBE at " + request.getContextPath() + "</h1>");
                    Connection con = DbConnection.getConnectTomovietickets()) {
                String sql="insert into BOOK (date,time,seat,location,price,movie) values(?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, selectedDate);
                ps.setString(2,selectedTime);
                ps.setString(3, seatCount);
                 ps.setString(4, selectedLocation);
                  ps.setString(5, TotalPrice);
                   ps.setString(6, Moviess);
               
                int i=ps.executeUpdate();
                if(i>0)
                {
                    out.println(" <center>seat is booked</center>");
                }
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
            Logger.getLogger(MovieBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MovieBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

  
}

