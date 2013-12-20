package project.formes;

import java.awt.Color;
import java.io.Serializable;

public class Line extends Shape implements Serializable {

	@Override
	public String toString() {
		return "Line [xDeb=" + xDeb + ", yDeb=" + yDeb + ", xFin=" + xFin
				+ ", yFin=" + yFin + ", indice=" + indice + ", estPlein="
				+ estPlein + ", couleur=" + couleur + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	

	public Line(int xD, int yD, int xF, int yF, Color couleur,
			boolean estPlein) {
		super(xD, yD, xF, yF, couleur);
		indice = 4;
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub
	}

	@Override
	public Shape copie() {
		// TODO Auto-generated method stub
		return new Line(xDeb, yDeb, xFin, yFin, couleur, true);
	}

}
