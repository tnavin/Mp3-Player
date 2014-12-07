package code;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class listOfTracks extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel songPanel = new JPanel(new MigLayout("Debug"));
	private JPanel artistPanel = new JPanel(new MigLayout("Debug"));
	private JPanel albumPanel = new JPanel(new MigLayout("Debug"));
	private JList<String> songsListBox;
	
	public listOfTracks() {
		
	}

	public void setSongPanel() {
		ArrayList<String> songList = new ArrayList<String>();
		songList.add("First");
		songList.add("Second");

		songsListBox = new JList(songList.toArray());
		songPanel.add(songsListBox, "span, grow");
	}

	public void setArtistPanel() {
		
	}

	public void setAlbumPanel() {
		List album = new List();
		album.add("First Album");
		album.add("Second Album");
		album.add("Third Album");
		albumPanel.add(album);
	}

	public JPanel getSongPanel() {
		return songPanel;
	}

	public JPanel getArtistPanel() {
		return artistPanel;
	}

	public JPanel getAlbumPanel() {
		return albumPanel;
	}

}
