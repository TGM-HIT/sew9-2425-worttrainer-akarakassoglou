package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Klasse zum Laden aus einer TXT Datei
 * @autor André Karakassoglou
 * @version 2024-11-06
 */
public class LadenAusWortTrainerTXT implements Umgang {


	/**
	 * Konstruktor
	 */
	public LadenAusWortTrainerTXT() {
	}

	/**
	 * Lädt WortTrainer aus Datei
	 * @param filename übergebener Dateiname
	 */
	@Override
	public Trainer laden(String filename) {
		if (filename == null) {
			throw new IllegalArgumentException("Dateiname darf nicht null sein!");
		}
		try (BufferedReader s = new BufferedReader(new FileReader(filename))) {
			Trainer t = new Trainer();
			t.setzAbgefragt(Integer.parseInt(s.readLine().split(": ")[1])); //liest aus der datei die Anzahl der durchgänge, splittet den string damit zahl und wort gleichzeitig gelesen wird.
			t.setzKorrekt(Integer.parseInt(s.readLine().split(": ")[1]));
			String wort;
			while ((wort = s.readLine()) != null) {
				Eintrag eintrag = new Eintrag(wort, s.readLine());
				t.addEintrag(eintrag);
			}
			return t;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Nicht benötigt
	 * @param filename
	 */
        @Override
	public void speichern(String filename) {

	}

}
