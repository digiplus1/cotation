package ftg.cotation.GrilleTarifaire.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "grilletarifaire")
public class GrilleTarirefaire implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idgrille;
    @Column(unique = true)
    private String libelle;
    private double distancemin;
    private double distancemax;
    private String description;
    private boolean status=true;
    private double prix;

    public Long getIdgrille() {
        return idgrille;
    }

    public void setIdgrille(Long idgrille) {
        this.idgrille = idgrille;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getDistancemin() {
        return distancemin;
    }

    public void setDistancemin(double distancemin) {
        this.distancemin = distancemin;
    }

    public double getDistancemax() {
        return distancemax;
    }

    public void setDistancemax(double distancemax) {
        this.distancemax = distancemax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
