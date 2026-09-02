import java.util.*;

class MatrixMismatchException extends Exception {
    public MatrixMismatchException(String message) {
        super(message);
    }
}

public class Problem2_MatrixMultiplication {

    public static int[][] multiplyMatrices(int[][] A, int[][] B)
            throws MatrixMismatchException {

        // TODO: Check if multiplication is possible
        if (A[0].length != B.length) {
            throw new MatrixMismatchException(
                "Matrix multiplication is not possible. Columns of A must equal rows of B."
            );
        }

        // TODO: Create result matrix
        int rowsA = A.length;
        int columnsB = B[0].length;

        int[][] result = new int[rowsA][columnsB];

        // TODO: Multiply the matrices
        for (int i = 0; i < rowsA; i++) {

            for (int j = 0; j < columnsB; j++) {

                for (int k = 0; k < B.length; k++) {

                    result[i][j] = result[i][j] + A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter rows and cols for Matrix A: ");
            int rA = sc.nextInt();
            int cA = sc.nextInt();

            int[][] A = new int[rA][cA];

            for (int i = 0; i < rA; i++)
                for (int j = 0; j < cA; j++)
                    A[i][j] = sc.nextInt();

            System.out.print("Enter rows and cols for Matrix B: ");
            int rB = sc.nextInt();
            int cB = sc.nextInt();

            int[][] B = new int[rB][cB];

            for (int i = 0; i < rB; i++)
                for (int j = 0; j < cB; j++)
                    B[i][j] = sc.nextInt();

            int[][] result = multiplyMatrices(A, B);

            System.out.println("Resulting Matrix:");

            for (int[] row : result)
                System.out.println(Arrays.toString(row));

        } catch (MatrixMismatchException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}