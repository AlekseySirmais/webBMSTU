package main.java;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet (name = "NewsServlet", urlPatterns = {"/table"})
public class NewsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest reques, HttpServletResponse response) throws IOException {
       response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();


        List<News> news = Validate.getNews();

        out.print(mapper.writeValueAsString(news));





    }

}
