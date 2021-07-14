package ftg.cotation.Cotation.WebController;

import ftg.cotation.Cotation.Metier.MetierCotation;
import ftg.cotation.Cotation.Model.Cotation;
import ftg.cotation.Cotation.Service.ServiceCotation;
import ftg.cotation.Cotation.WebController.Dto.CotationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("cotation")
public class CotationController {
    @Autowired
    MetierCotation metierCotation;

    @PostMapping("prix")
    private Cotation getCotation(@RequestBody CotationDto cotationDto){
        if (cotationDto.getPointA()!=null && cotationDto.getPointB()!=null){
            return metierCotation.calaculCotation(cotationDto.getPointA(), cotationDto.getPointB());

        }else return null;
    }
}
