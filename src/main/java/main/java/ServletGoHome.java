package main.java;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "ServletGoHome",urlPatterns = "/GoHome")
public class ServletGoHome extends HttpServlet {



    @Override
    protected void doPost (HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException {
        String  name=null, email=null;
        int id;
        Validate v = new Validate();
        HttpSession session = request.getSession(false); //получаем сессию (если нет то значение null)
   name =session.getAttribute("user_name").toString();
        id = Integer.parseInt(session.getAttribute("user_id").toString());
        try {
            email =v.getEmail(id).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/home.jsp?name="+name+"&id="+id+"&user_email="+email);


    }
}