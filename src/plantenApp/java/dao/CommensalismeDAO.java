package plantenApp.java.dao;

import plantenApp.java.model.CommMulti_Eigenschap;
import plantenApp.java.model.Commensalisme;
import plantenApp.java.model.Plant;

import java.sql.*;
import java.util.ArrayList;

/**@author Siebe*/
public class CommensalismeDAO implements Queries {
    private Connection dbConnection;
    private PreparedStatement stmtSelectCommeByID;
    private PreparedStatement stmtSelectCommeMultiByID;
    private PreparedStatement stmtSelectIdsByComm;
    private PreparedStatement stmtSelectIdsByCommMulti;
    private PreparedStatement stmtInsertCommensalisme;
    private PreparedStatement stmtinsertCommensalismeMulti;

    public CommensalismeDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectCommeByID = dbConnection.prepareStatement(GETCOMMENSALISMEBYPLANTID);
        stmtSelectCommeMultiByID = dbConnection.prepareStatement(GETCOMMENSALISMEMULTIBYPLANTID);
        stmtSelectIdsByComm = dbConnection.prepareStatement(GETIDSBYCOMM);
        stmtSelectIdsByCommMulti = dbConnection.prepareStatement(GETIDSBYCOMMMULTI);
        stmtInsertCommensalisme = dbConnection.prepareStatement(INSERTCOMMESALISME,
                Statement.RETURN_GENERATED_KEYS);
        stmtinsertCommensalismeMulti = dbConnection.prepareStatement(INSERTCOMMESALISMEMULTI,
        Statement.RETURN_GENERATED_KEYS);
    }


    public void createCommensalisme(Commensalisme commensalisme, Plant plant) throws  SQLException {
        stmtInsertCommensalisme.setInt(1, plant.getId());
        stmtInsertCommensalisme.setString(2, commensalisme.getStrategie());
        stmtInsertCommensalisme.setString(3, commensalisme.getOntwikkelingssnelheid());
        stmtInsertCommensalisme.executeUpdate();
        ResultSet rs = stmtInsertCommensalisme.getGeneratedKeys();
        rs.next();
        Integer commensialisme_id = rs.getInt(1);
        commensalisme.setId(commensialisme_id);
    }

    public ArrayList getCommensalismeById(int id) throws SQLException {
        ArrayList<String> arrListCommensalisme = new ArrayList<>();

        stmtSelectCommeByID.setInt(1, id);
        ResultSet rs = stmtSelectCommeByID.executeQuery();
        while (rs.next()) {
            arrListCommensalisme.add(rs.getString("commensalisme_id"));
            arrListCommensalisme.add(rs.getString("plant_id"));
            arrListCommensalisme.add(rs.getString("ontwikkelingssnelheid"));
        }
        return arrListCommensalisme;
    }

    public void createcommulti(CommMulti_Eigenschap commMulti_eigenschap, Plant plant) throws SQLException {
        stmtinsertCommensalismeMulti.setInt(1,plant.getId());
        stmtinsertCommensalismeMulti.setString(2,commMulti_eigenschap.getNaam());
        stmtinsertCommensalismeMulti.setString(3, commMulti_eigenschap.getValue());
        stmtinsertCommensalismeMulti.executeUpdate();
        ResultSet rs = stmtinsertCommensalismeMulti.getGeneratedKeys();
        rs.next();
        Integer commensalismemulti_id = rs.getInt(1);
        commMulti_eigenschap.setId(commensalismemulti_id);
    }

}

