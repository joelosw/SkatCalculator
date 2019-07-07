package controller;
/**
 * @author Joel Oswald
 * @ersion: 2019.07.07
 * 
 **/

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.text.JTextComponent;

public class TextFieldListener implements FocusListener {
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void focusGained(FocusEvent e) {
		((JTextComponent) e.getSource()).setText("");
		
	}
}
