package plantenApp;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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

    //Button om terug te gaan naar de vorig pagina
    public void clicked_TerugGaan(MouseEvent mouseEvent) {
    }

    //Button om een opmerking toe te voegen
    public void clicked_OpmerkingToevoegen(MouseEvent mouseEvent) {
    }

    //Button om een opmerking te verwijderen
    public void clicked_OpmerkingVerwijderen(MouseEvent mouseEvent) {
    }

    //Buttin om een behandeling toe te voegen
    public void clicked_BehandelingToevoegen(MouseEvent mouseEvent) {
    }
}
