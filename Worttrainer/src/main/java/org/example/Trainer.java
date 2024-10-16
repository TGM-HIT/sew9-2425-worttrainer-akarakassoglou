package org.example;

import java.util.ArrayList;


/**
 * Klasse die sich um die Eintraege und deren Handhabung kümmert.
 * @author André Karakassoglou
 * @version 2022-09-13
 */
public class Trainer {

	private int zAbgefragt;
	private int zKorrekt;
	private Eintrag eintrag;
	private ArrayList<Eintrag> eintraege;

	/**
	 * Konstruktor
	 */
	public Trainer() {
		this.zAbgefragt = 0;
		this.zKorrekt = 0;
		this.eintrag = null;
		this.eintraege = new ArrayList<Eintrag>();
	}

	/**
	 * Konstruktor
	 * @param eintraege Liste von Eintraegen
	 * @throws IllegalArgumentException
	 */
	public Trainer(ArrayList<Eintrag> eintraege) throws IllegalArgumentException{
		if(eintraege==null){
			throw new IllegalArgumentException("Liste muss einen Inhalt haben!");
		}
		else{
			this.eintraege=eintraege;
		}
	}

	/**
	 * Getter zAbgefragt
	 * @return zAbgefragt
	 */
	public int getzAbgefragt() {
		return this.zAbgefragt;
	}

	/**
	 * Setter zAbgefragt
	 * @param zAbgefragt neue Anzahl der gemachten Durchgänge
	 * @throws IllegalArgumentException
	 */
	public void setzAbgefragt(int zAbgefragt) {
		if(zAbgefragt<0){
			throw new IllegalArgumentException("Anzahl der Durchgänge muss positiv sein!");
		}
		if(this.zKorrekt>zAbgefragt){
			throw new IllegalArgumentException("Anzahl der Korrekten Antworten darf nicht größer als die Anzahl der Durchgänge sein!");
		}
		else{
			this.zAbgefragt = zAbgefragt;
		}
	}

	/**
	 * Getter zKorrekt
	 * @return zKorrekt
	 */
	public int getzKorrekt() {
		return zKorrekt;
	}

	/**
	 * Setter zKorrekt
	 * @param zKorrekt setzt Anzahl korrekt
	 * @throws IllegalArgumentException
	 */
	public void setzKorrekt(int zKorrekt) {
		if (zKorrekt<0||zKorrekt>this.zAbgefragt){
			throw new IllegalArgumentException("Anzahl korrekt muss zwischen 0 und Anzahl abgefragt liegen!");
		}
		else {
			this.zKorrekt = zKorrekt;
		}
	}

	/**
	 * Einen Eintrag hinzufügen
	 * @param eintrag neuer Eintrag
	 */
	public void addEintrag(Eintrag eintrag) {
		if(eintrag==null){
			throw new IllegalArgumentException("Der Eintrag darf nicht null sein!");
		}
		this.eintraege.add(eintrag);
	}

	/**
	 * Einen zufälligen Eintrag aus der Liste zurückgeben
	 * @return zufälliger Eintrag
	 */
	public Eintrag rndmEintrag() {
		return this.eintraege.get((int) (Math.random() * this.eintraege.size()));
	}

	/**
	 * Getter Eintrag
	 * @return
	 */
	public Eintrag getEintrag() {
		return this.eintrag;
	}

	/**
	 * Überprüft ob der mitgegebene Text, dem eines Eintrags entspricht
	 * @param txt mitgegebenes Wort
	 * @return ob entspricht oder nicht
	 */
	public boolean check(String txt) {
		++this.zAbgefragt;
		if (this.eintrag.getWort().equals(txt)) {
			++this.zKorrekt;
			return true;
		}
		return false;
	}


	/**
	 * toString Methode
	 * @return als String
	 */
	public String toString() {
		return "Trainer{" +
				"zAbgefragt=" + zAbgefragt +
				", zKorrekt=" + zKorrekt +
				", eintrag=" + eintrag +
				", eintraege=" + eintraege +
				'}';
	}

	/**
	 * Methode um die Werte zurückzusetzen
	 */
	public void zurueck() {
		this.zAbgefragt=0;
		this.zKorrekt=0;
	}

}
