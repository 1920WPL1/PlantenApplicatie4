package plantenApp.java.dao;

import plantenApp.java.model.Foto;
import plantenApp.java.model.Foto_Eigenschap;
import plantenApp.java.model.Plant;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Siebe
 */
public class FotoDAO implements Queries {
    private Connection dbConnection;
    private PreparedStatement stmtSelectFotoByID;
    private PreparedStatement stmtInsertFoto;

    public FotoDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectFotoByID = dbConnection.prepareStatement(GETFOTOBYPLANTID);
        stmtInsertFoto = dbConnection.prepareStatement(INSERTFOTOEIG,
                Statement.RETURN_GENERATED_KEYS);
    }


    private ArrayList<Foto_Eigenschap> getFotos(int id) throws SQLException {
        ArrayList<Foto_Eigenschap> fotos = new ArrayList<>();
        stmtSelectFotoByID.setInt(1, id);
        ResultSet rs = stmtSelectFotoByID.executeQuery();
        while (rs.next()) {
            Foto_Eigenschap foto = new Foto_Eigenschap(
                    rs.getInt("foto_id"),
                    rs.getInt("plant_id"),
                    rs.getString("eigenschap"),
                    rs.getString("url"),
                    rs.getBlob("figuur")
            );
            System.out.println(foto.getImage());
            fotos.add(foto);
        }
        return fotos;
    }

    public void createFoto(Foto_Eigenschap foto_eigenschap, Plant plant) throws SQLException {

        stmtInsertFoto.setInt(1, plant.getId());
        stmtInsertFoto.setString(2, foto_eigenschap.getEigenschap());
        stmtInsertFoto.setString(3, foto_eigenschap.getUrl());
        stmtInsertFoto.setBlob(4, foto_eigenschap.getImage());
        stmtInsertFoto.executeUpdate();
        ResultSet rs = stmtInsertFoto.getGeneratedKeys();
        rs.next();
        Integer fotoId = rs.getInt(1);
        foto_eigenschap.setId(fotoId);
    }
}
