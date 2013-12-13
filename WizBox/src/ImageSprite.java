import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class ImageSprite {
	int x, y;
	int x0, y0;
	int width, height;
	Image img;
	int xvel, yvel;
	double gravity = 0.8;

	public ImageSprite(int x, int y, int width, int height, URL url) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		if (url != null) {
			img = new ImageIcon(url).getImage();
		}
	}

	public void draw(Graphics g) {

		g.drawImage(img, x, y, width, height, null);

	}

}
