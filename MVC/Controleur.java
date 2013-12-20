package MVC;

import java.awt.Color;

import javax.swing.JComboBox;

import project.formes.*;

public class Controleur {
	private Model model;
	private int indiceBoutton = 0;

	public Controleur(Model model) {
		this.model = model;
	}

	public Model getMod() {
		return model;
	}

	public void setMod(Model mod) {
		this.model = mod;
	}

	public void addLine(int indiceBouton, Coordonne coordonneDeb,
			Coordonne coordonneFin, Color couleur, boolean estPlein) {
		// TODO Auto-generated method stub
		model.addToListShapeUtil(new Line(coordonneDeb.getX(), coordonneDeb
				.getY(), coordonneFin.getX(), coordonneFin.getY(), couleur,
				true));
	}

	public void addRect(int indiceBouton, Coordonne coordonneDeb,
			Coordonne coordonneFin, Color couleur, boolean estPlein) {
		model.addToListShapeUtil(new Rectangle(coordonneDeb.getX(),
				coordonneDeb.getY(), coordonneFin.getX(), coordonneFin.getY(),
				couleur, estPlein));
	}

	public void addSquare(int indiceBouton, Coordonne coordonneDeb,
			Coordonne coordonneFin, Color couleur, boolean estPlein) {
		model.addToListShapeUtil(new Square(coordonneDeb.getX(), coordonneDeb
				.getY(), coordonneFin.getX(), coordonneFin.getY(), couleur,
				estPlein));
	}

	public void addCircle(int indiceBouton, Coordonne coordonneDeb,
			Coordonne coordonneFin, Color couleur, boolean estPlein) {
		model.addToListShapeUtil(new Circle(coordonneDeb.getX(), coordonneDeb
				.getY(), coordonneFin.getX(), coordonneFin.getY(), couleur,
				estPlein));
	}

	public void miseAJourBox(JComboBox boxForme) {
		// TODO Auto-generated method stub
		Shape tmp;
		boxForme.removeAllItems();
		for (int i = 0; i < model.getListShapeUtil().size(); i++) {
			tmp = model.getListShapeUtil().get(i);
			boxForme.addItem(tmp);
		}
	}

	public void erase() {
		// TODO Auto-generated method stub
		for (int i = 0; i < model.getListShapeSelect().size(); i++) {
			Shape tmp = model.getListShapeSelect().get(i);
			model.removeFromListShapeUtil(tmp);
		}
	}

	public void select(Coordonne coordonneDeb, Coordonne coordonneFin) {
		// TODO Auto-generated method stub
		model.removeAllFromListShapeSelect();
		int xD, xF, yD, yF, itmp;
		xD = coordonneDeb.getX();
		xF = coordonneFin.getX();
		yD = coordonneDeb.getY();
		yF = coordonneFin.getY();
		itmp = yF - yD;
		if (itmp < 0) {
			coordonneDeb.setY(yF);
			coordonneFin.setY(yD);
		}

		itmp = xF - xD;
		if (itmp < 0) {
			coordonneDeb.setX(xF);
			coordonneFin.setX(xD);
		}
		for (int i = 0; i < model.getListShapeUtil().size(); i++) {
			Shape tmp = model.getListShapeUtil().get(i);
			int xdebut = coordonneDeb.x;
			int xfin = coordonneFin.x;
			int ydebut = coordonneDeb.y;
			int yfin = coordonneFin.y;
			if (xdebut < tmp.getxDeb() && ydebut < tmp.getyDeb()
					&& xfin > tmp.getxFin() && yfin > tmp.getyFin()) {
				model.addToListShapeSelect(tmp);
			}
		}
	}

	public void modify(Shape shape) {
		// TODO Auto-generated method stub

	}

	public void setIndiceButton(int indiceBouton) {
		// TODO Auto-generated method stub
		setIndiceBoutton(indiceBouton);
	}

	public int getIndiceBoutton() {
		return indiceBoutton;
	}

	public void setIndiceBoutton(int indiceBoutton) {
		this.indiceBoutton = indiceBoutton;
	}
}
