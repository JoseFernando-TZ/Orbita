package Visão;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel extends JPanel {
	
	JLabel sol = new JLabel();
	
	public Painel() {
		// TODO Auto-generated constructor stub
	}
	
	public void criaSol() {
		ImageIcon sun = new ImageIcon("IMG/Sol.png");
		Image sunRedim = sun.getImage();
		sun.setImage(sunRedim.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));
		
		this.sol.setIcon(sun);
	}

}
