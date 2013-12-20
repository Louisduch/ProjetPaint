package project.formes;

import java.awt.Color;
import java.io.Serializable;

public class Rectangle extends Shape implements Serializable {

	@Override
	public String toString() {
		return "Rectangle [xDeb=" + xDeb + ", yDeb=" + yDeb + ", xFin=" + xFin
				+ ", yFin=" + yFin + ", indice=" + indice + ", estPlein="
				+ estPlein + ", couleur=" + couleur + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rectangle(int xD, int yD, int xF, int yF, Color couleur,
			boolean estPlein) {
		super(xD, yD, xF, yF, couleur, estPlein);
		indice = 2;
	}

	public void modify() {

	}

	@Override
	public Shape copie() {
		// TODO Auto-generated method stub
		return new Rectangle(xDeb, yDeb, xFin, yFin, couleur, estPlein);
		}

}
