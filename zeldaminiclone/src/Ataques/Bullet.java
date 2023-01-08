package Ataques;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import player.Player;

public class Bullet extends Rectangle{
	
	public int dir=1;
	public int speed = 8; 
	public int frames = 0;
	
	
	public Bullet(int x, int y, int dir) {
		super(x+16,y+16,5,5);
		this.dir = dir;
		

		
	}

	public void tick() {
		x+=speed*dir;
		
		frames++;
		if(frames == 60 ) {
			Player.bullets.remove(this);
			return;
		}
	}
			
	public void render (Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}
	
}
