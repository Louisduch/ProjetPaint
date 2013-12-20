package MVC;

import javax.swing.JFrame;

//import java.awt.Toolkit;
class Main {
	public static void main(String[] args) {
		Model model = new Model();
		Controleur control = new Controleur(model);
		OutilView outil = new OutilView(model, control);
		CouleurView couleurV = new CouleurView();
		WindowView maVue;
		JFrame f = new JFrame("Dessin");
		maVue = new WindowView(control, model, outil, couleurV);
		f.getContentPane().add(maVue);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.getContentPane().add(maVue);
		f.pack();

	}
}