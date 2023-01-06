package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

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
		if(right) {
			x+=spd;
		}else if(left) {
			x-=spd;
		}
		//mover player pra cima e baixo 
		if(up) {
			y-=spd;
		}else if(down) {
			y+=spd;
		}
	}
	
	//renderizaçao do player
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
	}
}
