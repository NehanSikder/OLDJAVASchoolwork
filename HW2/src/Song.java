/**
 * Scott Miller (smm7cb) Homework 1 Lab section 103
 **/

public class Song implements Comparable<Song>, Playable {

	private String artist;
	private String title;
	private int minutes;
	private int seconds;

	public Song(String artist, String title) {
		/** Assigning values to this.artist and this.title **/
		this.artist = artist;
		this.title = title;
	}

	public Song(String artist, String title, int minutes, int seconds) {
		/**
		 * Assigning all the aspects of the "Song" to those given in the
		 * parenthesis
		 **/
		/**
		 * if (seconds < 0) throw new IllegalArgumentException(
		 * "The seconds should be greater or equal to zero");
		 **/
		while (seconds >= 60) {
			minutes++;
			seconds -= 60;
		}
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public Song(Song s) {
		/** Setting the values of Song s to those of a Song **/
		this.artist = s.artist;
		this.title = s.title;
		this.minutes = s.minutes;
		this.seconds = s.seconds;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		while (seconds >= 60) {
			this.minutes++;
			seconds -= 60;
		}
		this.seconds = seconds;
	}

	public boolean equals(Object o) {
		/** Ensuring that the object presented is a Song **/
		if (o instanceof Song) {
			Song song1 = (Song) o;
			return (this.artist.equals(song1.artist))
					&& (this.title.equals(song1.title))
					&& (this.minutes == (song1.minutes))
					&& (this.seconds == (song1.seconds));
		}
		return false;
	}

	public String toString() {
		/** Providing the user with a specified output **/
		return "{Song: title= " + title + " and the artist is= " + artist + "}";
	}

	public void play() {
		/** Going through and printing which songs are played **/
		System.out
				.printf("Playing Song: artist=%-20s title=%sn", artist, title);
	}

	@Override
	public int compareTo(Song s2) {
		int val = this.artist.compareTo(s2.artist);
		if (val != 0) {
			return val;
		}
		val = this.title.compareTo(s2.title);
		if (val != 0) {
			return val;
		}
		return val;
	}

	@Override
	public String getName() {
		return this.title;
	}

	@Override
	public int getPlayTimeSeconds() {
		return this.seconds + (this.minutes * 60);
	}
}
