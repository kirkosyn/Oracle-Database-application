import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.DatabaseConnect;
import sample.Pracownik;
import sample.PracownikDAO;

import java.sql.*;
import java.util.ArrayList;

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

    @FXML
    TextField textImie;

    @FXML
    TextField textNazwisko;

    @FXML
    DatePicker textUrodzenie;

    @FXML
    TextField textPesel;

    @FXML
    TextField textBank;

    @FXML
    TextField textTelefon;
    @FXML
    TextField textSearch;
    @FXML
    ComboBox<String> textAntykwariat;

    @FXML
    ComboBox<String> textAdres;

    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button commitButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button updateButton;
    String bank;
    String imie;
    String nazwisko;
    String pesel;
    String telefon;
    Date data_urodzin;
    private boolean isAddingPracownik;

    public Controller() {
    }

    @FXML
    public void initialize() {
        try {
            DatabaseConnect.ConnectToDatabase();


        } catch (SQLException ex) {
            ShowAlert(ex.toString());
        }

        SetTableWithData();
    }

    public void RefreshTable() {
        pracownicy.clear();
        SetTableWithData();
    }

    public void SetTableWithData() {

        pracownicy = new PracownikDAO().GetAllPracownicy();

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

    public void EnableFields() {
        textAdres.setDisable(false);
        textAntykwariat.setDisable(false);
        textBank.setDisable(false);
        textImie.setDisable(false);
        textNazwisko.setDisable(false);
        textPesel.setDisable(false);
        textTelefon.setDisable(false);
        textUrodzenie.setDisable(false);

        cancelButton.setDisable(false);
        commitButton.setDisable(false);
    }

    public void DisableFields() {
        ClearFields();

        textAdres.setDisable(true);
        textAntykwariat.setDisable(true);
        textBank.setDisable(true);
        textImie.setDisable(true);
        textNazwisko.setDisable(true);
        textPesel.setDisable(true);
        textTelefon.setDisable(true);
        textUrodzenie.setDisable(true);

        cancelButton.setDisable(true);
        commitButton.setDisable(true);
    }

    private void ClearFields()
    {
        textUrodzenie.getEditor().clear();
        textAdres.getEditor().clear();
        textAntykwariat.getEditor().clear();
        textBank.clear();
        textImie.clear();
        textTelefon.clear();
        textPesel.clear();
        textNazwisko.clear();

    }

    public void SearchEntry() throws SQLException {
        try {
            ObservableList<Pracownik> new_pracownicy = new PracownikDAO().SearchPracownik(textSearch.getText());
            pracownicy.clear();
            tablePracownicy.setItems(new_pracownicy);

        } catch (SQLException ex) {
            ShowAlert(ex.toString());
        }
    }

    public boolean CheckEntries(String imie, String nazwisko, Date data_urodzin, String pesel, String telefon, String bank) {
        if (imie == null || nazwisko == null || data_urodzin == null || telefon == null || bank == null)
            return false;
        if (imie.matches(".*\\d.*") || nazwisko.matches(".*\\d.*"))
            return false;

        return true;
    }

    public ArrayList GetEntries() throws NullPointerException {
        ArrayList al = new ArrayList();
        String bank = textBank.getText();
        String imie = textImie.getText();
        String nazwisko = textNazwisko.getText();
        String pesel = textPesel.getText();
        String telefon = textTelefon.getText();
        Date data_urodzin = Date.valueOf(textUrodzenie.getValue());

        al.add(imie);
        al.add(nazwisko);
        al.add(data_urodzin);
        al.add(pesel);
        al.add(telefon);
        al.add(bank);

        return al;
    }

    public void InsertPracownikAction() {
        EnableFields();
        isAddingPracownik = true;
    }

    public String InsertPracownik() throws SQLException {
        ArrayList al = GetEntries();
        try {
            bank = al.get(5).toString();
            imie = al.get(0).toString();
            imie = imie.substring(0,1).toUpperCase() + imie.substring(1);
            nazwisko = al.get(1).toString();
            nazwisko = nazwisko.substring(0,1).toUpperCase() + nazwisko.substring(1);
            pesel = al.get(3).toString();
            telefon = al.get(4).toString();
            data_urodzin = Date.valueOf(al.get(2).toString());
        } catch (NullPointerException ex) {
            ShowAlert(ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            ShowAlert(ex.toString());
        }

        if (CheckEntries(imie, nazwisko, data_urodzin, pesel, telefon, bank)) {
            /*try {

            } catch (SQLException ex) {
                ShowAlert(ex.toString());
            }
        } else {
            ShowAlert("Jedno z pól zawiera nieprawidłowe dane!");
        }*/
        }

        String cmd = new PracownikDAO().InsertPracownik(imie, nazwisko, data_urodzin, pesel, telefon, bank);

        return cmd;
    }

    public void CancelEntries() {
        DisableFields();
        try {
            ResultSet rs = DatabaseConnect.ExecuteStatement("ROLLBACK");
        } catch (SQLException ex) {
            ShowAlert(ex.toString());
        }
    }

    public void DeleteEntry() throws SQLException {
        Pracownik pracownik = tablePracownicy.getSelectionModel().getSelectedItem();
        int id = pracownik.getId_pracownika();
        try {
            new PracownikDAO().DeletePracownik(id);
        } catch (SQLException ex) {
            ShowAlert(ex.toString());
        }
        commitButton.setDisable(false);
        cancelButton.setDisable(false);
        RefreshTable();
    }

    public void CommitEntry() throws SQLException {
        String cmd = null;// = "COMMIT";
        if (isAddingPracownik) {
            cmd = InsertPracownik();
        }
        DatabaseConnect.ExecuteUpdateStatement(cmd);
        RefreshTable();
        DisableFields();
    }

    private void ShowAlert(Object ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(ex.toString());
        alert.show();
    }
}
