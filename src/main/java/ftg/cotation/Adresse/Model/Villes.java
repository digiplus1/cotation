package ftg.cotation.Adresse.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Villes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idville;
    @Column(unique = true)
    private String libelle;
    @OneToMany(mappedBy = "villes",fetch = FetchType.EAGER)
    private List<Quartier> quartiers=new ArrayList<>();
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idpays")
    private Pays pays;

    public Villes() {
    }

    public Villes(String libelle) {
        this.libelle = libelle;
    }

    public Long getIdville() {
        return idville;
    }

    public void setIdville(Long idville) {
        this.idville = idville;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Quartier> getQuartiers() {
        return quartiers;
    }

    public void setQuartiers(List<Quartier> quartiers) {
        this.quartiers = quartiers;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
