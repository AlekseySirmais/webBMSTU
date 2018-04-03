package main.java;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "ServletAddComment",urlPatterns = "/addcomment")
public class ServletAddCommnet extends HttpServlet {



    @Override
    protected void doPost (HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException{

        String text = request.getParameter("textcom");
int idnews= Integer.parseInt(request.getParameter("idnews"));
        Validate v = new Validate();
// надо вытащить из сессии имя пользователя чтобы полноценно соаздать новость
        HttpSession session777 = request.getSession(false);
        String nameOfAuthor =  session777.getAttribute("user_name").toString();
//void addNews(String title, String text, String author) - сигнатура для метода
        try {
            v.addComment(nameOfAuthor,text,idnews);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/table.html");
    }






}
