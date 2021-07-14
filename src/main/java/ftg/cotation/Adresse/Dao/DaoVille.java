package ftg.cotation.Adresse.Dao;

import ftg.cotation.Adresse.Model.Pays;
import ftg.cotation.Adresse.Model.Villes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoVille extends JpaRepository<Villes,Long> {
    @Query("select u from Villes u where lower(u.libelle) = :ville and lower(u.pays.libelle) = :pays")
    Villes findByLibelleAndLibellePays(String ville,String pays);
    Villes findByLibelleAndPays(String ville, Pays pays);
    Villes findByLibelle(String ville);
}
