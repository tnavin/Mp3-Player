package code;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MainWindow {

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
		
		JPanel splitPanel = new JPanel();
		frame.getContentPane().add(splitPanel, "cell 0 1,grow");
		splitPanel.setLayout(new MigLayout("", "[grow,left][grow,right]", "[grow,center]"));
		
		JPanel seanPanel = new JPanel();
		seanPanel.setBackground(SystemColor.activeCaption);
		splitPanel.add(seanPanel, "cell 0 0,grow");
		
		JPanel tommiePanel = new JPanel();
		tommiePanel.setBackground(SystemColor.activeCaption);
		splitPanel.add(tommiePanel, "cell 1 0,grow");
	}

}
