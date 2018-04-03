package main.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "ServletExit",urlPatterns = "/exit")
public class ServletExit extends HttpServlet {



    @Override
    protected void doPost (HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException {


        HttpSession session = request.getSession(false); //получаем сессию (если нет то значение null)
            session.invalidate(); // сам выход из сесии

        response.sendRedirect("login.jsp");// перенаправление


}
}