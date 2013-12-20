package MVC;

import java.util.ArrayList;

import project.formes.Shape;

public class Historique {
	ArrayList<Shape> histo = new ArrayList<Shape>();

	public Historique(ArrayList<Shape> histo) {
		// on ne met pas directement le parametre dans notre historique
		// sinon a chaque modification tout es modifer on copie pour garder un
		// historique
		for (int i = 0; i < histo.size(); i++) {
			this.histo.add(histo.get(i).copie());
		}
	}

	public ArrayList<Shape> getHisto() {
		return histo;
	}

	public void setHisto(ArrayList<Shape> histo) {
		this.histo = histo;
	}

	@Override
	public String toString() {
		return histo + " ";
	}
}
