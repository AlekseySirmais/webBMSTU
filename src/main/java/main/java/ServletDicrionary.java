package main.java;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDicrionary", urlPatterns = {"/dicrionary"})
public class ServletDicrionary extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    String ruwww;
    String engwww;



       String word_0 = request.getParameter("word");

     String word= new String(word_0.getBytes("ISO-8859-1"),"UTF-8");

// UTF-8   WINDOWS-1251

          int id=3;
        Validate v = new Validate();


        if (!word.equals("")){
           // код получения английского по русскому
            try {
                id=v.getIdTranslation(word);

              //  engwww=v.getEngTranslation(id);
              //  ruwww = v.getRuTranslation(id);
               // System.out.println("==========\n"+engwww+"  ---   "+ruwww+"  ----  "+id+"\n=======");




                response.sendRedirect("/dicrionary.jsp?id="+id);




            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("не получилось получить англ слово ");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("не получилось получить англ слово ");
            }

        }





            if (word.equals(""))
                response.sendRedirect("/dicrionary.jsp?id="+5);







    }



}
