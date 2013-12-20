package MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import project.formes.Shape;

/* affiche la vue a laquelle sera confronté l'utilisateur.
 * Pour plus d'information cf javadoc.*/
public class WindowView extends JPanel implements Observer, MouseListener,
		ActionListener {
	private static final long serialVersionUID = 1L;

	private static Model model;
	private static Controleur controleur;
	private OutilView outilV;

	private CouleurView colorV;

	protected Coordonne coordonneDeb;
	protected Coordonne coordonneFin;
	protected static boolean estPlein;
	protected JMenuBar menuBar = new JMenuBar();
	protected JMenu menu = new JMenu("Fichier");
	protected JMenuItem save = new JMenuItem("Sauvegarde");
	protected JMenuItem open = new JMenuItem("Ouvrir");
	protected JMenuItem savePng = new JMenuItem("save png");
	protected JMenuItem vider = new JMenuItem("vider");
	protected JButton vide = new JButton(new ImageIcon("src/Image/vide.png"));
	protected JButton plein = new JButton(new ImageIcon("src/Image/plein.png"));
	protected JButton retour = new JButton(
			new ImageIcon("src/Image/retour.png"));

	public WindowView(Controleur control, Model mod, OutilView outilVie,
			CouleurView color) {
		this.setPreferredSize(new Dimension(800,800));
		this.setLayout(new BorderLayout());
		menuBar.add(menu);
		menu.add(save);
		menu.add(open);
		menu.add(savePng);
		menu.add(vider);
		colorV = color;
		model = mod;
		controleur = control;
		outilV = outilVie;
		model.addObserver(this);
		this.setVisible(true);
		JPanel panel = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

		this.setBackground(Color.white);
		monDessin zoneDessin = new monDessin(model, this);
		zoneDessin.addMouseListener(this);
		zoneDessin.setBackground(Color.white);
		p2.setLayout(new BorderLayout(2, 2));
		panel.setLayout(new BorderLayout(2, 2));
		p2.add(retour, "East");
		p2.add(vide, "Center");
		p2.add(plein, "West");
		p3.add(colorV);
		p3.add(outilV);
		panel.add(p2, "North");
		panel.add(p3, "Center");
		vide.addActionListener(this);
		plein.addActionListener(this);
		retour.addActionListener(this);
		save.addActionListener(this);
		vider.addActionListener(this);
		open.addActionListener(this);
		savePng.addActionListener(this);
		
		add(menuBar, "North");
		add(panel, "West");
		add(zoneDessin, "Center");
	}

	public static void addForme(Shape forme) {
		// TODO Auto-generated method stub
		forme.setEstPlein(estPlein);
		getModel().addToListShapeUtil(forme);
	}

	public void moveForme(Shape forme, int x, int y) {
		// TODO Auto-generated method stub
		forme.setxDeb(forme.getxDeb() + x);
		forme.setyDeb(forme.getyDeb() + y);
	}

	public void modifyForme(Shape forme) {
		// TODO Auto-generated method stub
		forme.modify();
	}

	public void deleteForme(Shape forme) {
		// TODO Auto-generated method stub
		getModel().listShapeUtil.remove(forme);
	}

	public static Model getModel() {
		return model;
	}

	public static void setModel(Model model) {
		WindowView.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		coordonneDeb = new Coordonne(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		coordonneFin = new Coordonne(e.getX(), e.getY());
		switch (outilV.getIndiceBouton()) {
		case 1:
			controleur.addLine(outilV.getIndiceBouton(), coordonneDeb,
					coordonneFin, colorV.getCouleur(), estPlein);
			break;
		case 2:
			controleur.addRect(outilV.getIndiceBouton(), coordonneDeb,
					coordonneFin, colorV.getCouleur(), estPlein);
			break;
		case 3:
			controleur.addSquare(outilV.getIndiceBouton(), coordonneDeb,
					coordonneFin, colorV.getCouleur(), estPlein);
			break;
		case 4:
			controleur.addCircle(outilV.getIndiceBouton(), coordonneDeb,
					coordonneFin, colorV.getCouleur(), estPlein);
			break;
		case 5:
			controleur.erase();
			break;
		case 6:
			controleur.select(coordonneDeb, coordonneFin);
			break;
		case 7:
			// erreur nul pointer excption
			model.modifInListShapeUtil(model.getListShapeSelect(),
					coordonneDeb, coordonneFin);
			break;
		case 8:
			// controleur.modify(shape);
			break;

		}

		coordonneFin = new Coordonne(0, 0);
		coordonneDeb = coordonneFin;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
		System.out.println("repaint");
	}

	public OutilView getOutilV() {
		return outilV;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(vide))
			estPlein = false;
		else if (e.getSource().equals(plein))
			estPlein = true;
		else if (e.getSource().equals(retour))
			model.retour();
		else if (e.getSource().equals(save)) {
			sauvegarde();
		} else if (e.getSource().equals(open)) {
			ouvrir();
			repaint();
		} else if (e.getSource().equals(vider)) {
			model.removeAllFromListShapeUtil();
			repaint();
		}
		else if (e.getSource().equals(savePng))
			savePng();
	}

	private void savePng() {
		// TODO Auto-generated method stub
		new SaveViewPng(model, controleur /*, this*/);
	}

	private void ouvrir() {
		// TODO Auto-generated method stub
		OuvrirView oV = new OuvrirView();
		if (oV.getListShape() != null)
			model.setListShapeUtil(oV.getListShape());
	}

	private void sauvegarde() {
		// TODO Auto-generated method stub
		new SauvegardeView(model);
	}
}