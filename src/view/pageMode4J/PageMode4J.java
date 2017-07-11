package view.pageMode4J;

import javax.swing.*;
import java.awt.*;
import control.BlokusListener;

/**
 * Fichier : PageMode4J.java
 * Date : 06/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui organise les elements graphiques de la page Mode4J.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class PageMode4J extends JPanel{

//................................................................................................... I : EN-TÊTE
	
	/** Bouton d'accès au tutoriel pour 4 joueurs */

	private JButton tutoriel = new JButton();

	/** Bouton d'accès aux paramètres */
	
	private JButton parametres = new JButton();

	/** Bouton d'accès à l'accueil */
	
	private JButton accueil = new JButton();
	
	/** Bouton de lancement de partie */
	
	private JButton lancer = new JButton();

	/** Permet de modifier le joueur 1 en IA */
	
	private JCheckBox bot1 = new JCheckBox();
	
	/** Permet de modifier le joueur 2 en IA */
	
	private JCheckBox bot2 = new JCheckBox();
	
	/** Permet de modifier le joueur 3 en IA */
	
	private JCheckBox bot3 = new JCheckBox();
	
	/** Permet de modifier le joueur 4 en IA */
	
	private JCheckBox bot4 = new JCheckBox();

	/** Liste des équipes possibles pour le joueur 1 */
	
	private String[] list1 = {"EQUIPE 1", "EQUIPE 2", "EQUIPE 3", "EQUIPE 4"};
	
	/** Permet de choisir l'équipe du joueur 1 */
	
	private JComboBox cb1 = new JComboBox(list1);
	
	/** Liste des équipes possibles pour le joueur 2 */
	
	private String[] list2 = {"EQUIPE 2", "EQUIPE 1", "EQUIPE 3", "EQUIPE 4"};
	
	/** Permet de choisir l'équipe du joueur 1 */
	
	private JComboBox cb2 = new JComboBox(list2);
	
	/** Liste des équipes possibles pour le joueur 3 */
	
	private String[] list3 = {"EQUIPE 3", "EQUIPE 1", "EQUIPE 2", "EQUIPE 4"};
	
	/** Permet de choisir l'équipe du joueur 1 */
	
	private JComboBox cb3 = new JComboBox(list3);
	
	/** Liste des équipes possibles pour le joueur 4 */
	
	private String[] list4 = {"EQUIPE 4", "EQUIPE 1", "EQUIPE 2", "EQUIPE 3"};
	
	/** Permet de choisir l'équipe du joueur 1 */
	
	private JComboBox cb4 = new JComboBox(list4);

	/** Fond d'écran de la page */
	
	private Image img;

