package org.example;

public class Trainer implements Umgang {

	private int zAbgefragt;

	private int zKorrekt;

	private int zFalsch;

	private Umgang umgang;

	private Eintraege eintraege;

	private Eintrag eintrag;

	public Trainer(Eintraege liste) {

	}

	public int getzAbgefragt() {
		return 0;
	}

	public void setzAbgefragt(int zAbgefragt) {

	}

	public int getzKorrekt() {
		return 0;
	}

	public void setzKorrekt(int zKorrekt) {

	}

	public Eintraege getEintraege() {
		return null;
	}

	public Eintrag rndmEintrag() {
		return null;
	}

	public Eintrag getEintrag() {
		return null;
	}

	public boolean check(String txt) {
		return false;
	}

	public String toString() {
		return null;
	}

	public void zurueck() {

	}

	@Override
	public Trainer laden(String filename) {
		return null;
	}

	@Override
	public void speichern(String filename) {

	}

}
