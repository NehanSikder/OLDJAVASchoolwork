//Arham Sikder Ans2ur, Lab section 103, HW 1
public class Song {

	private String artist;
	/** the artist performing the song **/
	private String title;
	/** the title of the song **/
	private int minutes;
	/** number of min in length **/
	private int seconds; /** number of seconds of length of the song **/

	/** Constructor 1 **/
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}

	/** Constructor 2 **/
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/** Constructor 3 that takes song as a parameter **/
	public Song(Song s) {
		this.artist = s.artist;
		this.title = s.title;
		this.minutes = s.minutes;
		this.seconds = s.seconds;
	}

	/**
	 * Compares two song objects in order to determine if they have the same
	 * artist, title and length
	 **/
	public boolean equals(Object o) {
		if (o instanceof Song) {
			Song s = (Song) o;
			return (this.artist.equals(s.artist) && this.title.equals(s.title) && this.minutes == s.minutes
					&& this.seconds == s.seconds);
		}
		return false;
	}

	/** Plays the song **/
	public void play() {
		System.out.printf("Playing Song: artist=%-20s title=%s\n", artist, title);
	}

	/** Returns a string containing the title and artist of a song **/
	@Override
	public String toString() {
		return "{Song: title=" + title + " artist=" + artist + "}";
	}

	/** Gets artist **/
	public String getArtist() {
		return artist;
	}

	/** Sets artist **/
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/** Gets title **/
	public String getTitle() {
		return title;
	}

	/** sets title **/
	public void setTitle(String title) {
		this.title = title;
	}

	/** Gets minutes **/
	public int getMinutes() {
		return minutes;
	}

	/** Sets minutes **/
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/** Gets seconds **/
	public int getSeconds() {
		return seconds;
	}

	/** sets Seconds **/
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
