import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Timer;

public class AnimatedSprite extends ImageSprite {

	int x, y;
	int width, height;
	Image[] imgs;
	Image currImg;

	public AnimatedSprite(int x, int y, int width, int height, Image[] imgs) {
		super(x, y, width, height, null);

		this.imgs = imgs;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	public void rotate(Graphics g, int tx, int ty, int x, int y, int width,
			int height, double radians) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(tx, ty);
		g2d.rotate(radians);
		g2d.drawImage(currImg, x, y, width, height, null);
		g2d.rotate(-radians);
		g2d.translate(-tx, -ty);
	}

	public void animate(int startFrame, int endFrame, int delay,
			boolean repeat, Graphics g) {
		Timer animate = new Timer(delay, new Animator());
		animate.start();
		currImg = imgs[startFrame];
		Animator.startFrame = startFrame;
		Animator.endFrame = endFrame;
		Animator.repeat = repeat;
	}

	private static class Animator implements ActionListener {

		static int startFrame;
		static int endFrame;
		static boolean repeat;
		int i = startFrame;

		public void actionPerformed(ActionEvent e) {

			if (i < endFrame) {
				i++;
			}
			if (i > endFrame && repeat) {
				i = startFrame;
			}

		}

	}

	public void animDraw(Graphics g, int frame) {

		currImg = imgs[frame];
		g.drawImage(currImg, x, y, width, height, null);

	}

}
