package Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class takes a text from the "in.txt" file and translates the sentences written in Romanian into another language called “pig Latin”.
 * Takes each word and move the first letter to the end of the word, then add the string "ei".
 * Each sentence is written on a single line and ends with a period.
 * The phrases get by translation are stored in another file called "translation.txt".
 */
public class PigLatin {
    /**
     * The source file.
     */
    private final String sourceFile = "in.txt";
    /**
     * The translation file.
     */
    private final String destFile = "translation.txt";
    /**
     * The list of phrases.
     */
    private List<String> phrases;

    /**
     * The constructor of the class.
     * It creates a new instance of the class.
     */
    PigLatin(){
        this.phrases = new ArrayList<>();
    }

    /**
     * Reads the entire contents of the source file as a single string,
     * including all line breaks.
     * @return the contents of the source file as a string
     * @throws IOException if an I/O error occurs while reading the file
     */
    public String read() throws IOException{
        StringBuilder text = new StringBuilder();

        try(BufferedReader in = new BufferedReader(new FileReader(sourceFile))) {
            String line;

            while ((line = in.readLine()) != null){
                text.append(line).append("\n");
            }
        }
        return text.toString();
    }

    /**
     * Separates the text into phrases.
     * @throws IOException if an I/O error occurs while reading the file
     */
    public void textToPhrases() throws IOException {
        Pattern pattern = Pattern.compile("(?:[^.]\\s*){3,}(?=[.]|$)");
        Matcher matcher = pattern.matcher(read());
        while (matcher.find()) {
            phrases.add(matcher.group().trim());
        }
    }

    /**
     * Translates the phrases and save them in the file.
     * @throws IOException if an error occurs while writing the file
     */
    public void translatePhrases() throws IOException {
        textToPhrases();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {
            for (String phrase : phrases) {
                String[] words = phrase.split(" ");
                for (int i = 0; i < words.length; i++) {
                    words[i] = modifyWord(words[i]);
                }
                writer.write(String.join(" ", words));
                writer.newLine();
            }
        }
    }

    /**
     * Translates a word.
     * Moves the first letter to the end of the word and add the string "ei".
     * @param word The word to translate.
     * @return The translated word.
     */
    private String modifyWord(String word){
        if (word.length() > 0){
            return word.substring(1) + word.charAt(0) + "ei";
        }
        return word;
    }
}

/**
 * Tests the functionality of the {@link PigLatin} class.
 */
class TestPigLatin{
    public static void main(String[] args) throws IOException {
        PigLatin p = new PigLatin();
        p.translatePhrases();
    }
}
