package code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.miginfocom.swing.MigLayout;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.ID3v1;

public class listOfTracks extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> artistList;
	private File currentSelectedSong;
	private JPanel songPanel = new JPanel(new MigLayout("Debug"));
	private JPanel artistPanel = new JPanel(new MigLayout("Debug"));
	private JPanel imagedisplay = new JPanel(new MigLayout("Debug"));
	private JLabel ta = new JLabel();
	private JScrollPane scrollListSong;
	private JScrollPane scrollListArtist;
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
					ta.setText(getCurrentSelectedSong().toString());
					imagedisplay.add(ta);
					ImageIcon icon = new ImageIcon("res\\images\\Jubel.jpg");
					JLabel label1   = new JLabel();
					label1.setIcon(icon);
					imagedisplay.add(label1);

			
				}
			}
	    };
	    listSong.addListSelectionListener(listSelectionListener);
	}

	public void setArtistPanel() {
		File[] MP3list = getListFromFolder("res\\music");
		artistList = new ArrayList<>();
		for(File file : MP3list){
			File src = new File(file.getAbsolutePath());
			try {
				ID3v1 tag = new MP3File(src).getID3v1Tag();
				artistList.add(tag.getArtist());
				System.out.println(tag.getArtist());
			} catch (IOException | TagException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}


	public JPanel getSongPanel() {
		return songPanel;
	}

	public JPanel getArtistPanel() {
		return artistPanel;
	}
	public JPanel getDisplayPanel() {
		return imagedisplay;
	}
	
	public File[] getListFromFolder(String path){
		File folder = new File(path);
		File[] list = folder.listFiles();
		  
		return list;
	}

	public File getCurrentSelectedSong() {
		return currentSelectedSong;
	}

	public ArrayList<String> getArtistList() {
		return artistList;
	}
	
	

}
