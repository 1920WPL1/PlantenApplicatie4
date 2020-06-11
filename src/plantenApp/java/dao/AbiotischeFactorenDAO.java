package plantenApp.java.dao;

import plantenApp.java.model.AbioMulti_Eigenschap;
import plantenApp.java.model.AbiotischeFactoren;
import plantenApp.java.model.Plant;

import java.sql.*;
import java.util.ArrayList;

public class AbiotischeFactorenDAO implements Queries {
    private Connection dbConnection;
    private PreparedStatement stmtSelectAbioByID;
    private PreparedStatement stmtSelectAbioMultiByID;
    private PreparedStatement stmtSelectIdsByAbio;
    private PreparedStatement stmtSelectIdsByAbioMulti;
    private PreparedStatement stmsInsertAbiotischeFactoren;
    private PreparedStatement stmsInsertAbiotischeFactorenmulti;


    public AbiotischeFactorenDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectAbioByID = dbConnection.prepareStatement(GETABIOTISCHBYPLANTID);
        stmtSelectAbioMultiByID = dbConnection.prepareStatement(GETABIOTISCHBMULTIYPLANTID);
        stmtSelectIdsByAbio = dbConnection.prepareStatement(GETIDSBYABIO);
        stmtSelectIdsByAbioMulti = dbConnection.prepareStatement(GETIDSBYABIOMULTI);
        stmsInsertAbiotischeFactorenmulti = dbConnection.prepareStatement(INSERTABIOTISCHEFMULTI, Statement.RETURN_GENERATED_KEYS);
        stmsInsertAbiotischeFactoren = dbConnection.prepareStatement(INSERTABIOTISCHEF,
                Statement.RETURN_GENERATED_KEYS);
    }

    public ArrayList getAbiotischById(int id) throws SQLException {
        ArrayList<String> arrListAbiotisch = new ArrayList<>();

        stmtSelectAbioByID.setInt(1, id);
        ResultSet rs = stmtSelectAbioByID.executeQuery();
        while (rs.next()) {
            arrListAbiotisch.add(rs.getString("abiotische_id"));
            arrListAbiotisch.add(rs.getString("plant_id"));
            arrListAbiotisch.add(rs.getString("bezonning"));
            arrListAbiotisch.add(rs.getString("grondsoort"));
            arrListAbiotisch.add(rs.getString("vochtbehoefte"));
            arrListAbiotisch.add(rs.getString("voedingsbehoefte"));
            arrListAbiotisch.add(rs.getString("reactie_antagonistische_omg"));
        }
        return arrListAbiotisch;
    }



    public void createAbio(AbiotischeFactoren abiotischeFactoren, Plant plant) throws SQLException {
        stmsInsertAbiotischeFactoren.setInt(1, plant.getId());
        stmsInsertAbiotischeFactoren.setString(2,abiotischeFactoren.getBezonning());
        stmsInsertAbiotischeFactoren.setString(3, abiotischeFactoren.getGrondsoort());
        stmsInsertAbiotischeFactoren.setString(4, abiotischeFactoren.getVochtbehoefte());
        stmsInsertAbiotischeFactoren.setString(5, abiotischeFactoren.getVoedingsbehoefte());
        stmsInsertAbiotischeFactoren.setString(6, abiotischeFactoren.getReactieAntagonistischeOmgeving());
        stmsInsertAbiotischeFactoren.executeUpdate();
        ResultSet rs = stmsInsertAbiotischeFactoren.getGeneratedKeys();
        rs.next();
        Integer abiotische_id = rs.getInt(1);
        abiotischeFactoren.setId(abiotische_id);
    }

    public void createabiomulti(AbioMulti_Eigenschap abioMulti_eigenschap, Plant plant) throws SQLException {
        stmsInsertAbiotischeFactorenmulti.setInt(1, plant.getId());
        stmsInsertAbiotischeFactorenmulti.setString(2,abioMulti_eigenschap.getNaam());
        stmsInsertAbiotischeFactorenmulti.setString(3, abioMulti_eigenschap.getValue());
        stmsInsertAbiotischeFactorenmulti.executeUpdate();
        ResultSet rs = stmsInsertAbiotischeFactorenmulti.getGeneratedKeys();
        rs.next();
        Integer abiotische_id = rs.getInt(1);
        abioMulti_eigenschap.setId(abiotische_id);
    }


}