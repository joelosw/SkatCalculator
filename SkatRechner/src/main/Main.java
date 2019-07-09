/**
 * 
 */
package main;

import java.awt.Font;

import javax.swing.UIManager;

import view.AddPlayerFrame;

/**
 * @author Joel Oswald
 * @ersion: 2019.07.07
 * 
 **/

public class Main {

	public static void main(String[] args0) {
		System.out.println("Hello again!");
		UIManager.getLookAndFeelDefaults()
	    .put("defaultFont", new Font("Arial", Font.BOLD, 18));
		
		AddPlayerFrame f = new AddPlayerFrame();
		
	}
	
	
}
