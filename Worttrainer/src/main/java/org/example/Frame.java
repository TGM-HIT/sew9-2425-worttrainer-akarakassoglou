package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * Frame Klasse des Worttrainers
 * @author André Karakassoglou
 * @version 2024-10-16
 */

public class Frame extends JFrame {
	public Frame(Panel fensterlayout) {
		super("WortTrainer von André Karakassoglou");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.add(fensterlayout);
		this.setBounds(0, 0, 900, 750);
		this.setVisible(true);
	}


}