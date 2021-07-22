package ftg.cotation.GrilleTarifaire.Web.Dto;

public class DtoGrilleTarifaire {
    private String libelle;
    private double distancemin;
    private double distancemax;
    private String description;
    private double prix;

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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
