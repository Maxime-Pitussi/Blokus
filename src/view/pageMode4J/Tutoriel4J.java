package view.pageMode4J;

import javax.swing.*;
import java.awt.*;
import control.BlokusListener;

/**
 * Fichier : Tutoriel4J.java
 * Date : 06/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui organise les elements graphiques de la page Tutoriel4J.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class Tutoriel4J extends JPanel{

//................................................................................................... I : EN-TÊTE
	
	/** Ce label sert à afficher un titre à la fenêtre */

	private JLabel name = new JLabel("BLOKUS");

	/** Ce bouton sert à revenir à l'accueil */

	private JButton accueil = new JButton();

	/** L'image de fond du menu */
	
	private Image img;

//................................................................................................... II : CONSTRUCTEUR
	
	/**
  	 * Positionne les elements sur le panel
  	 *
  	 * @param l L'ecouteur qui permet de declencher une action en fonction de l'action de l'utilisateur
  	 */

	public Tutoriel4J(BlokusListener l) {

		this.setLayout(null);

		img = new ImageIcon("../data/images/backgrounds/BackgroundTutoriel.png").getImage();

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		accueil.setBounds((int)(width*0.475),(int)(height*0.122),(int)(width*0.062),(int)(height*0.09));
		accueil.setActionCommand("venantTuto");
		accueil.addActionListener(l);
		accueil.setBorderPainted(false);
		accueil.setContentAreaFilled(false);
		this.add(accueil);
	}

//................................................................................................... III : METHODES

	/**
	 * Cette méthode permet d'afficher un fond
	 *
	 * @param g Le composant graphique de la fenêtre
	 */
	
	public void paintComponent(Graphics g) {
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		g.drawImage(img, 0, 0, width, height, null);
	}
}