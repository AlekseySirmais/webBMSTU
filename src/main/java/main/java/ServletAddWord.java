package main.java;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name ="ServletAddWord", urlPatterns ="/addword")
public class ServletAddWord extends HttpServlet {



    @Override
    protected void doPost (HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException {
        String word_end = request.getParameter("word_end");
        String word_ruszzzzzz = request.getParameter("word_rus");


        String word_rus= new String(word_ruszzzzzz.getBytes("ISO-8859-1"),"UTF-8");



        System.out.println(word_ruszzzzzz+"==== после перекодировки  ==="+word_end);




        if (word_end.equals("")||word_rus.equals("")){

         response.sendRedirect("/dicrionary.jsp?id=5982");//5982 айди ошибки

        return;}



        Validate v = new Validate();


        try {
            v.addWord(word_end,word_rus);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/dicrionary.jsp?id=4");

    }




}
