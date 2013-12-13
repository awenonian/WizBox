import java.awt.Image;

public class Player extends Mob {

	double gravity = 0.8;
	double friction = 0.1;

	public Player(int x, int y, int width, int height, Image[] imgs,
			World world, int GAME_WIDTH, int GAME_HEIGHT) {
		super(x, y, width, height, imgs, world, GAME_WIDTH, GAME_HEIGHT);

	}

	public void control(char key) {
		if (key == 'a') {
			xvel = -4;
		}
		if (key == 'd') {
			xvel = 4;
		}
		if (key == ' ') {
			if (hitTestPoint(0, 0, width / 2, height)) {
				yvel -= 10;
			}
		}
	}

	public void move() {
		x += Math.round(xvel);
		y += yvel;
		yvel += gravity;
		if (Math.abs(xvel) > 0) {
			xvel += -(xvel / Math.abs(xvel)) * friction;
		}

		testCollide();
	}

	public void testCollide() {
		if (hitTestPoint(0, 0, width / 2, 0)) {
			yvel = 0;
			while (hitTestPoint(0, 0, width / 2, 0)) {
				y++;
			}
		}
		if (hitTestPoint(0, 0, width, height / 2)) {
			if (xvel > 0) {
				xvel = 0;
			}
			while (hitTestPoint(0, 0, width, height / 2)) {
				x--;
			}
		}
		if (hitTestPoint(0, 0, 0, height / 2)) {
			if (xvel < 0) {
				xvel = 0;
			}
			while (hitTestPoint(0, 0, 0, height / 2)) {
				x++;
			}
		}
		if (hitTestPoint(0, 0, width / 2, height)) {
			yvel = 0;
			while (hitTestPoint(0, 0, width / 2, height)) {
				y--;
			}
			y++;
		}
		if (hitTestPoint(0, 0, width, 0)) {
			yvel = 0;
			if (xvel > 0) {
				xvel = 0;
			}

		}
		if (hitTestPoint(0, 0, width, height)) {

			yvel = 0;

		}

		if (hitTestPoint(0, 0, 0, height)) {

			yvel = 0;

		}
		if (hitTestPoint(0, 0, 0, 0)) {
			yvel = 0;
			if (xvel < 0) {
				xvel = 0;
			}
		}

	}

}
