import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class WizBoxMain extends JApplet {
	public final int GAME_WIDTH = 960;
	public final int GAME_HEIGHT = 540;

	private StartScreen startScreen;
	private StagePanel gameMain;

	public WizBoxMain() {
		startScreen = new StartScreen();
		add(startScreen);
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("WizBox, Mage Sand Box");
		WizBoxMain myApplet = new WizBoxMain();
		frame.add(myApplet);
		myApplet.init();
		myApplet.start();

		frame.setSize(myApplet.GAME_WIDTH, myApplet.GAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setFocusable(true);
	}

	public void loadGameScreen() {
		gameMain = new StagePanel();
		remove(startScreen);
		add(gameMain);
		gameMain.requestFocusInWindow();
		invalidate();
		validate();
	}

	public class StartScreen extends JPanel {

		private ImageButton startButton;

		public StartScreen() {
			setLayout(null);
			startButton = new ImageButton(200, 100, this.getClass()
					.getResource("images/dirtEntity.png"));
			add(startButton);
			startButton.addActionListener(new ButtonActionListener());

		}

		public class ButtonActionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadGameScreen();
			}

		}

	}

	private class StagePanel extends JPanel {
		World world = new World(GAME_WIDTH, GAME_HEIGHT);

		public StagePanel() {
			MouseMotionListener mouseMotion = new MouseMotion();
			addMouseMotionListener(mouseMotion);

			MouseListener mouse = new MouseListen();
			addMouseListener(mouse);

			KeyListener keys = new KeyListen();
			addKeyListener(keys);

			Timer myTimer = new Timer(33, new TimerListen());
			myTimer.start();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			world.draw(g);
			world.drawEntities(g);

		}

		protected class TimerListen implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				world.moveEntities();
				repaint();
			}
		}

		protected class MouseListen implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				world.remove(e);
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				world.create(e);
				for (int i = 0; i < world.projectiles.size(); i++) {
					if (world.projectiles.get(i).getClass().getName() == "BlockEntity") {
						((BlockEntity) world.projectiles.get(i)).dragging = false;
					}
				}
				repaint();
			}

		}

		protected class KeyListen implements KeyListener {

			protected ArrayList<Character> keysPressed = new ArrayList<Character>();

			@Override
			public synchronized void keyPressed(KeyEvent e) {
				keysPressed.add(e.getKeyChar());
				for (int j = 0; j < keysPressed.size(); j++) {
					((Player) world.mobs.get(world.mobs.indexOf(world.wiz)))
							.control(keysPressed.get(j));
				}

			}

			@Override
			public synchronized void keyReleased(KeyEvent e) {
				keysPressed.remove(keysPressed.indexOf(e.getKeyChar()));
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		}

		protected class MouseMotion implements MouseMotionListener {

			@Override
			public void mouseDragged(MouseEvent e) {
				for (int i = 0; i < world.projectiles.size(); i++) {
					if (world.projectiles.get(i).getClass().getName() == "BlockEntity") {
						BlockEntity temp = (BlockEntity) world.projectiles
								.get(i);
						temp.findSpd(e);
					}
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {

			}

		}
	}
}
