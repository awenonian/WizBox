import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Wizard {

	Image right;
	Image left;
	String pics;
	int x, y;
	int width, height;
	int xvel, yvel;
	int gravity = 1;
	String direction = "right";
	boolean mouseClicked = false;

	public Wizard(int x, int y, int width, int height, String pics) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		right = new ImageIcon(this.getClass().getResource(pics + "right.png"))
				.getImage();
		left = new ImageIcon(this.getClass().getResource(pics + "left.png"))
				.getImage();

	}

	public void changeVel(String key) {

		if (key == "pa") {
			direction = "left";
			if (xvel >= 0) {
				xvel -= 3;
			}
			if (xvel > -5) {
				xvel -= 1;
			}
		} else {
			if (xvel < 0) {
				xvel += 1;
			}
		}

		if (key == "pd") {
			direction = "right";
			if (xvel <= 0) {
				xvel += 3;
			}
			if (xvel < 5) {
				xvel += 1;
			}
		} else {
			if (xvel > 0) {
				xvel -= 1;
			}
		}

		if (key == "pspace") {
			yvel = -15;
		}

	}

	public void move() {
		y += yvel;
		x += xvel;
		yvel += gravity;
	}

	public void draw(Graphics g) {
		if (direction == "right") {
			g.drawImage(right, x, y, width, height, null);
		}
		if (direction == "left") {
			g.drawImage(left, x, y, width, height, null);
		}
	}

}
