package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import mundo.World;
import player.Player;
import spritesheet.Spritesheet;

public class Game extends Canvas implements Runnable, KeyListener{

	//tamanho tela
	public static int WIDTH = 480, HEIGHT =489;
	public Player player;
	
	public World world; 
	
	public Game() {
		//adicionado  efeito de teclado. 
		this.addKeyListener(this);
		//cria a dimenção da tela 
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		new Spritesheet(); 
		player = new Player(32, 32);
		//renderiza mundo e inimigos 
		world = new World();
		
	}
	
	
	public void tick() {
		//inseri o comando no jogo. 
		player.tick();
		
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
	//	g.setColor(Color.yellow); exemplo de player retangulo 
	//	g.fillRect(10, 10, 50, 50);
		//renderizando player
		player.render(g);
		world.render(g);
		
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


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		//aciona  a tecla cima e para baixo 
		if(e.getKeyCode()  == KeyEvent.VK_RIGHT) {
			player.right = true;
		}else if(e.getKeyCode()  == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		if(e.getKeyCode()  == KeyEvent.VK_UP) {
			player.up = true;
		}else if(e.getKeyCode()  == KeyEvent.VK_DOWN) {
			player.down = true;
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		//aciona  a tecla cima e para baixo 
		if(e.getKeyCode()  == KeyEvent.VK_RIGHT) {
			player.right = false;
		}else if(e.getKeyCode()  == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		if(e.getKeyCode()  == KeyEvent.VK_UP) {
			player.up = false;
		}else if(e.getKeyCode()  == KeyEvent.VK_DOWN) {
			player.down = false;
		}
		
	}

}
