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
		if((wort!=null)&&(wort.length()>=2)){
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

	public boolean checkBild(String txt) {
		return false;
	}

	public boolean checkWort(String wort) {
		return false;
	}

	public String toString() {
		return null;
	}

}
