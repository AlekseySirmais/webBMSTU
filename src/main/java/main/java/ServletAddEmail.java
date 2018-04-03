package main.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "ServletAddEmail",urlPatterns = "/addemail")
public class ServletAddEmail extends HttpServlet {


// берем почту из формочки и берем айди из сессии и добавляем почту в базу по айди
    @Override
    protected void doPost (HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException{
        String email = request.getParameter("email");
        Validate v = new Validate();
        HttpSession session777 = request.getSession(false);
    int userId;
    userId = Integer.parseInt(session777.getAttribute("user_id").toString());
        try {
            v.addEmail(userId,email);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/home.jsp?name="+session777.getAttribute("user_name").toString()+"&id="+userId+"&user_email="+email);
    }






}
