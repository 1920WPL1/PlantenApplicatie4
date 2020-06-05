package plantenApp.java.dao;

public interface Queries {
    //region GETBYID
    String GETPLANTBYID = "SELECT * FROM plant WHERE plant_id = ?";

    String GETFENOTYPEBYPLANTID = "SELECT * FROM fenotype WHERE plant_id = ?";
    String GETFENOTYPEMULTIBYPLANTID = "SELECT * FROM fenotype_multi WHERE plant_id = ?";

    String GETABIOTISCHBYPLANTID = "SELECT * FROM abiotische_factoren WHERE plant_id = ?";
    String GETABIOTISCHBMULTIYPLANTID = "SELECT * FROM abiotisch_multi WHERE plant_id = ?";

    String GETCOMMENSALISMEBYPLANTID = "SELECT * FROM commensalisme WHERE plant_id = ?";
    String GETCOMMENSALISMEMULTIBYPLANTID = "SELECT * FROM commensalisme_multi WHERE plant_id = ?";

    String GETBEHEERBYPLANTID = "SELECT * FROM beheer WHERE plant_id = ?";

    String GETEXTRABYPLANTID = "SELECT * FROM extra WHERE plant_id = ?";

    String GETFOTOBYPLANTID = "SELECT * FROM foto WHERE plant_id = ?";
    //endregion

    //region GETIDBYKENMERKEN
    String GETIDSBYPLANT =
            "SELECT plant_id FROM plant WHERE " +
                    "type = ? OR  1=? " +
                    "AND " +
                    "familie = ? OR 1=?" +
                    "AND " +
                    "fgsv LIKE ? OR 1=?";

    String GETIDSBYEXTRA =
            "SELECT plant_id FROM extra WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "nectarwaarde = ? OR 1=?" +
                    "AND " +
                    "pollenwaarde = ? OR 1=?" +
                    "AND " +
                    "bijvriendelijk = ? OR 1=?" +
                    "AND " +
                    "eetbaar = ? OR 1=?" +
                    "AND " +
                    "kruidgebruik = ? OR 1=?" +
                    "AND " +
                    "geurend = ? OR 1=?" +
                    "AND " +
                    "vorstgevoelig = ? OR 1=?";

    String GETIDSBYABIO =
            "SELECT plant_id FROM abiotische_factoren " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "bezonning = ? OR 1=?" +
                    "AND " +
                    "grondsoort = ? OR 1=?" +
                    "AND " +
                    "vochtbehoefte = ? OR 1=?" +
                    "AND " +
                    "voedingsbehoefte = ? OR 1=?" +
                    "AND " +
                    "reactie_antagonistische_omg = ? OR 1=?";
    String GETIDSBYABIOMULTI =
            "SELECT plant_id FROM abiotische_factoren " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "eigenschap = ? "+
                    "AND " +
                    "waarde = ? OR 1=?";

    String GETIDSBYCOMM =
            "SELECT plant_id FROM commensalisme " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "strategie = ? OR 1=?" +
                    "AND " +
                    "ontwikkelingssnelheid = ? OR 1=?";
    String GETIDSBYCOMMMULTI =
            "SELECT plant_id FROM commensalisme_multi " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "eigenschap = ? "+
                    "AND " +
                    "waarde = ? OR 1=?";

    String GETIDSBYFENO =
            "SELECT plant_id FROM commensalisme " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "bladvorm = ? OR 1=?" +
                    "AND " +
                    "levensvorm = ? OR 1=?" +
                    "AND " +
                    "habitus = ? OR 1=?" +
                    "AND " +
                    "bloeiwijze = ? OR 1=?" +
                    "AND " +
                    "bladgrootte = ? OR 1=?" +
                    "AND " +
                    "ratio_bloei_blad = ? OR 1=?" +
                    "AND " +
                    "spruitfenologie = ? OR 1=?";
    String GETIDSBYFENOMULTI =
            "SELECT plant_id FROM commensalisme_multi " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "eigenschap = ? "+
                    "AND " +
                    "jan = ? OR 1=?" +
                    "AND " +
                    "feb = ? OR 1=?" +
                    "AND " +
                    "maa = ? OR 1=?" +
                    "AND " +
                    "apr = ? OR 1=?" +
                    "AND " +
                    "mei = ? OR 1=?" +
                    "AND " +
                    "jun = ? OR 1=?" +
                    "AND " +
                    "jul = ? OR 1=?" +
                    "AND " +
                    "aug = ? OR 1=?" +
                    "AND " +
                    "sep = ? OR 1=?" +
                    "AND " +
                    "okt = ? OR 1=?" +
                    "AND " +
                    "nov = ? OR 1=?" +
                    "AND " +
                    "dec = ? OR 1=?";
    String GETIDSBYBEHEER =
            "SELECT plant_id FROM Beheer " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "beheerdaad = ? OR 1=? "+
                    "AND " +
                    "maand = ? OR 1=?" +
                    "AND " +
                    "frequentie_jaar = ? OR 1=?";
//endregion

