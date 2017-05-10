import java.awt.*;

public class Bullet extends Thing {
	private int direction;
	
	public Bullet(int x, int y, int direction) {
		super(x, y, 20, 10);
		this.direction = direction;
	}

	public void act() {
		if (direction == 90)
			super.changeY(-5);
		else
			super.changeY(5);
	}

	public void draw(Graphics page) {
		page.setColor(Color.WHITE);
		page.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}
	
}
