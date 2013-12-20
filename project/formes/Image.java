package project.formes;

public class Image extends Shape {
	protected Image image;
	public Image(int xD, int yD, int xF, int yF, Image img) {
		super(xD, yD, xF, yF);
		// TODO Auto-generated constructor stub
		image = img;
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shape copie() {
		// TODO Auto-generated method stub
		return new Image(xDeb, yDeb, xFin, yFin, image);
	}

}
