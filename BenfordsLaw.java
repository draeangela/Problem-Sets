public class BenfordsLaw {

    public static int[] generateRandomNum(int min, int max){
        int[] benfordArr = new int[1000];
        for (int i = 0; i < benfordArr.length; i++){
            benfordArr[i] = (int)(Math.random() * (max - min + 1)) + min;
        }
        return (benfordArr);
    }  

    public static int getLeadingDigit(int num){
        return ((num/100) % 10);
    }

    public static void benfordDistribution(){
        int[] counter = new int [10];
        int[] proportions = new int[10];
        String stars = "";
        int numStars = 0;

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
            proportions[i] = (int)(((double) counter[i] / 10.0));
        }

        //Create string of stars distribution
        for (int i = 0; i < proportions.length; i++){
            numStars = (int)(proportions[i]/2);
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
        System.out.println ("Benford Distribution for Dataset in Stars (Key: 1 star = 2%, rounded down):");
        System.out.println(stars);

        }

    public static void main(String[] args) {
            benfordDistribution();
    }

}