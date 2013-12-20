package project.formes;

import java.awt.Color;
import java.io.Serializable;

public class Square extends Shape implements Serializable {

	@Override
	public String toString() {
		return "Square [xDeb=" + xDeb + ", yDeb=" + yDeb + ", xFin=" + xFin
				+ ", yFin=" + yFin + ", indice=" + indice + ", estPlein="
				+ estPlein + ", couleur=" + couleur + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Square(int xD, int yD, int xF, int yF,Color couleur, boolean estPlein) {
		// TODO Auto-generated constructor stub
		super(xD, yD, xF, yF, couleur, estPlein);
		indice = 3;
	}

	public void modify() {

	}

	@Override
	public Shape copie() {
		// TODO Auto-generated method stub
		return new Square(xDeb, yDeb, xFin, yFin, couleur, estPlein);
	}


}
