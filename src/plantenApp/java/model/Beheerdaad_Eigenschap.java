package plantenApp.java.model;

/**@author Siebe*/
public class Beheerdaad_Eigenschap {
    private Integer id;
    private Integer plantid;
    private String naam;
    private String opmerking;
    private String maand;
    private int frequentie;

    public Beheerdaad_Eigenschap(int id, String naam, String opmerking, String maand, int frequentie) {
        this.plantid = id;
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

    public Beheerdaad_Eigenschap(Beheerdaad_Eigenschap beeheerdaadeig) {
        this.plantid = beeheerdaadeig.getPlantID();
        this.naam = beeheerdaadeig.getNaam();
        this.opmerking = beeheerdaadeig.getOpmerking();
        this.maand = beeheerdaadeig.getMaand();
        this.frequentie = beeheerdaadeig.getFrequentie();
    }
    public void setId(Integer id) {
        if (this.id != null) {
            throw new UnsupportedOperationException("Id change not permitted");
        }
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public int getPlantID() {
        return plantid;
    }

    public void setPlantId(Integer id) {
        this.plantid = id;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public String toString() {
        return "{" +
                "plant id=" + plantid +
                ", naam='" + naam + '\'' +
                ", opmerking='" + opmerking + '\'' +
                ", maand='" + maand + '\'' +
                ", frequentie=" + frequentie +
                '}';
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
