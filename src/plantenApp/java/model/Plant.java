package plantenApp.java.model;


/**@author Siebe*/
public class Plant {
    private int id;
    private String type;
    private String familie;
    private String geslacht;
    private String soort;
    private String variatie;
    private int minPlantdichtheid;
    private int maxPlantdichtheid;

    private AbiotischeFactoren abiotischeFactoren;
    private Beheer beheer;
    private Commensalisme commensalisme;
    private Beheerdaad_Eigenschap beheerdaad_eigenschap;
    private Extra extra;
    private FenoMulti_Eigenschap fenoMulti_eigenschap;
    private Foto foto;
    private Fenotype fenotype;
    private Foto_Eigenschap foto_eigenschap;
    private InfoTables infoTables;

    public Plant(int id, String type, String familie, String geslacht, String soort, String variatie, int minPlantdichtheid, int maxPlantdichtheid) {
        this.id = id;
        this.type = type;
        this.familie = familie;
        this.geslacht = geslacht;
        this.soort = soort;
        this.variatie = variatie;
        this.minPlantdichtheid = minPlantdichtheid;
        this.maxPlantdichtheid = maxPlantdichtheid;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getFamilie() {
        return familie;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public String getSoort() {
        return soort;
    }

    public String getVariatie() {
        return variatie;
    }

    public int getMinPlantdichtheid() {
        return minPlantdichtheid;
    }

    public int getMaxPlantdichtheid() {
        return maxPlantdichtheid;
    }

    public AbiotischeFactoren getAbiotischeFactoren() {
        return abiotischeFactoren;
    }

    public void setAbiotischeFactoren(AbiotischeFactoren abiotischeFactoren) {
        this.abiotischeFactoren = abiotischeFactoren;
    }

    public Beheer getBeheer() {
        return beheer;
    }

    public void setBeheer(Beheer beheer) {
        this.beheer = beheer;
    }

    public Beheerdaad_Eigenschap getBeheerdaad_eigenschap() {
        return beheerdaad_eigenschap;
    }

    public void setBeheerdaad_eigenschap(Beheerdaad_Eigenschap beheerdaad_eigenschap) {
        this.beheerdaad_eigenschap = beheerdaad_eigenschap;
    }

    public Commensalisme getCommensalisme() {
        return commensalisme;
    }

    public void setCommensalisme(Commensalisme commensalisme) {
        this.commensalisme = commensalisme;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public FenoMulti_Eigenschap getFenoMulti_eigenschap() {
        return fenoMulti_eigenschap;
    }

    public void setFenoMulti_eigenschap(FenoMulti_Eigenschap fenoMulti_eigenschap) {
        this.fenoMulti_eigenschap = fenoMulti_eigenschap;
    }

    public Fenotype getFenotype() {
        return fenotype;
    }

    public void setFenotype(Fenotype fenotype) {
        this.fenotype = fenotype;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public Foto_Eigenschap getFoto_eigenschap() {
        return foto_eigenschap;
    }

    public void setFoto_eigenschap(Foto_Eigenschap foto_eigenschap) {
        this.foto_eigenschap = foto_eigenschap;
    }

    public InfoTables getInfoTables() {
        return infoTables;
    }

    public void setInfoTables(InfoTables infoTables) {
        this.infoTables = infoTables;
    }
}
