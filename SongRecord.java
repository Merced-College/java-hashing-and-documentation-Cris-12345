//package hashingAndDocumentation;

/**
 * The SongRecord class represents the details of a single song.
 * It parses song metadata from a CSV-formatted string and stores various attributes such as
 * artist, song ID, audio features (like valence, energy, etc.), popularity, and more.
 *
 * This class is primarily used in the SongProgram to load and retrieve song data efficiently.
 * 
 * @author Cristopher Gomez or the author of program I was unsure if i was meant to write an author or myself
 * @version 1.0
 */ 



import java.util.List;
import java.util.Arrays;
import java.util.Objects;


/**
 * Represents a song record containing metadata such as acousticness,
 * valence, artists, energy, etc. Designed to be used in a music database application.
 */ 
public class SongRecord {
    // Instance variables
    private double valence;
    private int year;
    private double acousticness;
    private List<String> artists;
    private double danceability;
    private int durationMs;
    private double energy;
    private int explicit;
    private String id;
    private double instrumentalness;
    private int key;
    private double liveness;
    private double loudness;
    private int mode;
    private String name;
    private int popularity;
    private String releaseDate;
    private double speechiness;
    private double tempo;

     
    /**
     * Default constructor that initializes the song with default or placeholder values.
     * 
     * Precondition: None
     * Postcondition: A SongRecord object is created with default values.
     */
      
    // Default constructor
    public SongRecord() {
        this.valence = 0.0;
        this.year = 0;
        this.acousticness = 0.0;
        this.artists = Arrays.asList("Unknown Artist");
        this.danceability = 0.0;
        this.durationMs = 0;
        this.energy = 0.0;
        this.explicit = 0;
        this.id = "";
        this.instrumentalness = 0.0;
        this.key = 0;
        this.liveness = 0.0;
        this.loudness = 0.0;
        this.mode = 0;
        this.name = "Unknown Title";
        this.popularity = 0;
        this.releaseDate = "0";
        this.speechiness = 0.0;
        this.tempo = 0.0;
    }


    
     /**
     * Constructs a SongRecord from a CSV line.
     * 
     * 
     * param data A CSV-formatted string with fields in expected order.
     * 
     * Precondition: data must be correctly formatted with 19 values.
     * Postcondition: Object fields initialized from data.
     */
    // Constructor that takes a CSV string and parses it
    public SongRecord(String data) {
        String[] fields = data.split(","); // Assuming comma-separated values
        
    	//fields = data.split(",");//means no quotes in the record
    	
    	/*System.out.println("fields length " + fields.length);
    	for(int i = 0; i < fields.length; i++) {
        	System.out.println("fields " + i + " = " + fields[i]);
        }*/

        // parse and assign each field from the cvs line 
    	this.valence = Double.parseDouble(fields[0]);
        this.year = Integer.parseInt(fields[1]);
        this.acousticness = Double.parseDouble(fields[2]);
        this.artists = Arrays.asList(fields[3].replaceAll("[\\[\\]']", "").split(";")); // remove braackets and split artists if multiple artists are listed 
        this.danceability = Double.parseDouble(fields[4]);
        this.durationMs = Integer.parseInt(fields[5]);
        this.energy = Double.parseDouble(fields[6]);
        this.explicit = Integer.parseInt(fields[7]);
        this.id = fields[8];
        this.instrumentalness = Double.parseDouble(fields[9]);
        this.key = Integer.parseInt(fields[10]);
        this.liveness = Double.parseDouble(fields[11]);
        this.loudness = Double.parseDouble(fields[12]);
        this.mode = Integer.parseInt(fields[13]);
        this.name = fields[14];
        this.popularity = Integer.parseInt(fields[15]);
        this.releaseDate = fields[16];
        this.speechiness = Double.parseDouble(fields[17]);
        this.tempo = Double.parseDouble(fields[18]);
    
    }

     // ===== Getter and Setter Methods =====
    
       /** @return the valence of the song */
    public double getValence() { return valence; }

     /** @param valence the valence to set */
    public void setValence(double valence) { this.valence = valence; }

      /** @return the release year of the song */
    public int getYear() { return year; }

       
     /** @param year the release year to set */
    public void setYear(int year) { this.year = year; }

     /** @return the acousticness of the song */
    public double getAcousticness() { return acousticness; }

     /** @param acousticness the acousticness to set */
    public void setAcousticness(double acousticness) { this.acousticness = acousticness; }

      /** @return a list of artist names */
    public List<String> getArtists() { return artists; }

     /** @param artists the list of artists to set */
    public void setArtists(List<String> artists) { this.artists = artists; }

     /** @return the danceability score of the song */
    public double getDanceability() { return danceability; }

     /** @param danceability the danceability to set */
    public void setDanceability(double danceability) { this.danceability = danceability; }

     /** @return the duration of the song in milliseconds */
    public int getDurationMs() { return durationMs; }

