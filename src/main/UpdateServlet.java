import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String sid= request.getParameter("id");
        int id=Integer.parseInt(sid);
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String email=request.getParameter("email");
        String phoneNumber=request.getParameter("phoneNumber");
        Emp e= new Emp();
        e.setId(id);
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setEmail(email);
        e.setPhoneNumber(phoneNumber);
        int status=EmpDao.update(e);
        if(status>0) {
            response.sendRedirect("ViewServlet");
        }
            else{
                out.println("Sorry! unable to update record");
            }
            out.close();
    }
}
