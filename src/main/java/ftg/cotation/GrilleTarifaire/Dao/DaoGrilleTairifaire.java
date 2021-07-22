package ftg.cotation.GrilleTarifaire.Dao;

import ftg.cotation.GrilleTarifaire.Model.GrilleTarirefaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaoGrilleTairifaire extends JpaRepository<GrilleTarirefaire,Long> {

    List<GrilleTarirefaire> findByStatusIsTrue();
}
