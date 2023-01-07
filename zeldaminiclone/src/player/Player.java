package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import mundo.World;

public class Player extends Rectangle {

	//direçoes
	public boolean right, up, down, left;
	
	public int spd = 4;
	
	public Player(int x, int y) {
		super(x, y, 32 , 32);
		
	}
	
	//logica do player
	public void tick() {
		
		//mover player lateral 
		if(right && World.isfree(x+spd, y)) {
			x+=spd;
		}else if(left && World.isfree(x-spd,y)) {
			x-=spd;
		}
		//mover player pra cima e baixo 
		if(up && World.isfree(x, y-spd)) {
			y-=spd;
		}else if(down && World.isfree(x, y+spd)) {
			y+=spd;
		}
	}
	
	//renderizaçao do player
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
	}
}
