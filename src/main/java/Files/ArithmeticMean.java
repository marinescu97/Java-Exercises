package Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class calculates and displays the arithmetic mean of two or more numbers read from a file.
 */
public class ArithmeticMean {
    /**
     * The file from which the numbers are read.
     */
    private final String fileName;

    /**
     * The list of numbers read from the file.
     */
    private final List<Double> numbers;

    /**
     * The controller of the class.
     * It creates a new instance of the class.
     * @param fileName The fine from which the numbers are read.
     */
    ArithmeticMean(String fileName){
        this.fileName = fileName;
        numbers = new ArrayList<>();
    }

    /**
     * Reads the numbers from the file and adds then to the array.
     */
    private void read(){
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));

            StreamTokenizer st = new StreamTokenizer(in);

            int wordType = st.nextToken();

            while (wordType != StreamTokenizer.TT_EOF){
                if (wordType == StreamTokenizer.TT_NUMBER){
                    numbers.add(st.nval);
                }
                wordType = st.nextToken();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Calculates the arithmetic mean of the numbers from the array and displays it.
     */
    public void calculateArithmeticMean(){
        read();
        double sum = 0;
        for (Double number : numbers){
            sum += number;
        }
        System.out.println(sum / numbers.size());
    }
}

/**
 * The class tests the functionality of the {@link ArithmeticMean} class.
 */
class TestArithmeticMean{
    public static void main(String[] args) {
        ArithmeticMean arithmetic = new ArithmeticMean("numbers.txt");
        arithmetic.calculateArithmeticMean();
    }
}
