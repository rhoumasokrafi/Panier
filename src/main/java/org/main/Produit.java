package org.main;


import java.util.Objects;

/**
 * Class Produit.
 * @author rhouma
 * @version 1.0
 */
public class Produit {

    private String nom;

    private double prix;

    private int quantite;


    /**
     * Contructeur complet avec paramètre.
     * @param nom nom du produit.
     * @param prix prix du produit.
     * @param quantite quantite du produit.
     */
    public Produit(String nom, double prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Sortie de stock.
     */
    public void sortie() {
        this.quantite--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Double.compare(produit.prix, prix) == 0 &&
                quantite == produit.quantite &&
                Objects.equals(nom, produit.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prix, quantite);
    }

    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}