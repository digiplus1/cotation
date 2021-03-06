package ftg.cotation.Cotation.Service;

import ftg.cotation.Cotation.Metier.MetierCotation;
import ftg.cotation.Cotation.Model.Cotation;
import ftg.cotation.Cotation.Model.Position;
import ftg.cotation.Erreur.ErrorMessages;
import ftg.cotation.GrilleTarifaire.Dao.DaoGrilleTairifaire;
import ftg.cotation.GrilleTarifaire.Metier.MetierGrilleTarifaire;
import ftg.cotation.GrilleTarifaire.Model.GrilleTarirefaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceCotation implements MetierCotation {
    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM
    @Autowired
    private MetierGrilleTarifaire metierGrilleTarifaire;

    @Override
    public Cotation calaculCotation(Position pointA, Position pointB) {
        double dLat = Math.toRadians((pointB.getLatitude() - pointA.getLatitude()));
        double dLong = Math.toRadians((pointB.getLongitude() - pointA.getLongitude()));

        pointA.setLatitude(Math.toRadians(pointA.getLatitude()));
        pointB.setLatitude(Math.toRadians(pointB.getLatitude()));

        double a = haversin(dLat) + Math.cos(pointA.getLatitude()) * Math.cos(pointB.getLatitude()) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance=EARTH_RADIUS*c;
        GrilleTarirefaire grilleTarirefaire=calculPrix(distance);
        Cotation cotation=new Cotation();
        cotation.setDistance(distance);
        cotation.setPrix(grilleTarirefaire.getPrix());
        cotation.setPositionA(pointA);
        cotation.setPositionB(pointB);
        cotation.setLieux(grilleTarirefaire.getLibelle());
        return cotation;
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

    GrilleTarirefaire calculPrix(double distance){
        GrilleTarirefaire grilleTarirefaire =metierGrilleTarifaire.getDistance(distance);
        if (grilleTarirefaire==null)throw new ErrorMessages("La distance "+distance+" Km est hors Zone", HttpStatus.CHECKPOINT);
        return grilleTarirefaire;
    }
}
