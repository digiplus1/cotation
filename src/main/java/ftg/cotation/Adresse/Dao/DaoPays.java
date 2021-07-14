package ftg.cotation.Adresse.Dao;

import ftg.cotation.Adresse.Model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoPays extends JpaRepository<Pays,Long> {

    Pays findByLibelleIgnoreCase(String libelle);
}
