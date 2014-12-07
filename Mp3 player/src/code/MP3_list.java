package code;

import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JPanel;

public class MP3_list extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MP3_list() {
		
		JList list = new JList();
		
		addTab("Songs", null, list, null);
		
		JPanel panel = new JPanel();
		addTab("Playlist", null, panel, null);

	}

}
