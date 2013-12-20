package MVC;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SaveViewPng extends JFrame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Model model;
	private Controleur control;
	private JFileChooser fileDialog;
	//private WindowView winVue;
	public SaveViewPng(Model mod, Controleur cont/*, WindowView winVue*/) {
		setModel(mod);
		setControl(cont);
		mod.addObserver(this);
		//this.winVue = winVue;
		doSaveImage();
	}

	private void doSaveImage() {
		if (fileDialog == null)
			fileDialog = new JFileChooser();
		fileDialog.setSelectedFile(new File("sketch.png"));
		fileDialog.setDialogTitle("Select File to be Saved");
		int option = fileDialog.showSaveDialog(this);
		if (option != JFileChooser.APPROVE_OPTION)
			return; // User canceled or clicked the dialog's close box.
		File selectedFile = fileDialog.getSelectedFile();
		if (selectedFile.exists()) { // Ask the user whether to replace the
										// file.
			int response = JOptionPane.showConfirmDialog(this, "The file \""
					+ selectedFile.getName()
					+ "\" already exists.\nDo you want to replace it?",
					"Confirm Save", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (response != JOptionPane.YES_OPTION)
				return; // User does not want to replace the file.
		}
		try {
			BufferedImage image; // A copy of the sketch will be drawn here.
			image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics(); // For drawing onto the image.
			paintComponents(g);
			g.dispose();
			boolean hasPNG = ImageIO.write(image, "PNG", selectedFile);
			if (!hasPNG)
				throw new Exception("PNG format not available.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Sorry, but an error occurred while trying to write the image:\n"
							+ e);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Controleur getControl() {
		return control;
	}

	public void setControl(Controleur control) {
		this.control = control;
	}

}
