package ftg.cotation.Cotation.WebController.Dto;

import ftg.cotation.Cotation.Model.Position;

public class CotationDto {

    private Position pointA;
    private Position pointB;

    public Position getPointA() {
        return pointA;
    }

    public void setPointA(Position pointA) {
        this.pointA = pointA;
    }

    public Position getPointB() {
        return pointB;
    }

    public void setPointB(Position pointB) {
        this.pointB = pointB;
    }
}
