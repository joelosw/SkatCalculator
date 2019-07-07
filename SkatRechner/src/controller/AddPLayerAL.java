package controller;
import java.awt.event.*;

import javax.swing.JTextField;

import model.Player;
import model.PlayerGroup;

public class AddPLayerAL implements ActionListener{
PlayerGroup group;
JTextField nameField;
	
	public AddPLayerAL(PlayerGroup group, JTextField nameField) {
	this.group = group;
	this.nameField = nameField;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		Player newp = new Player(nameField.getText());
		
		group.addPLayer(newp);
		
		nameField.setText("");
		
	}

}
