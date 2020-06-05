package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import plantenApp.java.dao.Database;
import plantenApp.java.dao.InfoTablesDAO;
import plantenApp.java.model.InfoTables;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class Controller {
    public ComboBox cboType;
    public ComboBox cboFamilie;
    public ComboBox cboBladgrootte;
    public ComboBox cboBladvorm;
    public ComboBox cboMaand;
    public ComboBox cboRatio;
    public ComboBox cboReactie;
    public ComboBox cboSpruitFenologie;
    private Connection dbConnection;

    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();

        /* infotabel object aanmaken */
        InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        InfoTables infoTables = infotablesDAO.getInfoTables();


        /*opvullen combobox Methode*/
        FillComboboxes(infoTables);
    }

    /**
     * @param infotables -> lijst van alle lijsten van gegevens uit de naakte tabellen
     * @author bradley
     * Functie om comboboxes te vullen met alle gegevens uit de database
     */
    private void FillComboboxes(InfoTables infotables) {
        //type
        System.out.println(infotables.getTypes().toString());
        cboType.getItems().addAll(infotables.getTypes());
        //familie
        System.out.println(infotables.getFamilies().toString());
        cboFamilie.getItems().addAll(infotables.getFamilies());
        //bladgrootte
        cboBladgrootte.getItems().addAll(infotables.getBladgroottes());
        //bladvorm
        cboBladvorm.getItems().addAll(infotables.getBladvormen());
        //Levensvorm
        //BehandelingMaand
        cboMaand.getItems().addAll("Januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december");
        //ratio
        cboRatio.getItems().addAll(infotables.getBloeiBladRatios());
        //spruitfenologie
        cboSpruitFenologie.getItems().addAll(infotables.getSpruitfenologieen());
        //reactie antagonistische omgeving
        //    cboReactie.getItems().addAll(infotables.getAntagonistischeOmgevingsReacties());
        //behandeling

    }
    public void plantToevoegenScherm(MouseEvent mouseEvent) throws IOException {
        //Hier typ je gewenste scherm dat opent)

        Parent root = FXMLLoader.load(getClass().getResource("view/PlantToevoegen.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.show();
        window.setScene(scene);
    }
}