package Modelo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Planeta {
	
	private double raioX;
	private double raioY;
	private double velocidade;
	
	
	private JLabel corpo;
	
	private int centroX;
	private int centroY;

	
	public Planeta(double raioX, double raioY, double velocidade, ImageIcon img, String nome, int raioPlaneta) {
		this.raioX = raioX;
		this.raioY = raioY;
		
		this.corpo = new JLabel(nome);
		this.corpo.setSize(raioPlaneta, raioPlaneta);
		this.corpo.setIcon(img);
	}
	
	
	public void animacao(double tempo) {
		
		double angulo = tempo * this.velocidade;
		double anguloCos = Math.cos(angulo);
		double anguloSin = Math.sin(angulo);
		
		int x = (int) (centroX + this.raioX * anguloCos);
		int y = (int) (centroY + this.raioY * anguloSin);
		
		this.corpo.setBounds(x - (corpo.getWidth() / 2), y - (corpo.getHeight() / 2), corpo.getWidth(), corpo.getHeight());
		
	}
	
	public JLabel getLabelCorpo() {
		return corpo;
	}
}
