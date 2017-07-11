package view;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import control.*;
import model.Audio;
import view.pageAccueil.PageAccueil;
import view.pageParametres.*;
import view.pageMode4J.*;
import view.pageMode8J.*;
import view.pageModeT.*;
import view.echap.PageEchap;

/**
 * Fichier : BlokusFrame.java
 * Date : 06/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui recupere tous les autres panel pour les mettre dans un CardLayout et ajouter celui ci a la fenetre
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class BlokusFrame extends JFrame{

//................................................................................................... I : EN TETE

	/** Le CardLayout qui gere le panel content et ses onglets */

	CardLayout cl = new CardLayout();

	/** Le panel principal, qui contient tous les onglets */

	JPanel content = new JPanel();

	/** Le CardLayout qui gere le panel glass et ses onglets */

	CardLayout clg = new CardLayout();

	/** Le glass panel, qui contient les onglets du menu echap et du drag'N drop */

	JPanel glass = new JPanel();

	/** Le panel du menu echap */

	JPanel menuEchap = new JPanel();

	/** Le panel du drag'N drop */

	JPanel dragNDrop = new JPanel();

	/** L'ecouteur du jeu, qui recupere tous les interractions de l'utilisateur avec le jeu */

	BlokusListener l;

	/** Le panel de la page d'accueil */

	PageAccueil pageAccueil;

	/** Le panel de la page parametres */

	PageParametres pageParametres;

	/** Le panel de la page du choix des joueurs dans le mode 4 joueurs */

	PageMode4J pageMode4J;

	/** Le panel de la page du choix des joueurs dans le mode 8 joueurs */

	PageMode8J pageMode8J;

	/** Le panel de la page du choix des joueurs dans le mode trigon */

	PageModeT pageModeT;

	/** Le panel de la page tutoriel pour 4 joueurs */

	Tutoriel4J tutoriel4J;

	/** Le panel de la page tutoriel pour 8 joueurs */

	Tutoriel8J tutoriel8J;

	/** Le panel de la page tutoriel pour le mode trigon */

	TutorielT tutorielT;

	/** Le panel de la page de jeu */

	PageJeu4J pageJeu4J;

	/** Le string contenant le nom de la page courante du panel principal */

	String courant = "pageAccueil";

	/** Le string contenant le nom de la page courante du glass panel */

	String courantGlass = "menuEchap";

	/** Le string contenant le nom de la page precedente du panel principal */

	String precedent = "pageAccueil";

	/** Le panel de la page de son */

	PageSon pageSon;

	/** Le panel de la page des mentions legales */

	PageMentionsLegales pageMentionsLegales;

	/** Le panel de la page des reglages */

	PageParamDeJeu pageParamDeJeu;

	/** Le panel de la page des regles du jeu */

	PageControles pageControles;

	/** Objet gérant le son du jeu */

	Audio son = new Audio();

	/** Le panel du menu echap */

	PageEchap pageEchap;

	/** boolean true si le glass panel est actif, false sinon */

	boolean glassActif;

//................................................................................................... II : CONSTRUCTEUR
	
	/**
  	 * Implemente tous les panel, les ajoute au panel principal et enfin au CardLayout
  	 */

	public BlokusFrame(){
		super();

		son.start();

		this.setTitle("Blokus");
     	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		l = new BlokusListener(this, son);
		this.addKeyListener(l);

		glass = (JPanel)this.getGlassPane();
		glass.setLayout(null);

		glass.setLayout(clg);

		pageEchap = new PageEchap(l);

		glass.add(pageEchap,"menuEchap");
		glass.add(dragNDrop,"dragNDrop");

		dragNDrop.setLayout(null);
		dragNDrop.setOpaque(false);

		pageAccueil = new PageAccueil(l);
		pageParametres = new PageParametres(l);
		pageMode4J = new PageMode4J(l);
		pageMode8J = new PageMode8J(l);
		pageModeT = new PageModeT(l);
		tutoriel4J = new Tutoriel4J(l);
		tutoriel8J = new Tutoriel8J(l);
		tutorielT = new TutorielT(l);
		pageJeu4J = new PageJeu4J(l, dragNDrop);
		pageSon = new PageSon(l, son);
		pageMentionsLegales = new PageMentionsLegales(l);
		pageParamDeJeu = new PageParamDeJeu(l);
		pageControles = new PageControles(l);

		content.setLayout(cl);

		content.add(pageAccueil,"pageAccueil");
		content.add(pageParametres,"pageParametres");
		content.add(pageMode4J,"pageMode4J");
		content.add(pageMode8J,"pageMode8J");
		content.add(pageModeT,"pageModeT");
		content.add(tutoriel4J,"tutoriel4J");
		content.add(tutoriel8J,"tutoriel8J");
		content.add(tutorielT,"tutorielT");
		content.add(pageJeu4J,"pageJeu4J");
		content.add(pageSon,"pageSon");
		content.add(pageMentionsLegales,"pageMentionsLegales");
		content.add(pageParamDeJeu,"pageParamDeJeu");
		content.add(pageControles,"pageControles");

		this.setContentPane(content);

		//this.setDefaultLookAndFeelDecorated(true);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setUndecorated(true);

		Image image = new ImageIcon("../data/logo.png").getImage();
		this.setIconImage(image); // Ne fonctionne pas sous mac

		setVisible(true);
		requestFocus(); // frame qui prends le focus
	}

