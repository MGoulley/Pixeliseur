package pixeliseur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Dessin extends JPanel{
	private static final long serialVersionUID = -1217797064551822167L;
	private Color[][] tableau;
	
	public Dessin(int taille){
		tableau = new Color[taille][taille];
		for(int i = 0; i < tableau.length; i++){
			for(int j = 0; j < tableau[i].length; j++){
				tableau[i][j] = Color.WHITE;
			}
		}
	}
	
	public void setColor(Color couleur, int x, int y){
		x = x/(this.getHeight()/ tableau.length);
		y = y/(this.getHeight()/ tableau.length);
		tableau[x][y] = couleur;
		this.repaint();
	}
	
	public BufferedImage getImage(){
		BufferedImage buf = new BufferedImage(tableau.length, tableau[0].length, BufferedImage.TYPE_INT_RGB);
		for(int i = 0; i < tableau.length; i++){
			for(int j = 0; j < tableau[i].length; j++){
				buf.setRGB(i, j, tableau[i][j].getRGB());
			}
		}
		return buf;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int tailleCarre = this.getHeight()/(tableau.length+1);
		for(int i = 0; i < tableau.length; i++){
			for(int j = 0; j < tableau[i].length; j++){
				g.setColor(tableau[i][j]);
				g.fillRect(i*tailleCarre, j*tailleCarre, tailleCarre, tailleCarre);
			}
		}
	}
}
