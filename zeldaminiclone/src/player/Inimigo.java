package player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import Ataques.Bullet;
import mundo.World;
import spritesheet.Spritesheet;

public class Inimigo extends Rectangle {

	// direçoes
	public int right= 1, up = 0, down = 0, left = 0;
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;

	public static List<Bullet> bullets = new ArrayList<Bullet>();
	public boolean shoot = false;
	public int spd = 4;
	public int dir =1;

	public Inimigo(int x, int y) {
		super(x, y, 32, 32);

	}

	// logica do player
	public void tick() {
		boolean moved = false;
		// mover player lateral
		if(right == 1) {
			x++;
			
		}
		if (moved) {
			curFrames++;
			if (curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if (curAnimation == Spritesheet.inimigo_front.length) {
					curAnimation = 0;
				}
			}
		}
		if (shoot) {
			shoot = false;
			bullets.add(new Bullet(x, y, dir));
			}
		
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
	}

	// renderizaçao do player
	public void render(Graphics g) {
		// g.setColor(Color.yellow);
		// g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.player_front[curAnimation], x, y, 32, 32, null);
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}
}
