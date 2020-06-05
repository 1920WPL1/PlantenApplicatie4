package plantenApp.java.model;

import java.util.ArrayList;

/**@author Siebe*/
public class Commensalisme {
    private Integer id;
    private int plant_id;
    private String strategie;
    private String ontwikkelingssnelheid;
    private ArrayList<CommMulti_Eigenschap> multiEigenschappen;

    //Constructor met id
    public Commensalisme(int id, int plant_id, String strategie, String ontwikkelingssnelheid, ArrayList<CommMulti_Eigenschap> multiEigenschappen) {
        this.id = id;
        this.plant_id = plant_id;
        this.strategie = strategie;
        this.ontwikkelingssnelheid = ontwikkelingssnelheid;
        this.multiEigenschappen = multiEigenschappen;
    }
    //Constructor zonder id
    public Commensalisme(int plant_id, String strategie, String ontwikkelingssnelheid) {
        this.plant_id = plant_id;
        this.strategie = strategie;
        this.ontwikkelingssnelheid = ontwikkelingssnelheid;
    }

    public int getId() {
        return id;
    }

    public int getPlant_id() {
        return plant_id;
    }

    public String getStrategie() {
        return strategie;
    }

    public String getOntwikkelingssnelheid() {
        return ontwikkelingssnelheid;
    }

    public ArrayList<CommMulti_Eigenschap> getMultiEigenschappen() {
        return multiEigenschappen;
    }

    public void setId(Integer id)
    {
        if (this.id != null)
        {
            throw new UnsupportedOperationException("Id change not permitted");
        }
        this.id = id;
    }

}
