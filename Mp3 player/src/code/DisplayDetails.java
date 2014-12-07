package code;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class DisplayDetails extends JPanel{
	
	 JPanel imagedisplay = new JPanel(new MigLayout("Debug"));
	JLabel ta = new JLabel();
	
	public DisplayDetails(){
		
		ta.setText("Please fucking work");
		imagedisplay.add(ta);
		ImageIcon icon = new ImageIcon("C:\\Users\\Tommie\\Documents\\GMIT\\Mp3_player\\Mp3-Player\\Mp3 player\\res\\images\\Jubel.jpg");
		JLabel label1   = new JLabel();
		label1.setIcon(icon);
		imagedisplay.add(label1);

	}


	public JPanel getImagedisplay() {
		return imagedisplay;
	}



	public void setImagedisplay(JPanel imagedisplay) {
		this.imagedisplay = imagedisplay;
	}
	

	

}
