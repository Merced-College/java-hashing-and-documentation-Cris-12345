//package hashingAndDocumentation;//comment this out if you do not need a package
/**
 * SongProgram.java
 *
 * A program to load song data from a CSV file and allow users to
 * retrieve songs by ID via console or GUI interface.
 *
 * This class handles file reading, storage of song records in a HashMap,
 * and user interaction through a basic Swing GUI.
 *
 * @author Cristopher gomez or the author of program I was unsure if i was meant to write an author or myself 
 * @version 1.0
 */ 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;




public class SongProgram {

     /**
     * HashMap to store SongRecords with the song's ID as the key.
     */
    // HashMap to store SongRecords with the song's ID as the key
    private HashMap<String, SongRecord> songMap;

     /**
     * Constructs a new SongProgram with an empty song map.
     */

    public SongProgram() {
        songMap = new HashMap<>();
    }

/**
     * Loads song data from a CSV file into the songMap.
     *
     * @param filePath the path to the CSV file 
     * @precondition filePath is a valid CSV file containing song data in the correct format 
     * @postcondition songMap is populated with SongRecord objects 
     */ 
    public void loadSongsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            //read in first line and do nothing with it
            br.readLine();
            
            while ((line = br.readLine()) != null) {
            	
            	//System.out.println(line);//for testing
                // Create a SongRecord from the line and add it to the map
                SongRecord song = new SongRecord(line);
                songMap.put(song.getId(), song);
            }
            System.out.println("Songs successfully loaded from CSV.");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }


     /**
     * Retrieves a SongRecord by its ID.
     *
     * @param id the song ID to search for
     * @return the SongRecord if found, null otherwise
     * @precondition id is not null
     * @postcondition returns matching SongRecord or null
     */

    // Method to retrieve a SongRecord by ID
    public SongRecord getSongById(String id) {
        return songMap.get(id);
    }

     /**
     * Prints all songs to the console (for debugging or display).
     *
     * @postcondition all SongRecords are printed to System.out
     */

    // Method to print all songs (for debugging or display purposes)
    public void printAllSongs() {
        for (SongRecord song : songMap.values()) {
            System.out.println(song);
        }
    }
    

     /**
     * Opens a GUI to allow the user to search for a song by ID.
     *
     * @postcondition displays a window with search functionality
     */
    
    // GUI method to search for a song by ID
    public void openSearchGui() {
        // Create the main frame
        JFrame frame = new JFrame("Song Lookup");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold input and button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Label, Text Field, and Button
        JLabel label = new JLabel("Enter Song ID:");
        JTextField idField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        // Add label, text field, and button to panel
        panel.add(label);
        panel.add(idField);
        panel.add(searchButton);

        // Result area to display song details
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        // Add action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                SongRecord song = getSongById(id);
                if (song != null) {
                    resultArea.setText("Song Found:\n" + song.toString());
                } else {
                    resultArea.setText("Song with ID " + id + " not found.");
                }
            }
        });

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

     /**
     * Main method to demonstrate functionality and open the GUI.
     *
     * @param args command-line arguments (not used)
     * @precondition "data.csv" exists and contains properly formatted song data
     * @postcondition GUI opens and song data is loaded
     */
    // Main method to demonstrate functionality and open GUI
    public static void main2(String[] args) {
        SongProgram program = new SongProgram();

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Open GUI for searching songs by ID
        program.openSearchGui();
    }

      /**
     * Alternate main method to load and display songs in the console.
     *
     * @param args command-line arguments (not used)
     */

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        SongProgram program = new SongProgram();

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Demonstrate retrieving a song by ID
        String testId = "4BJqT0PrAfrxzMOxytFOIz";  // replace with an actual ID from your file
        SongRecord song = program.getSongById(testId);
        if (song != null) {
            System.out.println("Retrieved song: " + song);
        } else {
            System.out.println("Song with ID " + testId + " not found.");
        }

        // Print all songs
        program.printAllSongs();
    }
}

