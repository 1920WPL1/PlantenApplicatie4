package plantenApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import plantenApp.java.dao.Database;
import plantenApp.java.dao.InfoTablesDAO;
import plantenApp.java.model.*;
import plantenApp.java.dao.*;
import plantenApp.java.model.Fenotype;
import plantenApp.java.model.InfoTables;
import plantenApp.java.model.Plant;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerPlantToevoegen {
    //Alle velden die ingevuld moeten worden bij Standaard
    public ComboBox cboType;
    public TextField txtFamilie;
    public TextField txtGeslacht;
    public TextField txtSoort;
    public TextField txtVariant;
    public Spinner spnMinPlantDicht;
    public Spinner spnMaxPlantDicht;
    //Alle velden die ingevuld moeten worden bij AbiotischeFactoren
    public ComboBox cboBezonning;
    public ComboBox cboVoedingsbehoefte;
    public ComboBox cboVochtbehoefte;
    public ComboBox cboReactieAntag;
    public ComboBox cboGrondsoort;
    public ComboBox cboHabitat;
    public ListView lvHabitat;
    //Alle velden die ingevuld moeten worden bij Commensalisme
    public ComboBox cboOntwikkelingssnelheid;
    //Alle checkboxen voor de verschillende  Sociabiliteiten
    public ToggleGroup Sociabiliteit;
    public RadioButton rdbSociabiliteit1;
    public RadioButton rdbSociabiliteit2;
    public RadioButton rdbSociabiliteit3;
    public RadioButton rdbSociabiliteit4;
    public RadioButton rdbSociabiliteit5;
    public RadioButton rdbSociabiliteitUnknow;
    //Alle radiobuttons voor de verschillende Strategieën
    public ToggleGroup StrategieToggle;
    public RadioButton rdbStrategieUnknown;
    public RadioButton rdbStrategieC;
    public RadioButton rdbStrategieCS;
    public RadioButton rdbStrategieCSR;
    public RadioButton rdbStrategieCR;
    public RadioButton rdbStrategieS;
    public RadioButton rdbStrategieSR;
    public RadioButton rdbStrategieR;
    //Alle velden die ingevuld moeten worden bij Fenotype
    public ComboBox cboBladgrootte;
    public ComboBox cboBladvorm;
    public ComboBox cboRatio;
    public ComboBox cboSpruitfenologie;
    //Alle radioButtons voor Levensvorm volgens Raunkhiaer
    public RadioButton rdbHydrofyt1;
    public RadioButton rdbHydrofyt2;
    public RadioButton rdbHelofyt3;
    public RadioButton rdbCryptophyt4;
    public RadioButton rdbCryptophyt5;
    public RadioButton rdbHemikryptofyt6;
    public RadioButton rdbChamaefyt7;
    public RadioButton rdbChamaefyt8;
    public RadioButton rdbFanerophyt9;
    //Alle spinners per maand voor Max Bladhoogte
    public Spinner spnBladhoogteJan;
    public Spinner spnBladhoogteFeb;
    public Spinner spnBladhoogteMaa;
    public Spinner spnBladhoogteApr;
    public Spinner spnBladhoogteMei;
    public Spinner spnBladhoogteJun;
    public Spinner spnBladhoogteJul;
    public Spinner spnBladhoogteAug;
    public Spinner spnBladhoogteSept;
    public Spinner spnBladhoogteOkt;
    public Spinner spnBladhoogteNov;
    public Spinner spnBladhoogteDec;
    //Alle comboxen per maand voor Bladkleur
    public ComboBox cboBladkleurJan;
    public ComboBox cboBladkleurFeb;
    public ComboBox cboBladkleurMaa;
    public ComboBox cboBladkleurApr;
    public ComboBox cboBladkleurMei;
    public ComboBox cboBladkleurJun;
    public ComboBox cboBladkleurJul;
    public ComboBox cboBladkleurAug;
    public ComboBox cboBladkleurSept;
    public ComboBox cboBladkleurOkt;
    public ComboBox cboBladkleurNov;
    public ComboBox cboBladkleurDec;
    //Alle spinners per maand voor Min Bloeihoogte
    public Spinner spnMinBloeihoogteJan;
    public Spinner spnMinBloeihoogteFeb;
    public Spinner spnMinBloeihoogteMaa;
    public Spinner spnMinBloeihoogteApr;
    public Spinner spnMinBloeihoogteMei;
    public Spinner spnMinBloeihoogteJun;
    public Spinner spnMinBloeihoogteJul;
    public Spinner spnMinBloeihoogteAug;
    public Spinner spnMinBloeihoogteSept;
    public Spinner spnMinBloeihoogteOkt;
    public Spinner spnMinBloeihoogteNov;
    public Spinner spnMinBloeihoogteDec;
    //Alle spinners per maand voor Max Bloeihoogte
    public Spinner spnMaxBloeihoogteJan;
    public Spinner spnMaxBloeihoogteFeb;
    public Spinner spnMaxBloeihoogteMaa;
    public Spinner spnMaxBloeihoogteApr;
    public Spinner spnMaxBloeihoogteMei;
    public Spinner spnMaxBloeihoogteJun;
    public Spinner spnMaxBloeihoogteJul;
    public Spinner spnMaxBloeihoogteAug;
    public Spinner spnMaxBloeihoogteSept;
    public Spinner spnMaxBloeihoogteOkt;
    public Spinner spnMaxBloeihoogteNov;
    public Spinner spnMaxBloeihoogteDec;
    //Alle comboboxen per maand voor Bloeikleur
    public ComboBox cboBloeikleurJan;
    public ComboBox cboBloeikleurFeb;
    public ComboBox cboBloeikleurMaa;
    public ComboBox cboBloeikleurApr;
    public ComboBox cboBloeikleurMei;
    public ComboBox cboBloeikleurJun;
    public ComboBox cboBloeikleurJul;
    public ComboBox cboBloeikleurAug;
    public ComboBox cboBloeikleurSept;
    public ComboBox cboBloeikleurOkt;
    public ComboBox cboBloeikleurNov;
    public ComboBox cboBloeikleurDec;
    //Alle radiobuttons voor Habitus
    public RadioButton rdbTufted;
    public RadioButton rdbUprightArching;
    public RadioButton rdbArching;
    public RadioButton rdbUprightDivergent;
    public RadioButton rdbUprightErect;
    public RadioButton rdbMounded;
    public RadioButton rdbMattenvormend;
    public RadioButton rdbWaaivormig;
    public RadioButton rdbKussenvormend;
    public RadioButton rdbZuilvomrig;
    public RadioButton rdbUitbuigend;
    //Alle radiobuttons voor Bloeiwijze
    public RadioButton rdbAar;
    public RadioButton rdbBredePluim;
    public RadioButton rdbEtage;
    public RadioButton rdbBolOfKnop;
    public RadioButton rdbMargrietachtig;
    public RadioButton rdbSchotel;
    public RadioButton rdbScherm;
    public RadioButton rdbSmallePluim;
    //Alle velden die ingevuld moeten worden bij Extra
    public ComboBox cboLevensduur;
    public ListView lvLevensduur;
    public Spinner spnNectarwaarde;
    public Spinner spnPollenwaarde;
    //Alle radiobuttons voor Bijvriendelijk
    public RadioButton rdbBijvriendelijkLeeg;
    public RadioButton rdbBijvriendelijkJa;
    public RadioButton rdbBijvriendelijkNeen;
    //Alle radiobuttons voor Vlindervriendelijk
    public RadioButton rdbVlindervriendelijkLeeg;
    public RadioButton rdbVlindervriendelijkJa;
    public RadioButton rdbVlindervriendelijkNeen;
    //Alle radiobuttons voor Eetbaar
    public RadioButton rdbEetbaarLeeg;
    public RadioButton rdbEetbaarJa;
    public RadioButton rdbEetbaarNeen;
    //Alle radiobuttons voor Kruidgebruik
    public RadioButton rdbKruidgebruikLeeg;
    public RadioButton rdbKruidgebruikJa;
    public RadioButton rdbKruidgebruikNeen;
    //Alle radiobuttons voor Geurend
    public RadioButton rdbGeurendLeeg;
    public RadioButton rdbGeurendJa;
    public RadioButton rdbGeurendNeen;
    //Alle radiobuttons voor Vorstgevoelig
    public RadioButton rdbVorstgevoeligLeeg;
    public RadioButton rdbVorstgevoeligJa;
    public RadioButton rdbVorstgevoeligNeen;
    //Button om terug te keren
    public Button btn_Terug;
    //Alle togglegroups overheen het hele project
    public ToggleGroup levensvormToggle;
    public ToggleGroup habitusToggle;
    public ToggleGroup bloeiwijzeToggle;
    public ToggleGroup BijvriendelijkToggle;
    public ToggleGroup VlindervriendelijkToggle;
    public ToggleGroup EetbaarToggle;
    public ToggleGroup KruidgebruikToggle;
    public ToggleGroup GeurendToggle;
    public ToggleGroup VorstgevoeligToggle;
    public Label lblHabitat;
    public Label lblLevensduur;
    public Label lblSociabiliteit;

    private Connection dbConnection;
    //arraylist van fenotype_Multi
    ArrayList<String> aBladhoogte = new ArrayList<>();
    ArrayList<String> aBladkleur = new ArrayList<>();
    ArrayList<String> aBloeihoogte = new ArrayList<>();
    ArrayList<Object> aBloeikleur = new ArrayList<Object>();
    String sNaamSpnbladhoogte;
    String sNaamSpnBloeihoogte;
    String sNaamCmbBladKleur;
    Object sNaamCmbBloeiKleur;





    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();

        /* infotabel object aanmaken */
        InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        InfoTables infoTables = infotablesDAO.getInfoTables();
        /*opvullen combobox Methode*/
        FillComboboxes(infoTables);
    }

    private void FillComboboxes(InfoTables infotables) {
        //type
        cboType.getItems().addAll(infotables.getTypes());
        //bladgrootte
        cboBladgrootte.getItems().addAll(infotables.getBladgroottes());
        //bladvorm
        cboBladvorm.getItems().addAll(infotables.getBladvormen());
        //Bezonning
        cboBezonning.getItems().addAll(infotables.getBezonningsMogelijkheden());
        //Voedingsbehoefte
        cboVoedingsbehoefte.getItems().addAll(infotables.getVoedingsbehoeftes());
        //Vochtbehoefte
        cboVochtbehoefte.getItems().addAll(infotables.getVochtbehoeftes());
        //ratio
        cboRatio.getItems().addAll(infotables.getBloeiBladRatios());
        //reactie Antagonistische
        cboReactieAntag.getItems().addAll(infotables.getAntagonistischeOmgevingsReacties());
        //Grond
        cboGrondsoort.getItems().addAll(infotables.getGrondsoorten());
        //Spruitfenologie
        cboSpruitfenologie.getItems().addAll(infotables.getSpruitfenologieen());
        //Ontwikkelingssnelheid
        cboOntwikkelingssnelheid.getItems().addAll(infotables.getOnstwikkelingssnelheden());
        //concurrentiekracht
        cboLevensduur.getItems().addAll(infotables.getConcurentiekrachten());

        //Bladkleur per maand
        cboBladkleurJan.getItems().addAll(infotables.getKleuren());
        cboBladkleurFeb.getItems().addAll(infotables.getKleuren());
        cboBladkleurMaa.getItems().addAll(infotables.getKleuren());
        cboBladkleurApr.getItems().addAll(infotables.getKleuren());
        cboBladkleurMei.getItems().addAll(infotables.getKleuren());
        cboBladkleurJun.getItems().addAll(infotables.getKleuren());
        cboBladkleurJul.getItems().addAll(infotables.getKleuren());
        cboBladkleurAug.getItems().addAll(infotables.getKleuren());
        cboBladkleurSept.getItems().addAll(infotables.getKleuren());
        cboBladkleurOkt.getItems().addAll(infotables.getKleuren());
        cboBladkleurNov.getItems().addAll(infotables.getKleuren());
        cboBladkleurDec.getItems().addAll(infotables.getKleuren());
        //Bloeikleur per maand
        cboBloeikleurJan.getItems().addAll(infotables.getKleuren());
        cboBloeikleurFeb.getItems().addAll(infotables.getKleuren());
        cboBloeikleurMaa.getItems().addAll(infotables.getKleuren());
        cboBloeikleurApr.getItems().addAll(infotables.getKleuren());
        cboBloeikleurMei.getItems().addAll(infotables.getKleuren());
        cboBloeikleurJun.getItems().addAll(infotables.getKleuren());
        cboBloeikleurJul.getItems().addAll(infotables.getKleuren());
        cboBloeikleurAug.getItems().addAll(infotables.getKleuren());
        cboBloeikleurSept.getItems().addAll(infotables.getKleuren());
        cboBloeikleurOkt.getItems().addAll(infotables.getKleuren());
        cboBloeikleurNov.getItems().addAll(infotables.getKleuren());
        cboBloeikleurDec.getItems().addAll(infotables.getKleuren());

        //habitat
        cboHabitat.getItems().addAll(infotables.getHabitats());
    }

    //Functie onder de button doe een nieuwe eigenschap voor habitat toevoegd

    public void clicked_ToevoegenHabitat(MouseEvent mouseEvent) {

        lvHabitat.getItems().add(cboHabitat.getValue().toString());
    }

    //Functie onder de button die een nieuwe eigenschap voor levensduur toevoegd
    public void clicked_ToevoegenLevensduur(MouseEvent mouseEvent) {
        lvLevensduur.getItems().add(cboLevensduur.getValue().toString());
    }

    //Functie onder de button die een plant toevoegd

    public void clicked_ToevoegenPlant(MouseEvent mouseEvent) throws SQLException {
        //vars voor plant
        String sType = cboType.getValue().toString();
        String sFam = txtFamilie.getText();
        String sGeslacht = txtGeslacht.getText();
        String sSoort = txtSoort.getText();
        String sVariant = txtVariant.getText();
        String fgsv = sFam + " " + sGeslacht + " " + sSoort + " '" + sVariant + "'";
        int iMinDichtheid = (int) spnMinPlantDicht.getValue();
        int iMaxDichtheid = (int) spnMaxPlantDicht.getValue();
        //vars voor Toevoegen Abio
        String sBezonning = (String) cboBezonning.getValue();
        String sGrond = (String) cboGrondsoort.getValue();
        String sVochtB = (String) cboVochtbehoefte.getValue();
        String sVoedingsB = (String) cboVoedingsbehoefte.getValue();
        String sAnta = (String) cboReactieAntag.getValue();
        //vars voor toevoegen Fenotype
        String sBladvorm = (String) cboBladvorm.getValue();
        RadioButton selectedRadioButton = (RadioButton) levensvormToggle.getSelectedToggle();
        String sLevensvorm = selectedRadioButton.getText();
        RadioButton selectedRadioButton2 = (RadioButton) habitusToggle.getSelectedToggle();
        String sHabitus = selectedRadioButton2.getText();
        RadioButton selectedRadioButton3 = (RadioButton) bloeiwijzeToggle.getSelectedToggle();
        String sBloeiwijze = selectedRadioButton3.getText();


        //Vars voor toevoegen Commensalisme
        String sOntwikkelingssnelheid = (String) cboOntwikkelingssnelheid.getValue();
        RadioButton selectStategied = (RadioButton) StrategieToggle.getSelectedToggle();
        String sStrategie = selectStategied.getText();
        //Vars voor toevoegen extra
        int iNectarwaarde = (int) spnNectarwaarde.getValue();
        int iPollenwaarde = (int) spnPollenwaarde.getValue();
        RadioButton selectBijvriendelijk = (RadioButton) BijvriendelijkToggle.getSelectedToggle();
        String sBijvriendelijk = selectBijvriendelijk.getText();
        RadioButton selectEetbaar = (RadioButton) EetbaarToggle.getSelectedToggle();
        String sEetbaar = selectEetbaar.getText();
        RadioButton selectKruidgebruik = (RadioButton) KruidgebruikToggle.getSelectedToggle();
        String sKruidgebruik = selectKruidgebruik.getText();
        RadioButton selectGeurend = (RadioButton) GeurendToggle.getSelectedToggle();
        String sGeurend = selectGeurend.getText();
        RadioButton selectVorstgevoelig = (RadioButton) VorstgevoeligToggle.getSelectedToggle();
        String sVorstgevoelig = selectVorstgevoelig.getText();

        int iBladgrootte = Integer.parseInt(cboBladgrootte.getValue().toString());
        String sRatioBloeiBlad = cboRatio.getValue().toString();
        String sSpruitfeno = (String) cboSpruitfenologie.getValue();
        //Alles voor het toevoegen van een volledige plant
        PlantDAO plantDao = new PlantDAO(dbConnection);
        Plant plant = new Plant
                (sType,
                        sFam,
                        sGeslacht,
                        sSoort,
                        sVariant,
                        iMinDichtheid,
                        iMaxDichtheid,
                        fgsv);
        plantDao.createPlant(plant);
        int plant_id = plant.getId();

        AbiotischeFactorenDAO abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        AbiotischeFactoren abiotischeFactoren = new AbiotischeFactoren
                (plant_id
                        , sBezonning,
                        sGrond,
                        sVochtB,
                        sVoedingsB,
                        sAnta);
        abiotischeFactorenDAO.createAbio(abiotischeFactoren, plant);

        CommensalismeDAO commensalismeDAO = new CommensalismeDAO(dbConnection);
        Commensalisme commensalisme = new Commensalisme(
                plant_id,
                sStrategie,
                sOntwikkelingssnelheid);
        commensalismeDAO.createCommensalisme(commensalisme, plant);

        FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
        Fenotype fenotype = new Fenotype(plant_id,
                sBladvorm,
                sLevensvorm,
                sHabitus,
                sBloeiwijze,
                iBladgrootte,
                sRatioBloeiBlad,
                sSpruitfeno);
        fenotypeDAO.createFeno(fenotype, plant);


        ExtraDAO extraDAO = new ExtraDAO(dbConnection);
        Extra extra = new Extra(
                plant_id,
                iNectarwaarde,
                iPollenwaarde,
                sBijvriendelijk,
                sEetbaar,
                sKruidgebruik,
                sGeurend,
                sVorstgevoelig
        );
        extraDAO.createExtra(extra, plant);


//
        setArrayFenotypeMultiFunction();
        createFenoMultiEig(aBladhoogte, plant);
        createFenoMultiEig(aBladkleur, plant);
        createFenoMultiEig(aBloeihoogte, plant);
        createFenoMultiEig(aBloeikleur, plant);


        //oproepen functie listview
        listviewreaderhabitat(lvHabitat, plant, lblHabitat );
        listviewreaderlevensduur(lvLevensduur, plant, lblLevensduur);
        //oproepen create commensalisme
        createcommensalismemulti(plant);






        notificationBox("U plant is opgeslagen");


    }


    //functie voor terug te kunnen keren naar het zoek scherm.
    public void clicked_TerugGaan(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/Zoekscherm.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.show();
        window.setScene(scene);
    }

    public void notificationBox(String string) {
        JOptionPane.showMessageDialog(null, string);
    }
    // Deze functie word opgeroepen om de comboboxen van de kleuren en maand
    // aan te passen van text naar kleur om een mooiere gebruikers ervaring

    public void textToColor(ComboBox cbo, String kleur) {
        switch (kleur) {
            case "rood":
                cbo.setStyle("-fx-background-color:RED");
                break;
            case "bruin":
                cbo.setStyle("-fx-background-color:BROWN");
                break;
            case "geel":
                cbo.setStyle("-fx-background-color:YELLOW");
                break;
            case "grijs":
                cbo.setStyle("-fx-background-color:GREY");
                break;
            case "groen":
                cbo.setStyle("-fx-background-color:GREEN");
                break;
            case "lila":
                cbo.setStyle("-fx-background-color:LAVENDER");
                break;
            case "oranje":
                cbo.setStyle("-fx-background-color:ORANGE");
                break;
            case "paars":
                cbo.setStyle("-fx-background-color:PURPLE");
                break;
            case "roze":
                cbo.setStyle("-fx-background-color:PINK");
                break;
            case "violet":
                cbo.setStyle("-fx-background-color:VIOLET");
                break;
            case "":
                cbo.setStyle("-fx-background-color:white");
                break;
            case "wit":
                cbo.setStyle("-fx-background-color:white");
                break;
            case "zwart":
                cbo.setStyle("-fx-background-color:Black");
                break;
            case "blauw":
                cbo.setStyle("-fx-background-color:BLUE");
                break;
        }

    }

    // Clicked event op de Comboboxes voor text naar kleur
    public void clickedbladkleurjan(ActionEvent actionEvent) {
        textToColor(cboBladkleurJan, cboBladkleurJan.getValue().toString());

    }

    public void clickedcboBladkleurFeb(ActionEvent actionEvent) {
        textToColor(cboBladkleurFeb, cboBladkleurFeb.getValue().toString());
    }

    public void clickedcboBladkleurMaa(ActionEvent actionEvent) {
        textToColor(cboBladkleurMaa, cboBladkleurMaa.getValue().toString());
    }

    public void clickedcboBladkleurApr(ActionEvent actionEvent) {
        textToColor(cboBladkleurApr, cboBladkleurApr.getValue().toString());
    }

    public void ClickedcboBladkleurMei(ActionEvent actionEvent) {
        textToColor(cboBladkleurMei, cboBladkleurMei.getValue().toString());
    }

    public void ClickedcboBladkleurJun(ActionEvent actionEvent) {
        textToColor(cboBladkleurJun, cboBladkleurJun.getValue().toString());
    }

    public void ClickedcboBladkleurJul(ActionEvent actionEvent) {
        textToColor(cboBladkleurJul, cboBladkleurJul.getValue().toString());
    }

    public void ClickedcboBladkleurAug(ActionEvent actionEvent) {
        textToColor(cboBladkleurAug, cboBladkleurAug.getValue().toString());
    }

    public void ClickedcboBladkleurSept(ActionEvent actionEvent) {
        textToColor(cboBladkleurSept, cboBladkleurSept.getValue().toString());
    }

    public void ClickedcboBladkleurOkt(ActionEvent actionEvent) {
        textToColor(cboBladkleurOkt, cboBladkleurOkt.getValue().toString());
    }

    public void ClickedcboBladkleurNov(ActionEvent actionEvent) {
        textToColor(cboBladkleurNov, cboBladkleurNov.getValue().toString());
    }

    public void ClickedcboBladkleurDec(ActionEvent actionEvent) {
        textToColor(cboBladkleurDec, cboBladkleurDec.getValue().toString());
    }

    public void actioncboBloeikleurJan(ActionEvent actionEvent) {
        textToColor(cboBloeikleurJan, cboBloeikleurJan.getValue().toString());
    }

    public void actioncboBloeikleurFeb(ActionEvent actionEvent) {
        textToColor(cboBloeikleurFeb, cboBloeikleurFeb.getValue().toString());
    }

    public void actioncboBloeikleurMaa(ActionEvent actionEvent) {
        textToColor(cboBloeikleurMaa, cboBloeikleurMaa.getValue().toString());
    }

    public void actioncboBloeikleurApr(ActionEvent actionEvent) {
        textToColor(cboBloeikleurApr, cboBloeikleurApr.getValue().toString());
    }

    public void actioncboBloeikleurMei(ActionEvent actionEvent) {
        textToColor(cboBloeikleurMei, cboBloeikleurMei.getValue().toString());
    }

    public void actioncboBloeikleurJun(ActionEvent actionEvent) {
        textToColor(cboBloeikleurJun, cboBloeikleurJun.getValue().toString());
    }

    public void actioncboBloeikleurJul(ActionEvent actionEvent) {
        textToColor(cboBloeikleurJul, cboBloeikleurJul.getValue().toString());
    }

    public void actioncboBloeikleurAug(ActionEvent actionEvent) {
        textToColor(cboBloeikleurAug, cboBloeikleurAug.getValue().toString());
    }

    public void actioncboBloeikleurSept(ActionEvent actionEvent) {
        textToColor(cboBloeikleurSept, cboBloeikleurSept.getValue().toString());
    }

    public void actioncboBloeikleurOkt(ActionEvent actionEvent) {
        textToColor(cboBloeikleurOkt, cboBloeikleurOkt.getValue().toString());
    }

    public void actioncboBloeikleurNov(ActionEvent actionEvent) {
        textToColor(cboBloeikleurNov, cboBloeikleurNov.getValue().toString());
    }

    public void actioncboBloeikleurDec(ActionEvent actionEvent) {
        textToColor(cboBloeikleurDec, cboBloeikleurDec.getValue().toString());
    }

    //set array van bladhoogte bloeihoogte bladkleur bloeikleur
    public void setArrayFenotypeMultiFunction() {

        for (int i = 0; i < 13; i++) {
            switch (i) {
                case 0:

                    sNaamSpnbladhoogte = "bladhoogte";
                    sNaamCmbBladKleur = "bladkleur";
                    sNaamCmbBloeiKleur = "bloeikleur";
                    sNaamSpnBloeihoogte = "bloeihoogte";
                    break;

                case 1:
                    sNaamSpnbladhoogte = spnBladhoogteJan.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurJan.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurJan.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteJan.getValue().toString();
                    break;
                case 2:
                    sNaamSpnbladhoogte = spnBladhoogteFeb.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurFeb.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurFeb.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteFeb.getValue().toString();
                    break;
                case 3:
                    sNaamSpnbladhoogte = spnBladhoogteMaa.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurMaa.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurMaa.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteMaa.getValue().toString();
                    break;
                case 4:
                    sNaamSpnbladhoogte = spnBladhoogteApr.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurApr.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurApr.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteApr.getValue().toString();
                    break;
                case 5:
                    sNaamSpnbladhoogte = spnBladhoogteMei.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurMei.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurMei.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteMei.getValue().toString();
                    break;
                case 6:
                    sNaamSpnbladhoogte = spnBladhoogteJun.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurJun.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurJun.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteJun.getValue().toString();
                    break;
                case 7:
                    sNaamSpnbladhoogte = spnBladhoogteJul.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurJul.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurJul.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteJul.getValue().toString();
                    break;
                case 8:
                    sNaamSpnbladhoogte = spnBladhoogteAug.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurAug.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurAug.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteAug.getValue().toString();
                    break;
                case 9:
                    sNaamSpnbladhoogte = spnBladhoogteSept.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurSept.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurSept.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteSept.getValue().toString();
                    break;
                case 10:
                    sNaamSpnbladhoogte = spnBladhoogteOkt.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurOkt.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurOkt.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteOkt.getValue().toString();
                    break;
                case 11:
                    sNaamSpnbladhoogte = spnBladhoogteNov.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurNov.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurNov.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteNov.getValue().toString();
                    break;
                case 12:
                    sNaamSpnbladhoogte = spnBladhoogteDec.getValue().toString();
                    sNaamCmbBladKleur = String.valueOf(cboBladkleurDec.getValue());
                    sNaamCmbBloeiKleur = String.valueOf(cboBloeikleurDec.getValue());
                    sNaamSpnBloeihoogte = spnMaxBloeihoogteDec.getValue().toString();
                    break;
            }


            aBladhoogte.add(sNaamSpnbladhoogte);
            aBladkleur.add(sNaamCmbBladKleur);
            aBloeihoogte.add(sNaamSpnBloeihoogte);
            aBloeikleur.add(sNaamCmbBloeiKleur);


        }
    }


    public void createFenoMultiEig(ArrayList array, Plant plant) throws SQLException {

        FenotypeDAO fenotypedao = new FenotypeDAO(dbConnection);
        FenoMulti_Eigenschap fenomulti = new FenoMulti_Eigenschap(
                plant.getId(),
                (String) array.get(0),
                (String) array.get(1),
                (String) array.get(2),
                (String) array.get(3),
                (String) array.get(4),
                (String) array.get(5),
                (String) array.get(6),
                (String) array.get(7),
                (String) array.get(8),
                (String) array.get(9),
                (String) array.get(10),
                (String) array.get(11),
                (String) array.get(12)
        );
        fenotypedao.createfenomulti(fenomulti, plant);


    }

    public void clicked_DeltenHabitat(MouseEvent mouseEvent) {
        lvHabitat.getItems().remove(lvHabitat.getSelectionModel().getSelectedItem());
        lvHabitat.refresh();

    }

    public void clicked_DeleteLevensduur(MouseEvent mouseEvent) {

        lvLevensduur.getItems().remove(lvLevensduur.getSelectionModel().getSelectedItem());
        lvLevensduur.refresh();
    }


    //funcite list view
    public void listviewreaderhabitat(ListView ls, Plant plant, Label label ) throws SQLException {
        ArrayList<String> al = new ArrayList<>();

        al.addAll(ls.getItems());

        for (int i = 0; i < al.size(); i++){

            AbiotischeFactorenDAO abiotischedao = new AbiotischeFactorenDAO(dbConnection);
            AbioMulti_Eigenschap abioMulti_eigenschap  = new AbioMulti_Eigenschap
                    (
                         plant.getId(),
                                     label.getText()
                            ,al.get(i)
                    );
           abiotischedao.createabiomulti(abioMulti_eigenschap, plant);
        }
    }

    //funcite list view levensduur
    public void listviewreaderlevensduur(ListView ls, Plant plant, Label label ) throws SQLException {
        ArrayList<String> al = new ArrayList<>();

        al.addAll(ls.getItems());

        for (int i = 0; i < al.size(); i++){

            CommensalismeDAO commensalismeDAO = new CommensalismeDAO(dbConnection);
            CommMulti_Eigenschap commMulti_eigenschap  = new CommMulti_Eigenschap
                    (
                            plant.getId(),
                            label.getText()
                            ,al.get(i)
                    );
            commensalismeDAO.createcommulti(commMulti_eigenschap, plant);
        }
    }


    //create commensalisme
    public void createcommensalismemulti(Plant plant) throws SQLException {
        RadioButton selectcoc = (RadioButton) Sociabiliteit.getSelectedToggle();
        String sSoc = selectcoc.getText();
        CommensalismeDAO commensalismeDAO = new CommensalismeDAO(dbConnection);
        CommMulti_Eigenschap commMulti_eigenschap  = new CommMulti_Eigenschap(
                plant.getId(),
                lblSociabiliteit.getText(),
                sSoc
        );
commensalismeDAO.createcommulti(commMulti_eigenschap, plant);

    }

}
