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
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.ID3v1;

public class listOfTracks extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> artistList;
	private ArrayList<String> songList;
	private ArrayList<String> albumList;
	private String currentSelectedSong;
	private StringBuilder sb = new StringBuilder(64);
	private JPanel songPanel = new JPanel(new MigLayout("Debug"));
	private JPanel artistPanel = new JPanel(new MigLayout("Debug"));
	private JPanel imagedisplay = new JPanel(new MigLayout("Debug"));
	private ImageIcon icon = new ImageIcon("res\\images\\Jubel.jpg");
	private ImageIcon icon2 = new ImageIcon("res\\images\\Taylor Swift.jpg");
	private JLabel label1   = new JLabel();
	private JTextArea ta = new JTextArea();
	private JScrollPane scrollListSong;
	private JScrollPane scrollListArtist;
	private JList<String> listSong;
	private JList<String> listArtist;
	private List<String> currentSelectedSongList;
	
	public listOfTracks() {
		
		
	}

	public void setSongPanel() {
		File[] MP3list = getListFromFolder("res\\music");
		
		//Get the songs name
		songList = new ArrayList<>();
		artistList = new ArrayList<>();
		albumList = new ArrayList<>();
		for(File file : MP3list){
			File src = new File(file.getAbsolutePath());
			try {
				ID3v1 tag = new MP3File(src).getID3v1Tag();

				songList.add(tag.getTitle());
				artistList.add(tag.getArtist());
				albumList.add(tag.getAlbum());
				System.out.println(tag.getTitle());

			} catch (IOException | TagException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Convert the songs to a string array and add them to list
		String[] songArr = new String[songList.size()];
		songArr = songList.toArray(songArr);
		listSong = new JList<String>(songArr);
		scrollListSong = new JScrollPane(listSong);
		//add the list to a panel
	    songPanel.add(scrollListSong);
	    
	    ListSelectionListener listSelectionListener = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				boolean adjust = listSong.getValueIsAdjusting();
				if(!adjust){
					currentSelectedSongList = listSong.getSelectedValuesList();
					int i = listSong.getSelectedIndex();
					
					currentSelectedSong = currentSelectedSongList.get(0);

					if(getCurrentSelectedSong().toString().equalsIgnoreCase("Jubel")){
						label1.setIcon(icon);
					}
					else{
						label1.setIcon(icon2);
					}
				

					System.out.println(currentSelectedSong);
					
					sb.append("Song Title: " + songList.get(i)).
					append("\nSong Artist: " + artistList.get(i)).
					append("\nSong Album: " + albumList.get(i));
					
					ta.setText(sb.toString());
					ta.setEditable(false);
					sb.setLength(0);
					imagedisplay.add(ta);
					imagedisplay.add(label1);

				}
			}
	    };
	    listSong.addListSelectionListener(listSelectionListener);
	}
	//Get the artist name and list it out
	public void setArtistPanel() {
		File[] MP3list = getListFromFolder("res\\music");
		
		//Get the songs name
		songList = new ArrayList<>();
		artistList = new ArrayList<>();
		albumList = new ArrayList<>();
		for(File file : MP3list){
			File src = new File(file.getAbsolutePath());
			try {
				ID3v1 tag = new MP3File(src).getID3v1Tag();
				songList.add(tag.getTitle());
				artistList.add(tag.getArtist());
				albumList.add(tag.getAlbum());
				System.out.println(tag.getArtist());
				ta.setText(tag.getArtist());
	
				
			} catch (IOException | TagException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Convert the songs to a string array and add them to list
		String[] artistArr = new String[artistList.size()];
		artistArr = artistList.toArray(artistArr);
		listArtist = new JList<String>(artistArr);
		scrollListArtist = new JScrollPane(listArtist);
		//add the list to a panel
	    artistPanel.add(scrollListArtist);
	    
	    ListSelectionListener listSelectionListener = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				boolean adjust = listArtist.getValueIsAdjusting();
				if(!adjust){
					currentSelectedSongList = listArtist.getSelectedValuesList();
					
					int i = listSong.getSelectedIndex();
					currentSelectedSong = currentSelectedSongList.get(0);
					System.out.println(currentSelectedSong);

					if(getCurrentSelectedSong().toString().equalsIgnoreCase("Taylor Swift")){
						label1.setIcon(icon2);
						
					}
					else{
						label1.setIcon(icon);
					}
				

					sb.append("Song Title: " + songList.get(i)).
					append("\nSong Artist: " + artistList.get(i)).
					append("\nSong Album: " + albumList.get(i));
					
					ta.setText(sb.toString());
					ta.setEditable(false);
					sb.setLength(0);
					imagedisplay.add(ta);
					imagedisplay.add(label1);
				

			
				}
			}
	    };
	    listArtist.addListSelectionListener(listSelectionListener);
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

	public String getCurrentSelectedSong() {
		return currentSelectedSong;
	}

	public ArrayList<String> getArtistList() {
		return artistList;
	}
	
	public ArrayList<String> getSongList() {
		return songList;
	}
	
	

}
