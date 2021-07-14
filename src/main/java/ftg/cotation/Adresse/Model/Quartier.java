package ftg.cotation.Adresse.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Quartier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idquartier;
    private String libelle;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idville")
    private Villes villes;
    @OneToMany(mappedBy = "quartier")
    private List<Secteurs> secteurs=new ArrayList<>();

    public Quartier() {
    }

    public Quartier(String libelle) {
        this.libelle = libelle;
    }

    public Long getIdquartier() {
        return idquartier;
    }

    public void setIdquartier(Long idquartier) {
        this.idquartier = idquartier;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Villes getVilles() {
        return villes;
    }

    public void setVilles(Villes villes) {
        this.villes = villes;
    }

    public List<Secteurs> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteurs> secteurs) {
        this.secteurs = secteurs;
    }
}
