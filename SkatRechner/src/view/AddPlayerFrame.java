package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.JTextComponent;

import controller.AddPLayerAL;
import controller.SubmitPlayerAL;
import controller.TextFieldListener;
import model.PlayerGroup;

public class AddPlayerFrame extends JFrame {
Container c;
JLabel lname;
JTextField tname;
JButton badd;
JButton bdone;
JPanel pname;
JPanel pbuttons;

PlayerGroup group;


public AddPlayerFrame() {
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
	
	c.setLayout(new GridLayout(2, 1) );
	group = new PlayerGroup();
	lname= new JLabel("Name: ");
	tname = new JTextField(" Bitte hier den Namen eingeben ");
	badd = new JButton("Hinzufügen");
	bdone = new JButton("Fertig");
	pname = new JPanel();
	pbuttons = new JPanel();
	
	
	
	pname.add(lname);
	pname.add(tname);
	
	badd.addActionListener(new AddPLayerAL(group, tname));
	bdone.addActionListener(new SubmitPlayerAL(group, this));
	
	pbuttons.add(badd);
	pbuttons.add(bdone);
	

	FocusListener fL = new TextFieldListener();
	
	tname.addFocusListener(fL);
	
	c.add(pname);
	c.add(pbuttons);
	
	this.setSize(450, 160);
	this.getRootPane().setDefaultButton(badd);
}


}
