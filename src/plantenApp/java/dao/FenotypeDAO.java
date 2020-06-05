package plantenApp.java.dao;

import plantenApp.java.model.FenoMulti_Eigenschap;
import plantenApp.java.model.Fenotype;
import plantenApp.java.model.Plant;

import java.sql.*;
import java.util.ArrayList;

/**@author Siebe*/
public class FenotypeDAO implements Queries {

    private Connection dbConnection;
    private PreparedStatement stmtSelectFenoByID;
    private PreparedStatement stmtSelectFenoMultiByID;
    private PreparedStatement stmtSelectIdsByFeno;
    private PreparedStatement stmtSelectIdsByFenoMulti;
    private PreparedStatement stmtInsertByFenotype;

    public FenotypeDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectFenoByID = dbConnection.prepareStatement(GETFENOTYPEBYPLANTID);
        stmtSelectFenoMultiByID = dbConnection.prepareStatement(GETFENOTYPEMULTIBYPLANTID);
        stmtSelectIdsByFeno = dbConnection.prepareStatement(GETIDSBYFENO);
        stmtSelectIdsByFenoMulti = dbConnection.prepareStatement(GETIDSBYFENOMULTI);

        stmtInsertByFenotype = dbConnection.prepareStatement(INSERTFENOTYPE,
                Statement.RETURN_GENERATED_KEYS);

    }

    /**@author Siebe
     * @param id -> plant_id
     * @return alle fenotipsche factoren van de specifieke plant
     */
    public Fenotype getById(int id) throws SQLException {
        Fenotype feno = null;

        stmtSelectFenoByID.setInt(1, id);
        ResultSet rs = stmtSelectFenoByID.executeQuery();
        if (rs.next()) {
            feno = new Fenotype(
                    rs.getInt("fenotype_id"),
                    rs.getInt("plant_id"),
                    rs.getString("bladvorm"),
                    rs.getString("levensvorm"),
                    rs.getString("habitus"),
                    rs.getString("bloeiwijze"),
                    rs.getInt("bladgrootte"),
                    rs.getString("ratio_bloei_blad"),
                    rs.getString("spruitfenelogie"),
                    getByIdMulti(id)
            );
        }
        return feno;
    }

    /**@author Siebe
     * word alleen gebruikt in getById
     * @param id -> plant_id
     * @return -> alle fenotype_multi van de specifieke plant
     */
    private ArrayList<FenoMulti_Eigenschap> getByIdMulti(int id) throws SQLException {
        ArrayList<FenoMulti_Eigenschap> commMulti = new ArrayList<>();;

        stmtSelectFenoMultiByID.setInt(1, id);
        ResultSet rs = stmtSelectFenoMultiByID.executeQuery();
        while (rs.next()) {
            FenoMulti_Eigenschap fenoEigenschap = new FenoMulti_Eigenschap(
                    rs.getInt("fenotype_id"),
                    rs.getString("eigenschap"),
                    rs.getString("jan"),
                    rs.getString("feb"),
                    rs.getString("maa"),
                    rs.getString("apr"),
                    rs.getString("mei"),
                    rs.getString("jun"),
                    rs.getString("jul"),
                    rs.getString("aug"),
                    rs.getString("sep"),
                    rs.getString("okt"),
                    rs.getString("nov"),
                    rs.getString("dec")
            );
            commMulti.add(fenoEigenschap);
        }
        return commMulti;
    }
    public void createFeno(Fenotype fenotype, Plant plant) throws SQLException {

        stmtInsertByFenotype.setInt(1, plant.getId());
        stmtInsertByFenotype.setString(2, fenotype.getBladvorm());
        stmtInsertByFenotype.setString(3, fenotype.getLevensvorm());
        stmtInsertByFenotype.setString(4, fenotype.getHabitus());
        stmtInsertByFenotype.setString(5, fenotype.getBloeiwijze());
        stmtInsertByFenotype.setInt(6,fenotype.getBladgrootte());
        stmtInsertByFenotype.setString(7, fenotype.getRatio_bloei_blad());
        stmtInsertByFenotype.setString(8, fenotype.getSpruitfenologie());
        stmtInsertByFenotype.executeUpdate();
        ResultSet rs = stmtInsertByFenotype.getGeneratedKeys();
        rs.next();
        Integer fenotype_id = rs.getInt(1);
        fenotype.setId(fenotype_id);
    }
}

