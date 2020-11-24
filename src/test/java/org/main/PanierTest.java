package org.main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PanierTest {

    /** panier est notre Panier sous tests	 */
    private Panier panier;
    private Produit p1,p2,p3,p4;

    @Before
    public void setUp(){
        panier=new Panier();
        /** p1 est un produit du panier */
        p1=new Produit("P1",648.45,17);
        p2=new Produit("P2",11525.00,3);
        p3=new Produit("P3",112.75,7);
        p4=new Produit("P4",77.00,5);
    }

    /**
     * Methode de test pour nbArticles().
     *
     */
    @Test
    public void testNb() {
        assertEquals(0, panier.nbArticles());
        panier.add(p1);
        panier.add(p3);
        assertEquals(2, panier.nbArticles());
        panier.add(p2);
        panier.add(p4);
        assertEquals(4, panier.nbArticles());
        assertEquals(16,p1.getQuantite()); //verif diminution du stock !
        assertEquals(2,p2.getQuantite());
        assertEquals(6,p3.getQuantite());
        assertEquals(4,p4.getQuantite());
    }

    /**
     * Methode de test pour add(panier.Produit).
     *
     */
    @Test
    public void testAdd() {
        assertEquals(0, panier.nbArticles());
        panier.add(p1);
        assertEquals(1, panier.nbArticles());
        assertTrue(panier.delete(p1));
        panier.add(p1);
        panier.add(p2);
        panier.add(p3);
        assertEquals(3, panier.nbArticles());
        assertTrue(panier.delete(p1));
        assertEquals(2, panier.nbArticles());
        assertTrue(panier.delete(p2));
        assertTrue(panier.delete(p3));
        assertEquals(0, panier.nbArticles());
    }

    /**
     * Methode de test pour delete(panier.Produit).
     *
     */
    @Test
    public void testDel() {
        assertEquals(0, panier.nbArticles());
        panier.add(p1);
        panier.add(p2);
        panier.add(p3);
        panier.add(p4);
        assertEquals(4, panier.nbArticles());
        assertTrue(panier.delete(p1));
        assertEquals(3, panier.nbArticles());
        assertFalse(panier.delete(p1));
        assertTrue(panier.delete(p3));
        assertEquals(2, panier.nbArticles());
        assertFalse(panier.delete(p3));
        assertTrue(panier.delete(p2));
        assertTrue(panier.delete(p4));
        assertEquals(0, panier.nbArticles());
    }

    /**
     * Methode de test pour totalMontant().
     *
     */
    @Test
    public void testtotalMontant() {
        assertEquals(0.00,panier.totalMontant(),0.001);
        panier.add(p1);
        assertEquals(648.45,panier.totalMontant(),0.001);
        panier.add(p2);
        panier.add(p3);
        panier.add(p4);
        assertEquals(12363.20,panier.totalMontant(),0.001);
        panier.delete(p1);
        panier.delete(p2);
        assertEquals(189.75,panier.totalMontant(),0.001);
    }

}