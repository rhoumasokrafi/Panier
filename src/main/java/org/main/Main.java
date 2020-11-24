package org.main;

/**
 * Main Class.
 * @author rhouma
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        Panier panier = new Panier();

        Produit p1 = new Produit("P1",648.45,17);
        Produit p2 = new Produit("P2",648.45,17);

        // Un acheteur peut ajouter un produit dans son panier.
        panier.add(p1);
        panier.add(p2);

        // Un acheteur peut supprimer un produit dans son panier.
        System.out.println("Statut de suppression de produit : " + panier.delete(p2));

        // Un acheteur peut consulter tous les produits de son panier.
        System.out.println("Liste des produis : ");
        panier.consult();

        // Un acheteur peut consulter le montant total de son panier.
        System.out.println("Montant total du panier : " + panier.totalMontant());
    }
}
