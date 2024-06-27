package models;

import application.Fenetre;

import java.awt.*;
import java.util.List;

public class Balle extends Sprite{

    protected int vitesseX = 10;
    protected int vitesseY = 10;
    protected int diametre = 50;

    public Balle(int x, int y, Color couleur, int diametre) {
        super(x, y , couleur);
        this.diametre = diametre;
    }

    public Balle(int x, int y, int vitesseX, int vitesseY) {
        super(x,y,Color.RED);
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
    }

    public Balle(int x, int y) {
        super(x,y,Color.RED);
        this.vitesseX = 5;
        this.vitesseY = 5;
    }

    public boolean deplacement(Barre barre, List<Brique> briques) {

        if(x > Fenetre.LARGEUR - diametre || x < 0) {
            vitesseX = - vitesseX;
        }

        /*ici*/
        if(y<0){
            vitesseY = -vitesseY;
        }

        if(y > Fenetre.HAUTEUR - diametre) {
            return true;
        }

        /*et là*/
        if (y + diametre >= barre.getY() && y <= barre.getY() + barre.getHauteur()&&
            x + diametre >= barre.getX() && x <= barre.getX() + barre.getLargeur()) {
            vitesseY = -vitesseY;
            y = barre.getY() - diametre;
        }

        /*collision avec les briques*/
        for (int i = 0; i < briques.size(); i++) {
            Brique brique = briques.get(i);
            if (this.collidesWith(brique)) {
                briques.remove(i); // Remove the brick
                vitesseY = -vitesseY;
                break;
            }
        }

        x += vitesseX;
        y += vitesseY;

        return false;
    }

    private boolean collidesWith(Brique brique) {
        // collisions avec les briques
        return x + diametre >= brique.getX() && x <= brique.getX() + brique.getLargeur() &&
                y + diametre >= brique.getY() && y <= brique.getY() + brique.getHauteur();
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y,diametre,diametre);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(int vitesseX) {
        this.vitesseX = vitesseX;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }

    /* et  encore là*/
    public int getDiametre() {
        return diametre;
    }
    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }
}
