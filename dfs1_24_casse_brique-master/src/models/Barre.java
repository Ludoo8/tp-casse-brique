package models;

import application.Fenetre;

import java.awt.*;

public class Barre extends Sprite{

    protected int largeur;
    protected int hauteur;
    private static final int DEPLACEMENT = 10;

    public Barre(int x, int y, int largeur, int hauteur, Color couleur) {
        super(x, y, couleur);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public Barre() {
        super(Fenetre.LARGEUR / 2 - 75, Fenetre.HAUTEUR - 100, Color.RED);
        this.largeur = 150;
        this.hauteur = 20;
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(x,y,largeur,hauteur);
    }

    public void deplacerGauche() {
        x = Math.max(0, x - DEPLACEMENT); // gauche
    }

    public void deplacerDroite() {
        x = Math.min(Fenetre.LARGEUR - largeur, x + DEPLACEMENT); // droite
    }

    /*getset*/

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }
}
