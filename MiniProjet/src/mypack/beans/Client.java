package mypack.beans;

public class Client {
    private String nom;
    private String prenom;
    private String adresseLivraison;
    private String tel;
    private String email;

    public Client(){}

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
