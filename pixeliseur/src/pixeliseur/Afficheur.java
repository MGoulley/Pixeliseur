package pixeliseur;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Afficheur extends JPanel{
	private Color couleur;
	
	public Afficheur(){
		this.couleur = Color.white;
		this.setForeground(Color.white);
	}
	
	public void setColor(Color couleur){
		this.couleur = couleur;
		this.repaint();
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(couleur);
    }
}
