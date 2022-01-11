package wyszukiwarka.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import wyszukiwarka.Config.DbConnect;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WyszukiwarkaController implements Initializable {

    @FXML
    private TextField stacjaPoczatkowa;
    @FXML
    private TextField stacjaKoncowa;
    @FXML
    private DatePicker data;
    @FXML
    private ComboBox godzina;
    @FXML
    private ComboBox minuta;

    private Connection connection;
    DbConnect dbConnect;

    public void wyczysc(ActionEvent actionEvent) {
        stacjaPoczatkowa.clear();
        stacjaKoncowa.clear();
        data.setValue(null);
        godzina.getSelectionModel().clearSelection();
        minuta.getSelectionModel().clearSelection();
    }

    public void szukaj(ActionEvent actionEvent) throws IOException, SQLException {
        if (stacjaPoczatkowa.getText().isEmpty()
                || stacjaKoncowa.getText().isEmpty()
                || data.getValue() == null
                || godzina.getSelectionModel().isEmpty()
                || minuta.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd danych");
            alert.setHeaderText("Musisz uzupełnić wszystkie pola");
            alert.showAndWait();
        } else {
            String query = "SELECT * FROM stacja WHERE nazwaStacji = '" + stacjaPoczatkowa.getText() + "' OR nazwaStacji = '" + stacjaKoncowa.getText() + "'";
            ResultSet rs = connection.createStatement().executeQuery(query);
            int i = 0; //ilość zwróconych wyników
            while (rs.next()) {
                i++;
            }
            if (i == 0 || i == 1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd danych");
                alert.setHeaderText("Błąd - jedna ze stacji nie istnieje");
                alert.showAndWait();
            } else {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/wyszukiwarka/przejazd.fxml"));
                AnchorPane anchorPane = fxmlLoader.load(); //przypisanie i wywołanie okienka przejazd
                PrzejazdController przejazd = fxmlLoader.getController();
                przejazd.rozpiskaTableView(stacjaPoczatkowa.getText(), stacjaKoncowa.getText(), data.getValue(), godzina.getSelectionModel().getSelectedItem(), minuta.getSelectionModel().getSelectedItem());
                Stage stage = new Stage();
                Scene scene = new Scene(anchorPane);
                stage.setScene(scene);
                stage.setTitle("Rozkład jazdy");
                stage.show();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnect = new DbConnect();
        connection = dbConnect.getConnection();
        for (int i = 00; i <= 23; i++) {
            godzina.getItems().add(i);
        }
        for (int i = 00; i <= 59; i++) {
            minuta.getItems().add(i);
        }
    }
}
