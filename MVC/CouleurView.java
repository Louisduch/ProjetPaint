package MVC;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class CouleurView extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color couleur = Color.black;
	ArrayList<JButton> listBouton;

	public CouleurView() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		listBouton = new ArrayList<JButton>();
		for (int i = 0; i < 13; i++) {
			listBouton.add(new JButton());
		}
		listBouton.get(0).setBackground(Color.BLACK);
		listBouton.get(0).setText("black");
		listBouton.get(1).setBackground(Color.blue);
		listBouton.get(1).setText("blue");
		listBouton.get(2).setBackground(Color.CYAN);
		listBouton.get(2).setText("Cyan");
		listBouton.get(3).setBackground(Color.DARK_GRAY);
		listBouton.get(3).setText("darkGray");
		listBouton.get(4).setBackground(Color.gray);
		listBouton.get(4).setText("gray");
		listBouton.get(5).setBackground(Color.green);
		listBouton.get(5).setText("green");
		listBouton.get(6).setBackground(Color.lightGray);
		listBouton.get(6).setText("lightGr");
		listBouton.get(7).setBackground(Color.magenta);
		listBouton.get(7).setText("magenta");
		listBouton.get(8).setBackground(Color.orange);
		listBouton.get(8).setText("orange");
		listBouton.get(9).setBackground(Color.pink);
		listBouton.get(9).setText("pink");
		listBouton.get(10).setBackground(Color.red);
		listBouton.get(10).setText("red");
		listBouton.get(11).setBackground(Color.white);
		listBouton.get(11).setText("white");
		listBouton.get(12).setBackground(Color.YELLOW);
		listBouton.get(12).setText("yellow");
		for (int i = 0; i < listBouton.size(); i++) {
			add(listBouton.get(i));
			listBouton.get(i).addActionListener(this);
		}
	}

	public Color getCouleur() {
		// TODO Auto-generated method stub
		return couleur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton tmp;
		tmp = (JButton) e.getSource();
		couleur = tmp.getBackground();
	}

}
