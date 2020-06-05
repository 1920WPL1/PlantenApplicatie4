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

    /**@author Siebe
     * @param id -> plant_id
     * @return -> alle extra kenmerken van de specifieke plant
     */
    public Extra getExtraById(int id) throws SQLException {
        Extra extra = null;

        stmtSelectExtraByID.setInt(1, id);
        ResultSet rs = stmtSelectExtraByID.executeQuery();
        if (rs.next()) {
            extra = new Extra(
                    rs.getInt("extra_id"),
                    rs.getInt("plant_id"),
                    rs.getInt("nectarwaarde"),
                    rs.getInt("pollenwaarde"),
                    rs.getString("bijvriendelijk"),
                    rs.getString("eetbaar"),
                    rs.getString("kruidgebruik"),
                    rs.getString("geurend"),
                    rs.getString("vorstgevoelig")
            );
        }
        return extra;
    }

    /**@author Siebe
     * @param sPlant_ids -> de te filteren ids
     * @param nectarwaarde -> waarde van nectarwaarde om op te filteren
     * @param pollenwaarde -> waarde van pollenwaarde om op te filteren
     * @param bijvriendelijk -> waarde van bijvriendelijk om op te filteren
     * @param eetbaar -> waarde van eetbaar om op te filteren
     * @param kruidgebruik -> waarde van kruidgebruik om op te filteren
     * @param geurend -> waarde van geurend om op te filteren
     * @param vorstgevoelig -> waarde van vorstgevoelig om op te filteren
     * @return -> de gefilterde ids
     */
    public ArrayList<Integer> KenmerkenFilter(String sPlant_ids, int nectarwaarde, int pollenwaarde, String bijvriendelijk, String eetbaar, String kruidgebruik, String geurend, String vorstgevoelig) throws SQLException {
        ArrayList<Integer> ids = null;

        stmtSelectByExtra.setString(1,sPlant_ids);

        int iTrue = (nectarwaarde == 0) ? 1 : 0;
        stmtSelectByExtra.setInt(2, nectarwaarde);
        stmtSelectByExtra.setInt(3, iTrue);

        iTrue = (pollenwaarde == 0) ? 1 : 0;
        stmtSelectByExtra.setInt(4, pollenwaarde);
        stmtSelectByExtra.setInt(5, iTrue);

        iTrue = (bijvriendelijk.isBlank()) ? 1 : 0;
        stmtSelectByExtra.setString(6, bijvriendelijk);
        stmtSelectByExtra.setInt(7, iTrue);

        iTrue = (eetbaar.isBlank()) ? 1 : 0;
        stmtSelectByExtra.setString(8, eetbaar);
        stmtSelectByExtra.setInt(9, iTrue);

        iTrue = (kruidgebruik.isBlank()) ? 1 : 0;
        stmtSelectByExtra.setString(10, kruidgebruik);
        stmtSelectByExtra.setInt(11, iTrue);

        iTrue = (geurend.isBlank()) ? 1 : 0;
        stmtSelectByExtra.setString(12, geurend);
        stmtSelectByExtra.setInt(13, iTrue);

        iTrue = (vorstgevoelig.isBlank()) ? 1 : 0;
        stmtSelectByExtra.setString(14, vorstgevoelig);
        stmtSelectByExtra.setInt(15, iTrue);

        ResultSet rs = stmtSelectByExtra.executeQuery();
        while (rs.next()) {
            while (rs.next()){
                ids.add(rs.getInt("plant_id"));
            }
            return ids;
        }
        return ids;
    }

    public void createExtra(Extra extra, Plant plant) throws SQLException
    {
        stmtInsertExtra.setInt(1, plant.getId());
        stmtInsertExtra.setInt(2, extra.getNectarwaarde());
        stmtInsertExtra.setInt(3, extra.getPollenwaarde());
        stmtInsertExtra.setString(4, extra.getBijvriendelijk());
        stmtInsertExtra.setString(5, extra.getEetbaar());
        stmtInsertExtra.setString(6, extra.getKruidgebruik());
        stmtInsertExtra.setString(7, extra.getGeurend());
        stmtInsertExtra.setString(8, extra.getVorstgevoelig());
        stmtInsertExtra.executeUpdate();
        ResultSet rs = stmtInsertExtra.getGeneratedKeys();
        rs.next();
        int extra_id = rs.getInt(1);
        extra.setId(extra_id);
    }

}
