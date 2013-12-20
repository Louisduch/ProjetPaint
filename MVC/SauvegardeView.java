package MVC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SauvegardeView {
	private JFileChooser fileDialog;
	private File fileName, selectedFile;
	protected Model model;

	/**
	 * Fenetre pour sauvegarder le fichier, se lance quand on clique sur Ctrl+S
	 * ou bien File > Save
	 */
	public SauvegardeView(Model model) {
		this.model = model;
		if (fileDialog == null) {
			fileDialog = new JFileChooser();
		}
		if (fileName == null) {
			selectedFile = new File("Untitled.ppj");
		} else {
			selectedFile = new File(fileName.getName());
		}
		fileDialog.setSelectedFile(selectedFile);
		fileDialog.setDialogTitle("Save the file");
		int option = fileDialog.showSaveDialog(fileDialog);
		if (option != JFileChooser.APPROVE_OPTION)
			return; // Annuler ou fermeture de la fenetre.
		selectedFile = fileDialog.getSelectedFile();
		if (selectedFile.exists()) {

			int rep = JOptionPane.showConfirmDialog(fileDialog, "Le fichier \""
					+ selectedFile.getName()
					+ "\" existe dejaÊ.\nVoulez-vous le remplacez ?",
					"Remplacer", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (rep != JOptionPane.YES_OPTION)
				return; // Annuler l'enregistrement
		}
		PrintWriter out = null;
		try {
			FileWriter stream = new FileWriter(selectedFile);
			out = new PrintWriter(stream);
		} catch (Exception e) { // Echec de l'ouverture du fihier
			JOptionPane.showMessageDialog(fileDialog, this,
					"Nous sommes desole mais une erreur s'est produite.",
					option);
		}
		try {
			// entete du fichier
			out.println("PPJ file");
			out.println("Path : " + selectedFile);
			/*
			 * 
			 * Contenu du fichier >> out.println(...);
			 */
			for(int i = 0; i < model.getListShapeUtil().size(); i++){
			out.println(model.getListShapeUtil().get(i));
			}
			out.close();
			if (out.checkError())
				throw new IOException("Output error.");
			fileName = selectedFile;
			// this.setTitle("AFG : " + fileName.getName());
		} catch (Exception e) { // Echec de l'enregistrement des donnees
			JOptionPane.showMessageDialog(fileDialog, this,
					"Nous sommes desole mais une erreur s'est produite.\n" + e,
					option);
		}

	}

}
