import java.awt.Image;
import java.awt.event.MouseEvent;

public class BlockEntity extends Projectile {

	double xvel, yvel;
	double gravity = 0.8;
	int mouseX, mouseY;
	boolean dragging = true;
	int[] Xcoords = new int[5];
	int[] Ycoords = new int[5];

	public BlockEntity(int x, int y, int width, int height, Image[] imgs,
			World world, int GAME_WIDTH, int GAME_HEIGHT) {
		super(x, y, width, height, imgs, world, GAME_WIDTH, GAME_HEIGHT);

	}

	public void findSpd(MouseEvent e) {
		x = e.getX() - width / 2;
		y = e.getY() - height / 2;

		mouseX = x;
		mouseY = y;

		for(int i = 1; i < 5; i++) {
			Xcoords[i] = Xcoords[i-1];
			Ycoords[i] = Ycoords[i-1];
		}

		Xcoords[0] = e.getX();
		Ycoords[0] = e.getY();

		xvel = (Xcoords[0] - Xcoords[4])/3;
		yvel = (Ycoords[0] - Ycoords[4])/3;
	}

	public void move() {
		if (!dragging) {
			x += xvel;
			y += yvel;
			testPlace();
			yvel += gravity;
			if (yvel > 10) {
				yvel = 10;
			}
		}
		else
		{
			dragging();
		}
		if (x + width < 0 || x > GAME_WIDTH) {
			remove();
		}
		if (y + height < 0 || y > GAME_HEIGHT) {
			remove();
		}

	}

	public void dragging() {
		if (mouseX != 0 && mouseY != 0) {
			x = mouseX;
			y = mouseY;
			testPlace();
		}
	}

	public void testPlace() {
		while (hitTestPoint(0, 0, width / 2, height / 2)) {
			x -= xvel;
			y -= yvel;
		}
		if (hitTestPoint(0, 0, width / 2, 0)) {
			place();
		}
		if (hitTestPoint(0, 0, width, height / 2)) {
			place();
		}
		if (hitTestPoint(0, 0, 0, height / 2)) {
			place();
		}
		if (hitTestPoint(0, 0, width / 2, height)) {
			place();
		}
		if (hitTestPoint(0, 0, width, 0)) {
			place();
		}
		if (hitTestPoint(0, 0, width, height)) {
			place();
		}
		if (hitTestPoint(0, 0, 0, height)) {
			place();
		}
		if (hitTestPoint(0, 0, 0, 0)) {
			place();
		}

	}

	public void place() {
		remove();
		int gridX, gridY;

		gridX = (x + (width / 2)) / 20;
		gridY = (y + (height / 2)) / 20;

		world.blocks[gridX][gridY] = new Block(gridX * 20, gridY * 20, 20, 20,
				this.getClass().getResource("images/dirt.png"));
	}

}
