import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetByIdServlet")
public class GetByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.println("<h1> Update Employee</h1>");
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        Emp e= EmpDao.getEmployeeById(id);
        out.print("<form action='UpdateServlet' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
        out.print("<tr><td>First Name:</td><td><input type='text' name='firstName' value='"+e.getFirstName()+"'/></td></tr>");
        out.print("<tr><td>Last Name:</td><td><input type='text' name='lastName' value='"+e.getLastName()+"'/> </td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Phone Number:</td><td><input type='text' name='phoneNumber' value='"+e.getPhoneNumber()+"'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.close();
    }
}
