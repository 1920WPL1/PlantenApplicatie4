package plantenApp.java.model;

import java.sql.Blob;

/**@author Siebe*/
public class Foto_Eigenschap {
    private Integer id;
    private int plant_id;
    private String eigenschap;
    private String url;
    private Blob image;

    public Foto_Eigenschap( int id, int plant_id, String eigenschap, String url, Blob image){
            this.id = id;
            this.plant_id = plant_id;
            this.eigenschap = eigenschap;
            this.url = url;
            this.image = image;
        }

    public Foto_Eigenschap( int plant_id, String eigenschap, String url, Blob image){
            this.plant_id = plant_id;
            this.eigenschap = eigenschap;
            this.url = url;
            this.image = image;
        }

        public void setId (Integer id){
            this.id = id;
        }

        public void setPlant_id ( int plant_id){
            this.plant_id = plant_id;
        }

        public void setEigenschap (String eigenschap){
            this.eigenschap = eigenschap;
        }

        public void setUrl (String url){
            this.url = url;
        }

        public void setImage (Blob image){
            this.image = image;
        }

        public int getPlant_id () {
            return plant_id;
        }

        public void setId ( int id){
            if (this.id != null) {
                throw new UnsupportedOperationException("Id change not permitted");
            }
            this.id = id;
        }
        public int getId () {
            return id;
        }

        public String getEigenschap () {
            return eigenschap;
        }

        public String getUrl () {
            return url;
        }

        public Blob getImage () {
            return image;
        }
    }



