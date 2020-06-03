package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerPlantToevoegen {
    //Alle velden die ingevuld moeten worden bij Standaard
    public ComboBox cboType;
    public TextField txtFamilie;
    public TextField txtGeslacht;
    public TextField txtSoort;
    public TextField txtVariant;
    public TextField txtPlantdichtX;
    public TextField txtPlantdichtY;
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
    public CheckBox chbSociabiliteit1;
    public CheckBox chbSociabiliteit2;
    public CheckBox chbSociabiliteit3;
    public CheckBox chbSociabiliteit4;
    public CheckBox chbSociabiliteit5;
        //Alle radiobuttons voor de verschillende Strategieën
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
    public Slider sldNectarwaarde;
    public Label lblNectarwaarde;
    public Slider sldPollenwaarde;
    public Label lblPollenwaarde;
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
    public Button btn_Terug;


    //Functie onder de button doe een nieuwe eigenschap voor habitat toevoegd
    public void clicked_ToevoegenHabitat(MouseEvent mouseEvent) {
    }

    //Functie onder de button die een nieuwe eigenschap voor levensduur toevoegd
    public void clicked_ToevoegenLevensduur(MouseEvent mouseEvent) {
    }

    //Functie onder de button die een plant toevoegd
    public void clicked_ToevoegenPlant(MouseEvent mouseEvent) {
    }

//functie voor terug te kunnen keren naar het zoek scherm.
    public void clicked_TerugGaan(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/Zoekscherm.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.show();
        window.setScene(scene);
    }
}