    //region NAAKTETABELLEN

    String NTTYPE =
            "SELECT type_naam FROM type";

    String NTFAMILIE =
            "SELECT familie_naam FROM familie";

    String NTLEVENSDUURCONCURRENTIEKRACHT =
            "SELECT waarde FROM levensduur_concurrentiekracht";

    String NTSTRATEGIE =
            "SELECT waarde FROM strategie";

    String NTONTWIKKELINGSSNELHEID =
            "SELECT waarde FROM ontwikkelingssnelheid";

    String NTVOEDINGSBEHOEFTE =
            "SELECT waarde FROM voedingsbehoefte";

    String NTVOCHTBEHOEFTE =
            "SELECT waarde FROM vochtbehoefte";

    String NTHABITAT =
            "SELECT waarde FROM habitat";

    String NTREACTIEOMGEVING =
            "SELECT waarde FROM reactieomgeving";

    String NTGRONDSOORT =
            "SELECT waarde FROM grondsoort";

    String NTBEZONNING =
            "SELECT waarde FROM bezonning";

    String NTHABITUS =
            "SELECT waarde FROM habitus";

    String NTKLEUREN =
            "SELECT kleur FROM kleuren";

    String NTBLADVORM =
            "SELECT waarde FROM bladvorm";

    String NTRATIOBLOEIBLAD =
            "SELECT waarde FROM ratio_bloeiblad";

    String NTSPRUITFENOLOGIE =
            "SELECT waarde FROM spruitfenologie";

    String NTBLOEIWIJZE =
            "SELECT waarde FROM bloeiwijze";

    String NTSOCIABILITEIT =
            "SELECT waarde FROM sociabiliteit";

    String NTBEHEERDAAD =
            "SELECT waarde FROM beheerdaad";

    String NTNECTARWAARDE =
            "SELECT waarde FROM nectarwaarde";

    String NTPOLLENWAARDE =
            "SELECT waarde FROM pollenwaarde";

    String NTBLADGROOTTE =
            "SELECT waarde FROM maxbladgrootte";

    String NTLEVENSVORM =
            "SELECT waarde FROM levensvorm";

    String NTFOTOHABITUS =
            "SELECT afbeelding FROM habitus";

    String NTFOTOBlOEIWIJZE =
            "SELECT afbeelding FROM bloeiwijze";
    //endregion

    //Groep 4
    //Insert query voor toevoegen
    String INSERTABIOTISCHEFMULTI =
            "INSTER INTO abiotisch_multi(plant_id, eigenschap, waarde)" +
                    "VALUES(?, ?, ?)";

    String INSERTABIOTISCHEF =
            "INSERT INTO abiotische_factoren(plant_id, bezonning, grondsoort, vochtbehoefte, voedingsbehoefte, reactie_antagonistische_omg) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

    String INSERTBEHEER =
            "INSERT INTO beheer(plant_id, beheerdaad, opmerking, maand, frequentie_jaar)" +
                    "VALUES(?, ?, ?, ?, ?)";

    String INSERTSTANDAARD =
            "INSERT INTO plant (type, familie, geslacht, soort, variatie, plantdichtheid_min, plantdichtheid_max, fgsv) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    String INSERTCOMMESALISME =
            "INSERT INTO commensalisme(plant_id, strategie, ontwikkelingssnelheid)" +
                    "VALUES(?, ?, ?)";

