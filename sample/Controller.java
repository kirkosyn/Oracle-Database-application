import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.DatabaseConnect;
import sample.Pracownik;

import java.sql.Connection;
import java.sql.SQLException;

public class Controller {
    static Connection conn;
    private ObservableList<Pracownik> pracownicy = FXCollections.observableArrayList();

    @FXML
    private TableView<Pracownik> tablePracownicy;

    @FXML
    private TableColumn<Pracownik, Integer> columnIdPracownika;

    @FXML
    private TableColumn<Pracownik, String> columnImiePracownika;

    @FXML
    private TableColumn<Pracownik, String> columnNazwiskoPracownika;

    @FXML
    private TableColumn<Pracownik, String> columnDataUrPracownika;

    @FXML
    private TableColumn<Pracownik, String> columnPeselPracownika;

    @FXML
    private TableColumn<Pracownik, String> columnNrKontaPracownika;

    @FXML
    private TableColumn<Pracownik, String> columnNrTelPracownika;

    @FXML
    private TableColumn<Pracownik, Integer> columnIdAntykwariatu;

    @FXML
    private TableColumn<Pracownik, Integer> columnIdAdresu;

    public Controller() {
    }

    @FXML
    public void initialize() {
        try {
            conn = new DatabaseConnect().GetConn();


        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.toString());
            alert.show();
        }

        SetTableWithData(conn);
    }


    public void SetTableWithData(Connection conn)
    {

        pracownicy = new Pracownik().GetAllPracownicy(conn);

        columnIdPracownika.setCellValueFactory(new PropertyValueFactory<>("id_pracownika"));
        columnImiePracownika.setCellValueFactory(new PropertyValueFactory<>("imie"));
        columnNazwiskoPracownika.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        columnDataUrPracownika.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia"));
        columnPeselPracownika.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        columnNrKontaPracownika.setCellValueFactory(new PropertyValueFactory<>("nr_konta_bankowego"));
        columnNrTelPracownika.setCellValueFactory(new PropertyValueFactory<>("nr_telefonu"));
        columnIdAntykwariatu.setCellValueFactory(new PropertyValueFactory<>("id_antykwariatu"));
        columnIdAdresu.setCellValueFactory(new PropertyValueFactory<>("id_adresu"));


        tablePracownicy.setItems(pracownicy);
       /* tablePracownicy.getColumns().addAll(columnIdPracownika, columnImiePracownika,
                columnNazwiskoPracownika, columnDataUrPracownika, columnPeselPracownika,
                columnNrKontaPracownika, columnNrTelPracownika, columnIdAntykwariatu, columnIdAdresu);

        tablePracownicy.refresh();*/
    }

}
