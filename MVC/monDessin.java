package MVC;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import project.formes.Shape;

public class monDessin extends JPanel implements KeyListener {
	protected Model model;
	protected WindowView windowView;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public monDessin(Model m, WindowView view) {
		model = m;
		windowView = view;
		addKeyListener(this);
		this.setPreferredSize(windowView.getSize());
	}

	public void paint(Graphics g) {
		this.setPreferredSize(windowView.getSize());
		Shape tmp;
		g.drawRect(0, 0, windowView.getWidth() - 1, windowView.getHeight() - 1);

		for (int i = 0; i < model.getListShapeUtil().size(); i++) {
			tmp = model.getListShapeUtil().get(i);

			switch (tmp.getIndice()) {
			case 1:
				g.setColor(tmp.getColor());
				if (tmp.isPlein())
					g.fillOval(tmp.getxDeb(), tmp.getyDeb(),
							tmp.getDiffXFinXDeb(), tmp.getDiffYFinYDeb());
				else
					g.drawOval(tmp.getxDeb(), tmp.getyDeb(),
							tmp.getDiffXFinXDeb(), tmp.getDiffYFinYDeb());
				break;
			case 2:
				g.setColor(tmp.getColor());
				if (tmp.isPlein())
					g.fillRect(tmp.getxDeb(), tmp.getyDeb(),
							tmp.getDiffXFinXDeb(), tmp.getDiffYFinYDeb());
				else
					g.drawRect(tmp.getxDeb(), tmp.getyDeb(),
							tmp.getDiffXFinXDeb(), tmp.getDiffYFinYDeb());
				break;
			case 3:
				g.setColor(tmp.getColor());
				if (tmp.isPlein())
					g.fillRect(tmp.getxDeb(), tmp.getyDeb(),
							tmp.getDiffXFinXDeb(), tmp.getDiffXFinXDeb());
				else
					g.drawRect(tmp.getxDeb(), tmp.getyDeb(),
							tmp.getDiffXFinXDeb(), tmp.getDiffXFinXDeb());
				break;
			case 4:
				g.setColor(tmp.getColor());
				g.drawLine(tmp.getxDeb(), tmp.getyDeb(), tmp.getxFin(),
						tmp.getyFin());
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key "+e.getSource());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key "+e.getSource());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key "+e.getSource());
	}
}
