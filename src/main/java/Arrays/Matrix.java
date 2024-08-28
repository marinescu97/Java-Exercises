package Arrays;

/**
 * This class creates a matrix object and performs operations on it.
 */
public class Matrix {
    /**
     * A two-dimensional matrix.
     */
    private final int[][] matrix;

    /**
     * The constructor of the class.
     * Creates an instance of the {@link Matrix} object.
     * @param matrix A two-dimensional matrix.
     */
    Matrix(int[][] matrix){
        this.matrix = matrix;
    }

    /**
     * Gets the matrix.
     * @return The matrix.
     */
    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Displays the matrix.
     */
    public void display(){
        for (int[] i : this.matrix) {
            for (int j = 0; j < this.matrix.length; j++) {
                System.out.print(i[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Adds the matrix with the one received as a parameter.
     * @param m The second matrix.
     * @return The sum of the two matrices.
     */
    public Matrix sum(Matrix m){
        int[][] sum = new int[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                sum[i][j] = matrix[i][j] + m.getMatrix()[i][j];
            }
        }
        return new Matrix(sum);
    }

    /**
     * Perform the subtraction of the two matrices.
     * @param m The second matrix.
     * @return The subtraction of the two matrices.
     */
    public Matrix subtraction(Matrix m){
        int[][] sub = new int[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                sub[i][j] = matrix[i][j] - m.getMatrix()[i][j];
            }
        }
        return new Matrix(sub);
    }

    /**
     * Returns the transpose of the matrix.
     * @return The transpose of the matrix.
     */
    public Matrix transpose(){
        int[][] transpose = new int[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                transpose[i][j] = matrix[j][i];
            }
        }
        return new Matrix(transpose);
    }

    /**
     * Calculates the product of two matrices.
     * @param arr The second matrix.
     * @return The product.
     */
    public Matrix product(Matrix arr) {
        int[][] multiply = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                multiply[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    multiply[i][j] += this.matrix[i][k] * arr.getMatrix()[k][j];
                }
            }
        }
        return new Matrix(multiply);
    }

    /**
     * It displays the minimum sum of elements of the submatrices, as well as the coordinates of the region of each submatrix.
     * @param length The length of submatrices.
     */
    public void minSumSubmatrices(int length) {
        int rows = getMatrix().length;
        int cols = getMatrix()[0].length;
        int sum = sumSubmatrix(0, 0, length);
        int sr=1, sc=1;

        for (int startRow = 0; startRow <= rows - length; startRow++) {
            for (int startCol = 0; startCol <= cols - length; startCol++) {
                if (sum > sumSubmatrix(startRow, startCol, length)){
                    sum = sumSubmatrix(startRow, startCol, length);
                    sr = startRow + 1;
                    sc = startCol + 1;
                }
            }
        }
        System.out.printf("The minimum amount is %d. The region starts on line %d, column %d\n", sum, sr, sc);
    }

    /**
     * Calculates the sum of the elements of a submatrix.
     * @param startRow The first row.
     * @param startCol The first column.
     * @param length The length of submatrix.
     * @return The sum of elements.
     */
    public int sumSubmatrix(int startRow, int startCol, int length) {
        int sum = 0;
        for (int i = startRow; i < startRow + length; i++) {
            for (int j = startCol; j < startCol + length; j++) {
                sum+=getMatrix()[i][j];
            }
        }
        return sum;
    }
}

class TestMatrix{
    public static void main(String[] args) {
        int[][] arr1 ={{1,2,3}, {6,3,1}, {9,3,6}};
        int[][] arr2 = {{1,2,3}, {4,5,6}, {7,8,9}};

        Matrix m = new Matrix(arr1);
        Matrix n = new Matrix(arr2);

        System.out.println("Matrix m:");
        m.display();

        System.out.println();

        System.out.println("The smallest sum of the elements of a submatrix of length 2: ");
        m.minSumSubmatrices(2);

        System.out.println();

        System.out.println("The transpose of the matrix m:");
        Matrix transpose = m.transpose();
        transpose.display();

        System.out.println("\nMatrix n:");
        n.display();

        System.out.println("\nThe sum of the matrices:");
        Matrix sum = m.sum(n);
        sum.display();

        System.out.println("\nThe subtraction of the matrices:");
        Matrix subtraction = m.subtraction(n);
        subtraction.display();

        System.out.println("\nThe product of the matrices:");
        Matrix product = m.product(n);
        product.display();
    }
}
