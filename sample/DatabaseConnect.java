package sample;

import javafx.scene.control.Alert;

import javax.xml.crypto.Data;
import java.sql.*;

public class DatabaseConnect {

    public static Connection connection;

    public DatabaseConnect()
    {

    }

    public Connection GetConn() throws SQLException
    {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "KPAWLUK";
        String pwd = "wbd2019";

        try
        {
            connection = DriverManager.getConnection(url, user, pwd);
            return connection;
        }
        catch(SQLException ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
        }

        return connection;
    }
}
