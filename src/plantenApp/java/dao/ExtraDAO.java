package plantenApp.java.dao;

import plantenApp.java.model.Extra;

import plantenApp.java.model.Plant;

import java.sql.*;
import java.util.ArrayList;

/**@author Siebe*/
public class ExtraDAO implements Queries {
    private Connection dbConnection;
    private PreparedStatement stmtSelectExtraByID;
    private PreparedStatement stmtSelectByExtra;
    private PreparedStatement stmtInsertExtra;

    public ExtraDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectExtraByID = dbConnection.prepareStatement(GETEXTRABYPLANTID);
        stmtSelectByExtra = dbConnection.prepareStatement(GETIDSBYEXTRA);
        stmtInsertExtra = dbConnection.prepareStatement(INSERTEXTRA, Statement.RETURN_GENERATED_KEYS);
    }

    public ArrayList getExtraById(int id) throws SQLException {
        ArrayList<String> arrListExtra = new ArrayList<>();

        stmtSelectExtraByID.setInt(1, id);
        ResultSet rs = stmtSelectExtraByID.executeQuery();
        while (rs.next()) {
            arrListExtra.add(rs.getString("extra_id"));
            arrListExtra.add(rs.getString("plant_id"));
            arrListExtra.add(rs.getString("nectarwaarde"));
            arrListExtra.add(rs.getString("pollenwaarde"));
            arrListExtra.add(rs.getString("bijvriendelijk"));
            arrListExtra.add(rs.getString("vlindervriendelijk"));
            arrListExtra.add(rs.getString("eetbaar"));
            arrListExtra.add(rs.getString("kruidgebruik"));
            arrListExtra.add(rs.getString("geurend"));
            arrListExtra.add(rs.getString("vorstgevoelig"));
        }
        return arrListExtra;
    }

    public void createExtra(Extra extra, Plant plant) throws SQLException
    {
        stmtInsertExtra.setInt(1, plant.getId());
        stmtInsertExtra.setInt(2, extra.getNectarwaarde());
        stmtInsertExtra.setInt(3, extra.getPollenwaarde());
        stmtInsertExtra.setString(4, extra.getBijvriendelijk());
        stmtInsertExtra.setString(5, extra.getVlindervriendelijk());
        stmtInsertExtra.setString(6, extra.getEetbaar());
        stmtInsertExtra.setString(7, extra.getKruidgebruik());
        stmtInsertExtra.setString(8, extra.getGeurend());
        stmtInsertExtra.setString(9, extra.getVorstgevoelig());
        stmtInsertExtra.executeUpdate();
        ResultSet rs = stmtInsertExtra.getGeneratedKeys();
        rs.next();
        int extra_id = rs.getInt(1);
        extra.setId(extra_id);
    }

}