    String INSERTCOMMESALISMEMULTI =
            "INSERT INTO commensialisme_multi(plant_id, eigenschap, waarde)" +
                    "VALUES(?, ?, ?)";

    String INSERTEXTRA =
            "INSERT INTO extra(plant_id, nectarwaarde, pollenwaarde, bijvriendelijk, eetbaar, kruidgebruik, geurend, vorstgevoelig)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?,?)";

    String INSERTFENOTYPE =
            "INSERT INTO fenotype(plant_id, bladvorm, levensvorm, habitus, bloeiwijze, bladgrootte, ratio_bloei_blad, spruitfenelogie)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    String INSERTFENOTYPEMULTI =
            "INSERT INTO fenotype_multi(plant_id,eigenschap, jan, feb, maa, apr, mei, jun, jul, aug, sep, okt, nov, dec)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String INSERTFOTO =
            "INSERT INTO foto(plant_id, eigenschap, url, figuur)" +
                    "VALUES(?, ?, ?, ?)";


    //Insert query voor naaktetabellen
    String INSERTBEHEERDAAD =
            "INSERT INTO beheerdaad(waarde)" +
                    "VALUES(?)";

    String INSERTBEZONNING =
            "INSERT INTO bezonning(waarde) VALUES(?)";

    String INSERTBLADVORM =
            "INSERT INTO bladvorm(waarde) VALUES(?)";

    String INSERTBLOEIWIJZE =
            "INSERT INTO bloeiwijze(waarde) VALEUS(?)";

    String INSERTFAMILIE =
            "INSERT INTO familie(familie_naam, type_id) VALUES(?, ?)";

    String INSERTGESLACHT =
            "INSERT INTO geslacht(geslacht_naam, familie_id) VALUES(?, ?)";

    String INSERTGRONDSOORT =
            "INSERT INTO grondsoort(waarde) VALUES(?)";

    String INSERTHABITAT =
            "INSERT INTO habitat(waarde, afkorting) VALUES(?, ?)";

    String INSERTHABITUS =
            "INSERT INTO habitus(waarde, afbeelding) VALUES(?, ?)";

    String INSERTKLEUR =
            "INSERT INTO kleuren(kleur) VALUES(?)";

    String INSERTLEVENSDUUR =
            "INSERT INTO levenduur_concurrentiekracht(waarde) VALUES (?)";

    String INSERTMAXBLADGROOTTE =
            "INSERT INTO maxbladgrootte(waarde) VALUES(?)";

    String INSERTNECTARWAARDE =
            "INSERT INTO nectarwaarde(waarde) VALUES(?)";

    String INSERTONTWIKKELINGSSNELHEID =
            "INSERT INTO ontwikkelingssnelheid(waarde) VALUES(?)";

    String INSERTPOLLENWAARDE =
            "INSERT INTO pollenwaarde(waarde) VALUES(?)";

    String INSERTRATIO =
            "INSERT INTO ratio_bloeiblad(waarde) VALUES(?)";

    String INSERTREACTIEOMGEVING =
            "INSERT INTO reactieomgeving(waarde) VALUES(?)";

    String INSERTSOCIABILITEIT =
            "INSERT INTO sociabiliteit(waarde) VALUES(?)";

    String INSERTSOORT =
            "INSERT INTO soort(soort_naam, geslacht_id) VALUES(?, ?)";

    String INSERTSPRUITFENOLOGIE =
            "INSERT INTO spruitfenologie(waarde) VALUES(?)";

    String INSERTSTRATEGIE =
            "INSERT INTO strategie(waarde) VALUES(?)";

    String INSERTTYPE =
            "INSERT INTO type(type_naam) VALUES(?)";

    String INSERTVARIATIE =
            "INSERT INTO variatie(variatie_naam, soort_id) VALUES(?,?)";

    String INSERTVOCHTBEHOEFTE =
            "INSERT INTO vochtbehoefte(waarde) VALUES(?)";

    String INSERTVOEDINGSBEHOEFTE =
            "INSERT INTO voedingsbehoeft(waarde) VALUES(?)";
    
}

