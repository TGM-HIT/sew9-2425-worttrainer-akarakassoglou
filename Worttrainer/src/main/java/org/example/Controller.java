package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Controller Klasse, die die Interaktion zwischen Trainer, Frame und Panel
 * steuert
 * @version 2024-11-06
 * @autor André Karakassoglou
 */

public class Controller implements ActionListener, KeyListener {

	private Trainer t;

	private Frame f;

	private Panel p;

	/**
	 * Initialisiert die View-Elemente und das Model
	 *
	 * @param trainer eine vorgebener WortTrainer
	 */
	public Controller(Trainer trainer) {
		this.t = trainer;
		this.t.rndmEintrag();
		try {
			this.p = new Panel(this, new ImageIcon(new URL(this.t.getEintrag().getBild())), this.t.getzKorrekt(), this.t.getzAbgefragt());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);		}
		this.f = new Frame(this.p);
	}

	/**
	 * bildet den Startpunkt der Applikation
	 *
	 * @param args nicht verwendet
	 */
	public static void main(String[] args) {
		//Trainer t = new Trainer(new ArrayList<Eintrag>());
		Eintrag e1 = new Eintrag("Hund", "https://tractive.com/blog/wp-content/uploads/2018/04/qualzucht-hund-die-auswirkungen-von-ueberzuechteten-hunden-ueberzuechtung-hund-768x576.jpg");
		Eintrag e2 = new Eintrag("Ribs", "https://www.ribsofvienna.at/wp-content/uploads/2020/02/logon.png");
		Eintrag e3 = new Eintrag("Ball", "https://upload.wikimedia.org/wikipedia/commons/0/0c/Fussball.jpg");
		Eintrag e4 = new Eintrag("TGM", "https://www.tgm.ac.at/wp-content/uploads/2022/03/cropped-tgm_logo_300dpi.jpg");
		Eintrag e5 = new Eintrag("Gehirn", "https://www.alzheimer-forschung.de/fileadmin/user_upload/0_Infografik/Anatomie_Gehirn_web.jpg");
		Eintrag e6 = new Eintrag("Elefant", "https://i1.sndcdn.com/artworks-000022077234-va8t3d-t500x500.jpg");
		Eintrag e7 = new Eintrag("Fisch", "https://m.media-amazon.com/images/I/715Bwdhd86L._AC_UL1500_.jpg");

		ArrayList<Eintrag> eintraege = new ArrayList<Eintrag>();
		eintraege.add(e1);
		eintraege.add(e2);
		eintraege.add(e3);
		eintraege.add(e4);
		eintraege.add(e5);
		eintraege.add(e6);
		eintraege.add(e7);

		new Controller(new Trainer(eintraege));
	}

	/**
	 * Die Steuerungsmethode die beim Button-Klick ausgelöst wird
	 *
	 * @param e das Ereignis, das den Aufruf der Methode ausgelöst hat
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if (ac.equals("zurücksetzen")) {
			this.p.zurueck();
			this.t.zurueck();
			try {
				this.p.setImg(new ImageIcon(new URL(this.t.getEintrag().getBild())));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);
			}
		}else if (ac.equals("Laden")) {
			boolean isLegal = true;
			try {
				JFileChooser fc = new JFileChooser();
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					String pfad = fc.getSelectedFile().getAbsolutePath();
					this.t = new LadenAusWortTrainerTXT().laden(pfad);
				}
			} catch (IllegalArgumentException ex) {
				isLegal = false;
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);
			}
			if (isLegal) {
				try {
					this.t.setEintrag(this.t.rndmEintrag());
					this.p.aktualisieren(this.t.getEintrag().getBild(), this.t.getzKorrekt(), this.t.getzAbgefragt());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);
				}
			}
		} else if (ac.equals("Speichern")) {
			try {
				JFileChooser fc = new JFileChooser();
				if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					String pfad = fc.getSelectedFile().getAbsolutePath();
					SpeichernAusWortTrainerTXT s = new SpeichernAusWortTrainerTXT(this.t);
					s.speichern(pfad);
				}
			} catch (IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	/**
	 * Wird aufgerufen wenn Enter gedrückt wurde
	 *
	 * @param e das Ereignis, das den Aufruf der Methode ausgelöst hat
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			boolean isLegal = true;
			try {
				isLegal = this.t.check(this.p.getEingabe());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);
			}
			if (isLegal) {
				try {
					this.t.setEintrag(this.t.rndmEintrag());
					this.p.aktualisieren(this.t.getEintrag().getBild(), this.t.getzKorrekt(), this.t.getzAbgefragt());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				try {
					this.p.aktualisieren(this.t.getzKorrekt(), this.t.getzAbgefragt());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}

	/**
	 * Invoked when a key has been typed.
	 * See the class description for {@link KeyEvent} for a definition of
	 * a key typed event.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Invoked when a key has been pressed.
	 * See the class description for {@link KeyEvent} for a definition of
	 * a key pressed event.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void keyPressed(KeyEvent e) {

	}

}
