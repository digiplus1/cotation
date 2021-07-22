package ftg.cotation.Adresse.Web;

public class AdresseDto {
    private String pays;
    private String villeDepart;
    private String quartierDepart;
    private String secteurDepart;
    private String villeArriver;
    private String quartierArriver;
    private String secteurArriver;

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
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

    public String getVilleArriver() {
        return villeArriver;
    }

    public void setVilleArriver(String villeArriver) {
        this.villeArriver = villeArriver;
    }
}
