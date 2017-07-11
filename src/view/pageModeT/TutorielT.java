package view.pageModeT;

import javax.swing.*;
import java.awt.*;
import control.BlokusListener;

/**
 * Fichier : TutorielT.java
 * Date : 06/06/2016
 * Derniere mise a jour : 06/06/2016
 *
 *   Classe qui organise les elements graphiques de la page TutorielT.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class TutorielT extends JPanel{
	
	JLabel name = new JLabel("BLOKUS");
	JButton accueil = new JButton("RETOUR ACCUEIL");

//................................................................................................... I : CONSTRUCTEUR
	
	/**
  	 * Positionne les elements sur le panel
  	 *
  	 * @param l  l'ecouteur qui permet de declencher une action en fonction de l'action de l'utilisateur
  	 */

	public TutorielT(BlokusListener l) {

		this.setLayout(null);

		name.setBounds(100,300,100,100);
		this.add(name);

		accueil.setBounds(800,300,200,100);
		accueil.setActionCommand("pageAccueil");
		accueil.addActionListener(l);
		this.add(accueil);
	}
}