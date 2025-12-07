package Visão;

import javax.swing.JFrame;

public class Frame extends JFrame{
	Painel painel;
	public Frame(){
		super();
		Painel painel = new Painel();
		this.setVisible(true);
		this.setSize(1920, 1080);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().add(painel);;
		
	}

}
