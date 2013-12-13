import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class World {

	BufferedImage world;
	Block[][] blocks;
	int GAME_WIDTH, GAME_HEIGHT;
	static int maxHeight = 20;
	static int minHeight = 10;
	static int featureRarity = 6;
	Random random = new Random();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Mob> mobs = new ArrayList<Mob>();
	Image[] wizard = new Image[2];
	Player wiz;
	Image[] blockEntityImgs = { new ImageIcon(this.getClass().getResource(
			"images/dirtEntity.png")).getImage() };

	public World(int GAME_WIDTH, int GAME_HEIGHT) {

		this.GAME_WIDTH = GAME_WIDTH;
		this.GAME_HEIGHT = GAME_HEIGHT;
		wiz = new Player(0, 0, 16, 32, null, this, GAME_WIDTH, GAME_HEIGHT);
		blocks = new Block[GAME_WIDTH / 20][GAME_HEIGHT / 20];
		wizard[0] = new ImageIcon(this.getClass().getResource(
				"images/wizard/right.png")).getImage();
		wizard[1] = new ImageIcon(this.getClass().getResource(
				"images/wizard/left.png")).getImage();
		wiz.imgs = wizard;
		terrainGen();
		mobs.add(wiz);
	}

	private void terrainGen() {
		
		int[] features = new int[(int)blocks.length/featureRarity];
		for(int i = 0; i < features.length; i++) {
			features[i] = random.nextInt(maxHeight - minHeight) + minHeight;
		}
		
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				if (j > blocks[i].length - (/*cosCurve*/(maxHeight - minHeight) * (Math.cos((2 * Math.PI * ((int)blocks.length/featureRarity) * i) - 1)) + minHeight)) {
					blocks[i][j] = new Block(i * 20, j * 20, 20, 20, this
							.getClass().getResource("images/dirt.png"));
				} else {
					blocks[i][j] = null;
				}
			}
		}
		blocks[0][0] = null;
		blocks[0][1] = null;
	}

	public void draw(Graphics g) {

		world = new BufferedImage(GAME_WIDTH, GAME_HEIGHT,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = world.createGraphics();
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[0].length; j++) {
				if (blocks[i][j] != null) {
					blocks[i][j].draw(g2d);
				}
			}
		}
		g2d.dispose();
		g.drawImage(world, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
	}

	public void remove(MouseEvent e) {

		int x = e.getX() / 20;
		int y = e.getY() / 20;
		if (blocks[x][y] != null) {
			int createX = blocks[x][y].x;
			int createY = blocks[x][y].y;
			System.out.println(createX + " " + createY);
			projectiles.add(new BlockEntity(createX, createY, 15, 15,
					blockEntityImgs, this, GAME_WIDTH, GAME_HEIGHT));
			blocks[x][y] = null;

		}
	}

	public void create(MouseEvent e) {
		int x = e.getX() / 20;
		int y = e.getY() / 20;
		if (blocks[x][y] == null) {
		}
	}

	public void drawEntities(Graphics g) {
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).animDraw(g, 0);
		}
		for (int i = 0; i < mobs.size(); i++) {
			mobs.get(i).animDraw(g, 0);
		}
	}

	public void moveEntities() {
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).move();
		}
		for (int i = 0; i < mobs.size(); i++) {
			mobs.get(i).move();
		}
	}

}