package pixeliseur;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.Panel;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fenetre extends JFrame implements MouseListener{
	private Color couleur;
	private int taille;
	private Dessin canvas;
	
	
	public Fenetre(int taille){
		this.taille = taille;
		this.setTitle("Pixeliseur");
		this.setSize(800, 700);
		this.couleur = Color.WHITE;
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmSauvegarder = new JMenuItem("Sauvegarder");
		mnFichier.add(mntmSauvegarder);
		
		JMenuItem mntmImporter = new JMenuItem("Importer");
		mnFichier.add(mntmImporter);
		
		JMenuItem mntmExporter = new JMenuItem("Exporter");
		mntmExporter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("BBBBBBBBBBBBBBBBBBB");
				BufferedImage buf = canvas.getImage();
				JFileChooser chooser = new JFileChooser();
				int retour = chooser.showSaveDialog(null);
				if(retour == JFileChooser.APPROVE_OPTION){
					File outputfile = new File(chooser.getSelectedFile().getAbsolutePath());
					try {
						ImageIO.write(buf, "png", outputfile);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		mnFichier.add(mntmExporter);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnFichier.add(mntmQuitter);
		
		JMenu mnEditer = new JMenu("Editer");
		menuBar.add(mnEditer);
		
		JMenuItem mntmFiltres = new JMenuItem("Filtres");
		mnEditer.add(mntmFiltres);
		
		JMenu mnPrfrences = new JMenu("Pr\u00E9f\u00E9rences");
		menuBar.add(mnPrfrences);
		
		JMenuItem mntmAide = new JMenuItem("Aide");
		mnPrfrences.add(mntmAide);
		getContentPane().setLayout(null);
		
		canvas = new Dessin(taille);
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				canvas.setColor(couleur, e.getX(), e.getY());
			}
		});
		canvas.setBounds(10, 118, 512, 512);
		getContentPane().add(canvas);
		
		
		Afficheur panel = new Afficheur();
		panel.setBounds(532, 201, 242, 72);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Choisir Couleur");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				couleur = JColorChooser.showDialog(null, "Choisir une couleur", Color.WHITE);
				panel.setColor(couleur);
			}
		});
		btnNewButton.setBounds(528, 118, 246, 72);
		getContentPane().add(btnNewButton);
		this.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
