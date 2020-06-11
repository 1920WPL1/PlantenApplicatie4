package plantenApp.java.dao;
import plantenApp.java.model.Plant;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlantNaamDAO implements Queries{
    private Connection dbConnection;
    private PreparedStatement stmtSelectTypeId;
    private PreparedStatement stmtSelectDubbeleNaam;
    private PreparedStatement stmtInsertInFamilie;
    private PreparedStatement stmtInsertInGeslacht;
    private PreparedStatement stmtInsertInSoort;
    private PreparedStatement stmtInsertInVariatie;
    private PreparedStatement stmtControleDubbeleFamilie;
    private PreparedStatement stmtControleDubbeleGeslacht;
    private PreparedStatement stmtControleDubbeleSoort;
    private PreparedStatement stmtControleDubbeleVariatie;

    public PlantNaamDAO(Connection dbConnection) throws SQLException {

        this.dbConnection = dbConnection;
        stmtSelectDubbeleNaam = dbConnection.prepareStatement(SELECTDUBBELENAAM);;
        stmtSelectTypeId = dbConnection.prepareStatement(SELECTIDPLANTTYPE);
        stmtInsertInFamilie= dbConnection.prepareStatement(INSERTFAMILIE);
        stmtInsertInGeslacht= dbConnection.prepareStatement(INSERTGESLACHT);
        stmtInsertInSoort = dbConnection.prepareStatement(INSERTSOORT);
        stmtInsertInVariatie = dbConnection.prepareStatement(INSERTVARIATIE);
        stmtControleDubbeleFamilie = dbConnection.prepareStatement(SELECTDUBBELEFAMILIE);
        stmtControleDubbeleGeslacht = dbConnection.prepareStatement(SELECTDUBBELEGESLACHT);
        stmtControleDubbeleSoort = dbConnection.prepareStatement(SELECTDUBBELESOORT);
        stmtControleDubbeleVariatie = dbConnection.prepareStatement(SELECTDUBBELEVARIATIE);
    }

    public Integer ControleDubbeleNaam(Plant plant) throws SQLException {
        stmtSelectDubbeleNaam.setString(1,plant.getType());
        stmtSelectDubbeleNaam.setString(2,plant.getFamilie());
        stmtSelectDubbeleNaam.setString(3,plant.getGeslacht());
        stmtSelectDubbeleNaam.setString(4,plant.getSoort());
        stmtSelectDubbeleNaam.setString(5,plant.getVariatie());
        ResultSet rsControleNaam = stmtSelectDubbeleNaam.executeQuery();
        rsControleNaam.next();
        int iDubbeleNaam = rsControleNaam.getInt(1) ;

        System.out.println("iDubbeleNaam = " + iDubbeleNaam);
        return iDubbeleNaam;
    }

    //functie om de
    public void createPlantNaam(Plant plant) throws SQLException {
        int iplanttypeID, ifamilieID, igeslachtID, isoortID, iVariatieID;

        //Ophalen id's & planttypeid
        stmtSelectTypeId.setString(1,plant.getType() );
        ResultSet rsTypeID =stmtSelectTypeId.executeQuery();
        rsTypeID.next();
        iplanttypeID = rsTypeID.getInt(1) ;
        System.out.println(iplanttypeID + " is planttypeID");

        System.out.println(iplanttypeID);
        //Ophalen bestaand id & familieID
        ifamilieID = OphalenFamilieID(plant);
        //Ophalen GeslachtID
        igeslachtID = OphalenGeslachtID(plant);
        //Ophalen soortID
        isoortID = OphalenSoortID(plant);
        //Ophalen variatieID
        iVariatieID = OphalenVariatieID(plant);

        //Invoegen in familie
        if (ifamilieID == 0)
        {
            stmtInsertInFamilie.setString(1,plant.getFamilie());
            stmtInsertInFamilie.setInt(2, iplanttypeID);
            stmtInsertInFamilie.executeUpdate();
            System.out.println("Toevoegen familie geslaagd");

            ifamilieID = OphalenFamilieID(plant);
        }

        //Invoegen in geslacht
        if (igeslachtID == 0)
        {
            stmtInsertInGeslacht.setString(1,plant.getGeslacht());
            stmtInsertInGeslacht.setInt(2, ifamilieID);
            stmtInsertInGeslacht.executeUpdate();
            System.out.println("Toevoegen geslacht geslaagd");

            igeslachtID = OphalenGeslachtID(plant);
        }

        //Invoegen in soort
        if (isoortID == 0) {
            stmtInsertInSoort.setString(1, plant.getSoort());
            stmtInsertInSoort.setInt(2, igeslachtID);
            stmtInsertInSoort.executeUpdate();
            System.out.println("Toevoegen soort geslaagd");

            isoortID = OphalenSoortID(plant);
        }

        if(iVariatieID == 0) {
            //Invoegen in variatie
            stmtInsertInVariatie.setString(1, plant.getVariatie());
            stmtInsertInVariatie.setInt(2, isoortID);
            stmtInsertInVariatie.executeUpdate();
            System.out.println("Toevoegen variatie geslaagd");

        }
    }

    //funtie om het familieID op te halen
    private int OphalenFamilieID(Plant plant) throws SQLException {
        int ifamilieID;
        stmtControleDubbeleFamilie.setString(1,plant.getFamilie() );
        stmtControleDubbeleFamilie.setString(2,plant.getFamilie() );
        ResultSet rsFamilieID =stmtControleDubbeleFamilie.executeQuery();
        rsFamilieID.next();
        ifamilieID = rsFamilieID.getInt(1) ;
        System.out.println(ifamilieID + " is familieID");
        return ifamilieID;
    }
    //functie op het geslachtsid op te halen
    private int OphalenGeslachtID(Plant plant) throws SQLException {
        int iGeslachtID;
        stmtControleDubbeleGeslacht.setString(1,plant.getGeslacht() );
        stmtControleDubbeleGeslacht.setString(2,plant.getGeslacht() );
        ResultSet rsGeslachtID =stmtControleDubbeleGeslacht.executeQuery();
        rsGeslachtID.next();
        iGeslachtID = rsGeslachtID.getInt(1) ;
        System.out.println(iGeslachtID + " is geslachtID");
        return iGeslachtID;
    }
    //fucntie om het soortid op te halen
    private int OphalenSoortID(Plant plant) throws SQLException {
        int iSoortID;
        stmtControleDubbeleSoort.setString(1,plant.getSoort() );
        stmtControleDubbeleSoort.setString(2,plant.getSoort() );
        ResultSet rsSoortID =stmtControleDubbeleSoort.executeQuery();
        rsSoortID.next();
        iSoortID = rsSoortID.getInt(1) ;
        System.out.println(iSoortID + " is soortID");
        return iSoortID;
    }
    //fucntie om de variantieID op te halen
    private int OphalenVariatieID(Plant plant) throws SQLException {
        int iVariatieID;
        stmtControleDubbeleVariatie.setString(1,plant.getVariatie() );
        stmtControleDubbeleVariatie.setString(2,plant.getVariatie() );
        ResultSet rsVariatieID =stmtControleDubbeleVariatie.executeQuery();
        rsVariatieID.next();
        iVariatieID= rsVariatieID.getInt(1) ;
        System.out.println(iVariatieID + " is variatieID");
        return iVariatieID;
    }
}
