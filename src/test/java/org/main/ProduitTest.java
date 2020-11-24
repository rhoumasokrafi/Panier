package org.main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ProduitTest {

    Produit p1,p2;

    /**
     * Création de deux produits de tests p1 et p2...
     */

    @Before
    public void setUp(){
        // Création de deux produits de tests p1 et p2
        p1=new Produit("P1",648.45,17);
        p2=new Produit("P2",11525.00,3);
    }

    /**
     * test de la gestion du nom.
     */
    @Test
    public void testNom() {
        assertEquals("P1", p1.getNom());
        assertEquals("P2", p2.getNom());
        p1.setNom("P1 modifié");
        p2.setNom("P2 modifié");
        assertEquals("P1 modifié", p1.getNom());
        assertEquals("P2 modifié", p2.getNom());

    }

    /**
     * Test de la gestion des prix.
     */
    @Test
    public void testPrix() {
        assertEquals(648.45, p1.getPrix(), 0.001);
        assertEquals(11525.00, p2.getPrix(), 0.001);
        p1.setPrix(635.15);
        p2.setPrix(11500.00);
        assertEquals(635.15, p1.getPrix(), 0.001);
        assertEquals(11500.00, p2.getPrix(), 0.001);

    }

    /**
     * Test de la gestion des quantités de produits.
     */
    @Test
    public void testQuantite() {
        assertEquals(17,p1.getQuantite());
        assertEquals(3,p2.getQuantite());
        p1.setQuantite(12);
        p2.setQuantite(5);
        assertEquals(12,p1.getQuantite());
        assertEquals(5,p2.getQuantite());

    }

    /**
     * test de la gestion des quantités, sans gestion du stock zéro pour le moment.
     */
    @Test
    public void testSortie() {
        p1.sortie();
        p1.sortie();
        p1.sortie();
        p2.sortie();
        assertEquals(14,p1.getQuantite());
        assertEquals(2,p2.getQuantite());
        p1.sortie();
        p2.sortie();
        assertEquals(13,p1.getQuantite());
        assertEquals(1,p2.getQuantite());

    }
}