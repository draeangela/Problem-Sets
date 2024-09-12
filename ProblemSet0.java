import java.util.ArrayList;
import java.util.Arrays;

public class ProblemSet0{
    public static int countInRange(int[] arr, int min, int max) {
        int count = 0; //initialize counter

        //Check if values are between min and max
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= max) {
                count += 1;
            }
        }
        return count;
    
    }
    public static ArrayList<String> clump(ArrayList<String> arr) {
        ArrayList<String> clumpedArr = new ArrayList<>(); //initialize empty array to store clumps
        
        //Clump string items by twos
        for (int i = 0; i < arr.size(); i+= 2) {
            if (i+1 < arr.size()){
                clumpedArr.add(arr.get(i) + " " + arr.get(i+1));
            }
            else {
                clumpedArr.add(arr.get(i));
            }
        }
        return clumpedArr;
    }

    //Note: will return false if input is not a square matrix
    public static boolean isMagicSquare(int[][] arr){
        int sum = 0; //Initialize overaching sum variable that will be compared against row sums, column sums, and diagonal sums.
        if (arr.length != arr[0].length) {
            return false;
        }

        //Sum each row
        int checkRowSum = 0;
        int rowSum = 0;
        for (int i = 0; i < arr.length; i++){
            if (i == 0) {
                for (int j = 0; j < arr[0].length; j++){
                checkRowSum += arr[i][j]; //Sum first row and store it
                }
            } else {
                for (int j = 0; j < arr[0].length; j++){
                    rowSum += arr[i][j]; //Sum the remaining rows
                }
                if (rowSum == checkRowSum){ //Compare each row against the first row's sum
                    rowSum = 0; //Reset rowSum
                } else {
                    return false;
                }
            }
        }

        //Sum each column 
        int checkColSum = 0;
        int colSum = 0;
        for (int j = 0; j < arr.length; j++){
            if (j == 0) {
                for (int i = 0; i < arr.length; i++){
                checkColSum += arr[i][j]; //Sum first column and store it
                }
            } else {
                for (int i = 0; i < arr.length; i++){
                    colSum += arr[i][j]; //Sum the remaining column
               }
                if (colSum == checkColSum){ //Compare each column against the first column's sum
                    colSum = 0; //Reset columnu
                } else {
                    return false;
                }
            }
        }
        
        if (checkRowSum == checkColSum){ 
            sum = checkRowSum;
        } else {
            return false;
        }

        //Sum each diagonal
        int checkDiagSum = 0;
        int diagSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++){
                if (i == j){
                    checkDiagSum += arr[i][j]; //Sum top left to bottom right diagonal
                }
            }
        }
        for (int i = 0; i <arr.length; i++) {
            diagSum += arr[i][arr.length - (i+1)]; //Sum bottom left to top right diagonal
        }
        if (diagSum != checkDiagSum){ //Compare diagonal sums
            return false;   
        } else if (diagSum != sum){
            return false;
        }
        return true;
    }

    public static int median (int arr[]){
        //Initialize variables
        int[] countArr = new int[100];
        int medIdx = arr.length/2; //Index of the median
        int median = 0;
        int count = 0;

        //Set counter array--the integers in the original array become the indices marked with "1" in the counter array
        for (int i = 0; i < countArr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (i == arr[j]){
                    countArr[i] += 1;
                }
            }
        }

        //Find median by counting the ones in the counter array. If the number of ones becomes larger than the median index, that index is the median. 
        for (int i = 0; i < countArr.length; i++){
            if (countArr[i] == 1){
                count += 1;
            }
            if (count > medIdx) {
                median = i;
                return median;
            }
        } 
        return 0;
    }

    public static void main(String[] args) {
        //Initialize tester arrays
        int[] testCountInRange = {14, 1, 22, 17, 36, 7, -43, 5};
        ArrayList<String> testClump = new ArrayList<>(Arrays.asList("hi", "there", "what", "is", "up?"));
        int[][] testIsMagicSquare = {{2,7,6}, {9,5,1}, {4,3,8}};
        int[] testMedian = {2, 3, 10, 1, 5};
        
        //Test countInRange
        System.out.println("Numbers in range: " + countInRange(testCountInRange, 4, 17));

        //Test clump
        System.out.println("Clumped Array:" + clump(testClump));

        //Test isMagicSquare
        System.out.println("Is Magic Square: " + isMagicSquare(testIsMagicSquare));

        //Test median
        System.out.println("Median: " + median(testMedian));
    }
    
}