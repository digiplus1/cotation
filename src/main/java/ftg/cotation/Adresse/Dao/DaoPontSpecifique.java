package ftg.cotation.Adresse.Dao;

import ftg.cotation.Adresse.Model.Pointspecifique;
import ftg.cotation.Adresse.Model.Secteurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoPontSpecifique extends JpaRepository<Pointspecifique, Long> {
    @Query("select u from Pointspecifique u where lower(u.libelle) = :pointspeci and lower(u.secteurs.libelle) = :secteur")
    Pointspecifique findByLibelleAndLibellePointSpecifique(String pointspeci, String secteur);

    @Query("select u from Pointspecifique u where lower(u.libelle) = :pointSpecifi and lower(u.secteurs.libelle) = :secteur " +
            "and lower(u.secteurs.quartier.libelle) = :quartier and lower(u.secteurs.quartier.villes.libelle) = :ville " +
            "and lower(u.secteurs.quartier.villes.pays.libelle) = :pays")
    Pointspecifique findByLibelleAndLibellevilleAndlibellePays(String pointSpecifi, String secteur, String quartier, String ville, String pays);

    Pointspecifique findByLibelleAndSecteurs(String pointspeci, Secteurs secteurs);

    Pointspecifique findByLibelle(String s);

}
