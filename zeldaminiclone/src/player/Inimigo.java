package player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Ataques.Bullet;
import mundo.World;
import spritesheet.Spritesheet;
import zeldaminiclone.Game;

public class Inimigo extends Rectangle {

	// direçoes
	public int right = 1, up = 0, down = 0, left = 0;
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;

	public static List<Bullet> bullets = new ArrayList<Bullet>();
	public boolean shoot = false;
	public int spd = 2;
	public int dir = 1;

	public Inimigo(int x, int y) {
		super(x, y, 32, 32);

	}

	public void perseguirPlayer() {
		Player p = Game.player;
		if (x < p.x && World.isfree(x + spd, y)) {
			if (new Random().nextInt(100) < 70) {
				x += spd;
			}
		} else if (x > p.x && World.isfree(x - spd, y)) {
			if (new Random().nextInt(100) < 70) {
				x -= spd;
			}
		}
		if (x < p.y && World.isfree(x, y + spd)) {
			if (new Random().nextInt(100) < 70) {
				y += spd;
			}
		} else if (y > p.y && World.isfree(x, y - spd)) {
			if (new Random().nextInt(100) < 70) {
				y -= spd;
			}
		}
	}

	// logica do player
	public void tick() {
		boolean moved = false;

		perseguirPlayer();

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
