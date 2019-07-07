package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.PlayerGroup;
import view.SkatFrame;

public class SubmitPlayerAL implements ActionListener{
PlayerGroup group;	
JFrame frame;	
	public SubmitPlayerAL(PlayerGroup group, JFrame frame) {
		this.group = group;
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		 new SkatFrame(group);
		 frame.dispose();
		
	}
		
}
