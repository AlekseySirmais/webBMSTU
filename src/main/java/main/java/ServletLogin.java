package main.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name ="ServletLogin", urlPatterns = "/login")
public class ServletLogin extends HttpServlet {





    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        String user = request.getParameter("user");
        String passwd = request.getParameter("password");
 Validate v = new Validate();


        try {
            if (v.checkUser(user,passwd)){ //сверяет имя и пароль с формы с БД
                int id=0;// вводим пепеменную для id
                id = v.getID(user,passwd); //получаем id
                String email =v.getEmail(id);
                User user22= Validate.getUser(user,passwd,id,email); //получаем объект user22 с полями имени, пароля и id иии почту дописали



                HttpSession session = request.getSession(true); //создаем сеанс (проверяет на наличие если что создает)
                session.setAttribute("user_id",user22.getmID());//установка в объекте сессии двух полей
                session.setAttribute("user_name",user22.getmName());
               session.setMaxInactiveInterval(60000*10); //10 минут

                response.sendRedirect("/home.jsp?name="+user22.getmName()+"&id="+user22.getmID()+"&user_email="+user22.getmEmail()); //перенаправляем пользователя на страницу
            }

            else {
            response.sendRedirect("/unsuccesseful.jsp");}
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("login/html");//устанавлием тип содержимого
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();//создаем массив куков
        if(cookies != null){//массив неравен нулю
            for(Cookie cookie : cookies){//просматриваем каждую куку в массиве
                if(cookie.getName().equals("JSESSIONID")){//если название куки равно
                    //JSESSIONID, то выводим значение куки
                    out.println("JSESSIONID = "+cookie.getValue());
                }
                cookie.setMaxAge(88000000); //максимальное время каждой куки
                response.addCookie(cookie);//добавление в объект responce данной куки
            }
        }

    }
}
