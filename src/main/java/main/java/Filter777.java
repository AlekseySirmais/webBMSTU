package main.java;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


//@WebFilter(filterName = "Filter777", urlPatterns = "/*")
public class Filter777 implements Filter {
    public void destroy(){}



    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        HttpServletResponse response = (HttpServletResponse) resp;


        HttpSession session = request.getSession(false);//возвращает null, если сессии нет
//localhost:8080
        String url = request.getRequestURI(); //записываем в переменную uri окончание нашего запроса,
        // то есть адрес страницы, на которую хотим перейти


        if (url.contains("successefulRegist")) {
            chain.doFilter(req,resp); //пропускаем
            return;

        }


        if (url.contains("createuser")) {
            chain.doFilter(req,resp);//пропускаем
            return;

        }

        if (url.contains("unsucc")) {
            chain.doFilter(req,resp);
            return;

        }

       if (url.contains("login")) {
           chain.doFilter(req,resp);
           return;
       }
       else {
           if (!url.contains("admin")){ // не содержит админ

             if (Integer.parseInt(session.getAttribute("user_id").toString())>=0) { // если в атрибутах сесии айди больше 0


                 chain.doFilter(req,resp);
                 return;
             }


           }
           else {
               if(session.getAttribute("user_id")== (Object)1){// у админа айди равно единице(он есть  вбазе изначчально)

                   chain.doFilter(req,resp);
               return;}

               else response.sendRedirect("/unsuccesseful.jsp"); return;
           }

       }










    }
    public void init(FilterConfig config) throws ServletException{


    }
}
