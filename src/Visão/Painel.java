package Visão;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel extends JPanel {
	
	private JLabel lblSol;
	private JLabel lblTerra;
	
	public Painel() {
		super();
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(Color.black);
		this.setSize(1200, 700);
		add(getLblSol());
		add(getLblTerra());
	}
	
	
	public void criaSol() {
		ImageIcon sun = new ImageIcon("IMG/Sol.png");
		Image sunRedim = sun.getImage();
		sun.setImage(sunRedim.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		
		this.lblSol.setIcon(sun);

	}
	public void criaTerra() {
		ImageIcon earth = new ImageIcon("IMG/terra.png");
		Image earthRedim = earth.getImage();
		earth.setImage(earthRedim.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		
		this.lblTerra.setIcon(earth);

	}
	public JLabel getLblSol() {
		if (lblSol == null) {
			lblSol = new JLabel();
			criaSol();
			lblSol.setBounds(550, 300, 50, 50);
		}
		return lblSol;
	}
	public JLabel getLblTerra() {
		if (lblTerra == null) {
			lblTerra = new JLabel();
			criaTerra();
			lblTerra.setBounds(400, 200, 50, 50);
		}
		return lblTerra;
	}
}

