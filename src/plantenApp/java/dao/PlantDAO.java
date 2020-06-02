package plantenApp.java.dao;

import plantenApp.java.model.Plant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**@author Siebe*/
public class PlantDAO implements Queries {

    private Connection dbConnection;

    //Statements waar geen externe input aan te pas komt
    private static final String GETALLTYPESDD =
            "SELECT type_naam FROM type ";


    private PreparedStatement stmtSelectById;
    private PreparedStatement stmtSelectByPlant;

    public PlantDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectById = dbConnection.prepareStatement(GETPLANTBYID);
        stmtSelectByPlant = dbConnection.prepareStatement(GETIDSBYPLANT);
    }

    /**@author Siebe
     * @param id -> plant_id
     * @return -> alle basis factoren van de specifieke plant
     */
    public Plant getPlantById(int id) throws SQLException {
        Plant plant = null;

        stmtSelectById.setInt(1, id);
        ResultSet rs = stmtSelectById.executeQuery();
        if (rs.next()) {
            plant = new Plant(
                    rs.getInt("plant_id"),
                    rs.getString("type"),
                    rs.getString("familie"),
                    rs.getString("geslacht"),
                    rs.getString("soort"),
                    rs.getString("variatie"),
                    rs.getInt("plantdichtheid_min"),
                    rs.getInt("plantdichtheid_max")
            );
        }
        return plant;
    }

    /**@author Siebe
     * @param type -> waarde type van de plant
     * @param familie -> familie van de plant
     * @param fgsv -> familie, geslacht, soort, variant
     * @return -> de gefilterde ids
     */
    public ArrayList<Integer> KenmerkenFilter (String type, String familie, String fgsv) throws SQLException {
        ArrayList<Integer> ids = new ArrayList<>();;

        int iTrue = (type.isBlank())? 1:0;
        stmtSelectByPlant.setString(1,type);
        stmtSelectByPlant.setInt(2,iTrue);

        iTrue = (familie.isBlank())? 1:0;
        stmtSelectByPlant.setString(3,type);
        stmtSelectByPlant.setInt(4,iTrue);

        iTrue = (fgsv.isBlank())? 1:0;
        stmtSelectByPlant.setString(5,type);
        stmtSelectByPlant.setInt(6,iTrue);

        ResultSet rs = stmtSelectByPlant.executeQuery();
        while (rs.next()){
            ids.add(rs.getInt("plant_id"));
        }
        return ids;
    }
    public List<String> getAllTypes() {
        List<String> typeList = new ArrayList<>();
        typeList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLTYPESDD);
            while (rs.next()) {
                typeList.add(rs.getString("type_naam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeList;
    }

}
