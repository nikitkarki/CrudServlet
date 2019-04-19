import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.println("<a href='index.jsp'>Add New Employee</a>");
        out.println("<h1>Employees List</h1>");
        List<Emp> list= EmpDao.getAllEmployees();
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Phone number</th><th>Edit</th><th>Delete</th></tr>");
        for(Emp e:list){
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhoneNumber()+"</td><td><a href='GetByIdServlet?id="+e.getId()+"'>edit</a></td> <td><a href='GetByIdServlet?id="+e.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");
    }
    }

