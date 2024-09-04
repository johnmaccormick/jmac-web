/**
 * A class that maintains information about a song. It may
 * be used in the construction of an audio player.
 * 
 * @author Grant Braught, Tim Wahls, Louis Ziantz
 * @author (YOUR NAME HERE)
 * @version (PUT DATE HERE)
 */
public class Song {

	private String songName;
	private String fileName;
	private String artistName;
	private String albumName;
	private int rating;

	/**
	 * Create a new Song.
	 * 
	 * @param initSongName
	 *            the name of the Song.
	 * @param initFileName
	 *            the name of the audio file for the Song.
	 * @param initArtistName
	 *            the name of the Song's artist.
	 * @param initAlbumName
	 *            the name of the album that contains the
	 *            Song.
	 * @param initRating
	 *            the rating of the Song.
	 */
	public Song(String initSongName, String initFileName,
			String initArtistName, String initAlbumName,
			int initRating) {
		songName = initSongName;
		fileName = initFileName;
		artistName = initArtistName;
		albumName = initAlbumName;
		rating = initRating;
	}

	/**
	 * Returns the name of the Song.
	 * 
	 * @return the name of the Song.
	 */
	public String getSongName() {
		return songName; 
	}

	/**
	 * Returns the name of the audio file associated with
	 * the Song.
	 * 
	 * @return the name of the audio file for the Song.
	 */
	public String getFileName() {
		return fileName; 
	}

	/**
	 * Returns the name of the Song's artist.
	 * 
	 * @return the name of the Song's artist.
	 */
	public String getArtistName() {
		return artistName; 
	}

	/**
	 * Returns the name of the album on which the Song
	 * resides.
	 * 
	 * @return the name of the album on which the Song
	 *         resides.
	 */
	public String getAlbumName() {
		return albumName; 
	}

	/**
	 * Returns the Song's rating.
	 * 
	 * @return the Song's rating.
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Sets the rating associated with the song. A valid
	 * rating ranges from 0 to 5. The current rating remains
	 * unchanged if a value less than 0 or greater than 5 is
	 * passed to the method. Further, an error message is
	 * output if a value outside of the range from 0 to 5 is
	 * passed to the method.
	 * 
	 * @param newRating
	 *            An int representing the new value of the
	 *            rating.
	 */
	public void setRating(int newRating) {
		if (newRating >= 0 && newRating <= 5) {
			rating = newRating;
		} else {
			System.out.println("invalid rating");
		}
	}

	/**
	 * Generate and return a String containing all of the
	 * information about this Song. The String contains the
	 * name, artist, album, filename and rating of the song
	 * in an easy to read intelligible format.
	 * 
	 * @return a String describing this Song.
	 */
	public String toString() {
		// add to the next line -- it is only partially
		// correct
		return songName + ", " + artistName;
	}

	/**
	 * Returns true if two songs are equal. Two two songs
	 * are considered to be the same if they have the same
	 * song name, artist name and album name and rating.
	 * 
	 * @param song2
	 *            The second song to be compared.
	 * @return true if two Songs are equal and false
	 *         otherwise.
	 */
	public boolean equals(Song song2) {
		if (this.songName.equals(song2.songName)
				&& this.artistName.equals(song2.artistName)
		// insert some more code here -- this Boolean
		// expression is not yet complete
		) {
			return true;
		} else {
			return false;
		}
	}
}