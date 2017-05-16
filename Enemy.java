import java.awt.*;

public class Enemy extends Thing {

	private int row;
	private int col;

	public Enemy(int x, int y, int w, int h, int r, int c) {
		super(x, y, w, h);
		row = r;
		col = c;
		setCommand("right");
	}

	public void draw(Graphics page) {
		page.setColor(Color.RED);
		page.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
		
	}

	public void act() {
		System.out.println(getCommand());
		int speed = 50;
		if (getCommand().equals("right"))
			super.setVX(speed);
		else if (getCommand().equals("left"))
			super.setVX(-speed);
		changeX(super.getVX());
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public void moveDown() {
		this.changeY(getHeight());
	}

}
