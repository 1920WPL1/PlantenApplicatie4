package plantenApp.java.model;

/**@author Siebe*/
public class Beheerdaad_Eigenschap {
    private Integer id;
    private String naam;
    private String opmerking;
    private String maand;
    private int frequentie;

    public Beheerdaad_Eigenschap(int id, String naam, String opmerking, String maand, int frequentie) {
        this.id = id;
        this.naam = naam;
        this.opmerking = opmerking;
        this.maand = maand;
        this.frequentie = frequentie;
    }

    public Beheerdaad_Eigenschap(String naam, String opmerking, String maand, int frequentie) {
        this.naam = naam;
        this.opmerking = opmerking;
        this.maand = maand;
        this.frequentie = frequentie;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public String getMaand() {
        return maand;
    }

    public int getFrequentie() {
        return frequentie;
    }
}
