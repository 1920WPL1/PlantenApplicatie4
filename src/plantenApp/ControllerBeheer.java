package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import plantenApp.java.dao.BeheerDAO;
import plantenApp.java.dao.Database;
import plantenApp.java.dao.FenotypeDAO;
import plantenApp.java.dao.InfoTablesDAO;
import plantenApp.java.model.*;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerBeheer {
    //Alle checkboxen voor de maanden
    public CheckBox chbJanuari;
    public CheckBox chbFebruari;
    public CheckBox chbMaart;
    public CheckBox chbApril;
    public CheckBox chbMei;
    public CheckBox chbJuni;
    public CheckBox chbJuli;
    public CheckBox chbAugustus;
    public CheckBox chbSeptember;
    public CheckBox chbOktober;
    public CheckBox chbNovember;
    public CheckBox chbDecember;
    //Alle velden voor een bestaande behandeling
    public ComboBox cboBehandeling;
    public Spinner spnJaar;
    public TextArea txtOpmerking;
    public ListView lvLijstBehandeling;
    //Alle velden voor een nieuwe behandeling
    public TextField txtBehandeling;
    public Label lblPlant_id;
    //Connectie
    private Connection dbConnection;
    Plant Vlant;

    public void initialize(Plant plant) throws SQLException {
        Vlant=plant;
        dbConnection = Database.getInstance().getConnection();
        /* infotabel object aanmaken */
        InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        InfoTables infoTables = infotablesDAO.getInfoTables();
        /*opvullen combobox Methode*/
        FillComboboxes(infoTables);
    }

    private void FillComboboxes(InfoTables infoTables) {
        //beheerdaden
        cboBehandeling.getItems().addAll(infoTables.getBeheerdaden());
    }

    /* !!!!Click Events!!!!!*/
   //Button om terug te gaan naar de vorig pagina
    public void clicked_TerugGaan(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/PlantToevoegen.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.show();
        window.setScene(scene);
    }

    //Button om een opmerking toe te voegen
    public void clicked_OpmerkingToevoegen(MouseEvent mouseEvent) {
        lvLijstBehandeling.getItems().add(cboBehandeling.getValue().toString());
    }

    //Button om een opmerking te verwijderen
    public void clicked_OpmerkingVerwijderen(MouseEvent mouseEvent) {
        lvLijstBehandeling.getItems().remove(lvLijstBehandeling.getSelectionModel().getSelectedItem());
        lvLijstBehandeling.refresh();
    }

    //Button om een behandeling toe te voegen
    public void clicked_BehandelingToevoegen(MouseEvent mouseEvent) throws SQLException {

        String swaarde = txtBehandeling.getText();
        int iAntwoord = JOptionPane.showConfirmDialog(null, "Wenst u deze beheerdaad toe te voegen?");
        if (iAntwoord == 0) {
            BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
            beheerDAO.createBeheer(swaarde);
            cboBehandeling.getItems().add(swaarde);
        }

    }


    public void clicked_ToevoegenBeheerdaad(MouseEvent mouseEvent) throws SQLException {
        //String sPlant_id = lblPlant_id.getText();
        createBeheerEig();

    }

    public void createBeheerEig() throws SQLException {
        for (int i = 0; i < 12; i++) {
            String sBehandeling = cboBehandeling.getValue().toString();
            String sOpmerking = txtOpmerking.getText();
            CheckBox checkBox = null;
            switch (i){
                case 0:
                    checkBox = chbJanuari;
                    break;
                case 1:
                    checkBox = chbFebruari;
                    break;
                case 2:
                    checkBox = chbMaart;
                    break;
                case 3:
                    checkBox = chbApril;
                    break;
                case 4:
                    checkBox = chbMei;
                    break;
                case 5:
                    checkBox = chbJuni;
                    break;
                case 6:
                    checkBox = chbJuli;
                    break;
                case 7:
                    checkBox = chbAugustus;
                    break;
                case 8:
                    checkBox = chbSeptember;
                    break;
                case 9:
                    checkBox = chbOktober;
                    break;
                case 10:
                    checkBox = chbNovember;
                    break;
                case 11:
                    checkBox = chbDecember;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Geen maanden aangeduid!");
            }
            String sMaand = checkCheckbox(checkBox);
            int iJaar = (int) spnJaar.getValue();
            BeheerDAO beheerDAO = new BeheerDAO(dbConnection);

            Beheerdaad_Eigenschap beheerEig = new Beheerdaad_Eigenschap(
                    Vlant.getId(),
                    sBehandeling,
                    sOpmerking,
                    sMaand,
                    iJaar
            );
            beheerDAO.createBeheerEigenschap(beheerEig);
        }
    }

    public String checkCheckbox(CheckBox chb) {
        String sMaand = " ";
        if (chb.isSelected()) {
            sMaand = chb.getText();
        }
        return sMaand;
    }
}