//................................................................................................... II : CONSTRUCTEUR
	
	/**
  	 * Positionne les elements sur le panel
  	 *
  	 * @param l  l'ecouteur qui permet de declencher une action en fonction de l'action de l'utilisateur
  	 */

	public PageMode4J(BlokusListener l) {

		this.setLayout(null);

		img = new ImageIcon("../data/images/backgrounds/BackgroundChoixJoueurs.png").getImage();

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		tutoriel.setBounds((int)(width*0.883),(int)(height*0.775),(int)(width*0.105),(int)(height*0.115));
		tutoriel.setActionCommand("tutoriel4J");
		tutoriel.addActionListener(l);
		tutoriel.setBorderPainted(false);
		tutoriel.setContentAreaFilled(false);
		this.add(tutoriel);

		parametres.setBounds((int)(width*0.01),(int)(height*0.775),(int)(width*0.105),(int)(height*0.115));
		parametres.setActionCommand("pageParametres");
		parametres.addActionListener(l);
		parametres.setBorderPainted(false);
		parametres.setContentAreaFilled(false);
		this.add(parametres);

		accueil.setBounds((int)(width*0.475),(int)(height*0.122),(int)(width*0.062),(int)(height*0.09));
		accueil.setActionCommand("pageAccueil");
		accueil.addActionListener(l);
		accueil.setBorderPainted(false);
		accueil.setContentAreaFilled(false);
		this.add(accueil);

		bot1.setBounds((int)(width*0.53),(int)(height*0.255),(int)(width*0.1),(int)(height*0.1));
		bot1.setFocusable(false);
		this.add(bot1);

		cb1.setBounds((int)(width*0.68),(int)(height*0.280),(int)(width*0.1),(int)(height*0.05));
		cb1.setFocusable(false);
		this.add(cb1);

		bot2.setBounds((int)(width*0.53),(int)(height*0.355),(int)(width*0.1),(int)(height*0.1));
		bot2.setFocusable(false);
		this.add(bot2);

		cb2.setBounds((int)(width*0.68),(int)(height*0.380),(int)(width*0.1),(int)(height*0.05));
		cb2.setFocusable(false);
		this.add(cb2);

		bot3.setBounds((int)(width*0.53),(int)(height*0.45),(int)(width*0.1),(int)(height*0.1));
		bot3.setFocusable(false);
		this.add(bot3);

		cb3.setBounds((int)(width*0.68),(int)(height*0.475),(int)(width*0.1),(int)(height*0.05));
		cb3.setFocusable(false);
		this.add(cb3);

		bot4.setBounds((int)(width*0.53),(int)(height*0.55),(int)(width*0.1),(int)(height*0.1));
		bot4.setFocusable(false);
		this.add(bot4);

		cb4.setBounds((int)(width*0.68),(int)(height*0.575),(int)(width*0.1),(int)(height*0.05));
		cb4.setFocusable(false);
		this.add(cb4);

		lancer.setBounds((int)(width*0.365),(int)(height*0.805),(int)(width*0.28),(int)(height*0.1));
		lancer.setActionCommand("lancer4J");
		lancer.addActionListener(l);
		lancer.setBorderPainted(false);
		lancer.setContentAreaFilled(false);
		this.add(lancer);
	}

//................................................................................................... III : MÉTHODES
	
	/**
  	 * Permet de savoir si le joueur 1 est une IA
  	 *
  	 * @return  true si le joueur 1 est une IA, false sinon
  	 */

	public boolean bot1(){
		return bot1.isSelected();
	}

	/**
  	 * Permet de savoir si le joueur 2 est une IA
  	 *
  	 * @return  true si le joueur 2 est une IA, false sinon
  	 */

	public boolean bot2(){
		return bot2.isSelected();
	}

	/**
  	 * Permet de savoir si le joueur 3 est une IA
  	 *
  	 * @return  true si le joueur 3 est une IA, false sinon
  	 */

	public boolean bot3(){
		return bot3.isSelected();
	}

	/**
  	 * Permet de savoir si le joueur 4 est une IA
  	 *
  	 * @return  true si le joueur 4 est une IA, false sinon
  	 */

	public boolean bot4(){
		return bot4.isSelected();
	}

	/**
  	 * Permet de connaître l'équipe du joueur 1
  	 *
  	 * @return  le numéro de l'équipe du joueur 1
  	 */

	public int equipeJ1(){
		int ret = 0;
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		return ret;
	}

	/**
  	 * Permet de connaître l'équipe du joueur 2
  	 *
  	 * @return  le numéro de l'équipe du joueur 2
  	 */

	public int equipeJ2(){
		int ret = 0;
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		return ret;
	}

	/**
  	 * Permet de connaître l'équipe du joueur 3
  	 *
  	 * @return  le numéro de l'équipe du joueur 3
  	 */

	public int equipeJ3(){
		int ret = 0;
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		return ret;
	}

	/**
  	 * Permet de connaître l'équipe du joueur 4
  	 *
  	 * @return  le numéro de l'équipe du joueur 4
  	 */

	public int equipeJ4(){
		int ret = 0;
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		return ret;
	}

	/**
	 * Cette méthode permet de gérer l'affichage du fond
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