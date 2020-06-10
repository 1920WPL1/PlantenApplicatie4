package plantenApp;

import javafx.scene.control.*;
import plantenApp.java.dao.Database;
import plantenApp.java.dao.InfoTablesDAO;
import plantenApp.java.model.InfoTables;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerPlantWijzigen {
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
    public Button btnVerstuurVoorGoek;
    public ListView lvLijstOpgeslagenPlanten;

    private Connection dbConnection;
    //arraylist van fenotype_Multi
    ArrayList<String> aBladhoogte = new ArrayList<>();
    ArrayList<String> aBladkleur = new ArrayList<>();
    ArrayList<String> aBloeihoogte = new ArrayList<>();
    ArrayList<String> aBloeikleur = new ArrayList<>();
    String sNaamSpnbladhoogte;
    String sNaamSpnBloeihoogte;
    String sNaamCmbBladKleur;
    String sNaamCmbBloeiKleur;

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
}
