package code;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

public class listOfTracks extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel songPanel = new JPanel(new MigLayout("Debug"));
	private JPanel artistPanel = new JPanel(new MigLayout("Debug"));
	private JList<SongObject> songsListBox;
	
	public listOfTracks() {

	}

	public void setSongPanel() {

		//songPanel.add(songsListBox, "span, grow");
	}

	public void setArtistPanel() {
		JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("JList Test");
	    frame.setLayout(new FlowLayout());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    String[] selections = { "green", "red", "orange", "dark blue" };
	    JList list = new JList(selections);
	    list.setSelectedIndex(1);
	    System.out.println(list.getSelectedValue());
	    frame.add(new JScrollPane(list));
	    frame.pack();

	    frame.setVisible(true);
	}


	public JPanel getSongPanel() {
		return songPanel;
	}

	public JPanel getArtistPanel() {
		return artistPanel;
	}


}
