import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String email=request.getParameter("email");
        String phoneNumber=request.getParameter("phoneNumber");
        Emp e= new Emp();
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setEmail(email);
        e.setPhoneNumber(phoneNumber);
        int status= EmpDao.add(e);
        if(status>0){
            out.println("<p> Record saved successfully!</p>");
            request.getRequestDispatcher("index.jsp").include(request,response);
        }
        else {
            out.println("Sorry! unable to save record");
        }
        out.close();
    }
}
