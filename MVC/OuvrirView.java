package MVC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import project.formes.Image;
import project.formes.Shape;

public class OuvrirView {
	private JFileChooser fileDialog;
	private File fileName, selectedFile;
	protected File file;
	private FileReader fileRead;

	public OuvrirView() {
		if (fileDialog == null) {
			fileDialog = new JFileChooser();
		}
		if (fileName == null) {
			selectedFile = new File("");
		} else {
			selectedFile = new File(fileName.getName());
		}
		fileDialog.setSelectedFile(selectedFile);
		fileDialog.setDialogTitle("Open the file");
		int option = fileDialog.showOpenDialog(fileDialog);
		if (option != JFileChooser.APPROVE_OPTION)
			return; // Annuler ou fermeture de la fenetre.
		file = fileDialog.getSelectedFile();
		// open(file);
		try {
			setFileRead(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		// FileReader stream = new FileReader(selectedFile);
	}

	public File getFile() {
		return file;
	}

	public FileReader getFileRead() {
		return fileRead;
	}
	public Image getImage(){
		
		return null;
		
	}
	public ArrayList<Shape> getListShape(){
		ArrayList<Shape> liste = new ArrayList<Shape>();
		System.out.println(file.toString());
		
		
		return liste;
	}
	public void setFileRead(FileReader fileRead) {
		this.fileRead = fileRead;
	}
}
