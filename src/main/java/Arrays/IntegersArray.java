package Arrays;

import java.util.Arrays;

/**
 * This class creates an array object with integers and operations on it.
 */
public class IntegersArray {
    /**
     * An array of integers.
     */
    private int[] arr;

    /**
     * Constructor of the class without parameters that initializes an array with null elements.
     */
    IntegersArray(){
        this.arr = new int[10];
    }

    /**
     * Constructor of the class that receives as a parameter an array that stores the elements of the set of maximum length 10.
     * @param array An array of integers.
     */
    public IntegersArray(int[] array){
        if(array.length<=10){
            this.arr = array;
        } else {
            System.out.println("Maximum length 10!");
            this.arr = null;
        }
    }

    /**
     * Constructor of the class that creates the array of n randomly generated elements.
     * @param n The array length (1 <= n <= 10).
     */
    public IntegersArray(int n){
        if (n > 0){
            this.arr = new int[n];
            for (int i=0; i<arr.length; i++){
                arr[i] =(int) (Math.random() * 10);
            }
        } else {
            this.arr = null;
        }
    }

    /**
     * Gets the array of integers.
     * @return The array.
     */
    public int[] getArr() {
        return arr;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.arr == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.arr, ((IntegersArray) obj).arr);
    }

    /**
     * Returns an array which length is the maximum element between this array and the given array.
     * @param array The given array.
     * @return The maximum array.
     */
    public IntegersArray max(int[] array){
        int max = 0;
        for (int k : this.arr) {
            if (k > max) {
                max = k;
            }
        }
        for (int k : array) {
            if (k > max) {
                max = k;
            }
        }
        return new IntegersArray(max+1);
    }

    /**
     * It realizes a reunion of two arrays.
     * An element in the third array is set to 1 if that element is 1 in one or both arrays.
     * E.g.: this.arr = {0,3,5,6}, array = {3, 4, 7, 9}, reunion = {1, 0, 0, 1, 1, 1, 1, 1, 0, 1}
     * @param array The second array.
     * @return A reunion of the two arrays.
     */
    public int[] reunion(int[] array){
        // Initializes the length of the new array (both arrays accepting only numbers from the range [0, 9]).
        // "max" will be the largest number from the two arrays, the array of the IntegersArray object, and the array received as a parameter.

        IntegersArray reunion = max(array);

        for (int i=0; i<reunion.getArr().length; i++){
            int exists = 0;
            for (int k : this.arr) {
                if (k == i) {
                    exists++;
                }
            }
            for (int k : array) {
                if (k == i) {
                    exists++;
                }
            }
            if (exists==0){
                reunion.getArr()[i] = 0;
            }else {
                reunion.getArr()[i] = 1;
            }
        }
        return reunion.getArr();
    }

    /**
     * It realizes an intersection of two arrays.
     * An element in the third array is set to 1 if that element is 1 in both arrays.
     * E.g.: this.arr = {0,3,5,6}, array = {3, 4, 7, 9}, reunion = {0, 0, 0, 1, 0, 0, 0, 0, 0, 0}
     * @param array The second array.
     * @return An intersection of the two arrays.
     */
    public int[] intersection(int[] array){
        IntegersArray intersection = max(array);

        for (int i=0; i< intersection.getArr().length; i++){
            int exists = 0;
            for (int k : this.arr) {
                if (k == i) {
                    exists++;
                    break;
                }
            }
            for (int k : array) {
                if (k == i) {
                    exists++;
                    break;
                }
            }
            if (exists==0 || exists==1){
                intersection.getArr()[i] = 0;
            }else {
                intersection.getArr()[i] = 1;
            }
        }
        return intersection.getArr();
    }

    /**
     * Inserts a new element to the array.
     * @param position The position where the number should be inserted.
     * @param number The number to be inserted.
     */
    public void insertItem(int position, int number){
        if (number >= 0){
            int[] array = new int[this.arr.length+1];

            if (position == 0){
                array[0] = number;
                System.arraycopy(this.arr, 0, array, 1, array.length - 1);
            } else if (position == this.arr.length+1){
                for (int i=0; i<this.arr.length; i++){
                    array[i] = this.arr[i];
                    array[array.length] = number;
                }
            } else {
                if (position >= 0) System.arraycopy(this.arr, 0, array, 0, position);
                array[position] = number;
                if (array.length - (position + 1) >= 0)
                    System.arraycopy(this.arr, position + 1 - 1, array, position + 1, array.length - (position + 1));
            }
            this.arr = array;
        }
    }

    /**
     * It deletes an element from an array.
     * @param position The position from which the element should be deleted.
     */
    public void deleteElement(int position){
        if (position < this.arr.length){
            int[] array = new int[this.arr.length-1];
            for (int i=0, k=0; i<this.arr.length; i++){
                if (i!=position){
                    array[k] = this.arr[i];
                    k++;
                }
            }
            this.arr = array;
        }
    }

    /**
     * Checks if two arrays are equal in length.
     * @param array The second array.
     */
    public void areEqual(int[] array){
        if (this.arr.length == array.length){
            System.out.println("The arrays are equal");
        } else {
            System.out.println("The arrays are not equal");
        }
    }

    /**
     * Displays the array.
     */
    public void display(){
        int zero = 0;
        for (int j : this.arr) {
            if (j == 0) {
                zero++;
            }
        }
        if (zero == arr.length){
            System.out.println("---");
        } else {
            for (int j : this.arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

/**
 * This class tests the functionality of the {@link IntegersArray} class.
 */
class Test{
    public static void main(String[] args) {
        System.out.println("The first array:");
        IntegersArray firstArr = new IntegersArray(new int[]{0, 3, 5, 6});
        firstArr.display();

        System.out.println("The second array: ");
        IntegersArray secondArr = new IntegersArray(5);
        secondArr.display();

        System.out.println("The reunion: ");
        int[] reunion = firstArr.reunion(secondArr.getArr());
        for (int i : reunion){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("The intersection: ");
        int[] intersection = firstArr.intersection(secondArr.getArr());
        for (int i : intersection){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\nInsert the number 6 in the first array on position 2");
        firstArr.insertItem(2, 6);
        firstArr.display();
        System.out.println();

        System.out.println("Delete the element at position 1 from the first array");
        firstArr.deleteElement(1);
        firstArr.display();
        System.out.println();

        System.out.println("Check if the first array is equal to the array {2, 4, 6, 8, 10}");
        firstArr.areEqual(new int[]{2, 4, 6, 8, 10});
    }
}
