package model.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static Connection connection;
    private ConnectionFactory(){}

    static{
        try(InputStream input = new FileInputStream("resources/db.properties")) {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Properties properties = new Properties();
            properties.load(input);

            String url = properties.getProperty("CONNECTION_URL");
            String user = properties.getProperty("CONNECTION_USER");
            String pass = properties.getProperty("CONNECTION_PASS");

            connection = DriverManager.getConnection(url, user, pass);

        }catch (IOException | SQLException  e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return connection;
    }
}
