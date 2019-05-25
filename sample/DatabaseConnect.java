package sample;

import javafx.scene.control.Alert;

import javax.xml.crypto.Data;
import java.sql.*;

public class DatabaseConnect {

    public static Connection connection;

    public DatabaseConnect() {

    }

    public static void ConnectToDatabase() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "KPAWLUK";
        String pwd = "wbd2019";

        try {
            connection = DriverManager.getConnection(url, user, pwd);

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.toString());
            alert.show();
        }

    }

    public static void DisconnectConnection() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e){
            throw e;
        }
    }

    public static ResultSet ExecuteStatement(String cmd) throws SQLException {
        ResultSet rs = null;
        Statement state = null;

        try {
            state = connection.createStatement();
            rs = state.executeQuery(cmd);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (state != null) {
                state.close();
            }
            DisconnectConnection();
        }
        return rs;
    }

    public static void ExecuteUpdateStatement(String cmd) throws SQLException {
        Statement state = null;
        try {
            state = connection.createStatement();

            state.executeUpdate(cmd);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            if (state != null)
                state.close();
            DisconnectConnection();
        }

    }
}
