package ftg.cotation.Adresse.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Secteurs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsecteur;
    private String libelle;
    private double latitude;
    private double longitude;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idquartier")
    private Quartier quartier;

    @OneToMany(mappedBy = "secteurs",fetch = FetchType.EAGER)
    private List<Pointspecifique> pointspecifiques =new ArrayList<>();

    public Secteurs() {
    }

    public Secteurs(String libelle) {
        this.libelle = libelle;
    }

    public Long getIdsecteur() {
        return idsecteur;
    }

    public void setIdsecteur(Long idsecteur) {
        this.idsecteur = idsecteur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }

    public List<Pointspecifique> getPointspecifiques() {
        return pointspecifiques;
    }

    public void setPointspecifiques(List<Pointspecifique> pointspecifiques) {
        this.pointspecifiques = pointspecifiques;
    }
}
