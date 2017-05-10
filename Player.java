import java.awt.*;

public class Player extends Thing {
	private String command;
	
	public Player(int x, int y, int w, int h) {
		super(x, y, w, h);
		command = super.getCommand();
	}

	public void draw(Graphics page) {
		page.setColor(Color.GREEN);
		page.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}

	public void act() {
		if (!(command.equals("stay"))) {
			if (command.equals("moveRight"))
				super.changeX(5);
			else if (command.equals("moveLeft"))
				super.changeX(-5);
		}

	}

	public void setAct(String command) {
		this.command = command;
	}

}
