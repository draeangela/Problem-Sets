public class BenfordsLaw {

    public static int[] generateRandomNum(int min, int max){
        int[] benfordArrRandom = new int[1000];
        for (int i = 0; i < benfordArrRandom.length; i++){
            benfordArrRandom[i] = (int)(Math.random() * (max - min + 1)) + min;
        }
        return (benfordArrRandom);
    }  

    public static int[] generateExpNum(double factor, int size) {
        int[] benfordArrExp = new int[size];
        for (int i = 0; i < size; i++) {
            benfordArrExp[i] = (int) Math.pow(factor, i);
        }
        return benfordArrExp;
    }

    public static int getLeadingDigit(int num){
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    public static void benfordRandomDistribution(){
        int[] counter = new int [10];
        int[] proportions = new int[10];

        int[] benfordArr = generateRandomNum(100, 999); //Generate array with 1000 three digit numbers

        //Create counter array
        for (int i = 0; i < benfordArr.length;i++){
            int hundredsDigit = getLeadingDigit(benfordArr[i]);

            for (int j = 0; j < counter.length; j++){
                if (j == hundredsDigit){
                    counter[j]+=1;
                }
            }
        }


        //Create proportions array based on values in counter array
        for (int i = 0; i < counter.length; i++){
            proportions[i] = (int) Math.floor(((double) counter[i] / benfordArr.length) * 100);
        }
            printStarDist(proportions);
    }

    public static void benfordExpDistribution(double factor, int size){
        int[] counter = new int [10];
        int[] proportions = new int[10];

        int[] benfordArr = generateExpNum(factor, size); //Generate array with (size) three digit numbers

        //Create counter array
        for (int i = 0; i < benfordArr.length;i++){
            int hundredsDigit = getLeadingDigit(benfordArr[i]);

            for (int j = 0; j < counter.length; j++){
                if (j == hundredsDigit){
                    counter[j]+=1;
                }
            }
        }

        //Create proportions array based on values in counter array
        for (int i = 0; i < counter.length; i++){
            proportions[i] = (int) Math.floor(((double) counter[i] / benfordArr.length) * 100);
        }
        printStarDist(proportions);
    }

    //Print string of stars distribution
    public static void printStarDist(int[] benfordProportionsArr){
        String stars = "";
        int numStars = 0;

        for (int i = 0; i < benfordProportionsArr.length; i++){
            numStars = (int)(benfordProportionsArr[i]/2);
            for (int j = 0; j < numStars; j++ ){
                if (j == 0){
                    stars += i + ": *";
                } else if (j != numStars-1) {
                    stars += "*";
                } else {
                    stars += "* \n";
                }
            }
        }
        System.out.println ("Benford Distribution for Dataset in Stars (Key: 1 star = 2%, rounded up):");
        System.out.println(stars);
    }


    public static void main(String[] args) {
        benfordRandomDistribution();
        benfordExpDistribution(1.1, 200);
    }

}