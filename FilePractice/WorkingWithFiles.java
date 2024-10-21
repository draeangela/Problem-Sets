import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is practice and provides methods for working with files, including counting values,
 * calculating averages, and processing multiple sets of numbers.
 */
public class WorkingWithFiles{

    /**
     * Counts the number of lines in a file.
     * 
     * @param pathname The path to the file to be read.
     * @return The number of lines in the file.
     * @throws FileNotFoundException If the file is not found.
     */
    public static int countValues(String pathname) throws FileNotFoundException {
        File f = new File(pathname);
        int count = 0;
        try (Scanner input = new Scanner(f)) {
            while (input.hasNextLine()) {
                input.nextLine();
                count++;
            }
        }
        System.out.println("count = " + count);
        return count;
    }

    /**
     * Calculates the average of all integers in a file.
     * 
     * @param pathname The path to the file containing integers.
     * @return The average of all integers in the file.
     * @throws FileNotFoundException If the file is not found.
     */
    public static double calcAverage(String pathname) throws FileNotFoundException {
        int numValues;
        int sum;
        try (Scanner input = new Scanner (new File(pathname))) {
            numValues = countValues(pathname);
            sum = 0;
            while (input.hasNextInt()){
                sum += input.nextInt();
            }
            input.close();
        }
        return (double)(sum)/(double)(numValues);
    }

    /**
     * Calculates the average of each line of integers in a file.
     * 
     * @param pathname The path to the file containing sets of integers.
     * @return An ArrayList of averages, one for each line in the file.
     * @throws FileNotFoundException If the file is not found.
     */
    public static ArrayList<Double> calcAverages(String pathname) throws FileNotFoundException{
        ArrayList<Integer> sums = new ArrayList<>();
        ArrayList<Integer> numValues = new ArrayList<>();
        ArrayList<Double> averages = new ArrayList<>();
        
        try (Scanner input = new Scanner(new File(pathname))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Scanner lineScanner = new Scanner(line);
                
                int sum = 0;
                int count = 0;
                
                while (lineScanner.hasNextInt()) {
                    sum += lineScanner.nextInt();
                    count++;
                }
                
                if (count > 0) {
                    sums.add(sum);
                    numValues.add(count);
                }
                
                lineScanner.close();
            }
        }

        for (int i = 0; i < sums.size(); i++) {
            if (numValues.get(i) > 0) {
                averages.add((double) sums.get(i) / numValues.get(i));
            } else {
                averages.add(0.0);
            }
        }

        return (averages);
    }

    /**
     * Main method
     * 
     * @param args Command line arguments (not used).
     * @throws FileNotFoundException If any of the files are not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        String numberFile = "/Users/dvizcarra/FilePractice/numbers.txt";
        double average = calcAverage(numberFile);
        System.out.println (average);
        
        ArrayList<Double> averages = calcAverages("/Users/dvizcarra/FilePractice/numbersets.txt");
        System.out.println (averages);
    }
}