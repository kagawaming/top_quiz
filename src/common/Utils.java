package common;

import javax.sound.sampled.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;

/**
 * Utils class contains static utility functions for I/O and media
 */
public class Utils {
    // Constants
    public static final String QUESTIONS_FILE = new File("resources","questionsData.txt").getAbsolutePath();
    public static final String PICTURE_DIR = new File("src/resources", "pics").getPath();
    public static final String INPUT_TYPE = "input";
    public static final String SINGLE_TYPE = "single";
    public static final String MULTIPLE_TYPE = "multiChoice";

    //file I/O function
    public static String readFile(String filePath){
        StringBuilder content = new StringBuilder();
        File inputFile = new File(filePath);
        if(inputFile.exists()){
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(filePath));
                String line = bufferedReader.readLine();
                while (line != null) {
                    content.append(line);
                    line = bufferedReader.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(bufferedReader != null)
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
        return content.toString();
    }

    //set sound function
    public static void setSound(String soundPath) {
        String soundName = soundPath;
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = getAudioInputStream(new File(soundName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    /**
     * Join the arraylist to a string with the given delimiter
     * @param input an arraylist of string
     * @param delimiter delimiter
     * @return a joined string
     */
    public static String join(List<String> input, String delimiter){
        String output = "";
        int length = input.size();
        for(int i=0; i < length; i++){
            if(i == length -1)
                output += input.get(i);
            else
                output += (input.get(i) + delimiter);
        }

        return output;
    }
}
