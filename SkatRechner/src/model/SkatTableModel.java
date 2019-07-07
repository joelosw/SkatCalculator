package model;
/**
 * @author Joel Oswald
 * @ersion: 2019.07.07
 * 
 **/

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;


public class SkatTableModel extends AbstractTableModel{
PlayerGroup pgroup;
List<Player> players;
List<String> names;
int rowcount;
int colcount;
List<int[]> values;
	public SkatTableModel(PlayerGroup pgroup) {
	super();
	this.pgroup = pgroup;
	players = pgroup.players;
	colcount = players.size() +1;
	names = new ArrayList<String>();
	names.add("Spiel # ");
	for(Player p : players) {
		names.add(p.name);
	}
	
	values = new ArrayList<int[]>();
	
}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowcount;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colcount;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		System.out.println("Get Column Names aufgerufe, mit Index und Wert: " + columnIndex + names.get(columnIndex));
		return names.get(columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return values.get(rowIndex)[columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		int length = names.size();
		int[] row = new int[length];
		row[columnIndex] = (int) aValue;
		row[0] = rowcount +1;
		values.add(row);
		rowcount++;
		fireTableCellUpdated(rowIndex, columnIndex);
		fireTableDataChanged();
	System.out.println("Neuer Wert Gesetzt: " + aValue + " es gibt jetzt Spalten: " + rowcount);
	}

	

}
