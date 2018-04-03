package main.java;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 // для поиска используем поле автора и два метода
// получение параметра через POST
// делаем джексона через GET
@WebServlet(name = "ServletSearch",urlPatterns = "/search")
public class ServletSearch extends HttpServlet {
private String author; // наш буфер между приемом с формой и отправкой джексона

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    protected void doPost (HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException {
        String name=request.getParameter("author");

setAuthor(name);

        response.sendRedirect("/searchnewsss.jsp?author="+name);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {








            String text =getAuthor();


        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();

// выдает новость определенного автора
        List<News> news = Validate.getAuthorNews(text);

        out.print(mapper.writeValueAsString(news));




    }





}
