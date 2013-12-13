import java.awt.Image;

public class Mob extends AnimatedSprite {

	double xvel, yvel;
	World world;
	int GAME_WIDTH, GAME_HEIGHT;

	public Mob(int x, int y, int width, int height, Image[] imgs, World world,
			int GAME_WIDTH, int GAME_HEIGHT) {
		super(x, y, width, height, imgs);

		this.GAME_WIDTH = GAME_WIDTH;
		this.GAME_HEIGHT = GAME_HEIGHT;
		this.world = world;

	}

	public boolean hitTestObject(ImageSprite sp) {

		int left1, left2;
		int right1, right2;
		int top1, top2;
		int bottom1, bottom2;

		left1 = x;
		left2 = sp.x;
		right1 = x + width;
		right2 = sp.x + sp.width;
		top1 = y;
		top2 = sp.y;
		bottom1 = y + height;
		bottom2 = sp.y + sp.height;

		if (bottom1 < top2)
			return false;
		if (top1 > bottom2)
			return false;

		if (right1 < left2)
			return false;
		if (left1 > right2)
			return false;

		return true;

	}

	public boolean hitTestPoint(int x, int y, int pointX, int pointY) {
		boolean isHit = false;

		int globalToLocalX = this.x - x + pointX;
		int globalToLocalY = this.y - y + pointY;
		if (globalToLocalX > 0 && globalToLocalX < world.world.getWidth()) {
			if (globalToLocalY > 0 && globalToLocalY < world.world.getHeight()) {
				int color = world.world.getRGB(globalToLocalX, globalToLocalY);
				int alpha = (color >> 24) & 0xff;
				if (alpha == 0xff || alpha == 0x01) {
					isHit = true;
				}
			}
		}

		return isHit;

	}

	public void move() {
		x += xvel;
		y += yvel;
	}

	public void add() {
		world.mobs.add(this);
	}

	public void remove() {
		world.mobs.remove(this);
	}

}
