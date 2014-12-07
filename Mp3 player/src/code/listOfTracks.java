package code;

import java.io.File;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;

public class listOfTracks extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private File currentSelectedSong;
	private JPanel songPanel = new JPanel(new MigLayout("Debug"));
	private JPanel artistPanel = new JPanel(new MigLayout("Debug"));
	private JScrollPane scrollListSong;
	private JList<File> listSong;
	private List<File> currentSelectedSongList;
	
	public listOfTracks() {

	}

	public void setSongPanel() {

		listSong = new JList<File>(getListFromFolder("res\\music"));
		scrollListSong = new JScrollPane(listSong);
	    artistPanel.add(scrollListSong);
	    
	    ListSelectionListener listSelectionListener = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				boolean adjust = listSong.getValueIsAdjusting();
				if(!adjust){
					currentSelectedSongList = listSong.getSelectedValuesList();
					currentSelectedSong = currentSelectedSongList.get(0);
					System.out.println(currentSelectedSong);
				}
			}
	    };
	    listSong.addListSelectionListener(listSelectionListener);
	}

	public void setArtistPanel() {

		
	}


	public JPanel getSongPanel() {
		return songPanel;
	}

	public JPanel getArtistPanel() {
		return artistPanel;
	}
	
	public File[] getListFromFolder(String path){
		File folder = new File(path);
		File[] list = folder.listFiles();
		  
		return list;
	}

	public File getCurrentSelectedSong() {
		return currentSelectedSong;
	}

}
