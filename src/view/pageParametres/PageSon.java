package view.pageParametres;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import control.BlokusListener;
import model.Audio;

/**
 * Fichier : PageParametres.java
 * Date : 06/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui organise les éléments audio de la page paramètres.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class PageSon extends JPanel{

//................................................................................................... I : EN-TÊTE

	/** Ce bouton permet de couper la musique */

	private JButton musique = new JButton();

	/** Slider de réglage du volume */

	private JSlider gainSlider;

	/** Objet gérant la musique */

	private Audio son;

	/** l est un objet de type ActionListener, créer pour réagir aux actions réalisées par l'utilisateur */

	private BlokusListener l;

	/** Cette image est utilisée pour le fond du menu */

	private Image img;

	/** Ce label affiche le volume de la musique */

	private JLabel valeur = new JLabel("80");

	/** Ce bouton renvoie aux paramètres généraux */

	private JButton param = new JButton();

//................................................................................................... II : CONSTRUCTEUR
	
	/**
  	 * Positionne les éléments sur le panel
  	 *
  	 * @param l L'écouteur qui permet de déclencher une action en fonction de l'action de l'utilisateur
  	 * @param son  L'objet gérant la musique
  	 */

	public PageSon(BlokusListener l, Audio son) {

		this.setLayout(null);

		img = new ImageIcon("../data/images/backgrounds/BackgroundSon.png").getImage();

		this.son = son;
		this.l = l;

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		ImageIcon icon = new ImageIcon("../data/images/icones/VolumeInactif.png");
		Image image = icon.getImage();
		image = changerTailleImage(image,(int)(width*0.1375),(int)(height*0.22));
		icon = new ImageIcon(image);

		musique.setBounds((int)(width*0.2),(int)(height*0.35),(int)(width*0.15),(int)(height*0.24));
		musique.setActionCommand("musique");
		musique.addActionListener(l);
		musique.setBorderPainted(false);
		musique.setContentAreaFilled(false);
		musique.setIcon(icon);
		musique.setFocusable(false);
		this.add(musique);

		valeur.setBounds((int)(width*0.805),(int)(height*0.277),(int)(width*0.1),(int)(height*0.5));
		valeur.setFont(new Font("Berlin", Font.BOLD, (int)(width*0.05)));
		this.add(valeur);

		param.setBounds((int)(width*0.475),(int)(height*0.122),(int)(width*0.062),(int)(height*0.09));
		param.setActionCommand("pageParametres");
		param.addActionListener(l);
		param.setBorderPainted(false);
		param.setContentAreaFilled(false);
		this.add(param);

		setGainSlider();
	}
//................................................................................................... III : MÉTHODES

	/**
	 * Définit l'image du bouton de gestion de la musique
	 *
	 * @param string Le chemin de l'image attribuée au bouton
	 */

	public void setBoutonMusique(String string){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		ImageIcon icon = new ImageIcon(string);
		Image image = icon.getImage();
		image = changerTailleImage(image,(int)(width*0.1375),(int)(height*0.22));
		icon = new ImageIcon(image);
		
		this.musique.setIcon(icon);
		repaint();
	}

	/**
	 * Récupère la valeur courante du slider
	 *
	 * @return  la valeur courante du slider
	 */

	public float getGainSliderValue(){
		return gainSlider.getValue();
	}

	/**
	 * Affiche le slider de modification du volume uniquement si la récupération du volume est effective
	 */
	
	public void setGainSlider(){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		GridBagConstraints gbc = new GridBagConstraints();

		System.out.println("page son "+son.getGainControl());

		if (son.getGainControl() != null) {
            gainSlider = new JSlider((int) son.getGainControl().getMinimum(), (int) son.getGainControl().getMaximum());
            gainSlider.setValue((int) son.getGainControl().getValue());
            gainSlider.setMinorTickSpacing(1);
            gainSlider.setMajorTickSpacing((int) son.getGainControl().getMaximum() - (int) son.getGainControl().getMinimum());
            gainSlider.setSnapToTicks(true);
            gainSlider.setBounds((int)(width*0.485),(int)(height*0.28),(int)(width*0.28),(int)(height*0.5));
            gainSlider.setFocusable(false);
            gainSlider.addChangeListener(l);
            gbc.weightx = 1;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            this.add(gainSlider, gbc);
        }
	}

	/**
	 * Permet de modifier la classe qui gère la musique
	 *
	 * @param son  Objet Audio
	 */
	
	public void setAudio(Audio son){
		this.son = son;
	}

	/**
	 * Permet de modifier la valeur affichée du volume
	 *
	 * @param string  la valeur affichée
	 */
	
	public void setValeur(String string){
		valeur.setText(string);
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

	/**
	 * Permet de modifier la taille d'une image passée en paramètre
	 *
	 * @param source  Image à modifier
	 * @param width  La largeur voulue
	 * @param height  La hauteur voulue
	 *
	 * @return  L'image à la taille voulue
	 */

	public static Image changerTailleImage(Image source, int width, int height) {
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = (Graphics2D) img.getGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(source, 0, 0, width, height, null);
	    g.dispose();
	    return img;
	}
}