     /** @param durationMs the duration in ms to set */
    public void setDurationMs(int durationMs) { this.durationMs = durationMs; }

     /** @return the energy level of the song */
    public double getEnergy() { return energy; }

     /** @param energy the energy value to set */
    public void setEnergy(double energy) { this.energy = energy; }

     /** @return 1 if the song is explicit, 0 otherwise */
    public int getExplicit() { return explicit; }

     /** @param explicit the explicit value to set (1 = explicit, 0 = not) */
    public void setExplicit(int explicit) { this.explicit = explicit; }

     /** @return the unique ID of the song */
    public String getId() { return id; }
    
      /** @param id the unique ID to set */
    public void setId(String id) { this.id = id; }

      /** @return the instrumentalness of the song */
    public double getInstrumentalness() { return instrumentalness; }
   
     /** @param instrumentalness the value to set */
    public void setInstrumentalness(double instrumentalness) { this.instrumentalness = instrumentalness; }

      /** @return the musical key of the song */
    public int getKey() { return key; }
       
     /** @param key the musical key to set */
    public void setKey(int key) { this.key = key; }

     /** @return the liveness score of the song */
    public double getLiveness() { return liveness; }
   
      /** @param liveness the liveness to set */
    public void setLiveness(double liveness) { this.liveness = liveness; }

      /** @return the loudness in decibels */
    public double getLoudness() { return loudness; }
    
        /** @param loudness the loudness to set */
    public void setLoudness(double loudness) { this.loudness = loudness; }

      /** @return the mode (major/minor) */
    public int getMode() { return mode; }
   
      /** @param mode the mode to set (1 = major, 0 = minor) */ 
    public void setMode(int mode) { this.mode = mode; }

      /** @return the name/title of the song */ 
    public String getName() { return name; }
   
      /** @param name the song title to set */  
    public void setName(String name) { this.name = name; }

       /** @return the popularity score (0–100) */
    public int getPopularity() { return popularity; }
    
      /** @param popularity the popularity value to set */
    public void setPopularity(int popularity) { this.popularity = popularity; }

      /** @return the release date of the song */
    public String getReleaseDate() { return releaseDate; }
   
     /** @param releaseDate the release date to set */
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

       /** @return the speechiness score of the song */
    public double getSpeechiness() { return speechiness; }
   
       /** @param speechiness the speechiness value to set */
    public void setSpeechiness(double speechiness) { this.speechiness = speechiness; }

      /** @return the tempo of the song */
    public double getTempo() { return tempo; }
    
     /** @param tempo the tempo to set */ 
    public void setTempo(double tempo) { this.tempo = tempo; }

    // toString method



    /**
     * Converts the song record to a human-readable string representation.
     * return A formatted string of all song attributes.
     */

    @Override
    public String toString() {
        return "SongRecord{" +
                "valence=" + valence +
                ", year=" + year +
                ", acousticness=" + acousticness +
                ", artists=" + artists +
                ", danceability=" + danceability +
                ", durationMs=" + durationMs +
                ", energy=" + energy +
                ", explicit=" + explicit +
                ", id='" + id + '\'' +
                ", instrumentalness=" + instrumentalness +
                ", key=" + key +
                ", liveness=" + liveness +
                ", loudness=" + loudness +
                ", mode=" + mode +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", releaseDate=" + releaseDate +
                ", speechiness=" + speechiness +
                ", tempo=" + tempo +
                '}';
    }

    // equals method

     /**
     * Compares this SongRecord to another for equality.
     * 
     * @param o The object to compare to.
     * @return true if all fields match; false otherwise.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRecord that = (SongRecord) o;
        return Double.compare(that.valence, valence) == 0 &&
                year == that.year &&
                Double.compare(that.acousticness, acousticness) == 0 &&
                Objects.equals(artists, that.artists) &&
                Double.compare(that.danceability, danceability) == 0 &&
                durationMs == that.durationMs &&
                Double.compare(that.energy, energy) == 0 &&
                explicit == that.explicit &&
                Objects.equals(id, that.id) &&
                Double.compare(that.instrumentalness, instrumentalness) == 0 &&
                key == that.key &&
                Double.compare(that.liveness, liveness) == 0 &&
                Double.compare(that.loudness, loudness) == 0 &&
                mode == that.mode &&
                Objects.equals(name, that.name) &&
                popularity == that.popularity &&
                releaseDate == that.releaseDate &&
                Double.compare(that.speechiness, speechiness) == 0 &&
                Double.compare(that.tempo, tempo) == 0;
    }



     /**
     * Returns the hash code for this SongRecord.
     * @return the hash code.
     */

    @Override
    public int hashCode() {
        return Objects.hash(valence, year, acousticness, artists, danceability, durationMs, energy, explicit, id,
                instrumentalness, key, liveness, loudness, mode, name, popularity, releaseDate, speechiness, tempo);
    }
}
