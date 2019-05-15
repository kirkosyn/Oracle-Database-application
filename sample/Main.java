package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {
    static Connection conn;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        DatabaseConnect databaseConnect = new DatabaseConnect();
        try
        {
            conn = databaseConnect.GetConn();
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM PRACOWNICY");

            while(rs.next())
            {
                System.out.println(rs.getObject(2));
            }
        }
        catch (SQLException ex)
        {

        }

    }
}
