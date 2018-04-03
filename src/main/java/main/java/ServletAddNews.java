package main.java;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "ServletAddNews",urlPatterns = "/addnews")
public class ServletAddNews extends HttpServlet {



    @Override
    protected void doPost (HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException{
        String title = request.getParameter("title");
        String text = request.getParameter("text");



        Validate v = new Validate();
// надо вытащить из сессии имя пользователя чтобы полноценно соаздать новость
        HttpSession session777 = request.getSession(false);
        String nameOfAuthor =  session777.getAttribute("user_name").toString();
//void addNews(String title, String text, String author) - сигнатура
        try {
            v.addNews(title,text,nameOfAuthor);
        } catch (SQLException e) {
            e.printStackTrace();
        }

response.sendRedirect("/table.html");
    }






}
