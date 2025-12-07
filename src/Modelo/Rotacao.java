package Modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import Visão.Painel;

public class Rotacao {
	
	private double raioX;
	private double raioY;
	private double velocidade;	
	
	private JLabel corpo;
	private JLabel sol;
	
	private int centroX = 995;
	private int centroY = 575;
	
	private double tempo;
	private Timer timer;
	private double inclinacao;
	
	private int layer;
	
	private Shape formatoOrbita;
	
	private static final double PERIODO_REAL_NETUNO = 164.79;
    private static final double META_TEMPO_NETUNO = 40.0;
    
    

	
	public Rotacao(double raioX, double raioY, double velocidade, double incinacao ,JLabel corpo, JLabel sol, int layer) {
		this.raioX = raioX;
		this.raioY = raioY;
		this.velocidade = velocidade;
		this.corpo = corpo;
		this.sol = sol;
		this.inclinacao = Math.toRadians(incinacao);
		this.layer = layer;
		double razao = this.velocidade / PERIODO_REAL_NETUNO;
		this.tempo = razao * META_TEMPO_NETUNO;
		calcularTrajetoriaFixa();
	}
	
	public void animacao() {
		 
					this.tempo +=0.05;
	
	            	double angulo = this.tempo * this.velocidade;
	            	double anguloCos = Math.cos(angulo);
	            	double anguloSin = Math.sin(angulo);
		
	            	double x = this.raioX * anguloCos;
	            	double y = this.raioY * anguloSin;
	            	
	            	double incX = x * Math.cos(inclinacao) - y * Math.sin(inclinacao);
	            	double incY = x * Math.sin(inclinacao) + y * Math.cos(inclinacao);
	            	
	            	int finalX = (int) (centroX + incX);
	            	int finalY = (int) (centroY + incY);
	            	
	            	this.corpo.setBounds(finalX - (corpo.getWidth() / 2), finalY - (corpo.getHeight() / 2), corpo.getWidth(), corpo.getHeight());
	            	
	            	Container parent = corpo.getParent();
	        		if (parent != null) {
	        			parent.repaint();
	        			// Se o Seno é positivo (> 0), o planeta está na metade de baixo da tela (Visualmente perto)
	        			if (anguloSin > 0) {
	        				// Terra na frente (Z-Order 0)
	        				parent.setComponentZOrder(corpo, 0);
	        				parent.setComponentZOrder(sol, 5);
	        			} 
	        			// Se o Seno é negativo (< 0), o planeta está na metade de cima (Visualmente longe/atrás)
	        			else {
	        				// Sol na frente (Z-Order 0)
	        				parent.setComponentZOrder(sol, 0);
	        				parent.setComponentZOrder(corpo, layer);
	        			}
	        		}
	        		

	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	public void calcularTrajetoriaFixa() {
	    GeneralPath path = new GeneralPath();
	    boolean primeiroPonto = true;

	    // Loop de 0 a 360
	    for (int i = 0; i <= 360; i += 2) {
	        double anguloRad = Math.toRadians(i);

	        // Matemática da posição (igual a antes)
	        double xBase = this.raioX * Math.cos(anguloRad);
	        double yBase = this.raioY * Math.sin(anguloRad);

	        // Rotação da inclinação
	        double xRot = xBase * Math.cos(inclinacao) - yBase * Math.sin(inclinacao);
	        double yRot = xBase * Math.sin(inclinacao) + yBase * Math.cos(inclinacao);

	        double xFinal = centroX + xRot;
	        double yFinal = centroY + yRot;

	        if (primeiroPonto) {
	            path.moveTo(xFinal, yFinal); // Começa o desenho
	            primeiroPonto = false;
	        } else {
	            path.lineTo(xFinal, yFinal); // Liga os pontos
	        }
	    }
	    path.closePath(); // Fecha o círculo
	    this.formatoOrbita = path; // Salva na memória
	}
	public void desenharTrajetoria(Graphics2D g2d) {
	    if (this.formatoOrbita == null) return;

	    Color corOriginal = g2d.getColor();
	    g2d.setColor(new Color(255, 255, 255, 250)); 
	    g2d.setStroke(new BasicStroke(1));

	    //Apenas uma linha de código agora
	    g2d.draw(this.formatoOrbita); 

	    g2d.setColor(corOriginal);
	}
}
