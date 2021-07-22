package ftg.cotation.Cotation.Service;

import ftg.cotation.Cotation.Metier.MetierCotation;
import ftg.cotation.Cotation.Model.Cotation;
import ftg.cotation.Cotation.Model.Position;
import ftg.cotation.GrilleTarifaire.Dao.DaoGrilleTairifaire;
import ftg.cotation.GrilleTarifaire.Metier.MetierGrilleTarifaire;
import ftg.cotation.GrilleTarifaire.Model.GrilleTarirefaire;
import org.springframework.beans.factory.annotation.Autowired;
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

        Cotation cotation=new Cotation();
        cotation.setDistance(distance);
        cotation.setPrix(calculPrix(distance));
        return cotation;
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

    double calculPrix(double distance){
        GrilleTarirefaire grilleTarirefaire= metierGrilleTarifaire.getDistance(distance);
        return grilleTarirefaire.getPrix();
    }
}
