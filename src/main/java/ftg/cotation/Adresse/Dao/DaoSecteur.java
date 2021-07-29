package ftg.cotation.Adresse.Dao;

import ftg.cotation.Adresse.Model.Quartier;
import ftg.cotation.Adresse.Model.Secteurs;
import ftg.cotation.Adresse.Model.Villes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DaoSecteur extends JpaRepository<Secteurs,Long> {
    @Query("select u from Secteurs u where u.libelle = :secteur and u.quartier.libelle = :quartier")
    Secteurs findByLibelleAndLibelleQuartier(@Param("secteur") String secteur, @Param("quartier") String quartier);

    @Query("select u from Secteurs u where lower(u.libelle) = :secteur " +
            "and lower(u.quartier.libelle) = :quartier and lower(u.quartier.villes.libelle) = :ville and " +
            "lower(u.quartier.villes.pays.libelle) = :pays")
    Secteurs findByLibelleAndLibellevilleAndlibellePays(String secteur,String quartier, String ville, String pays);

    Secteurs findByLibelleAndQuartier(String secteur,Quartier quartier);
    Secteurs findByLibelle(String s);
    @Query("select u from Secteurs u where u.latitude <> 0 and  u.longitude <> 0")
    List<Secteurs> findBycordonnenon();

}
