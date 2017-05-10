import java.awt.Graphics;

public abstract class Thing {
	private int x;
	private int y;
	private int width;
	private int height;
	private int vx;
	private int vy;
	private String command;

	public Thing() {
		x = -100;
		y = -100;
		width = 10;
		height = 10;
		command = "stay";
		vx = 0;
		vy = 0;
	}

	public Thing(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		command = "stay";
		vx = 0;
		vy = 0;
	}

	public int getVX() {
		return vx;
	}

	public int getVY() {
		return vy;
	}

	public void setVX(int changeVX) {
		vx = changeVX;
	}

	public void setVY(int changeVY) {
		vy = changeVY;
	}

	public int[] getBoundingBox() {
		return new int[] { x - width / 2, y - height / 2, x + width / 2, y + height / 2 };
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void changeX(int num) {
		this.x += num;
	}

	public void changeY(int num) {
		this.y += num;
	}

	public String getCommand() {
		return command;
	}

	public abstract void draw(Graphics page);

	public abstract void act();

}
