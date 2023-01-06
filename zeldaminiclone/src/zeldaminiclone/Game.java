package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	//tamanho tela
	public static int WIDTH = 480, HEIGHT =489;
	
	public Game() {
		//cria a dimenção da tela 
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
	}
	
	
	public void tick() {
		
	}
	
	public void render() {
		//começo render automatico 
		BufferStrategy bs = this.getBufferStrategy();
			if(bs == null) {
				this.createBufferStrategy(3);
				return;
			}
		Graphics g = bs.getDrawGraphics();
		
		
		//fundo
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//redanculo
		g.setColor(Color.yellow);
		g.fillRect(10, 10, 50, 50);
		
		
		bs.show();
		//fim render automatico 
	}
	
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		//titulo da tela
		frame.setTitle("Mini Zelda");
		
		//calcula o tamanho correto da janela
		frame.pack();
		
		//centraliza a tela
		frame.setLocationRelativeTo(null);
		
		//fecha a janela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//visualizar a janela
		frame.setVisible(true);
		
		
		new  Thread(game).start(); //começar o jogo 
		
	}

	
	@Override
	public void run() {
		
		while(true) {
			tick();
			render();
			try {
				Thread.sleep((1000/60));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}

}
