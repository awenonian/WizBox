public class OldCodeStorage {

	/*
	 * import java.awt.*; import java.awt.event.*; import javax.swing.*;
	 * 
	 * public class WizBoxMain extends JApplet {
	 * 
	 * int playerx = 100; int playery = 100; int wizspdY = 0; int wizspdX = 0;
	 * int gravity = 1; String direction = "right";
	 * 
	 * 
	 * public WizBoxMain() {
	 * 
	 * add(new StagePanel());
	 * 
	 * }
	 * 
	 * public static void main(String[] args) {
	 * 
	 * JFrame frame = new JFrame("Platformer?"); WizBoxMain myApplet = new
	 * WizBoxMain(); frame.add(myApplet); myApplet.init(); myApplet.start();
	 * 
	 * frame.setSize(800, 600); frame.setLocationRelativeTo(null);
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.setVisible(true); frame.setResizable(false);
	 * 
	 * }
	 * 
	 * public class StagePanel extends JPanel {
	 * 
	 * ImageSprite img; ImageSprite img2; String dance = "Wizard32x32left.png";
	 * AnimatedSprite anim; String[] frames = new String[2]; Block block;
	 * 
	 * 
	 * public StagePanel() {
	 * 
	 * img = new ImageSprite(0, 0, this.getClass().getResource(
	 * "images/mushroom.png"));
	 * 
	 * frames[0] = "images/Wizard32x32.png"; frames[1] =
	 * "images/Wizard32x32left.png";
	 * 
	 * anim = new AnimatedSprite(400, 300, 500, true, frames); block = new
	 * Block(100, 100, img);
	 * 
	 * KeyListener keyListen = new MyKeyListener(); addKeyListener(keyListen);
	 * this.setFocusable(true); Timer time = new Timer(33, new
	 * MyTimerListener()); time.start();
	 * 
	 * }
	 * 
	 * protected void paintComponent(Graphics g) {
	 * 
	 * super.paintComponent(g);
	 * 
	 * 
	 * 
	 * img2 = new ImageSprite(400, 300, this.getClass().getResource("images/" +
	 * dance));
	 * 
	 * Image wizardleft = new ImageIcon(this.getClass().getResource(
	 * "images/Wizard32x32left.png")).getImage(); Image wizardright = new
	 * ImageIcon(this.getClass().getResource(
	 * "images/Wizard32x32.png")).getImage(); if (direction == "right") {
	 * g.drawImage(wizardright, playerx, playery, 64, 64, this); } if (direction
	 * == "left") { g.drawImage(wizardleft, playerx, playery, 64, 64, this); }
	 * g.fillRect(0, 550, 850, 50); g.fillRect(600, 520, 50, 60); anim.draw(g);
	 * 
	 * 
	 * }
	 * 
	 * public class MyKeyListener implements KeyListener {
	 * 
	 * public void keyPressed(KeyEvent e) { if (e.getKeyCode() ==
	 * KeyEvent.VK_UP) { if (rectCollision(playerx, 0, 64, 800, playery, 550,
	 * 64, 50)) { wizspdY = -15; repaint(); } } if (e.getKeyCode() ==
	 * KeyEvent.VK_DOWN) {
	 * 
	 * } if (e.getKeyCode() == KeyEvent.VK_RIGHT) { direction = "right"; if
	 * (wizspdX < 0) { wizspdX = 0; } if (wizspdX < 5) { wizspdX = 5; }
	 * repaint(); } if (e.getKeyCode() == KeyEvent.VK_LEFT) { direction =
	 * "left"; if (wizspdX > 0) { wizspdX = 0; } if (wizspdX > -5) { wizspdX =
	 * -5; } }
	 * 
	 * }
	 * 
	 * public void keyReleased(KeyEvent e) { if (e.getKeyCode() ==
	 * KeyEvent.VK_UP) {
	 * 
	 * } if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	 * 
	 * } if (e.getKeyCode() == KeyEvent.VK_RIGHT) { if (wizspdX > 0) { wizspdX =
	 * 0; } repaint(); } if (e.getKeyCode() == KeyEvent.VK_LEFT) { if (wizspdX <
	 * 0) { wizspdX = 0; } repaint(); }
	 * 
	 * }
	 * 
	 * public void keyTyped(KeyEvent e) {
	 * 
	 * }
	 * 
	 * }
	 * 
	 * private class MyTimerListener implements ActionListener {
	 * 
	 * public void actionPerformed(ActionEvent arg0) {
	 * 
	 * 
	 * if (wizspdX > 15) { wizspdX = 15; } if (wizspdX < -15) { wizspdX = -15; }
	 * if (wizspdY < -15) { wizspdY = -15; } playery += wizspdY; playerx +=
	 * wizspdX;
	 * 
	 * if (rectCollision(playerx, 0, 64, 800, playery, 550, 64, 50)) { wizspdY =
	 * 0; playery = 550 - 64; } else { if (wizspdY < 15) { wizspdY += gravity; }
	 * }
	 * 
	 * repaint();
	 * 
	 * } }
	 * 
	 * // x1 & x2= x coords of rects 1 & 2, width1 & 2= widths of rects heights
	 * // = heights etc. match 1s with first rect, 2s with second public boolean
	 * rectCollision(int x1, int x2, int width1, int width2, int y1, int y2, int
	 * height1, int height2) {
	 * 
	 * int left1, left2; int right1, right2; int top1, top2; int bottom1,
	 * bottom2;
	 * 
	 * left1 = x1; left2 = x2; right1 = x1 + width1; right2 = x2 + width2; top1
	 * = y1; top2 = y2; bottom1 = y1 + height1; bottom2 = y2 + height2;
	 * 
	 * if (bottom1 < top2) return false; if (top1 > bottom2) return false;
	 * 
	 * if (right1 < left2) return false; if (left1 > right2) return false;
	 * 
	 * return true; }
	 * 
	 * } }
	 */

}
