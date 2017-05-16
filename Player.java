import java.awt.*;

public class Player extends Thing {

	private boolean left = false;
	private boolean right = false;
	
	public Player(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void draw(Graphics page) {
		page.setColor(Color.GREEN);
		page.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}

	public void act() {
		System.out.println("X = " + super.getX());
		
		if (right && super.getX() < Driver.WIDTH - super.getWidth()) {
			super.setVX(5);
			super.changeX(super.getVX());
		} else if (left && super.getX() > 0) {
			super.setVX(-5);
			super.changeX(super.getVX());
		} else {
			super.setVX(0);
		}
			

	}

	// takes in a boolean
	// returns nothing
	public void moveRight(boolean value) {
		this.right = value;
	}

	// takes in a boolean
	// returns nothing
	public void moveLeft(boolean value) {
		this.left = value;
	}

}
