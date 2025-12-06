package Visão;

import javax.swing.JFrame;

public class Frame extends JFrame{
	Painel painel;
	public Frame(){
		super();
		Painel painel = new Painel();
		this.setVisible(true);
		this.setSize(1200, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(painel);;
		
	}

}
