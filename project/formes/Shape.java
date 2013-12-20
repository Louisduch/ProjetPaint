package project.formes;

import java.awt.Color;

import MVC.Coordonne;

public abstract class Shape {
	int xDeb = 0;
	int yDeb = 0;
	int xFin = 0;
	int yFin = 0;
	int indice = 0;
	boolean estPlein;
	Color couleur = Color.BLACK;

	public Shape(int xD, int yD, int xF, int yF, Color couleur, boolean estPlein) {
		int tmp;
		this.estPlein = estPlein;
		this.couleur = couleur;
		xDeb = xD;
		yDeb = yD;
		xFin = xF;
		yFin = yF;
		tmp = yF - yD;
		if (tmp < 0) {
			yDeb = yF;
			yFin = yD;
		}

		tmp = xF - xD;
		if (tmp < 0) {
			xDeb = xF;
			xFin = xD;
		}
	}

	public Shape(int xD, int yD, int xF, int yF, Color couleur) {
		// TODO Auto-generated constructor
		this.couleur = couleur;
		xDeb = xD;
		yDeb = yD;
		xFin = xF;
		yFin = yF;
	}

	public Shape(int xD, int yD, int xF, int yF) {
		// TODO Auto-generated constructor stub
		xDeb = xD;
		yDeb = yD;
		xFin = xF;
		yFin = yF;
	}

	@Override
	public String toString() {
		return "Shape [xDeb=" + xDeb + ", yDeb=" + yDeb + ", xFin=" + xFin
				+ ", yFin=" + yFin + ", indice=" + indice + ", estPlein="
				+ estPlein + ", couleur=" + couleur + "]";
	}

	public void move(Coordonne deb, Coordonne fin) {

		Coordonne diff = deb.soustraction(fin);
		xDeb += diff.getX();
		yDeb += diff.getY();
		xFin += diff.getX();
		yFin += diff.getY();
	}

	public abstract void modify();

	public int getxDeb() {
		return xDeb;
	}

	public void setxDeb(int xDeb) {
		this.xDeb = xDeb;
	}

	public int getyDeb() {
		return yDeb;
	}

	public void setyDeb(int yDeb) {
		this.yDeb = yDeb;
	}

	public int getxFin() {
		return xFin;
	}

	public void setxFin(int xFin) {
		this.xFin = xFin;
	}

	public int getyFin() {
		return yFin;
	}

	public void setyFin(int yFin) {
		this.yFin = yFin;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int getDiffXFinXDeb() {
		int tmp = xFin - xDeb;
		if (tmp < 0)
			return xDeb - xFin;
		return xFin - xDeb;
	}

	public int getDiffYFinYDeb() {
		int tmp = yFin - yDeb;
		if (tmp < 0)
			return yDeb - yFin;
		return yFin - yDeb;
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return couleur;
	}

	public boolean isPlein() {
		// TODO Auto-generated method stub
		return estPlein;
	}

	public void setEstPlein(boolean estPlein) {
		this.estPlein = estPlein;
	}

	public abstract Shape copie();

}
