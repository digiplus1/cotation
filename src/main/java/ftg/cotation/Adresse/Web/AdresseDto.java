package ftg.cotation.Adresse.Web;

public class AdresseDto {
    private String pays;
    private String ville;
    private String quartierDepart;
    private String secteurDepart;
    private String quartierArriver;
    private String secteurArriver;

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartierDepart() {
        return quartierDepart;
    }

    public void setQuartierDepart(String quartierDepart) {
        this.quartierDepart = quartierDepart;
    }

    public String getSecteurDepart() {
        return secteurDepart;
    }

    public void setSecteurDepart(String secteurDepart) {
        this.secteurDepart = secteurDepart;
    }

    public String getQuartierArriver() {
        return quartierArriver;
    }

    public void setQuartierArriver(String quartierArriver) {
        this.quartierArriver = quartierArriver;
    }

    public String getSecteurArriver() {
        return secteurArriver;
    }

    public void setSecteurArriver(String secteurArriver) {
        this.secteurArriver = secteurArriver;
    }
}
