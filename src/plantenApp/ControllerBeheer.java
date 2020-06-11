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
import plantenApp.java.dao.InfoTablesDAO;
import plantenApp.java.model.*;

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
    public Label lblPlantnaam;
    //Connectie
    private Connection dbConnection;
    Plant objectPlant;

    public void initialize(Plant plant) throws SQLException {
        objectPlant = plant;
        dbConnection = Database.getInstance().getConnection();
        /* infotabel object aanmaken */
        InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        InfoTables infoTables = infotablesDAO.getInfoTables();
        /*opvullen combobox Methode*/
        FillComboboxes(infoTables);
        lblPlantnaam.setText(objectPlant.getFgsv());
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
    public void clicked_OpmerkingToevoegen(MouseEvent mouseEvent) throws SQLException {
        String sMaand = null;
        for (int i = 0; i < 12; i++) {
            switch (i) {
                case 0:
                    if (chbJanuari.isSelected()) {
                        sMaand = chbJanuari.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 1:
                    if (chbFebruari.isSelected()) {
                        sMaand = chbFebruari.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 2:
                    if (chbMaart.isSelected()) {
                        sMaand = chbMaart.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 3:
                    if (chbApril.isSelected()) {
                        sMaand = chbApril.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 4:
                    if (chbMei.isSelected()) {
                        sMaand = chbMei.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 5:
                    if (chbJuni.isSelected()) {
                        sMaand = chbJuni.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 6:
                    if (chbJuli.isSelected()) {
                        sMaand = chbJuli.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 7:
                    if (chbAugustus.isSelected()) {
                        sMaand = chbAugustus.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 8:
                    if (chbSeptember.isSelected()) {
                        sMaand = chbSeptember.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 9:
                    if (chbOktober.isSelected()) {
                        sMaand = chbOktober.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 10:
                    if (chbNovember.isSelected()) {
                        sMaand = chbNovember.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
                case 11:
                    if (chbDecember.isSelected()) {
                        sMaand = chbDecember.getText();
                        beheersdaadaanmaken(sMaand);
                    }
                    break;
            }
        }
    }

    public void beheersdaadaanmaken(String sMaand) {
        try {
            cboBehandeling.getValue().toString();
        } catch (NullPointerException except) {
            JOptionPane.showMessageDialog(null, "Behandeling moet ingevuld zijn");
        }

        if (txtOpmerking.getText().equals("")) {
            int iResp = JOptionPane.showConfirmDialog(null, "bent u zeker dat u geen opmerking wenst in te geven ?");
            if (iResp == 0) {
                System.out.println(iResp);
                String sOpmerking = "";
                String sBehandeling = cboBehandeling.getValue().toString();
                int iFrequentie = Integer.parseInt(spnJaar.getValue().toString());
                Beheerdaad_Eigenschap beheerEig = new Beheerdaad_Eigenschap(
                        objectPlant.getId(),
                        sBehandeling,
                        sOpmerking,
                        sMaand,
                        iFrequentie);

                lvLijstBehandeling.getItems().add(beheerEig);
            }
        } else {
            String sOpmerking = txtOpmerking.getText();
            String sBehandeling = cboBehandeling.getValue().toString();
            int iFrequentie = Integer.parseInt(spnJaar.getValue().toString());
            Beheerdaad_Eigenschap beheerEig = new Beheerdaad_Eigenschap(
                    objectPlant.getId(),
                    sBehandeling,
                    sOpmerking,
                    sMaand,
                    iFrequentie);

            lvLijstBehandeling.getItems().add(beheerEig);
        }

    }

    //Button om een object van de lijst te verwijderen
    public void clicked_verwijderlijstitems(MouseEvent mouseEvent) {

        lvLijstBehandeling.getItems().remove(lvLijstBehandeling.getSelectionModel().getSelectedItem());
        lvLijstBehandeling.refresh();
    }

    //Button om een behandeling extra toe te voegen aan de combobox en de DB beheerdaad
    public void clicked_BehandelingToevoegen(MouseEvent mouseEvent) throws SQLException {

        String swaarde = txtBehandeling.getText();
        int iAntwoord = JOptionPane.showConfirmDialog(null, "Wenst u deze beheerdaad toe te voegen?");
        if (iAntwoord == 0) {
            BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
            beheerDAO.createBeheer(swaarde);
            cboBehandeling.getItems().add(swaarde);
        }

    }

    // schrijven van de data naar de DB
    public void clicked_ToevoegenBeheerdaad(MouseEvent mouseEvent) throws SQLException {

        int iResp = JOptionPane.showConfirmDialog(null, "Wenst u deze beheersdaden op te slaan in de databank ?");
        if (iResp == 0) {
            BeheerDAO beheerdao = new BeheerDAO(dbConnection);
            ArrayList<Beheerdaad_Eigenschap> arrBeheerEig = new ArrayList<>();
            arrBeheerEig.addAll(lvLijstBehandeling.getItems());
            System.out.println(arrBeheerEig);
            for (int i = 0; i < arrBeheerEig.size() - 1; i++) {
                beheerdao.createBeheerEigenschap(arrBeheerEig.get(i));
            }
        }
    }
}