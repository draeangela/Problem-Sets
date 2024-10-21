import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkingWithFiles{
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

    
    public static void main(String[] args) throws FileNotFoundException {
        String numberFile = "/Users/dvizcarra/FilePractice/numbers.txt";
        double average = calcAverage(numberFile);
        System.out.println (average);
        
        ArrayList<Double> averages = calcAverages("/Users/dvizcarra/FilePractice/numbersets.txt");
        System.out.println (averages);
        //     File f = new File("/Users/dvizcarra/FilePractice/lyrics.txt");
        //     Scanner input = new Scanner(f);
        //     while (input.hasNextLine()){
        //         String line = input.nextLine();
        //         System.out.println(line);
        //     }
        // input.close(); //not necessary
    }
}