package MVC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

import project.formes.*;

public class Model extends Observable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Shape> listShapeSelect = new ArrayList<Shape>();
	ArrayList<Shape> listShapeUtil = new ArrayList<Shape>();
	ArrayList<Historique> historiqueUtil = new ArrayList<Historique>();

	public Model() {

	}

	public ArrayList<Shape> getListShapeSelect() {
		return listShapeSelect;
	}

	public void setListShapeSelect(ArrayList<Shape> listShapeSelect) {
		this.listShapeSelect = listShapeSelect;
		setChanged();
		notifyObservers();
	}

	public void addToListShapeSelect(Shape shape) {
		this.listShapeSelect.add(shape);
		setChanged();
		notifyObservers();
	}

	

	public void removeFromListShapeUtil(Shape tmpS) {
		// TODO Auto-generated method stub
		// Ajout dans la l'historique avant modif
		historiqueUtil.add(new Historique(listShapeUtil));
		this.listShapeUtil.remove(tmpS);
		setChanged();
		notifyObservers();
	}

	public void addToListShapeUtil(ArrayList<Shape> listShape) {
		// Ajout dans la l'historique
		historiqueUtil.add(new Historique(listShapeUtil));
		for (int i = 0; i < listShape.size(); i++)
			this.listShapeUtil.add(listShape.get(i));
		setChanged();
		notifyObservers();
	}

	public void removeFromListShapeUtil(ArrayList<Shape> listShape) {
		// Ajout dans la l'historique
		historiqueUtil.add(new Historique(listShapeUtil));
		for (int i = 0; i < listShape.size(); i++)
			this.listShapeUtil.remove(listShape.get(i));
		setChanged();
		notifyObservers();
	}

	public ArrayList<Shape> getListShapeUtil() {
		return listShapeUtil;
	}

	public void setListShapeUtil(ArrayList<Shape> listShapeUtil) {
		// Ajout dans la l'historique
		historiqueUtil = new ArrayList<Historique>();
		this.listShapeUtil = listShapeUtil;
		setChanged();
		notifyObservers();
	}

	public void addToListShapeUtil(Shape shape) {
		// TODO Auto-generated method stub
		// Ajout dans la l'historique
		
		historiqueUtil.add(new Historique(listShapeUtil));
		this.listShapeUtil.add(shape);
		setChanged();
		notifyObservers();
	}

	@Override
	public String toString() {
		return "Model [listShapePossible=" + listShapeSelect
				+ ", listShapeUtil=" + listShapeUtil + "]";
	}

	public void modifInListShapeUtil(ArrayList<Shape> arrayList, Coordonne fin,
			Coordonne deb) {
		// TODO Auto-generated method stub
		historiqueUtil.add(new Historique(listShapeUtil));
		for (int i = 0; i < arrayList.size(); i++) {
			arrayList.get(i).move(deb, fin);
		}
		setChanged();
		notifyObservers();
	}

	public void removeAllFromListShapeSelect() {
		// TODO Auto-generated method stub
		historiqueUtil.add(new Historique(listShapeUtil));
		listShapeSelect = new ArrayList<Shape>();

	}

	public void retour() {
		// TODO Auto-generated method stub
		if (historiqueUtil.size() > 0) {
			listShapeUtil = historiqueUtil.get(historiqueUtil.size() - 1)
					.getHisto();
			historiqueUtil.remove(historiqueUtil.size() - 1);
			setChanged();
			notifyObservers();
		}

	}

	public void removeAllFromListShapeUtil() {
		// TODO Auto-generated method stub
		listShapeUtil = new ArrayList<Shape>();
	}

}
