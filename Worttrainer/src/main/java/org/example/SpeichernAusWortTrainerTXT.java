package org.example;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * speichert Trainer in TXT Datei
 * @autor André Karakassoglou
 * @version 2024-11-06
 */
public class SpeichernAusWortTrainerTXT implements Umgang {

	private Trainer trainer;

	/**
	 * Konstruktor
	 * @param trainer übergebener Trainer
	 */
	public SpeichernAusWortTrainerTXT(Trainer trainer) {
		setTrainer(trainer);
	}

	public void setTrainer(Trainer trainer) {
		if (trainer == null) {
			throw new IllegalArgumentException("Trainer darf nicht null sein!");
		}
		this.trainer = trainer;
	}

	/**
	 * Schreibt Trainer in Datei
	 * @param filename übergebener Dateiname
	 */
	public void speichern(String filename) {
		if (filename == null) {
			throw new IllegalArgumentException("Dateiname darf nicht null sein!");
		}
		try (PrintWriter outputStream = new PrintWriter(filename)) {
			outputStream.println("Durchgänge: "+this.trainer.getzAbgefragt());
			outputStream.println("Korrekt: "+this.trainer.getzKorrekt());
			for (Eintrag eintrag : this.trainer.getEintraege()) {
				outputStream.println(eintrag.getWort());
				outputStream.println(eintrag.getBild());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Nicht benötigt
	 * @param filename
	 */
	@Override
	public Trainer laden(String filename) {
		return null;
	}

}
