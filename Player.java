import java.awt.*;

public class Player extends Thing {
	
	private String command;

	private boolean left, right;
	
	public Player(int x, int y, int w, int h) {
		super(x, y, w, h);
		command = super.getCommand();
	}

	public void draw(Graphics page) {
		page.setColor(Color.GREEN);
		page.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}

	public void act() {
		System.out.println("X = " + super.getX());
		
			if (command.equals("moveRight")&& super.getX() < Driver.WIDTH - super.getWidth()) {
				super.setVX(5);
				super.changeX(super.getVX());
			} else if (command.equals("moveLeft")&& super.getX() > 0) {
				super.setVX(-5);
				super.changeX(super.getVX());
			} else if (command.equals("stay")) {
				super.setVX(0);
			}
			

	}

	public void setAct(String command) {
		this.command = command;
	}

}
