package pixeliseur;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		Runnable r = new Runnable(){
			public void run() {
				Fenetre fen = new Fenetre(8);				
			}	
		};
		SwingUtilities.invokeLater(r);
	}
}
