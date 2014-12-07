package code;

public class SongObject {

	private String name;
	private String album;
	private String artist;
	private String songPath;
	
	public SongObject(String name,
			String artist,
			String album,
			String songPath) {
		
		this.name = name;
		this.album = album; 
		this.artist = artist;
		this.songPath = songPath;
	}

	public String getName() {
		return name;
	}

	public String getAlbum() {
		return album;
	}

	public String getArtist() {
		return artist;
	}

	public String getSongPath() {
		return songPath;
	}
	
	

}
