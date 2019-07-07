package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.PlayerGroup;

import java.awt.*;



/**
 * @author Joel Oswald
 * @ersion: 2019.07.07
 * 
 **/

public class SkatFrame extends JFrame {
PlayerGroup pgroup;
Container c;

public SkatFrame(PlayerGroup pgroup) {
	this.pgroup = pgroup;
	this.setVisible(true);
	this.setSize(400, 150);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	try {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e) {

		e.printStackTrace();
	}

	SwingUtilities.updateComponentTreeUI(this);
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	
	
	
	
	c= getContentPane();
	this.setTitle("Spieler Hinzufügen");
	
	
	
	
}


}
