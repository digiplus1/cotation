package ftg.cotation.Adresse.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Pays implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpays;
    @Column(unique = true)
    private String libelle;
    @OneToMany(mappedBy = "pays",fetch = FetchType.EAGER)
    private List<Villes> villes=new ArrayList<>();

    public Pays() {
    }

    public Pays(String libelle) {
        this.libelle = libelle;
    }

    public Long getIdpays() {
        return idpays;
    }

    public void setIdpays(Long idpays) {
        this.idpays = idpays;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Villes> getVilles() {
        return villes;
    }

    public void setVilles(List<Villes> villes) {
        this.villes = villes;
    }
}
