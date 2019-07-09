package view;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import controller.AddPointsAL;
import controller.TextFieldListener;

import model.Player;
import model.PlayerGroup;
import model.SkatTableModel;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Joel Oswald
 * @ersion: 2019.07.07
 * 
 **/
// Serialisierbarkeit to be implemented (Fragen wenn geschlossen werden soll....)
public class SkatFrame extends JFrame {
	PlayerGroup pgroup;
	Container c;
	JSplitPane split;

	JScrollPane scrollPoints, scrollDebt, scrollRounds;
	JPanel pPunkte, pDebt, pTable, pAddRound, pLinks, pRechts, pAdd;
	JComboBox<model.Player> cbPlayer;
	JLabel ladd;
	JButton badd;
	JTextField tadd;
	JTable trounds;
	public SkatTableModel dm;
	public DefaultTableModel dm2;
	int roundsplayed;

public SkatFrame(PlayerGroup pgroup) {
	
	UIManager.getLookAndFeelDefaults()
    .put("defaultFont", new Font("Arial", Font.BOLD, 18));
	
	
	this.pgroup = pgroup;
	this.setVisible(true);
	this.setSize(800, 400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * try {
		 * UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); }
		 * catch (ClassNotFoundException | InstantiationException |
		 * IllegalAccessException | UnsupportedLookAndFeelException e) {
		 * 
		 * e.printStackTrace(); }
		 */

	SwingUtilities.updateComponentTreeUI(this);
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	
	
	
	
	c= getContentPane();
	this.setTitle("Skatspielrechner");
	
	split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	pPunkte = new JPanel(new GridLayout(pgroup.players.size(),2));
	pDebt =  new JPanel(new GridLayout(pgroup.players.size(),2));
	
	createPLayerPoints();
	createPLayerDebt();
	
	
	pLinks = new JPanel(new GridLayout(2, 1));
	scrollPoints = new JScrollPane(pPunkte);
	scrollDebt = new JScrollPane(pDebt);
	
	pLinks.add(scrollPoints);
	pLinks.add(scrollDebt);
	split.add(pLinks);
	
	

	pAdd = new JPanel();
	
	tadd = new JTextField("000000");
	tadd.setSize(30, 50);
	tadd.addFocusListener(new TextFieldListener());
	pAdd.add(tadd);
	
	ladd  = new JLabel("Punkte für: ");
	pAdd.add(ladd);
	cbPlayer = new JComboBox<Player>();
	for(Player p : pgroup.players) {
		cbPlayer.addItem(p);
	}
	pAdd.add(cbPlayer);
	
	
	badd = new JButton("Hinzufügen");
	badd.setSize(50,30);
	
	pAdd.add(badd);
	
	
	pRechts = new JPanel(new BorderLayout());
	
	pRechts.add(pAdd, BorderLayout.SOUTH);
	
	

	dm = new SkatTableModel(pgroup);
	//dm2 = createTM();
	//dm2.addRow(pgroup.players.toArray());
	trounds = new JTable(dm);
	
	scrollPoints = new JScrollPane();
	scrollPoints.add(trounds);
	pRechts.add(new JScrollPane(trounds), BorderLayout.CENTER);
	
	badd.addActionListener(new AddPointsAL(pgroup, tadd, cbPlayer, this, dm));
	split.add(pRechts);
	split.setDividerLocation(200);
	c.add(split);
	
	
	
	
	
}

public void createPLayerPoints() {
	pPunkte.removeAll();
	for(Player p: pgroup.players ) {
		JLabel nameLab = new JLabel(p.toString() + ": ");
		JLabel pointsLab = new JLabel(Integer.toString(p.points) + " Punkte");
		pPunkte.add(nameLab );
		pPunkte.add(pointsLab);	
	
	}
}

public void createPLayerDebt() {
	pgroup.caculateDebts();
	pDebt.removeAll();
	for(Player p: pgroup.players ) {
		JLabel nameLab = new JLabel(p.toString() + ": ");
		JLabel debtLab = new JLabel(Integer.toString(p.debt) + " Cent");
		pDebt.add(nameLab );
		pDebt.add(debtLab);	
		
	}
}

public DefaultTableModel createTM() {
	DefaultTableModel dm2= new DefaultTableModel();
	dm2.setColumnCount(pgroup.players.size()+1);
	ArrayList<String> names = new ArrayList<String>();
	names.add("Runde");
	for(Player p : pgroup.players) {
		names.add(p.name);
	}
	
	dm2.setColumnIdentifiers(names.toArray());
	return dm2;
}


}
