import java.awt.*;

public class Bullet extends Thing {
	private int direction;
	
	public Bullet(int x, int y, int direction) {
		super(x, y, 10, 20);
		this.direction = direction;
	}

	public void act() {
		if (direction == 90)
			super.changeY(-15);
		else
			super.changeY(15);
	}

	public void draw(Graphics page) {
		page.setColor(Color.WHITE);
		page.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}
	
}
