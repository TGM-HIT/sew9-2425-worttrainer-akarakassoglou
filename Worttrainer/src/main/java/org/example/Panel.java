package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Panel Klasse des Worttrainers
 * @author André Karakassoglou
 * @version 2024-10-16
 */

public class Panel extends JPanel {

	private JTextField eingabe;

	private JLabel korrekt;

	private JLabel gesamt;

	private JLabel bild;

	private Controller c;

	/**
	 * Konstruktor des Panels
	 * @param controller Controller für das Panel
	 */
	public Panel(Controller controller, ImageIcon icon, int zKorrekt, int zges) {
		BorderLayout fensterLayout = new BorderLayout();
		this.setLayout(fensterLayout);


		this.c = controller;
		eingabe.addKeyListener(this.c);

		//Panel oben für die Eingabe und Speichern/Laden
		JPanel panelOben = new JPanel();
		JLabel frage = new JLabel("Welches Wort wird unten dargestellt?");
		JButton sbtn = new JButton("Speichern");
		JButton lbtn = new JButton("Laden");

		sbtn.addActionListener(controller);
		lbtn.addActionListener(controller);

		panelOben.setLayout(new GridLayout(2,2));
		panelOben.add(sbtn);
		panelOben.add(frage);
		panelOben.add(lbtn);
		panelOben.add(eingabe);

		//Bild in der Mitte
		this.setImg(icon);
		this.bild.setHorizontalAlignment(this.getWidth()/2);

		// Panel unten mit Statistik
		JPanel panelUnten = new JPanel();
		GridLayout gl = new GridLayout(2,3);
		panelUnten.setLayout(gl);

		JLabel lKorrekt = new JLabel("Korrekte Wörter:");
		JLabel lGesamt = new JLabel("Gesamtanzahl Wörter:");
		JButton reset = new JButton("Zurücksetzen");
		JButton add = new JButton("Hinzufügen");

		reset.setActionCommand("zurücksetzen");
		reset.addActionListener(this.c);
		add.setActionCommand("hinzufügen");
		add.addActionListener(this.c);
		panelUnten.add(lKorrekt);
		panelUnten.add(this.korrekt);
		panelUnten.add(reset);
		panelUnten.add(lGesamt);
		panelUnten.add(this.gesamt);
		panelUnten.add(add);

		this.add(panelOben, BorderLayout.PAGE_START);
		this.add(this.bild, BorderLayout.CENTER);
		this.add(panelUnten, BorderLayout.PAGE_END);
	}

	/**
	 * Getter für die Eingabe
	 * @return Eingabe
	 */
	public String getEingabe() {
		return eingabe.getText();
	}

	/**
	 * Setzt neues Bild ins label
	 * @param icon
	 */
	public void setImg(ImageIcon icon) {
		Image image = icon.getImage();
		image = image.getScaledInstance(450, 450, Image.SCALE_SMOOTH);
		this.bild.setIcon(new ImageIcon(image));
	}

	/**
	 * setzt zurück
	 */
	public void zurueck() {
		this.eingabe.setText("");
		this.korrekt.setText("0");
		this.gesamt.setText("0");
	}

	/**
	 * aktualisiert die zähler
	 * @param richtige
	 * @param gesamte
	 */
	public void aktualisieren(int richtige, int gesamte) {
		this.eingabe.setText("");
		this.korrekt.setText(String.valueOf(richtige));
		this.gesamt.setText(String.valueOf(gesamte));
	}

	/**
	 * aktualisert bild sowie zähler
	 * @param url
	 * @param richtige
	 * @param gesamte
	 * @throws MalformedURLException
	 */
	public void aktualisieren(String url, int richtige, int gesamte) throws MalformedURLException {
		this.aktualisieren(richtige, gesamte);
		this.setImg(new ImageIcon(new URL(url)));
	}

}
