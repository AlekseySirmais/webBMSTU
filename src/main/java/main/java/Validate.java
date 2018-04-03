package main.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Validate {
    // JDBC URL, username and password of MySQL server
    private static final String burl = "jdbc:mysql://localhost:3306/mydbtest?" + "user=root&password=131313&useSSL=false&serverTimezone=UTC";


    public boolean checkUser(String log, String pass) throws SQLException {
        ResultSet resultSet = null;
        boolean bool = false;
        try { // try catch для проверки исключений-ошибок

            Class.forName("com.mysql.cj.jdbc.Driver"); // драйвер


            //создание соединения с базой
            Connection con = DriverManager.getConnection(burl);


            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM userslog ;");// подготавливаем запрос


            resultSet = preparedStatement.executeQuery();// выполняет запрос


            while (resultSet.next()) { // пока есть след.
                bool = log.equals(resultSet.getString("name")) && pass.equals(resultSet.getString("passwd"));
               // если log (имя) равно имени из базы И pass равен
                if (bool) {
                        break;
                } else {
                    continue;
                }
            }
            preparedStatement.close();// закрываем - память чистим
            con.close(); //close connection


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (bool) { // можно было просто return bool;
            return true;
        } else
            return false;

    }


    public boolean addUser(String log, String pass) throws SQLException {
        ResultSet resultSet = null;
        boolean bool = false;


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            //creating connection with the database
            Connection con = DriverManager.getConnection(burl);


            PreparedStatement preparedStatement = con.prepareStatement("insert into userslog (name,passwd) values ('" + log + "','" + pass + "');");

            bool = preparedStatement.execute();

            preparedStatement.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (checkUser(log, pass)) {
            bool = true;
        } else bool = false;

        return bool;

    }



    public static User getUser(String name, String password, int id, String email) {

        User user666 = new User(name, password, id, email);

        return user666;
    }

    public int getID(String log, String pass) throws SQLException, ClassNotFoundException {
        int id = 0;
        ResultSet resultSet = null;
        boolean bool = false;

        Class.forName("com.mysql.cj.jdbc.Driver");


        //creating connection with the database
        Connection con = DriverManager.getConnection(burl);


        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM userslog ;");


        resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            bool = log.equals(resultSet.getString("name")) && pass.equals(resultSet.getString("passwd"));
            if (bool) {
                break;
            } else {
                continue;
            }
        }
        if (bool) {
            resultSet.close();
            preparedStatement = con.prepareStatement("SELECT id FROM userslog WHERE name='" + log + "';");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                id = resultSet.getInt("id");
        }


        preparedStatement.close();// закрываем запрос
        con.close();//закрываем соединение


        return id;
    }


    public int getMaxId() throws SQLException, ClassNotFoundException {
        int MaxId = 1;
        ResultSet resultSet = null;
        Connection con = DriverManager.getConnection(burl);
        PreparedStatement preparedStatement = con.prepareStatement("SELECT id FROM userslog;");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
            MaxId = resultSet.getInt("id");

        return MaxId;
    }


    public static List<User> getData() {
        List<User> result = new ArrayList<User>();
        Connection con = null;
        ResultSet resultSet = null;

        String mmane, ppassw, email;
        int iid;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(burl);
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM mydbtest.userslog");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                mmane = resultSet.getString(2);
                ppassw = resultSet.getString(3);
                iid = resultSet.getInt(1);
                email = resultSet.getString(4);
                result.add(new User(mmane, ppassw, iid, email));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return result;
    }


    public static List<News> getNews() {
        List<News> result = new ArrayList<News>();
        Connection con = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(burl);
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM mydbtest.news");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {//    public News(int newsId, String tittle, String text, String author) не 1 2 3 4 ТК конструктор уже написали в другой последовательности
                result.add(new News(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4), resultSet.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return result;
    }


    public boolean checkName(String log) throws SQLException {
        ResultSet resultSet = null;
        boolean bool = false;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            //creating connection with the database
            Connection con = DriverManager.getConnection(burl);


            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM userslog ;");
         //   PreparedStatement preparedStatement = con.prepareStatement("ctktrrc * FROM userslog ;");

            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                bool = log.equals(resultSet.getString("name"));
                if (bool) {
                    break;
                } else {
                    continue;
                }
            }
            preparedStatement.close();
            con.close(); //close connection
 } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (bool) {
            return true;
        } else
            return false;

    }



