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
    //Connectie
    private Connection dbConnection;

    public void initialize() throws SQLException{
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

    //Buttin om een behandeling toe te voegen
    public void clicked_BehandelingToevoegen(MouseEvent mouseEvent) {
        String sBehandeling = txtBehandeling.getText();
        cboBehandeling.getItems().add(sBehandeling);
    }

    public void clicked_ToevoegenBeheerdaad(MouseEvent mouseEvent) throws SQLException {
        //Vars voor beheer
        String sBehandeling = cboBehandeling.getValue().toString();
        String sOpmerking = txtOpmerking.getText();
        int iJaar = (int) spnJaar.getValue();


        //Toevoegen beheersdaad_eigenschappen
        //BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        //Beheer beheer = new Beheer(
          //      ,
            //    createBeheerEig(lvLijstBehandeling, plant)

        //);

        //beheer.createBeheer(beheer);
        Beheerdaad_Eigenschap beheerdaadEigenschap = new Beheerdaad_Eigenschap(
                sBehandeling,
                sOpmerking,
                controleMaanden(),
                iJaar
        );
        //beheerDAO.createBeheerEigenschap(beheerdaadEigenschap);
    }

    public void createBeheerEig(ArrayList array, Plant plant) throws SQLException {

        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        Beheerdaad_Eigenschap beheerEig = new Beheerdaad_Eigenschap(
                plant.getId(),
                (String) array.get(0),
                (String) array.get(1),
                (String) array.get(2),
                (int)    array.get(3)
        );
        //beheerDAO.createBeheerEigenschap(beheerEig, plant);

    }




    public String controleMaanden(){
        String sMaand = " ";
        if (chbJanuari.isSelected()) {
            sMaand += chbJanuari.getText();
        }
        else if(chbFebruari.isSelected()){
            sMaand += chbFebruari.getText();
        }
        else if (chbMaart.isSelected()){
            sMaand += chbMaart.getText();
        }
        else if (chbApril.isSelected()){
            sMaand += chbApril.getText();
        }
        else if (chbMei.isSelected()){
            sMaand += chbMei.getText();
        }
        else if (chbJuni.isSelected()){
            sMaand += chbJuni.getText();
        }
        else if (chbJuli.isSelected()){
            sMaand += chbJuli.getText();
        }
        else if (chbAugustus.isSelected()){
            sMaand += chbAugustus.getText();
        }
        else if (chbSeptember.isSelected()){
            sMaand += chbSeptember.getText();
        }
        else  if (chbOktober.isSelected()){
            sMaand += chbOktober.getText();
        }
        else if(chbNovember.isSelected()){
            sMaand += chbNovember.getText();
        }
        else if (chbDecember.isSelected()){
            sMaand += chbDecember.getText();
        }
        else {
            sMaand = "null";
        }
        return sMaand;
    }
}
