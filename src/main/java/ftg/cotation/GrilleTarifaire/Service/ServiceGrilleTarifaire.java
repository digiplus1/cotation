package ftg.cotation.GrilleTarifaire.Service;

import ftg.cotation.GrilleTarifaire.Dao.DaoGrilleTairifaire;
import ftg.cotation.GrilleTarifaire.Metier.MetierGrilleTarifaire;
import ftg.cotation.GrilleTarifaire.Model.GrilleTarirefaire;
import ftg.cotation.GrilleTarifaire.Web.Dto.DtoGrilleTarifaire;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ServiceGrilleTarifaire implements MetierGrilleTarifaire {

    @Autowired
    private DaoGrilleTairifaire daoGrilleTairifaire;

    @Override
    public GrilleTarirefaire save(DtoGrilleTarifaire dtoGrilleTarifaire) {
        GrilleTarirefaire grilleTarirefaire=new GrilleTarirefaire();
        BeanUtils.copyProperties(dtoGrilleTarifaire,grilleTarirefaire);
        return daoGrilleTairifaire.save(grilleTarirefaire);
    }

    @Override
    public List<GrilleTarirefaire> getAll() {
        return daoGrilleTairifaire.findByStatusIsTrue();
    }

    @Override
    public GrilleTarirefaire updategrille(DtoGrilleTarifaire dtoGrilleTarifaire, Long idgrille) {
        GrilleTarirefaire grilleTarirefaire=daoGrilleTairifaire.getById(idgrille);
        BeanUtils.copyProperties(dtoGrilleTarifaire,grilleTarirefaire);
        return grilleTarirefaire;
    }

    @Override
    public GrilleTarirefaire changeStatusgrille(Long idgrille) {
        GrilleTarirefaire grilleTarirefaire=daoGrilleTairifaire.getById(idgrille);
        grilleTarirefaire.setStatus(!grilleTarirefaire.isStatus());
        return grilleTarirefaire;
    }

    @Override
    public GrilleTarirefaire getDistance(double distance) {
        return daoGrilleTairifaire.getGrilleTarirefaireBy(distance);
    }


}