//возвращает текст новости  по айди (айди преобразуем в int)
    public static String getNews(String id2) {

        int id = Integer.parseInt(id2);
        String text = "some text...";
        Connection con = null;
        ResultSet resultSet = null;


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(burl);

            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM mydbtest.news ");//можно было бы получить по конкретному id, используя WHERE id =...
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                if (resultSet.getInt(1) == id) {
                    text = resultSet.getString("text");
break;// id уникальны
                }


            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return text;
    }


    public static List<Comment> getComments() {
        List<Comment> result = new ArrayList<Comment>();
        Connection con = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(burl);
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM mydbtest.comments");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {//public Comment(int id, int idnews, String author, String text) - сигнатура
                result.add(new Comment(resultSet.getInt(1), resultSet.getInt(4), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return result;
    }


    public static List<Comment> getONEComments(int iiid) {
        List<Comment> result = new ArrayList<Comment>();
        Connection con = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(burl);
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM mydbtest.comments");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {//public Comment(int id, int idnews, String author, String text)

                if (resultSet.getInt(4) == iiid) {
                    result.add(new Comment(resultSet.getInt(1), resultSet.getInt(4), resultSet.getString(2), resultSet.getString(3)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return result;
    }


    //метод  для добавления новости

    public void addNews(String title, String text, String author) throws SQLException {
        ResultSet resultSet = null;
        boolean bool = false;


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            //creating connection with the database
            Connection con = DriverManager.getConnection(burl);


            PreparedStatement preparedStatement = con.prepareStatement("insert into news (title,awthor,text) values ('" + title + "','" + author + "','" + text + "');");

            bool = preparedStatement.execute();

            preparedStatement.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    //добавляем почту пользователю или обнволяет! её
    public void addEmail(int iduser, String email) throws SQLException {
        ResultSet resultSet = null;
        boolean bool = false;


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            //creating connection with the database
            Connection con = DriverManager.getConnection(burl);


            PreparedStatement preparedStatement = con.prepareStatement("UPDATE `mydbtest`.`userslog` SET `email`='" + email + "' WHERE `id`='" + iduser + "';");

            bool = preparedStatement.execute();// выполняем

            preparedStatement.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    //получаем почту по айди
    public String getEmail(int id) throws SQLException, ClassNotFoundException {
        String result = null;
        ResultSet resultSet = null;
        boolean bool = false;

        Class.forName("com.mysql.cj.jdbc.Driver");


        //creating connection with the database
        Connection con = DriverManager.getConnection(burl);

// можем получить конкретную почту "SELECT email FROM userslog WHERE id=id
        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM userslog ;");


        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getInt(1) == id) {
                result = resultSet.getString("email");
 break; //id уникальны, там не будет повторений
            }
        }
  return result; }





//добавляем коммент
public void addComment(String author_name, String text,int idnews) throws SQLException {
    ResultSet resultSet = null;
    boolean bool = false;


    try {

        Class.forName("com.mysql.cj.jdbc.Driver");


        //creating connection with the database
        Connection con = DriverManager.getConnection(burl);


        PreparedStatement preparedStatement = con.prepareStatement("insert into comments (author, text, idnews) values ('"+author_name+"','"+text+"','"+idnews+"');");

        bool = preparedStatement.execute();

        preparedStatement.close();
        con.close();

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }


}







//получение списка новостей по автору
public static List<News> getAuthorNews(String author) {
    List<News> result = new ArrayList<News>();
    Connection con = null;
    ResultSet resultSet = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(burl);
        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM mydbtest.news WHERE awthor ='" + author + "'");

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            result.add(new News(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4), resultSet.getString(3)));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    return result;
}


    public int getIdTranslation(String word) throws ClassNotFoundException, SQLException {
        int s=6;

        ResultSet resultSet = null;
        boolean bool = false;

        Class.forName("com.mysql.cj.jdbc.Driver");


        //creating connection with the database
        Connection con = DriverManager.getConnection(burl);

// можем получить конкретную почту "SELECT email FROM userslog WHERE id=id
        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM dicrionary ;");


        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getString(2).equals(word)) {
                s = resultSet.getInt(1);
                break;
            }

            if (resultSet.getString(3).equals(word)) {
                s = resultSet.getInt(1);
                break;
            }

        }

        return s;
    }



    public static String getRuTranslation(int id) throws ClassNotFoundException, SQLException {
        String s="not found ru word";

        ResultSet resultSet = null;
        boolean bool = false;

        Class.forName("com.mysql.cj.jdbc.Driver");


        //creating connection with the database
        Connection con = DriverManager.getConnection(burl);


        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM dicrionary ;");


        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getInt(1) == id) {
                s = resultSet.getString(3);
                break;
            }



        }


        return s;
    }





    public static String getEngTranslation(int id) throws ClassNotFoundException, SQLException {
        String s="not found eng word";

        ResultSet resultSet = null;
        boolean bool = false;

        Class.forName("com.mysql.cj.jdbc.Driver");


        //creating connection with the database
        Connection con = DriverManager.getConnection(burl);

// можем получить конкретную почту "SELECT email FROM userslog WHERE id=id
        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM dicrionary ;");


        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getInt(1) == id) {
                s = resultSet.getString(2);
                break;
            }



        }


        return s;
    }






    public void addWord(String engWord, String rusWord) throws SQLException {
        ResultSet resultSet = null;
  boolean bool;


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            //creating connection with the database
            Connection con = DriverManager.getConnection(burl);


            PreparedStatement preparedStatement = con.prepareStatement("insert into dicrionary (eng,rus) values ('" + engWord + "','" + rusWord + "');");


            bool = preparedStatement.execute();
            preparedStatement.close();
            con.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }













}