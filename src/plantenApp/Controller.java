package plantenApp;



import plantenApp.java.dao.Database;
import plantenApp.java.dao.InfoTablesDAO;
import plantenApp.java.dao.PlantDAO;
import plantenApp.java.model.InfoTables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Controller {
    public ComboBox<String> cboType;
    public ComboBox cboFamilie;
    public Slider slrBezonning;
    public Slider slrVochtbehoefte;
    public ComboBox<String> cboBladgrootte;
    public Button btnminimize;
    public Button btnExit;
    public Button btnMaximize;
    public ComboBox<String> cboRatio;
    public ComboBox<String> cboSpruitFenologie;
    public ComboBox<String> cboBladvorm;
    public ComboBox<String> cboMaand;
    public CheckBox chkBezonning;
    public CheckBox chkVochtbehoefte;
    public ComboBox<String> cboReactie;
    public Slider slrOntwikkelingssnelheid;
    public CheckBox chkPollenwaarde;
    public CheckBox chkNectarwaarde;
    public Slider slrPollenwaarde;
    public Slider slrNectarwaarde;
    public CheckBox chkOntwikkelingsnelheid;
    public Slider slrVoedingsbehoefte;
    public CheckBox chkVoedingsbehoefte;
    private boolean maximized=false;
    private InfoTables infoTables;
    private Connection dbConnection;
    List<String> types;

    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
        PlantDAO plantdao = new PlantDAO(dbConnection);
        types = plantdao.getAllTypes();
        cboType.getItems().addAll(types);
    }
    /**
     @param infotables -> lijst van alle lijsten van gegevens uit de naakte tabellen
     @author bradley
     Functie om comboboxes te vullen met alle gegevens uit de database
     */
    public void FillComboboxes(InfoTables infotables){
        //type
         System.out.println(infotables.getTypes().toString());
        cboType.getItems().addAll(infotables.getTypes());
        //familie
        cboFamilie.getItems().addAll(infotables.getFamilies());
        //bladgrootte
        cboBladgrootte.getItems().addAll(infotables.getBladgroottes());
        //bladvorm
        cboBladvorm.getItems().addAll(infotables.getBladvormen());
        //Levensvorm

        //BehandelingMaand
        cboMaand.getItems().addAll("Januari", "februari", "maart", "april", "mei", "juni", "juli","augustus","september", "oktober", "november", "december");
        //ratio
        cboRatio.getItems().addAll(infotables.getBloeiBladRatios());
        //spruitfenologie
        cboSpruitFenologie.getItems().addAll(infotables.getSpruitfenologieen());
        //reactie antagonistische omgeving
        cboReactie.getItems().addAll(infotables.getAntagonistischeOmgevingsReacties());
        //behandeling

    }

    public void Clicked_Search(MouseEvent mouseEvent) {

    }

    /**
     @author bradley
     Functie om scherm aan te passen tussen volledig scherm en normale grootte
     */
    public void resize(){
        if(maximized == true){
            btnMaximize.setOnAction(e ->
                    ( (Stage) ( (Button) e.getSource() ).getScene().getWindow() ).setMaximized(false));
            maximized=false;
        } else {
            btnMaximize.setOnAction(e ->
                    ( (Stage) ( (Button) e.getSource() ).getScene().getWindow() ).setMaximized(true));
            maximized=true;
        }
    }

    /**
     @author bradley
     Functie om scherm beheer knoppen te gebruiken
     */
    public void ScreenControl(){
        btnExit.setOnAction(e ->
                ((Stage) ((Button) e.getSource()).getScene().getWindow()).close()
        );

        btnminimize.setOnAction(e ->
                ((Stage) ((Button) e.getSource()).getScene().getWindow()).setIconified(true)
        );
        resize();
    }

    /**
     @author bradley
     wanneer hier op geklikt wordt, wordt de schermgrootte aangepast
     */
    public void Clicked_Resize(MouseEvent mouseEvent) {
        resize();
    }

    /**
     * @author Bradley Velghe
     * @param box
     * @param slider
     * @return true > slider is beweegbaar || false > slider is niet beweegbaar
     */
    public boolean Togledisable(CheckBox box, Slider slider){
        if(box.isSelected()){
            slider.setDisable(false);
            return true;
        } else {
            slider.setDisable(true);
            return false;
        }
    }

    public void Clicked_Bezonning(MouseEvent mouseEvent) {
        Togledisable(chkBezonning, slrBezonning);
    }

    public void Clicked_Vochtbehoefte(MouseEvent mouseEvent) {
        Togledisable(chkVochtbehoefte, slrVochtbehoefte);
    }

    public void Clicked_VoedingsBehoefte(MouseEvent mouseEvent) {
        Togledisable(chkVoedingsbehoefte, slrVoedingsbehoefte);
    }

    public void Clicked_Ontwikkelingssnelheid(MouseEvent mouseEvent) {
        Togledisable(chkOntwikkelingsnelheid, slrOntwikkelingssnelheid);
    }

    public void Clicked_Pollenwaarde(MouseEvent mouseEvent) {
        Togledisable(chkPollenwaarde, slrPollenwaarde);
    }

    public void Clicked_Nectarwaarde(MouseEvent mouseEvent) {
        Togledisable(chkNectarwaarde, slrNectarwaarde);
    }
}


