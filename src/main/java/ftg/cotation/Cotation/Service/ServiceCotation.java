package ftg.cotation.Cotation.Service;

import ftg.cotation.Cotation.Metier.MetierCotation;
import ftg.cotation.Cotation.Model.Cotation;
import ftg.cotation.Cotation.Model.Position;
import org.springframework.stereotype.Service;

@Service
public class ServiceCotation implements MetierCotation {
    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

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
        double prix=0;
        if (0<=distance && distance<=5){
            prix=500;
        }else  if (5<distance && distance<=10){
            prix=1000;
        } if (10<distance && distance<=20){
            prix=1500;
        } if (25<distance && distance<=30){
            prix=1500;
        }
        return prix;
    }
}
