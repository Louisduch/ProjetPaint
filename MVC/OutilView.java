package MVC;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OutilView extends JPanel implements Observer, ActionListener {
	private Model model;
	private Controleur control;
	/**
	 * 
	 */
	protected ArrayList<JButton> listButton = new ArrayList<JButton>();
	protected int indiceBouton = 1;
	private static final long serialVersionUID = 1L;

	public OutilView(Model mod, Controleur control) {
		this.control = control;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		model = mod;
		model.addObserver(this);
		this.setVisible(true);
		JPanel dessin = new JPanel();
		dessin.setBackground(Color.white);
		BoxLayout bl = new BoxLayout(dessin, BoxLayout.Y_AXIS);
		dessin.setLayout(bl);
		add(dessin);
		initListButton(listButton);
		for (int i = 0; i < listButton.size(); i++) {
			dessin.add(listButton.get(i));
			listButton.get(i).addActionListener(this);
		}
	}

	private void initListButton(ArrayList<JButton> listB) {
		// TODO Auto-generated method stub
		listB.add(new JButton(new ImageIcon("src/Image/line.png")));
		listB.add(new JButton(new ImageIcon("src/Image/rect.png")));
		listB.add(new JButton(new ImageIcon("src/Image/square.png")));
		listB.add(new JButton(new ImageIcon("src/Image/circle.png")));
		listB.add(new JButton(new ImageIcon("src/Image/erase.png")));
		listB.add(new JButton(new ImageIcon("src/Image/select.png")));
		listB.add(new JButton(new ImageIcon("src/Image/move.png")));
		listB.add(new JButton(new ImageIcon("src/Image/modif.png")));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		indiceBouton = 0;
		for (int i = 0; i < listButton.size(); i++) {
			if (e.getSource().equals(listButton.get(i))){
				indiceBouton = i+1;
			}
		}
	}

	public int getIndiceBouton() {
		return indiceBouton;
	}

	public void setIndiceBouton(int indiceBouton) {
		this.indiceBouton = indiceBouton;
	}

	@Override
	public void update(Observable obs, Object obj) {
		// TODO Auto-generated method stub
		control.setIndiceButton(indiceBouton);
	}

}
