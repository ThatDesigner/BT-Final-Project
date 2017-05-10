import java.awt.*;

public class Cover extends Thing {

	private int health = 10;

	public Cover(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void draw(Graphics page) {
		page.setColor(Color.WHITE);
		page.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}

	public void act() {

	}

	public void loseHealth() {
		health--;
	}

	public int getHealth() {
		return health;
	}
}
