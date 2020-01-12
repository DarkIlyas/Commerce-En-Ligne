package mypack.beans;

public class Commande {
    private Client client;
    private String date;
    private double montant;
    private String modePaiement;
    private String statutPaiement;
    private String modeLivraison;
    private String statutLivraison;

    public Client getClient() {
        return client;
    }

    public String getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public String getModeLivraison() {
        return modeLivraison;
    }

    public String getStatutLivraison() {
        return statutLivraison;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public void setModeLivraison(String modeLivraison) {
        this.modeLivraison = modeLivraison;
    }

    public void setStatutLivraison(String statutLivraison) {
        this.statutLivraison = statutLivraison;
    }
}
