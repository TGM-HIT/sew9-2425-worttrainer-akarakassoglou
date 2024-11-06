package org.example;

import java.net.URL;

/**
 * Klasse Worteintrag erstellt, besteht aus Wort und URL und prüft auf Gültigkeit
 * @author André Karakassoglou
 * @version 2024-10-16
 */

public class Eintrag {

	private String wort;

	private String bild;


	/**
	 * Konstruktor
	 * @param wort neues Wort
	 * @param url neue URL
	 */
	public Eintrag(String wort, String url) {
		setBild(url);
		setWort(wort);
	}

	/**
	 * Getter wort
	 * @return das wort
	 */
	public String getWort() {
		return this.wort;
	}

	/**
	 * Setter wort
	 * @param wort neues Wort
	 */
	public void setWort(String wort) {
		if((wort!=null)){
			this.wort = wort;
		}
		else{
			throw new IllegalArgumentException("Es muss ein Wort angegeben werden!");
		}
	}

	/**
	 * Getter Bild
	 * @return die url/Bild
	 */
	public String getBild() {
		return this.bild;
	}


	/**
	 * Setter Bild
	 * @param bild neues Bild
	 */
	public void setBild(String bild) {
		if (bild != null) {
			this.bild = bild;
		} else {
			throw new IllegalArgumentException("Es muss eine URL angegeben werden!");
		}
	}

	/**
	 * Überprüft ob eine gültige URL übergeben wurde
	 * @param txt neue url
	 * @return ob gültig oder nicht
	 */
	public static boolean checkBild(String txt) {
		if(txt==null){
			return false;
		}
		try {
			new URL(txt).toURI();
			return true;
		}
		catch (Exception e){
			return false;
		}
	}


	/**
	 * Schaut ob wort gültig ist
	 * @param wort
	 * @return
	 */
	public static boolean checkWort(String wort) {
		if ((wort != null) && (wort.length() >= 2)) {
			return true;
		} else {
			throw new IllegalArgumentException("Es muss ein Wort angegeben sein!");
		}
	}

	/**
	 * Überschreibung von toString
	 * @return Wort, URL
	 */
	public String toString() {
		return this.wort +"; "+ this.bild;
	}

}
