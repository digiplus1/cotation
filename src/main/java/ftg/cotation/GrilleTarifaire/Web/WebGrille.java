package ftg.cotation.GrilleTarifaire.Web;

import ftg.cotation.GrilleTarifaire.Dao.DaoGrilleTairifaire;
import ftg.cotation.GrilleTarifaire.Metier.MetierGrilleTarifaire;
import ftg.cotation.GrilleTarifaire.Model.GrilleTarirefaire;
import ftg.cotation.GrilleTarifaire.Web.Dto.DtoGrilleTarifaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("grille")
public class WebGrille {
    @Autowired
    private MetierGrilleTarifaire metierGrilleTarifaire;

    @GetMapping("all")
    List<GrilleTarirefaire> getAll(){
        return metierGrilleTarifaire.getAll();
    }

    @PostMapping("save")
    GrilleTarirefaire saveGrill(@RequestBody DtoGrilleTarifaire dtoGrilleTarifaire){
        return metierGrilleTarifaire.save(dtoGrilleTarifaire);
    }

    @PutMapping("update/{idgrille}")
    GrilleTarirefaire updategrille(@RequestBody DtoGrilleTarifaire dtoGrilleTarifaire,@PathVariable Long idgrille){
        return metierGrilleTarifaire.updategrille(dtoGrilleTarifaire, idgrille);
    }

    @GetMapping("change/status/{idgrille}")
    GrilleTarirefaire changeStatus(@PathVariable Long idgrille){
        return metierGrilleTarifaire.changeStatusgrille(idgrille);
    }
}
