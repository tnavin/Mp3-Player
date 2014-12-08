package code;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import net.miginfocom.swing.MigLayout;

public class MainWindow {

	private Buttons buttons;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow,center]", "[100px:n:100px,grow][grow]"));
		
		JPanel johnPanel = new JPanel();
		johnPanel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(johnPanel, "cell 0 0,grow");

		//play song in the background thread
		SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				buttons = new Buttons();
				buttons.playSong();
				return null;
			}

			
		};
		sw.execute();
		
		buttons.stopSong();

		JPanel splitPanel = new JPanel();
		frame.getContentPane().add(splitPanel, "cell 0 1,grow");
		splitPanel.setLayout(new MigLayout("", "[grow,left][grow,right]", "[grow,center]"));

		JTabbedPane seanTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		listOfTracks tracks = new listOfTracks();
		songsSetup(tracks);
		seanTabbedPane.add("Artists", tracks.getArtistPanel());
		seanTabbedPane.add("Songs", tracks.getSongPanel());
		splitPanel.add(seanTabbedPane, "cell 0 0,grow");
		
		JPanel tommiePanel = new JPanel();
		
		
		tommiePanel.add(tracks.getDisplayPanel());
		
		splitPanel.add(tommiePanel, "cell 1 0,grow");
	}
	
	private void songsSetup(listOfTracks tracks){

		tracks.setArtistPanel();
		tracks.setSongPanel();
	}

}
