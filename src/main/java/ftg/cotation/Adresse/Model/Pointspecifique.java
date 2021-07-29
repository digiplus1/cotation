package ftg.cotation.Adresse.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Pointspecifique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpointspecifique;
    private String libelle;
    private double latitude;
    private double longitude;
    private boolean statutscordonner=false;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idsecteur")
    private Secteurs secteurs;

    public Pointspecifique() {
    }

    public Pointspecifique(String libelle) {
        this.libelle = libelle;
    }

    public Long getIdpointspecifique() {
        return idpointspecifique;
    }

    public void setIdpointspecifique(Long idpointspecifique) {
        this.idpointspecifique = idpointspecifique;
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

    public Secteurs getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(Secteurs secteurs) {
        this.secteurs = secteurs;
    }

    public boolean isStatutscordonner() {
        return statutscordonner;
    }

    public void setStatutscordonner(boolean statutscordonner) {
        this.statutscordonner = statutscordonner;
    }
}
