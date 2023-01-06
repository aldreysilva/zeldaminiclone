package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	//tamanho tela
	public static int WIDTH = 480, HEIGHT =489;
	
	public Game() {
		//cria a dimenção da tela 
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
	}
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		//titulo da tela
		frame.setTitle("Mini Zelda");
		//centraliza a tela
		frame.setLocationRelativeTo(null);
		//calcula o tamanho correto da janela
		frame.pack();
		
		//fecha a janela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//visualizar a janela
		frame.setVisible(true);
		
	}

	@Override
	public void run() {
		
		

	}

}
