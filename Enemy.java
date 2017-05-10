import java.awt.*;

public class Enemy extends Thing {

	private String command;
	private boolean movingRight = true;
	
	public Enemy(int x, int y, int w, int h) {
		super(x, y, w, h);
		command = super.getCommand();
	}

	public void draw(Graphics page) {
		page.setColor(Color.RED);
		page.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}

	public void act() {
		move();
	}

	public void setAct(String command) {
		this.command = command;
	}
	
	public void move(){
		if(movingRight)
			super.setVX(3);
		else
			super.setVX(-3);
	}

}
