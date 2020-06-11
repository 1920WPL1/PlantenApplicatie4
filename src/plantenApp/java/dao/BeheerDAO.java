package plantenApp.java.dao;

import plantenApp.java.model.Beheer;
import plantenApp.java.model.Beheerdaad_Eigenschap;

import java.sql.*;
import java.util.ArrayList;

/**@author Siebe*/
public class BeheerDAO implements Queries {
    private Connection dbConnection;
    private PreparedStatement stmtSelectBeheerByID;
    private PreparedStatement stmtSelectByBeheer;
    private PreparedStatement stmtInsertBeheer;
    private PreparedStatement stmtInsertBeheerdaadEigenschap;

    public BeheerDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectBeheerByID = dbConnection.prepareStatement(GETBEHEERBYPLANTID);
        stmtSelectByBeheer = dbConnection.prepareStatement(GETIDSBYBEHEER);
        stmtInsertBeheer = dbConnection.prepareStatement(INSERTBEHEER);
        stmtInsertBeheerdaadEigenschap = dbConnection.prepareStatement(INSERTBEHEERMULTI,
                Statement.RETURN_GENERATED_KEYS);
    }

    /**@author Siebe
     * @param id -> plant_id
     * @return -> beheer van de specifieke plant
     */
    public Beheer getById(int id) throws SQLException {
        Beheer beheer = null;

        beheer = new Beheer(
                id,
                getBeheerdadenByID(id)
        );
        return beheer;
    }

    /**@author Siebe
     * word alleen gebruikt in getById
     * @param id -> plant_id
     * @return -> alle beheerdaden van de specifieke plant
     */
    private ArrayList<Beheerdaad_Eigenschap> getBeheerdadenByID(int id) throws SQLException {
        ArrayList<Beheerdaad_Eigenschap> arrBeheer = new ArrayList<>();;

        stmtSelectBeheerByID.setInt(1, id);
        ResultSet rs = stmtSelectBeheerByID.executeQuery();
        while (rs.next()) {
            Beheerdaad_Eigenschap beheerdaad = new Beheerdaad_Eigenschap(
                    rs.getInt("beheer_id"),
                    rs.getString("beheerdaad"),
                    rs.getString("opmerking"),
                    rs.getString("maand"),
                    rs.getInt("frequentie_jaar")
            );
            arrBeheer.add(beheerdaad);
        }
        return arrBeheer;
    }


    //Functie om een beheer/behandeling toe te voegen
    public void createBeheer(String swaarde) throws SQLException
    {
        stmtInsertBeheer.setString(1, swaarde);
        stmtInsertBeheer.executeUpdate();
    }

    public void createBeheerEigenschap(Beheerdaad_Eigenschap beheerEigenschap) throws SQLException{
        stmtInsertBeheerdaadEigenschap.setInt(1,beheerEigenschap.getPlantID());
        stmtInsertBeheerdaadEigenschap.setString(2, beheerEigenschap.getNaam());
        stmtInsertBeheerdaadEigenschap.setString(3, beheerEigenschap.getOpmerking());
        stmtInsertBeheerdaadEigenschap.setString(4, beheerEigenschap.getMaand());
        stmtInsertBeheerdaadEigenschap.setInt(5, beheerEigenschap.getFrequentie());
        stmtInsertBeheerdaadEigenschap.executeUpdate();
        ResultSet rs = stmtInsertBeheerdaadEigenschap.getGeneratedKeys();
        rs.next();
        Integer beheer_id = rs.getInt(1);
        beheerEigenschap.setId(beheer_id);
    }

}
