import java.awt.Image;
import java.awt.event.MouseEvent;

public class Projectile extends Mob {

	double rotate;

	public Projectile(int x, int y, int width, int height, Image[] imgs,
			World world, int GAME_WIDTH, int GAME_HEIGHT) {
		super(x, y, width, height, imgs, world, GAME_WIDTH, GAME_HEIGHT);

	}

	public void findSpd(MouseEvent e, double spd) {
		double dy = e.getY();// - hero.y + (hero.height / 2);
		double dx = e.getX();// - hero.x + (hero.width / 2);

		double f = dy / dx;
		double ang1 = Math.atan(f);
		double side1 = spd * Math.cos(ang1);
		double side2 = side1 * f;
		xvel = side1;
		yvel = side2;
		rotate = ang1;
	}

	public void add() {
		world.projectiles.add(this);
	}

	public void remove() {
		world.projectiles.remove(this);
	}

	public void move() {
		x += xvel;
		y += yvel;
	}

}
