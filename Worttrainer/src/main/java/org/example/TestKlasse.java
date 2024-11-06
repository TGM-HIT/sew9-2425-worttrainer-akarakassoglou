package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Testklasse um die Funktionalität der Klassen per JUnit-Testing zu testen.
 * @author André Karakassoglou
 * @version 2024-10-16
 */
public class TestKlasse {


    //Testet den Konstruktor der Klasse Eintrag, mit Setter und Getter
    @Test
    @DisplayName("Test Eintrag Konstruktor,Setter,Getter")
    public void testEintrag() {
        Eintrag e = new Eintrag("Test", "https://www.google.de");
        assertEquals("Test", e.getWort());
        assertEquals("https://www.google.de", e.getBild());
        e.setWort("Test2");
        assertEquals("Test2", e.getWort());
        e.setBild("https://www.google.com");
        assertEquals("https://www.google.com", e.getBild());
    }

    //Testet ob gültige Wörter und URLs in Eintrag überprüft werden und prüft außerdem toString
    @Test
    @DisplayName("Test Eintrag Gültigkeit und toString")
    public void testEintragGueltigkeit() {
        Eintrag e = new Eintrag("Test", "https://www.google.de");
        assertEquals("Test", e.getWort());
        assertEquals("https://www.google.de", e.getBild());
        e.setWort("Test2");
        assertEquals("Test2", e.getWort());
        e.setBild("https://www.google.com");
        assertEquals("https://www.google.com", e.getBild());
        Eintrag e2 = new Eintrag("T", "https://www.google.de");
        Eintrag e3 = new Eintrag("Test", "https://www.google.de");
        assertThrows(IllegalArgumentException.class, () -> e2.checkWort("T"));
        assertEquals("Test", e3.getWort());
        Eintrag e4 = new Eintrag("Test", "https://www.google.de");
        assertEquals("https://www.google.de", e4.getBild());
        Eintrag e5 = new Eintrag("Test", "https://www.google.de");
        assertEquals("https://www.google.de", e5.getBild());
        Eintrag e6 = new Eintrag("Test", "https://www.google.de");
        assertEquals("Test; https://www.google.de", e6.toString());
    }

    //Testet die Trainer Klasse
    @Test
    @DisplayName("Test Trainer")
    public void testTrainer() {
        Trainer t = new Trainer();
        Eintrag e = new Eintrag("Test", "https://www.google.de");
        t.addEintrag(e);
        assertEquals(1, t.getEintraege().size());
        Eintrag e2 = new Eintrag("Test2", "https://www.google.com");
        t.addEintrag(e2);
        assertEquals(2, t.getEintraege().size());
        Eintrag e3 = new Eintrag("Test3", "https://www.google.de");
        t.addEintrag(e3);
        assertEquals(3, t.getEintraege().size());
        //teste ob ein zufälliger eintrag aus der Liste gewählt wird
        t.setEintrag(e);
        assertEquals(e, t.getEintrag());
        assertNotNull(t.rndmEintrag());
        //teste ob eintrag korrekt ist
        assertTrue(t.check("Test"));
        assertFalse(t.check("Test2"));
        //teste tostring
        assertEquals("Trainer{zAbgefragt=2, zKorrekt=1, eintrag=Test; https://www.google.de, eintraege=[Test; https://www.google.de, Test2; https://www.google.com, Test3; https://www.google.de]}", t.toString());
        //setze abgefragt und korrekt zurück
        t.zurueck();
        assertEquals(0, t.getzAbgefragt());
        assertEquals(0, t.getzKorrekt());


    }

    //Testet Speichern und Laden
    @Test
    @DisplayName("Test Speichern und Laden")
    public void testSpeichernLaden() {
        Trainer t = new Trainer();
        Eintrag e = new Eintrag("Test", "https://www.google.de");
        t.addEintrag(e);
        Eintrag e2 = new Eintrag("Test2", "https://www.google.com");
        t.addEintrag(e2);
        Eintrag e3 = new Eintrag("Test3", "https://www.google.de");
        t.addEintrag(e3);
        SpeichernAusWortTrainerTXT s = new SpeichernAusWortTrainerTXT(t);
        s.speichern("test.txt");
        Trainer t2 = new LadenAusWortTrainerTXT().laden("test.txt");
        assertEquals(t.getEintraege().size(), t2.getEintraege().size());
        assertEquals(t.getzAbgefragt(), t2.getzAbgefragt());
        assertEquals(t.getzKorrekt(), t2.getzKorrekt());
    }

}