//................................................................................................... III : METHODES

	/**
	 * retourne le nom de la page courante
	 *
	 * @return  la page courante
	 */

	public String getCourant(){
		return this.courant;
	}

	/**
	 * modifie le nom de la page courante
	 *
	 * @param string  le nouveau nom de la page courante
	 */

	public void setCourant(String string){
		this.courant = string;
	}

	/**
	 * retourne le nom de la page precedente
	 *
	 * @return  la page precedente
	 */

	public String getPrecedent(){
		return this.precedent;
	}

	/**
	 * modifie le nom de la page precedente
	 *
	 * @param string  le nouveau nom de la page precedente
	 */

	public void setPrecedent(String string){
		this.precedent = string;
	}

	/**
	 * modifie la page affichée grâce à son nom
	 *
	 * @param string  le nom de la page à afficher
	 */

	public void changerPage(String string){
		cl.show(content, string);
		requestFocus();
		courant = string;
		pagePrecedent(string);
	}

	/**
	 * modifie le nom de la page precedente si le parametre n'est pas egal a echap
	 *
	 * @param string  le nouveau nom de la page precedente
	 */

	public void pagePrecedent(String string){
		if (!string.equals("echap")) {
			this.precedent = string;
		}
	}

	/**
	 * retourne le panel de la page du choix des parametres
	 *
	 * @return  le panel de la page du choix des parametres
	 */

	public PageMode4J getPageMode4J(){
		return this.pageMode4J;
	}

	/**
	 * retourne le panel de la page du jeu
	 *
	 * @return  le panel de la page du jeu
	 */

	public PageJeu4J getPageJeu4J(){
		return this.pageJeu4J;
	}

	/**
	 * retourne le panel de la page de son
	 *
	 * @return  le panel de la page de son
	 */

	public PageSon getPageSon(){
		return this.pageSon;
	}

	/**
	 * Permet de stopper la musique
	 */

	public void stopperLaMusique(){
		son.interrompu();
	}

	/**
	 * Permet d'activer la musique
	 */

	public void activerLaMusique(){
		son = new Audio();
		son.start();
		pageSon.setAudio(son);
		pageSon.setGainSlider();
		//pageSon = new PageSon(l,son);
		//cl.show(content, "pageSon");
	}

	/**
	 * Permet de remettre les parametres de jeu à 0
	 */

	public void setPageJeu4J(){
		dragNDrop = new JPanel();
		glass.add(dragNDrop,"dragNDrop");
		dragNDrop.setLayout(null);
		dragNDrop.setOpaque(false);
		pageJeu4J = new PageJeu4J(l, dragNDrop);
		content.add(pageJeu4J,"pageJeu4J");
		dragNDrop.repaint();
	}

	/**
	 * Permet de rendre le glass panel visible
	 */

	public void setGlassVisible(){
		this.glass.setVisible(true);
		glassActif = true;
	}

	/**
	 * Permet de rendre le glass panel invisible
	 */

	public void setGlassInvisible(){
		this.glass.setVisible(false);
		glassActif = false;
	}

	/**
	 * Permet de savoir si le glass panel est actif ou non
	 *
	 * @return  true si le glass panel est actif, false sinon
	 */

	public boolean getGlassActif(){
		return glassActif;
	}

	/**
	 * Permet de connaitre le nom de la page affichee sur le glass panel
	 *
	 * @return  le nom de la page affichee sur le glass panel
	 */

	public String getCourantGlass(){
		return courantGlass;
	}

	/**
	 * modifie la page affichée sur le glass panel grâce à son nom
	 *
	 * @param string  le nom de la page à afficher
	 */

	public void changerGlassPage(String string){
		clg.show(glass, string);
		requestFocus();
		courantGlass = string;
		pagePrecedent(string);
	}
}