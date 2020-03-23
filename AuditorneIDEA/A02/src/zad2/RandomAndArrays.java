package zad2;

/**
 *
 * @author Matija
 */
public class RandomAndArrays {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("A program need an argument for array length");
            System.exit(1);
        }

        //parsing value of array size from inpuut parameters
        int arraySize = Integer.parseInt(args[0]);
        //creating array of certain size
        int[] randomArray = new int[arraySize]; //at this point array is filled with null's

        //filling array with values 0-100. Since Math.random returns double values from
        //0-1, we need to multiply those with 100 and cast to int
        for (int i = 0; i < randomArray.length - 1; i++) {
            randomArray[i] = (int) (Math.random() * 100);
        }

        //printing array backwards on standard output
        for (int i = randomArray.length - 1; i >= 0; i--) {
            System.out.println("Array[" + i + "] = " + randomArray[i]);
        }

        int largestInt = randomArray[0];
        int smallestInt = randomArray[0];
        // ALTERNATIVE
        // int largestInt = Integer.MIN_VALUE; //we could also put 0 here
        // int smallestInt = Integer.MAX_VALUE; //we could also put 100 here

        int indexOfLargerst = 0;
        int indexOfSmallest = 0;

        //find largest and smallest int in array
        for (int i = 0; i < randomArray.length; i++) {

            if (randomArray[i] > largestInt) {
                largestInt = randomArray[i];
                indexOfLargerst = i;
            }
            if (randomArray[i] < smallestInt) {
                smallestInt = randomArray[i];
                indexOfSmallest = i;
            }
        }

        System.out.println();
        System.out.println("Smallest integer in array is: " + smallestInt
                + " at position [" + indexOfSmallest + "]");
        System.out.println("Largest integer in array is: " + largestInt
                + " at position [" + indexOfLargerst + "]");

    }

}
