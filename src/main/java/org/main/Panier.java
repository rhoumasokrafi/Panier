package org.main;

import java.util.ArrayList;
import java.util.List;

/**
 * La Class qui gére les produits.
 * On pourra stocker des produits dans notre panier, retirer, lister, calculer le montant.
 * @author rhouma
 * @version 1.0
 */
public class Panier {
    /**
     * La liste contenant les produits
     */
    private List<Produit> panier;

    /**
     * Constructeur, qui affecte une ArrayList de Produit.
     */
    public Panier() {
        panier = new ArrayList<>();
    }

    /**
     * Méthode d'ajout d'un produit
     *
     * @param produit le produit à ajouter.
     */
    public void add(Produit produit) {
        panier.add(produit);
        produit.sortie();
    }

    /**
     * pour ressortir un produit du panier.
     *
     * @param produit produit à supprimer du panier.
     * @return True si c'est ok , sinon False
     */
    public boolean delete(Produit produit) {
        if (panier.remove(produit)) {
            produit.setQuantite(produit.getQuantite() + 1); //on remet en stock
            return true;
        } else
            return false;
    }

    /**
     * pour calculer le nombre d'articles dans le panier.
     *
     * @return nombre des articles.
     */
    public int nbArticles() {
        return panier.size();
    }

    /**
     * pour consulter la liste des produits dans le panier.
     */
    public void consult(){
        panier.stream().forEach(System.out::println);
    }

    /**
     * On calcule le total du panier
     *
     * @return la montant total du panier.
     */
    public double totalMontant() {
        return panier.stream().mapToDouble(Produit::getPrix).sum();
    }

}
