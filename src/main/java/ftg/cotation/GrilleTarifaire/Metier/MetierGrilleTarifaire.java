package ftg.cotation.GrilleTarifaire.Metier;

import ftg.cotation.GrilleTarifaire.Model.GrilleTarirefaire;
import ftg.cotation.GrilleTarifaire.Web.Dto.DtoGrilleTarifaire;

import java.util.List;

public interface MetierGrilleTarifaire {

    GrilleTarirefaire save(DtoGrilleTarifaire dtoGrilleTarifaire);
    List<GrilleTarirefaire> getAll();
    GrilleTarirefaire updategrille(DtoGrilleTarifaire dtoGrilleTarifaire,Long idgrille);
    GrilleTarirefaire changeStatusgrille(Long idgrille);
    GrilleTarirefaire getDistance(double distance);
}
