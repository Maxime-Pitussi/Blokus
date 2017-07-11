package model;

import  java.io.*;
import javax.sound.sampled.*;
import java.util.ArrayList;
 
/**
 * Fichier : Audio.java
 * Date : 06/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *  Classe qui gère l'aspect audio du jeu.
 *
 * @author Maxime Pitusi
 * @version 1.0.0
 */

public class Audio extends Thread{

    /**  Objet AudioInputStream courant qui permet de récupérer le flux audio */

    private AudioInputStream audioInputStream = null;

    /**  Objet SourceDataLine qui permet de récuperer la ligne de donnée du fichier audio*/

    private SourceDataLine line;

    /**  Permet de récuperer le son courant de l'application */

    private FloatControl gainControl;
    
    /**  Quand interrompu passe a true, la musique s'arrete, quand il passe a false, la musique peut redémarrer*/

    private boolean interrompu;

    /**
     *  Méthode héritée de Thread qui permet de lancer la musique en continu avec une playlist aléatoire.
     */

    public void run(){
        ArrayList<File> liste = new ArrayList<File>();

        for (int i = 5; i<21; i++) {
            File f = new File("../data/musiques/musique"+i+".wav");
            liste.add(f);
        }

        interrompu = false;

        while(!interrompu){
            int g = (int)Math.floor(Math.random()*liste.size());
            
            try {
             AudioFileFormat format = AudioSystem.getAudioFileFormat(liste.get(g));
            } catch (UnsupportedAudioFileException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
             
            try {
                audioInputStream = AudioSystem.getAudioInputStream(liste.get(g));
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
             AudioFormat audioFormat = audioInputStream.getFormat();
             DataLine.Info info = new DataLine.Info(SourceDataLine.class,audioFormat);
              
             try {
                 line = (SourceDataLine) AudioSystem.getLine(info);
                            
                 } catch (LineUnavailableException e) {
                   e.printStackTrace();
                   return;
                 }
              
            try {
                    line.open(audioFormat);
            } catch (LineUnavailableException e) {
                        e.printStackTrace();
                        return;
            }

            if (line.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                gainControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
            }
            
            line.start();
            //Fenetre.begin=true;

            try {
                byte bytes[] = new byte[1024];
                int bytesRead=0;
                while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1 && !interrompu) {
                     line.write(bytes, 0, bytesRead);
                    }
            } catch (IOException io) {
                io.printStackTrace();
                return;
            } 
        }        
    }

    /**
     *  Permet de récuperer l'audioInputStream courant
     *
     * @return  l'audioInputStream courant
     */
    
    public AudioInputStream getAudioInputStream(){
        return audioInputStream;
    }

    /**
     *  Permet de récuperer la ligne de donnée courante
     *
     * @return  la ligne de donnée courante
     */
    
    public SourceDataLine getSourceDataLine(){
        return line;
    }

    /**
     *  Permet de récuperer le volume sonore courant
     *
     * @return  le volume sonore courant
     */
    
    public FloatControl getGainControl(){
        return gainControl;
    }

    /**
     *  Permet de modifier le volume sonore courant
     *
     * @param gainControl  le volume a appliquer
     */
    
    public void setGainControl(FloatControl gainControl){
        this.gainControl = gainControl;
    }

    /**
     *  Permet d'interrompre la musique
     */
    
    public void interrompu(){
        interrompu = true;
    }
}