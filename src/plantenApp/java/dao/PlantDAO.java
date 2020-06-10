package plantenApp.java.dao;

import plantenApp.java.model.Plant;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Siebe
 */
public class PlantDAO implements Queries {

    private Connection dbConnection;
    //Query voor alle standaard waarde van de plant
    //private static final
    private PreparedStatement stmtSelectById;
    private PreparedStatement stmtSelectByPlant;
    private PreparedStatement stmtInsertByStandard;
    private PreparedStatement stmtSelectAllByStatus0;
    private PreparedStatement stmtUpdateStatusByid;

    public PlantDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectById = dbConnection.prepareStatement(GETPLANTBYID);
        stmtSelectByPlant = dbConnection.prepareStatement(GETIDSBYPLANT);
        stmtInsertByStandard = dbConnection.prepareStatement(INSERTSTANDAARD,
                Statement.RETURN_GENERATED_KEYS);
        stmtSelectAllByStatus0 = dbConnection.prepareStatement(GETPLANTSBYSTATUS);
        stmtUpdateStatusByid = dbConnection.prepareStatement(UPDATESTATUSBYID);
    }

    /**
     * @param id -> plant_id
     * @return -> alle basis factoren van de specifieke plant
     * @author Siebe
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
                    rs.getInt("plantdichtheid_max"),
                    rs.getString("fgsv"),
                    rs.getInt("status")
            );
        }
        return plant;
    }

    public void createPlant(Plant plant) throws SQLException {

        stmtInsertByStandard.setString(1, plant.getType());
        stmtInsertByStandard.setString(2, plant.getFamilie());
        stmtInsertByStandard.setString(3, plant.getGeslacht());
        stmtInsertByStandard.setString(4, plant.getSoort());
        stmtInsertByStandard.setString(5, plant.getVariatie());
        stmtInsertByStandard.setInt(6, plant.getMinPlantdichtheid());
        stmtInsertByStandard.setInt(7, plant.getMaxPlantdichtheid());
        stmtInsertByStandard.setString(8, plant.getFgsv());
        stmtInsertByStandard.setInt(9, plant.getStatus());
        stmtInsertByStandard.executeUpdate();
        ResultSet rs = stmtInsertByStandard.getGeneratedKeys();
        rs.next();
        Integer plant_id = rs.getInt(1);
        plant.setId(plant_id);
    }

    public ArrayList getPlantenByStatus(int status) throws SQLException {
        ArrayList<Plant> arrListPlanten = new ArrayList<>();

        stmtSelectAllByStatus0.setInt(1, status);
        ResultSet rs = stmtSelectAllByStatus0.executeQuery();
        while (rs.next()) {
            arrListPlanten.add(new Plant(
                    rs.getInt("plant_id"),
                    rs.getString("planttype"),
                    rs.getString("familie"),
                    rs.getString("geslacht"),
                    rs.getString("soort"),
                    rs.getString("variatie"),
                    rs.getInt("plantdichtheid_min"),
                    rs.getInt("plantdichtheid_max"),
                    rs.getString("fgsv"),
                    rs.getInt("status")));
        }
        return arrListPlanten;
    }

    public void updatePlantStatusByID(Plant plant) throws SQLException {
        stmtUpdateStatusByid.setInt(1, plant.getStatus());
        stmtUpdateStatusByid.setInt(2, plant.getId());
        stmtUpdateStatusByid.executeUpdate();


    }
}
