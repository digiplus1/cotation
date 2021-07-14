package ftg.cotation.Adresse.Dao;

import ftg.cotation.Adresse.Model.Quartier;
import ftg.cotation.Adresse.Model.Villes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoQuartier extends JpaRepository<Quartier,Long> {

    @Query("select u from Quartier u where lower(u.libelle) = :quartier and lower(u.villes.libelle) = :ville")
    Quartier findByLibelleAndLibelleville(String quartier, String ville);

    @Query("select u from Quartier u where lower(u.libelle) = :quartier and lower(u.villes.libelle) = :ville and lower(u.villes.pays.libelle) = :pays")
    Quartier findByLibelleAndLibellevilleAndlibellePays(String quartier, String ville,String pays);

    Quartier findByLibelleAndVilles(String quartier,Villes villes);
    Quartier findByLibelle(String s);
}
