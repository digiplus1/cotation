package ftg.cotation.Adresse.Web;

import ftg.cotation.Adresse.Metier.MetierAdresse;
import ftg.cotation.Adresse.Model.Pays;
import ftg.cotation.Adresse.Model.Secteurs;
import ftg.cotation.Cotation.Model.Cotation;
import ftg.cotation.Cotation.Model.Position;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("adresse")
public class AdresseRest {

    @Autowired
    private MetierAdresse metierAdresse;

    @PostMapping("prix")
    Cotation getPrix(@RequestBody AdresseDto adresseDto){
        return metierAdresse.getCotationByAdresse(adresseDto);
    }

    @GetMapping("all/pays")
    List<Pays> getAllPays(){
        return metierAdresse.getAllPays();
    }

    @PutMapping("update/secteur/cordonne/{idsecteur}")
    Secteurs updateSecteur(@RequestBody Position position,@PathVariable Long idsecteur){
        return metierAdresse.updateCordonne(position, idsecteur);
    }

    @PutMapping("update/pointspecifique/cordonne/{idpointspecifique}")
    Secteurs updatepointSpecifique(@RequestBody Position position,@PathVariable Long idpointspecifique){
        return metierAdresse.updateCordonne(position, idpointspecifique);
    }
}
