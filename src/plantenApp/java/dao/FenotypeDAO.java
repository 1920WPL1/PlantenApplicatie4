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
    private PreparedStatement stmtInsertFenotypeMulti;


    public FenotypeDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectFenoByID = dbConnection.prepareStatement(GETFENOTYPEBYPLANTID);
        stmtSelectFenoMultiByID = dbConnection.prepareStatement(GETFENOTYPEMULTIBYPLANTID);
        stmtSelectIdsByFeno = dbConnection.prepareStatement(GETIDSBYFENO);
        stmtSelectIdsByFenoMulti = dbConnection.prepareStatement(GETIDSBYFENOMULTI);

        stmtInsertByFenotype = dbConnection.prepareStatement(INSERTFENOTYPE,
                Statement.RETURN_GENERATED_KEYS);
        stmtInsertFenotypeMulti = dbConnection.prepareStatement(INSERTFENOTYPEMULTI,
                Statement.RETURN_GENERATED_KEYS);
    }

    public ArrayList getFenotypeById(int id) throws SQLException {
        ArrayList<String> arrListFeno = new ArrayList<>();

        stmtSelectFenoByID.setInt(1, id);
        ResultSet rs = stmtSelectFenoByID.executeQuery();
        while (rs.next()) {
            arrListFeno.add(rs.getString("fenotype_id"));
            arrListFeno.add(rs.getString("plant_id"));
            arrListFeno.add(rs.getString("bladvorm"));
            arrListFeno.add(rs.getString("levensvorm"));
            arrListFeno.add(rs.getString("habitus"));
            arrListFeno.add(rs.getString("bloeiwijze"));
            arrListFeno.add(rs.getString("bladgrootte"));
            arrListFeno.add(rs.getString("ratio_bloei_blad"));
            arrListFeno.add(rs.getString("spruitfenologie"));
        }
        return arrListFeno;
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


    public void createfenomulti(FenoMulti_Eigenschap fenoMulti_eigenschap, Plant plant) throws SQLException {

        stmtInsertFenotypeMulti.setInt(1, plant.getId());
        stmtInsertFenotypeMulti.setString(2, fenoMulti_eigenschap.getNaam());
        stmtInsertFenotypeMulti.setString(3, fenoMulti_eigenschap.getJan());
        stmtInsertFenotypeMulti.setString(4, fenoMulti_eigenschap.getFeb());
        stmtInsertFenotypeMulti.setString(5, fenoMulti_eigenschap.getMaa());
        stmtInsertFenotypeMulti.setString(6, fenoMulti_eigenschap.getApr());
        stmtInsertFenotypeMulti.setString(7, fenoMulti_eigenschap.getMei());
        stmtInsertFenotypeMulti.setString(8, fenoMulti_eigenschap.getJun());
        stmtInsertFenotypeMulti.setString(9, fenoMulti_eigenschap.getJul());
        stmtInsertFenotypeMulti.setString(10, fenoMulti_eigenschap.getAug());
        stmtInsertFenotypeMulti.setString(11, fenoMulti_eigenschap.getSep());
        stmtInsertFenotypeMulti.setString(12, fenoMulti_eigenschap.getOkt());
        stmtInsertFenotypeMulti.setString(13, fenoMulti_eigenschap.getNov());
        stmtInsertFenotypeMulti.setString(14, fenoMulti_eigenschap.getDec());
        stmtInsertFenotypeMulti.executeUpdate();
        ResultSet rs = stmtInsertFenotypeMulti.getGeneratedKeys();
        rs.next();
        Integer fenotype_id = rs.getInt(1);
        fenoMulti_eigenschap.setId(fenotype_id);
    }




}

