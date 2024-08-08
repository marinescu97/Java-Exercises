package Arrays;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * This class contains methods with arrays and {@link ArrayList}.
 */
public class Exercises {
    /**
     * A {@link Scanner} object used for text input.
     */
    static Scanner scn = new Scanner(System.in);

    /**
     * Constructs a one-dimensional array, whose components are numbers from the interval [a, b] (read from the keyboard) divisible by 3, ordered in descending order.
     */
    private static void displayArrayRange(){
        System.out.print("a = ");
        int a = scn.nextInt();
        System.out.print("b = ");
        int b = scn.nextInt();

        if (a > b){
            System.out.println("a should be less than b");
            displayArrayRange();
        } else {
            int v[];
            int count = 0;

            for (int i = a; i<=b; i++){
                if (i%3==0){
                    count++;
                }
            }

            v = new int[count];
            int index = 0;
            for (int i = b; i>=a; i--){
                if (i%3 == 0){
                    v[index]=i;
                    index++;
                }
            }
            for (int i : v){
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Constructs a {@link Stream}, whose components are numbers from the interval [a, b] (read from the keyboard) divisible by 3, ordered in descending order.
     */

    private static void displayArrayRangeStream(){
        System.out.print("a = ");
        int a = scn.nextInt();
        System.out.print("b = ");
        int b = scn.nextInt();

        if (a > b){
            System.out.println("a should be less than b");
            displayArrayRange();
        } else {
            Stream.iterate(a, n -> n <= b, n -> n + 1)
                    .filter(n -> n % 3 == 0)
                    .sorted(Comparator.reverseOrder())
                    .forEach(n -> System.out.print(n + " "));
        }
    }

    /**
     * Constructs an {@link ArrayList}, whose components are numbers from the interval [a, b] (read from the keyboard) divisible by 3, ordered in descending order.
     */
    private static void displayArrayListRange(){
        System.out.print("a = ");
        int a = scn.nextInt();
        System.out.print("b = ");
        int b = scn.nextInt();

        if (a > b){
            System.out.println("a should be less than b");
            displayArrayListRange();
        } else {
            List<Integer> v = new ArrayList<>();
            for (int i = b; i>=a; i--){
                if (i % 3 == 0){
                    v.add(i);
                }
            }
            for (int i : v){
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Displays the maximum number formed by the elements of an array.
     */
    private static void maxNumber(){
        System.out.print("Enter the number of elements of the array: ");
        int length = scn.nextInt();

        if (length<2){
            System.out.println("Enter a length greater than or equal to 2");
            maxNumber();
        } else {
            int arr[] = new int[length];
            for (int i=0; i<length; i++){
                System.out.print("Item no." + (i+1) + ": ");
                arr[i] = scn.nextInt();
            }

            int max[] = new int[length];
            int digit;

            for (int i=0; i< arr.length; i++){
                digit = 0;
                while (arr[i] != 0){
                    int remaining = arr[i] % 10;
                    digit = max(digit, remaining);
                    arr[i]/=10;
                }
                max[i] = digit;
            }

            max = sortIntegersDesc(max);

            int number = 0;

            for (int i : max){
                number = number * 10 + i;
            }

            System.out.println("The largest number formed by the elements of the array: " + number);
        }
    }

    /**
     * This is a helper method for {@link #maxNumber()} method.
     * @param a The first number.
     * @param b The second number.
     * @return The maximum number between the two numbers.
     */
    private static int max(int a, int b){
        if (a>b){
            return a;
        }
        return b;
    }

    /**
     * Sorts the elements of an array in ascending order.
     * @param array The array to be sort.
     * @return The sorted array.
     */
    private static int[] sortIntegers(int [] array){
        int[] sortedArray = new int[array.length];
        for (int i=0; i<array.length; i++){
            sortedArray[i] = array[i];
        }
        boolean flag = true;
        int temp;
        while (flag){
            flag = false;
            for (int i=0; i<sortedArray.length-1; i++){
                if (sortedArray[i] > sortedArray[i+1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

    /**
     * Sorts the elements of an array in ascending order using {@link Stream}.
     * @param array The array to sort.
     * @return The sorted array.
     */
    private static int[] sortIntegersStream(int[] array){
        return Arrays.stream(array).sorted().toArray();
    }

    /**
     * Sorts the elements of an array in descending order.
     * @param array The array to be sort.
     * @return The sorted array.
     */
    private static int[] sortIntegersDesc(int [] array){
        int[] sortedArray = new int[array.length];
        for (int i=0; i<array.length; i++){
            sortedArray[i] = array[i];
        }
        boolean flag = true;
        int temp;
        while (flag){
            flag = false;
            for (int i=0; i<sortedArray.length-1; i++){
                if (sortedArray[i] < sortedArray[i+1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

    /**
     * Sorts the elements of an array in descending order using {@link Stream}.
     * @param array The array to be sorted.
     * @return The sorted array.
     */

    private static int[] sortIntegersDescStream(int[] array){
        return Arrays.stream(array).boxed().sorted((a, b) -> b - a).mapToInt(i -> i).toArray();
    }

    /**
     * Sorts the even elements of an array in descending order without affecting the positions of the odd elements.
     * @param array The array to be sort.
     * @return The sorted array.
     */
    private static int[] sortEvenIntegers(int[] array){
        ArrayList<Integer> evens = new ArrayList<>();

        for (int i : array){
            if (i % 2 == 0){
                evens.add(i);
            }
        }

        evens.sort(Collections.reverseOrder());

        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                array[i] = evens.get(j++);
        }

        return array;
    }

    /**
     * Checks if an array is depression type.
     * An array is of depression type if from the first position to some position p is ordered strictly decreasing,
     * and from position p+1 to the last element it is ordered strictly ascending.
     * E.g.: v=(5 3 2 4 5) => YES
     *       v=(5 3 2 2 3) => NO
     * @param arr The array to be checked.
     */
    private static void checkDepression(int[] arr){
        int position = 0;

        for (int i=0; i<arr.length-1; i++){
            if (arr[i] > arr[i+1]){
                position++;
            } else {
                break;
            }
        }
        if (position!=0 && arr[position] != arr[position+1]){
            for (int i = position+1; i<arr.length-1; i++){
                if (arr[i]<arr[i+1]){
                    position++;
                }
            }
            if (arr[position+1] == arr[arr.length-1]){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
    }

    /**
     * Checks if an array has the same number of digits of the same type.
     * E.g.: n=348834 => n has 2 digits -> 3, 4 and 8 => YES
     *       n=566 => NO
     * @param arr The array to be checked.
     */
    private static void checkSameNumberOfDigits(int[] arr){
        boolean result = true;

        for (int i = 0; i<arr.length-1; i++){
            if (occurrencesNumber(arr, arr[i]) != occurrencesNumber(arr, arr[i+1])){
                result = false;
                break;
            }
        }

        if (result){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    /**
     * Calculates the number of occurrences of a number in an array.
     * @param arr The array.
     * @param n The number.
     * @return The number of occurrences.
     */
    private static int occurrencesNumber(int[] arr, int n){
        int count = 0;
        for (int i : arr){
            if (i == n){
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if the elements of two arrays form two sets of directly proportional or inversely proportional numbers.
     *
     * Directly proportional: the ratios formed by numbers in the same position in the two arrays must be equal.
     * E.g.: a=(2 5 7) and b=( 6 15 21) => 2/6=5/15=7/21
     *
     * inversely proportional: it is checked if the products between the first element of a and the last element of b,
     * the second element of a and the penultimate element of b, etc., are equal.
     * E.g.: a=(2 6 8) and b=(3 4 12) => 2*12=6*4=8*3
     */
    private static void directlyOrInverselyProportional(){
        System.out.print("Enter the length of the arrays: ");
        int length = scn.nextInt();
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];

        for (int i = 0; i < 2; i++){
            System.out.println("Enter the elements of the array " + (i+1) + ":");
            for (int j = 0; j < length; j++){
                System.out.print("Item no." + (j+1) + ": ");
                if (i == 0){
                    arr1[j] = scn.nextInt();
                } else {
                    arr2[j] = scn.nextInt();
                }
            }
        }

        arr1 = sortIntegers(arr1);
        arr2 = sortIntegers(arr2);

        boolean directProp = true, inversProp = true;

        for (int i = 0; i<length-1; i++){
            if ((arr1[i] / arr2[i]) != (arr1[i+1] / arr2[i+1])){
                directProp = false;
            }
        }

        arr2 = sortIntegersDesc(arr2);

        for (int i = 0; i<length-1; i++){
            if ((arr1[i] * arr2[i]) != (arr1[i+1] * arr2[i+1])){
                inversProp = false;
            }
        }

        if (directProp){
            System.out.println("Directly proportional");
        } else if (inversProp) {
            System.out.println("Inversely proportional");
        } else {
            System.out.println("The arrays are neither directly proportional nor inversely proportional\n");
        }
    }
}
