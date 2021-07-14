package ftg.cotation.Cotation.Metier;

import ftg.cotation.Cotation.Model.Cotation;
import ftg.cotation.Cotation.Model.Position;

public interface MetierCotation {
    public Cotation calaculCotation(Position pointA,Position pointB);
}
