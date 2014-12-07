package code;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.List;

public class listOfTracks extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public listOfTracks() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel artists = new JPanel();
		JPanel albums = new JPanel();
		tabbedPane.add("Artists", artists);
		tabbedPane.add("Albums", albums);
		List songList = new List();
		
		songList.add("First");
		songList.add("Sean", 0);
		
		tabbedPane.add("Songs", songList);
		
		

		setVisible(true); 
	}

}
