package MVC;

public class Coordonne {
	int x;
	int y;

	public Coordonne(int a, int b) {
		x = a;
		y = b;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}

	public Coordonne soustraction(Coordonne fin) {
		// TODO Auto-generated method stub
		return new Coordonne(x - fin.x, y - fin.y);
	}
	
}
