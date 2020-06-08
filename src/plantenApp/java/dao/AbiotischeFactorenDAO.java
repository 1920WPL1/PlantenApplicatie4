package plantenApp.java.dao;

import plantenApp.java.model.AbioMulti_Eigenschap;
import plantenApp.java.model.AbiotischeFactoren;
import plantenApp.java.model.Plant;

import java.sql.*;
import java.util.ArrayList;



/**@author Siebe*/
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

    /**
     * @param id -> plant_id
     * @return -> alle abiotische factoren van de specifieke plant
     * @author Siebe
     */
    public AbiotischeFactoren getById(int id) throws SQLException {
        AbiotischeFactoren abio = null;

        stmtSelectAbioByID.setInt(1, id);
        ResultSet rs = stmtSelectAbioByID.executeQuery();
        if (rs.next()) {
            abio = new AbiotischeFactoren(
                    rs.getInt("abiotische_id"),
                    rs.getInt("plant_id"),
                    rs.getString("bezonning"),
                    rs.getString("grondsoort"),
                    rs.getString("vochtbehoefte"),
                    rs.getString("voedingsbehoefte"),
                    rs.getString("reactie_antagonistische_omg"),
                    getByIdMulti(id)
            );
        }
        return abio;
    }

    /**
     * @param id -> plant_id
     * @return -> alle abiotische_multi factoren van de specifieke plant
     * @author Siebe
     * word alleen gebruikt in getById
     */
    private ArrayList<AbioMulti_Eigenschap> getByIdMulti(int id) throws SQLException {
        ArrayList<AbioMulti_Eigenschap> abioMulti = new ArrayList<>();
        ;

        stmtSelectAbioMultiByID.setInt(1, id);
        ResultSet rs = stmtSelectAbioMultiByID.executeQuery();
        while (rs.next()) {
            AbioMulti_Eigenschap abioEigenschap = new AbioMulti_Eigenschap(
                    rs.getInt("abiotische_id"),
                    rs.getString("eigenschap"),
                    rs.getString("waarde")
            );
            abioMulti.add(abioEigenschap);
        }
        return abioMulti;
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