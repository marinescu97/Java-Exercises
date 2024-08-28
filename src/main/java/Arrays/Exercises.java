package Arrays;

import java.util.*;
import java.util.stream.Stream;

/**
 * This class contains methods with arrays and {@link ArrayList}.
 */
public class Exercises {
    /**
     * Constructs a one-dimensional array, whose components are numbers from the interval [a, b] divisible by 3, ordered in descending order.
     */
    public int[] displayArrayRange(int a, int b){
        if (a > b || a == b){
            System.out.println("a should be less than b");
            return null;
        } else {
            int count = 0;

            for (int i = a; i<=b; i++){
                if (i%3==0){
                    count++;
                }
            }

            int[] v = new int[count];
            int index = 0;
            for (int i = b; i>=a; i--){
                if (i%3 == 0){
                    v[index]=i;
                    index++;
                }
            }
            return v;
        }
    }

    /**
     * Constructs a {@link Stream}, whose components are numbers from the interval [a, b] divisible by 3, ordered in descending order.
     */

    public int[] displayArrayRangeStream(int a, int b){
        if (a > b || a == b){
            System.out.println("a should be less than b");
            return null;
        }
        return Stream.iterate(a, n -> n <= b, n -> n + 1)
                .filter(n -> n % 3 == 0)
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /**
     * Constructs an {@link ArrayList}, whose components are numbers from the interval [a, b] divisible by 3, ordered in descending order.
     */
    public List<Integer> displayArrayListRange(int a, int b){
        if (a > b || a == b){
            System.out.println("a should be less than b");
            return null;
        }
        List<Integer> v = new ArrayList<>();
        for (int i = b; i>=a; i--){
            if (i % 3 == 0){
                v.add(i);
            }
        }

        return v;
    }

    /**
     * Displays the maximum possible number that can be formed by concatenating the maximum digits from each element in the input array.
     */
    public int maxNumber(int[] array){
        if (array.length<2){
            return 0;
        }

        int[] max = new int[array.length];
        int digit;

        for (int i=0; i< array.length; i++){
            digit = 0;
            if (array[i] < 0){
                array[i] *= -1;
            }
            while (array[i] != 0){
                int remaining = array[i] % 10;
                digit = max(digit, remaining);
                array[i]/=10;
            }
            max[i] = digit;
        }

        max = sortIntegersDesc(max);

        int number = 0;

        for (int i : max){
            number = number * 10 + i;
        }

        return number;
    }

    /**
     * This is a helper method for {@link #maxNumber(int[])} method.
     * @param a The first number.
     * @param b The second number.
     * @return The maximum number between the two numbers.
     */
    public int max(int a, int b){
        return Math.max(a, b);
    }

    /**
     * Sorts the elements of an array in ascending order.
     * @param array The array to be sort.
     * @return The sorted array.
     */
    public int[] sortIntegers(int[] array){
        if (array == null){
            return null;
        }

        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);
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
    public int[] sortIntegersStream(int[] array){
        if (array == null){
            return null;
        }

        return Arrays.stream(array).sorted().toArray();
    }

    /**
     * Sorts the elements of an array in descending order.
     * @param array The array to be sort.
     * @return The sorted array.
     */
    public int[] sortIntegersDesc(int[] array){
        if (array == null){
            return null;
        }

        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);
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

    public int[] sortIntegersDescStream(int[] array){
        if (array == null){
            return null;
        }

        return Arrays.stream(array).boxed().sorted((a, b) -> b - a).mapToInt(i -> i).toArray();
    }

    /**
     * Sorts the even elements of an array in descending order without affecting the positions of the odd elements.
     * @param array The array to be sort.
     * @return The sorted array.
     */
    public int[] sortEvenIntegers(int[] array){
        if (array == null){
            return null;
        }
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
    public boolean checkDepression(int[] arr){
        if (arr == null){
            return false;
        }
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
            return arr[position + 1] == arr[arr.length - 1];
        } else {
            return false;
        }
    }

    /**
     * Checks if an array has the same number of digits of the same type.
     * E.g.: n=348834 => n has 2 digits -> 3, 4 and 8 => YES
     *       n=566 => NO
     * @param arr The array to be checked.
     */
    public boolean checkSameNumberOfDigits(int[] arr){
        if (arr == null){
            return false;
        }
        boolean result = true;

        for (int i = 0; i<arr.length-1; i++){
            if (occurrencesNumber(arr, arr[i]) != occurrencesNumber(arr, arr[i+1])){
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Calculates the number of occurrences of a number in an array.
     * @param arr The array.
     * @param n The number.
     * @return The number of occurrences.
     */
    public int occurrencesNumber(int[] arr, int n){
        if (arr == null){
            return 0;
        }

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
     * <p>
     * Directly proportional: the ratios formed by numbers in the same position in the two arrays must be equal.
     * E.g.: a=(2 5 7) and b=( 6 15 21) => 2/6=5/15=7/21
     * <p>
     * inversely proportional: it is checked if the products between the first element of a and the last element of b,
     * the second element of a and the penultimate element of b, etc., are equal.
     * E.g.: a=(2 6 8) and b=(12, 4, 3) => 2*12=6*4=8*3
     */
    public String directlyOrInverselyProportional(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null){
            return null;
        }

        boolean directProp = true, inversProp = true;

        for (int i = 0; i< arr1.length; i++){
            if ((arr1[i] / arr2[i]) != (arr1[0] / arr2[0])){
                directProp = false;
            }
            if ((arr1[i] * arr2[i]) != (arr1[0] * arr2[0])){
                inversProp = false;
            }
        }

        if (directProp){
            return "Directly proportional";
        } else if (inversProp) {
            return "Inversely proportional";
        } else {
            return "The arrays are neither directly proportional nor inversely proportional";
        }
    }
}
