package controller;

/**
 * @author Joel Oswald
 * @ersion: 2019.07.07
 * 
 **/


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Player;
import model.PlayerGroup;
import model.SkatTableModel;
import view.SkatFrame;

public class AddPointsAL implements ActionListener {
	public PlayerGroup pgroup;
	public JTextField tpoints;
	public JComboBox<Player> cbPlayer;
	public SkatFrame frame;
	SkatTableModel dm;
	public AddPointsAL(PlayerGroup pgroup, JTextField tpoints, JComboBox<Player> cbPlayer, SkatFrame frame, SkatTableModel dm) {
		super();
		this.pgroup = pgroup;
		this.tpoints = tpoints;
		this.cbPlayer = cbPlayer;
		this.frame = frame;
		this.dm=dm;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Player p = (Player) cbPlayer.getSelectedItem();
		try {
			int points = Integer.parseInt(tpoints.getText());
			p.AddPoints(points);
			dm.setValueAt(points, dm.getRowCount()-1, cbPlayer.getSelectedIndex()+1);
			tpoints.setText("0000");
			frame.createPLayerPoints();
			frame.createPLayerDebt();
			frame.repaint();
			frame.revalidate();
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(frame, "Achtung, keine gültige Zahl eingegeben! \n Eingabe wurde icht akzeptiert","Falsche Eingabe", JOptionPane.ERROR_MESSAGE );
		}
	}

}
