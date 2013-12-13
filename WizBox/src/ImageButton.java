import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton {

	int x, y;
	int width, height;
	Image img;

	public ImageButton(int x, int y, URL url) {

		super(new ImageIcon(url));

		this.x = x;
		this.y = y;
		img = new ImageIcon(url).getImage();

		width = img.getWidth(null) * 10;
		height = img.getHeight(null) * 10;
		System.out.println(x + " " + y + " " + width + " " + height);
		setBounds(x, y, width, height);
		setBorder(null);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);

	}

}
