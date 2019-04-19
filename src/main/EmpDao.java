import com.sun.corba.se.impl.orb.PrefixParserAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","nikit123");
        }catch (Exception e) {
            System.out.println(e);
        }
            return con;
    }
    public static int add(Emp e){
        int status=0;
        try{
            Connection con=EmpDao.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into user(firstName,lastName,email,phoneNumber) values(?,?,?,?)");
            ps.setString(1, e.getFirstName());
            ps.setString(2,e.getLastName());
            ps.setString(3,e.getEmail());
            ps.setString(4,e.getPhoneNumber());
            status=ps.executeUpdate();
            con.close();
        }
        catch (Exception ex){
           ex.printStackTrace();
        }
        return status;
    }
    public static int update(Emp e){
        int status=0;
        try{
            Connection con=EmpDao.getConnection();
            PreparedStatement ps=con.prepareStatement("update user set firstName=?,lastName=?,email=?,phoneNumber=? where id=?");
            ps.setString(1,e.getFirstName());
            ps.setString(2,e.getLastName());
            ps.setString(3,e.getEmail());
            ps.setString(4,e.getPhoneNumber());
            ps.setInt(5,e.getId());

            status=ps.executeUpdate();
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return status;
    }
    public static int delete(int id){
     int status=0;
     try{
         Connection con= EmpDao.getConnection();
         PreparedStatement ps= con.prepareStatement("delete from user where id=?");
         ps.setInt(1,id);
         status=ps.executeUpdate();
         con.close();
     }catch (Exception ex){
         ex.printStackTrace();
     }
     return status;
    }
    public static Emp getEmployeeById(int id){
        Emp e= new Emp();
        try{
            Connection con= EmpDao.getConnection();
            PreparedStatement ps= con.prepareStatement("select * from user where id=?");
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt(1));
                e.setFirstName(rs.getString(2));
                e.setLastName(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPhoneNumber(rs.getString(5));
            }
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return e;
    }
    public static List<Emp> getAllEmployees(){
        List<Emp> list= new ArrayList<>();
        try {
            Connection con=EmpDao.getConnection();
            PreparedStatement ps= con.prepareStatement("select * from user");
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Emp e= new Emp();
                e.setId(rs.getInt(1));
                e.setFirstName(rs.getString(2));
                e.setLastName(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPhoneNumber(rs.getString(5));
                list.add(e);
            }
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
