package ftg.cotation.GrilleTarifaire.Dao;

import ftg.cotation.Adresse.Model.Pointspecifique;
import ftg.cotation.GrilleTarifaire.Model.GrilleTarirefaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DaoGrilleTairifaire extends JpaRepository<GrilleTarirefaire,Long> {

    List<GrilleTarirefaire> findByStatusIsTrue();
    @Query("select u from GrilleTarirefaire u where lower(u.distancemin) >= :distance and lower(u.distancemax) < :distance")
    GrilleTarirefaire getGrilleTarirefaireBy(double distance);
}
