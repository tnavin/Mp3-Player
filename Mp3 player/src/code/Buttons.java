package code;

import java.io.FileInputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class Buttons {
	
	private AdvancedPlayer playMP3;
	
	public Buttons(){
		
	}
	
	public void playSong(){
		try{

		    FileInputStream fis = new FileInputStream("res\\music\\Jubel.mp3");
		    playMP3 = new AdvancedPlayer(fis);
		    
		    playMP3.play();
		    
		    }
		catch(Exception e){
			System.out.println(e);
			}
	}
	
	public void stopSong(){
		playMP3.stop();
	}
}
