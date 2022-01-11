package wyszukiwarka.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import wyszukiwarka.Config.DbConnect;
import wyszukiwarka.Config.Przejazd;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PrzejazdController implements Initializable {
    @FXML
    private TableView<Przejazd> rozpiskaTableView;
    @FXML
    private TableColumn<Przejazd, String> nazwa;
    @FXML
    private TableColumn<Przejazd, Integer> numer;
    @FXML
    private TableColumn<Przejazd, String> stacjaPoczatek;
    @FXML
    private TableColumn<Przejazd, String> stacjaKoniec;
    @FXML
    private TableColumn<Przejazd, String> dataOdjazdu;

    private ObservableList<Przejazd> przejazds; //deklaracja listy
    private Connection connection;
    DbConnect dbConnect;

    public void rozpiskaTableView(String stacjaPoczatkowa, String stacjaKoncowa, LocalDate data, Object godzina, Object minuta) {
        try {
            przejazds = FXCollections.observableArrayList();
            String dataOdjazdu = data + " " + godzina + ":" + minuta;
            String query = "SELECT * FROM pociagi " +
                    "INNER JOIN rozpiska ON pociagi.idPociagu = rozpiska.idPociagu " +
                    "INNER JOIN trasa ON rozpiska.idTrasy = trasa.idTrasy " +
                    "INNER JOIN stacja ON stacja.idStacji = trasa.idStacjiPoczatkowej " +
                    "WHERE " +
                    "trasa.idStacjiPoczatkowej = (SELECT idStacji FROM stacja WHERE nazwaStacji = '" + stacjaPoczatkowa + "') " +
                    "AND trasa.idStacjiKoncowej = (SELECT idStacji FROM stacja WHERE nazwaStacji = '" + stacjaKoncowa + "') " +
                    "AND dataOdjazdu > '" + dataOdjazdu + "' " +
                    "ORDER BY dataOdjazdu " +
                    "LIMIT 3 ";
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                Przejazd przejazd = new Przejazd();
                przejazd.setNazwa(rs.getString("nazwaTrasy"));
                przejazd.setNumerPociagu(rs.getInt("idPociagu"));
                przejazd.setStacjaPoczatkowa(stacjaPoczatkowa);
                przejazd.setStacjaKoncowa(stacjaKoncowa);
                przejazd.setDataOdjazdu(rs.getString("dataOdjazdu"));
                przejazds.add(przejazd); //wpisanie do listy
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        numer.setCellValueFactory(new PropertyValueFactory<>("numerPociagu"));
        stacjaPoczatek.setCellValueFactory(new PropertyValueFactory<>("stacjaPoczatkowa"));
        stacjaKoniec.setCellValueFactory(new PropertyValueFactory<>("stacjaKoncowa"));
        dataOdjazdu.setCellValueFactory(new PropertyValueFactory<>("dataOdjazdu")); //wpisanie

        rozpiskaTableView.setItems(przejazds);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnect = new DbConnect();
        connection = dbConnect.getConnection();
    }
}
