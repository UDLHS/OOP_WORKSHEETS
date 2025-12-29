package worksheet7;

import java.sql.*;

public class Sql {

    String url = "jdbc:mysql://localhost:3306/registration?useSSL=false";
    String uname = "root";
    String password = "mysql@123";

    public void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }


    public void getConnection() {

        try {
            Connection connection = DriverManager.getConnection(url, uname, password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }


}
