package org.example;

/**
 * Interface Umgang, welches die Klassen Speichern und Laden auswechselbar (zB. JSON, XML, usw.) macht.
 * @author André Karakassoglou
 * @version 2024-10-16
 */
public interface Umgang {

    Trainer laden(String filename);

    void speichern(String filename);
}
