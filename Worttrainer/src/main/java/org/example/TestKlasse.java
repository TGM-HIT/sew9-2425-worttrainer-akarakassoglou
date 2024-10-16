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

}
