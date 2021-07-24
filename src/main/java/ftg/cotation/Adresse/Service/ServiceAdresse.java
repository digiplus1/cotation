package ftg.cotation.Adresse.Service;

import ftg.cotation.Adresse.Dao.*;
import ftg.cotation.Adresse.Metier.MetierAdresse;
import ftg.cotation.Adresse.Model.*;
import ftg.cotation.Adresse.Web.AdresseDto;
import ftg.cotation.Cotation.Metier.MetierCotation;
import ftg.cotation.Cotation.Model.Cotation;
import ftg.cotation.Cotation.Model.Position;
import ftg.cotation.Erreur.ErrorMessages;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Service("serviceadresse")
@Transactional
public class ServiceAdresse implements MetierAdresse {

    @Autowired
    DaoPays daoPays;
    @Autowired
    DaoVille daoVille;
    @Autowired
    DaoQuartier daoQuartier;
    @Autowired
    DaoSecteur daoSecteur;
    @Autowired
    DaoPontSpecifique daoPontSpecifique;
    @Autowired
    MetierCotation metierCotation;


    @Override
    public Pays getpaysByName(String pays) {
        return daoPays.findByLibelleIgnoreCase(pays);
    }

    @Override
    public Pays savePays(Pays pays) {
        Pays pays1=daoPays.findByLibelleIgnoreCase(pays.getLibelle());
        if (pays1==null){
            pays=daoPays.save(pays);
            return pays;
        }else return pays1;

    }

    @Override
    public Villes getVilleByName(String ville, String pays) {
        return daoVille.findByLibelleAndLibellePays(ville, pays);
    }

    @Override
    public Villes saveVille(Villes villes,Pays pays) {
        Villes villes1=daoVille.findByLibelle(villes.getLibelle());
        if (villes1==null){
            villes.setPays(pays);
            villes=daoVille.save(villes);
            return villes;
        }else return villes1;

    }

    @Override
    public Quartier getQuartierByName(String quartier, String ville) {
        return daoQuartier.findByLibelleAndLibelleville(quartier, ville);
    }

    @Override
    public Quartier saveQuartier(Quartier quartier,Villes ville) {
        Quartier quartier1=daoQuartier.findByLibelleAndVilles(quartier.getLibelle(),ville);
        if (quartier1==null){
            quartier.setVilles(ville);
            quartier=daoQuartier.save(quartier);
            return quartier;
        }else return quartier1;

    }

    @Override
    public Secteurs getSecteurByName(String secteur, String quartier) {
        return daoSecteur.findByLibelleAndLibelleQuartier(secteur, quartier);
    }

    @Override
    public Secteurs saveSecteur(Secteurs secteurs,Quartier quartier) {
        Secteurs secteurs1=daoSecteur.findByLibelleAndQuartier(secteurs.getLibelle(),quartier);
        if (secteurs1==null){
            secteurs.setQuartier(quartier);
            secteurs =daoSecteur.save(secteurs);
            return secteurs;
        }else return secteurs1;

    }

    @Override
    public Pointspecifique getPointSpecifiByName(String pointSpecifique, String secteur) {
        return daoPontSpecifique.findByLibelleAndLibellePointSpecifique(pointSpecifique, secteur);
    }

    @Override
    public Pointspecifique savePointSpecifique(Pointspecifique pointSpecifique, Secteurs secteur) {
      Pointspecifique pointspecifique1 =daoPontSpecifique.findByLibelleAndSecteurs(pointSpecifique.getLibelle(),secteur);
      if (pointspecifique1 ==null){
          pointSpecifique.setSecteurs(secteur);
          pointSpecifique=daoPontSpecifique.save(pointSpecifique);
          return pointSpecifique;
      }else return pointspecifique1;

    }

    @Override
    public Cotation getCotationByAdresse(AdresseDto adresseDto) {

        Secteurs secteursA=daoSecteur.getById( adresseDto.getIdsecteurArriver());
        Position positionA=new Position(secteursA.getLatitude(),secteursA.getLongitude());
        Secteurs secteursB=daoSecteur.getById(adresseDto.getIdsecteurDepart());
       Position positionB=new Position(secteursB.getLatitude(),secteursB.getLongitude());

       if ((secteursA.getLatitude()==0 && secteursA.getLongitude()==0) || (secteursB.getLatitude()==0 || secteursB.getLongitude()==0))
           throw new ErrorMessages("Les adresses des secteur choisis ne sont pas encore enregistrés merci de le signaler ", HttpStatus.FOUND);

        Cotation cotation=metierCotation.calaculCotation(positionA,positionB);
        return cotation;
    }

    @Override
    public Secteurs updateCordonne(Position position, Long idsecteur) {
        Secteurs secteurs=daoSecteur.getById(idsecteur);
        secteurs.setLatitude(position.getLatitude());
        secteurs.setLongitude(position.getLongitude());
        return secteurs;
    }

    @Override
    public Pointspecifique updatepointspecifique(Position position, Long idpointspecifique) {
        Pointspecifique pointspecifique=daoPontSpecifique.getById(idpointspecifique);
        pointspecifique.setLatitude(position.getLatitude());
        pointspecifique.setLongitude(position.getLongitude());
        return pointspecifique;
    }

    @Override
    public List<Pays> getAllPays() {
        return daoPays.findAll();
    }


    @Bean
    void lireExcel() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("localisation.xlsx"));

        // Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // Get first sheet from the workbook
        XSSFSheet feuille = workbook.getSheetAt(0);
        int index=1;
        Row row=feuille.getRow(index++);
        row=feuille.getRow(index++);
        // Get iterator to all the rows in current sheet
        while (row!=null) {
            if (row.getCell(0) != null && row.getCell(2) != null && row.getCell(3) != null && row.getCell(4) != null) {
                Quartier  quartier=new Quartier();
                Secteurs secteurs=new Secteurs();
                Pointspecifique pointSpecifique=new Pointspecifique();
               Pays p=savePays(new Pays(row.getCell(0).getStringCellValue().trim()));

                Villes v=saveVille(new Villes(row.getCell(1).getStringCellValue().trim()),p);

                Quartier q=saveQuartier(new Quartier(row.getCell(2).getStringCellValue().trim()),v);

                Secteurs s=saveSecteur(new Secteurs(row.getCell(3).getStringCellValue().trim()),q);

                savePointSpecifique(new Pointspecifique(row.getCell(4).getStringCellValue().trim()),s);
            }
            row=feuille.getRow(index++);
        }


    }
}
