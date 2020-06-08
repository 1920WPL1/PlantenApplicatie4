package plantenApp.java.model;

/**@author Siebe*/
public class CommMulti_Eigenschap {
    private int id;
    private String naam;
    private String value;

    public CommMulti_Eigenschap(int id, String naam, String value) {
        this.id = id;
        this.naam = naam;
        this.value = value;
    }




    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
