package ftg.cotation.Cotation.Model;

import java.util.Date;

public class Cotation {
    private String lieux;
    private double distance;
    private double prix;
    private Position positionA;
    private Position positionB;
    private Date date=new Date();

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieux() {
        return lieux;
    }

    public void setLieux(String lieux) {
        this.lieux = lieux;
    }

    public Position getPositionA() {
        return positionA;
    }

    public void setPositionA(Position positionA) {
        this.positionA = positionA;
    }

    public Position getPositionB() {
        return positionB;
    }

    public void setPositionB(Position positionB) {
        this.positionB = positionB;
    }
}
