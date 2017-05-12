import java.awt.*;

public class Enemy extends Thing {

	private String command;
	private int row;
	private int col;

	public Enemy(int x, int y, int w, int h, int r, int c) {
		super(x, y, w, h);
		row = r;
		col = c;
		command = "right";
	}

	public void draw(Graphics page) {
		page.setColor(Color.RED);
		page.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}

	public void act() {
		System.out.println(command);
		int speed = 5;
		if (command.equals("right"))
			super.setVX(speed);
		else if (command.equals("left"))
			super.setVX(-speed);
		changeX(super.getVX());
	}

	public void setAct(String command) {
		this.command = command;
	}
	
	public int getCol(){
		return col;
	}
	public int getRow(){
		return row;
	}

	public void moveDown() {
		this.changeY(getHeight());
	}

}
