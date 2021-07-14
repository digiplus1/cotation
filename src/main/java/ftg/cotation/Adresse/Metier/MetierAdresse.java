package ftg.cotation.Adresse.Metier;

import ftg.cotation.Adresse.Model.*;
import ftg.cotation.Adresse.Web.AdresseDto;
import ftg.cotation.Cotation.Model.Cotation;
import ftg.cotation.Cotation.Model.Position;

import java.util.List;

public interface MetierAdresse {
    Pays getpaysByName(String pays);
    Pays savePays(Pays pays);

    Villes getVilleByName(String ville,String pays);
    Villes saveVille(Villes villes,Pays pays);

    Quartier getQuartierByName(String quartier,String ville);
    Quartier saveQuartier(Quartier quartier,Villes ville);

    Secteurs getSecteurByName(String secteur,String quartier);
    Secteurs saveSecteur(Secteurs secteurs,Quartier quartier);

    Pointspecifique getPointSpecifiByName(String pointSpecifique, String secteur);
    Pointspecifique savePointSpecifique(Pointspecifique pointSpecifique, Secteurs secteur);


    Cotation getCotationByAdresse(AdresseDto adresseDto);

    Secteurs updateCordonne(Position position,Long idsecteur);
    List<Pays> getAllPays();
}
