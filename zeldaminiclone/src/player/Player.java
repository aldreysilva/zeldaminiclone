package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import mundo.World;
import spritesheet.Spritesheet;

public class Player extends Rectangle {

	//direçoes
	public boolean right, up, down, left;
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	
	
	public int spd = 4;
	
	public Player(int x, int y) {
		super(x, y, 32 , 32);
		
	}
	
	//logica do player
	public void tick() {
		boolean moved = false;
		//mover player lateral 
		if(right && World.isfree(x+spd, y)) {
			x+=spd;
			moved =true;
		}else if(left && World.isfree(x-spd,y)) {
			x-=spd;
			moved =true;
		}
		//mover player pra cima e baixo 
		if(up && World.isfree(x, y-spd)) {
			y-=spd;
			moved =true;
		}else if(down && World.isfree(x, y+spd)) {
			y+=spd;
			moved =true;
		}
		if(moved) {
			curFrames ++;
			if(curFrames == targetFrames){
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.player_front.length) {
					curAnimation = 0;
				}
			}
		}
		
	}
	
	//renderizaçao do player
	public void render(Graphics g) {
		//g.setColor(Color.yellow);
	//	g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.player_front[curAnimation], x,y, 32,32 , null); 
		
	}
}
