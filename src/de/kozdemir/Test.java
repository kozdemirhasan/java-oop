package de.kozdemir;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Test {
	static int count = 10;

	public static void main(String[] args) {

	
		new Timer(1_000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println(count--);
				Toolkit.getDefaultToolkit().beep();
					
			}
		}).start();
	
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);

	}

}
