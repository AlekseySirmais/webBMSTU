package main.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "CreateUserServlet",urlPatterns = "/createuser")
public class CreateUserServlet extends HttpServlet {

//пустое имя - тоже имя
    // исключить возможность создание пустого имени тем, что заранее добавим пустое имя в базу
// пустой пароль - тоже пароль, если нужно то можно организовать проврку на длину и качество пароля в сервлете формы логирования

@Override
    protected void doPost (HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException{
    String user = request.getParameter("user");
    String passwd = request.getParameter("password");
boolean bool = false;
    Validate v = new Validate();
    int id=0;// вводим переменную для id
        //проверяем наличие пользователя в базе
    try {
        if (!v.checkName(user)){

            bool=   v.addUser(user,passwd);



            id = v.getID(user,passwd); //получаем id


        }

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

String emaildefault ="Почта не указана";
    User user23= Validate.getUser(user,passwd,id,emaildefault);
   if (bool)
       response.sendRedirect("/successefulRegist.jsp?name="+user23.getmName());
   else     response.sendRedirect("/unsuccesseful.jsp");
}






}
