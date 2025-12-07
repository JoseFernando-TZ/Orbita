package Visão;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.Rotacao;

public class Painel extends JPanel {
	
	private JLabel lblSol;
	private JLabel lblTerra;
	private JLabel lblMercurio;
	private JLabel lblVenus;
	private JLabel lblMarte;
	private JLabel lblJupiter;
	private JLabel lblSaturno;
	private JLabel lblUrano;
	private JLabel lblNetuno;
	private Rotacao mercurio;
	private Rotacao venus;
	private Rotacao terra;
	private Rotacao marte;
	private Rotacao jupiter;
	private Rotacao saturno;
	private Rotacao urano;
	private Rotacao netuno;
	
	private int tempo = 40;
	
	private Timer timerGlobal;
	
	private ArrayList<Rotacao> planetas = new ArrayList<Rotacao>();
	
	
	
	public Painel() {
		super();
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(Color.black);
		this.setSize(1200, 700);
		add(getLblSol());
		add(getLblTerra());
		add(getLblMercurio());
		add(getLblVenus());
		add(getLblMarte());
		add(getLblJupiter());
		add(getLblSaturno());
		add(getLblUrano());
		add(getLblNetuno());
		iniciarAnim();
		iniciarTimerGlobal();
	}
	
	
	public void criaSol() {
		ImageIcon sun = new ImageIcon("IMG/Sol.png");
		Image sunRedim = sun.getImage();
		sun.setImage(sunRedim.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
		
		this.lblSol.setIcon(sun);

	}
	public void criaMercurio() {
		ImageIcon mercury = new ImageIcon("IMG/Mercurio.png");
		Image mercuryRedim = mercury.getImage();
		mercury.setImage(mercuryRedim.getScaledInstance(15, 15, Image.SCALE_SMOOTH));
		
		this.lblMercurio.setIcon(mercury);

	}
	public void criaVenus() {
		ImageIcon venus = new ImageIcon("IMG/Venus.png");
		Image venusRedim = venus.getImage();
		venus.setImage(venusRedim.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		
		this.lblVenus.setIcon(venus);

	}
	public void criaTerra() {
		ImageIcon earth = new ImageIcon("IMG/terra.png");
		Image earthRedim = earth.getImage();
		earth.setImage(earthRedim.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		
		this.lblTerra.setIcon(earth);

	}
	public void criaMarte() {
		ImageIcon mars = new ImageIcon("IMG/Marte.png");
		Image marsRedim = mars.getImage();
		mars.setImage(marsRedim.getScaledInstance(19, 19, Image.SCALE_SMOOTH));
		
		this.lblMarte.setIcon(mars);

	}
	public void criaJupiter() {
		ImageIcon jupiter = new ImageIcon("IMG/Jupiter.png");
		Image jupiterRedim = jupiter.getImage();
		jupiter.setImage(jupiterRedim.getScaledInstance(64, 64, Image.SCALE_SMOOTH));
		
		this.lblJupiter.setIcon(jupiter);

	}
	public void criaSaturno() {
		ImageIcon saturn = new ImageIcon("IMG/Saturno.png");
		Image saturnRedim = saturn.getImage();
		saturn.setImage(saturnRedim.getScaledInstance(100, 60, Image.SCALE_SMOOTH));
		
		this.lblSaturno.setIcon(saturn);

	}
	public void criaUrano() {
		ImageIcon uranus = new ImageIcon("IMG/Urano.png");
		Image uranusRedim = uranus.getImage();
		uranus.setImage(uranusRedim.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
		
		this.lblUrano.setIcon(uranus);

	}public void criaNetuno() {
		ImageIcon neptune = new ImageIcon("IMG/Netuno.png");
		Image neptuneRedim = neptune.getImage();
		neptune.setImage(neptuneRedim.getScaledInstance(55, 44, Image.SCALE_SMOOTH));
		
		this.lblNetuno.setIcon(neptune);

	}
	public JLabel getLblSol() {
		if (lblSol == null) {
			lblSol = new JLabel();
			criaSol();
			lblSol.setBounds(960, 540, 70, 70);
		}
		return lblSol;
	}
	public JLabel getLblMercurio() {
		if (lblMercurio == null) {
			lblMercurio = new JLabel();
			criaMercurio();
			lblMercurio.setBounds(400, 200, 15, 15);
		}
		return lblMercurio;
	}
	public JLabel getLblVenus() {
		if (lblVenus == null) {
			lblVenus = new JLabel();
			criaVenus();
			lblVenus.setBounds(400, 200, 30, 30);
		}
		return lblVenus;
	}
	public JLabel getLblTerra() {
		if (lblTerra == null) {
			lblTerra = new JLabel();
			criaTerra();
			lblTerra.setBounds(400, 200, 30, 30);
		}
		return lblTerra;
	}
	public JLabel getLblMarte() {
		if (lblMarte == null) {
			lblMarte = new JLabel();
			criaMarte();
			lblMarte.setBounds(400, 200, 19, 19);
		}
		return lblMarte;
	}
	public JLabel getLblJupiter() {
		if (lblJupiter == null) {
			lblJupiter = new JLabel();
			criaJupiter();
			lblJupiter.setBounds(400, 200, 64, 64);
		}
		return lblJupiter;
	}
	public JLabel getLblSaturno() {
		if (lblSaturno == null) {
			lblSaturno = new JLabel();
			criaSaturno();
			lblSaturno.setBounds(400, 200, 100, 60);
		}
		return lblSaturno;
	}
	public JLabel getLblUrano() {
		if (lblUrano == null) {
			lblUrano = new JLabel();
			criaUrano();
			lblUrano.setBounds(400, 200, 45, 45);
		}
		return lblUrano;
	}
	public JLabel getLblNetuno() {
		if (lblNetuno == null) {
			lblNetuno = new JLabel();
			criaNetuno();
			lblNetuno.setBounds(400, 200, 55, 44);
		}
		return lblNetuno;
	}
	
	public void iniciarAnim() {
		this.mercurio = new Rotacao(70, 20, 64, 353, getLblMercurio(), getLblSol(), 1);
		planetas.add(mercurio);
		this.venus = new Rotacao(130, 30, 16, 3, getLblVenus(), getLblSol(), 2);
		planetas.add(venus);
		this.terra = new Rotacao(200, 35, 8, 0, getLblTerra(), getLblSol(), 5);
		planetas.add(terra);
		this.marte = new Rotacao(250, 45, 1.2, 358.15, getLblMarte(), getLblSol(), 3);
		planetas.add(marte);
		this.jupiter = new Rotacao(350, 100, 0.9, 1.31, getLblJupiter(), getLblSol(), 1);
		planetas.add(jupiter);
		this.saturno = new Rotacao(570, 150, 0.5, 357.51, getLblSaturno(), getLblSol(), 1);
		planetas.add(saturno);
		this.urano = new Rotacao(700, 250, 0.2, 359.13, getLblUrano(), getLblSol(), 1);
		planetas.add(urano);
		this.netuno = new Rotacao(850, 350, 0.1, 1.77, getLblNetuno(), getLblSol(), 1);
		planetas.add(netuno);
		
		
	}
	public void iniciarTimerGlobal() {
        // 16ms ~= 60 Frames Por Segundo (FPS)
        timerGlobal = new Timer(20, (ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				atualizarJogo();
			}
        });
        timerGlobal.start();
    }
	private void atualizarJogo() {
        // 1. Atualiza a matemática de TODOS os planetas
        if (planetas != null) {
            for (Rotacao r : planetas) {
                r.animacao();
            }
        }
        
        // 2. Desenha a tela UMA VEZ SÓ com tudo atualizado
        repaint(); 
    }
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (planetas != null) {
            for (Rotacao r : planetas) {
                r.desenharTrajetoria(g2d);
            }
        }
    }
}

