package processor;
import java.util.Scanner;
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            printMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMatrix();
                    break;
                case 2:
                    multiplyN();
                    break;
                case 3:
                    matrixMultiplication();
                    break;
                case 4:
                    transposeMatrix();
                    break;
                case 5:
                    detScan();
                    break;
                case 6:
                    invMatrixScan();
                    break;

                case 0:
                    return;
                default:
                    break;
            }
            System.out.println();
        }




    }

    /* Print Menu */
    public static void printMenu(){
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix to a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    /* Function to read the array */
    public static double[][] readMatrix(int x, int y){
        double[][] readMatrix = new double[x][y];

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                readMatrix[i][j] = scanner.nextDouble();

        return readMatrix;
    }

    /* Function to add arrays */
    public static void addMatrix(){

        System.out.print("Enter size of first matrix: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] matrix1 = readMatrix(a,b);

        System.out.print("Enter size of second matrix: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("Enter second matrix:");

        if (x != a || y != b) {
            System.out.println("ERROR - Matrix sizes do not match");
            return;
        }

        double[][] matrix2 = readMatrix(x,y);
        double[][] res1 = new double[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                res1[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        printMatrix(res1);
    }

    /* Function to multiply array by number */
    public static void multiplyN(){

        double[][] matrix1 = matrixInit();
        System.out.print("Enter scalar value: ");
        double c = scanner.nextInt();

        double[][] res1 = scalarMultiply(matrix1, c);

        System.out.println("The multiplication result is:");
        printMatrix(res1);
    }

    public static double[][] scalarMultiply (double[][] matrix1, double c) {
        double[][] res1 = new double[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                res1[i][j] = matrix1[i][j] * c;
            }
        }
        return res1;
    }

    public static void matrixMultiplication(){

        System.out.print("Enter size of first matrix: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] matrix1 = readMatrix(a,b);

        System.out.print("Enter size of second matrix: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("Enter second matrix:");

        if (b != x) {
            System.out.println("ERROR - First Matrix's column count doesn't match Second Matrix row count");
            return;
        }

        double[][] matrix2 = readMatrix(x,y);

        double[][] res1 = new double[a][y];
        double dotVal = 0.0;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    dotVal += matrix1[i][k] * matrix2[k][j];
                }
                res1[i][j] = dotVal;
                dotVal = 0.0;
            }
        }
        printMatrix(res1);
    }

    /* Function to print array matrix */
    public static void  printMatrix(double[][] matrix1) {

        for (double[] ints : matrix1) {
            for (double anInt : ints) {
                System.out.printf("%6.2f ",anInt);
            }
            System.out.println();
        }

    }
    public static double[][] matrixInit() {

        System.out.print("Enter matrix size: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Enter matrix:");
        return readMatrix(a,b);
    }
    public static void printSecondMenu() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
    }

    /* Print Menu */
    public static void transposeMatrix() {

        printSecondMenu();
        int choice = scanner.nextInt();
        double[][] matrix1 = matrixInit();
        double[][] tMatrix;

        switch (choice) {
            case 1:
                tMatrix = mainDiagonal(matrix1);
                break;

            case 2:
                tMatrix = sideDiagonal(matrix1);
                break;

            case 3:
                tMatrix = verticalT(matrix1);
                break;

            case 4:
                tMatrix = horizontalT(matrix1);
                break;

            default:
                return;
        }

            System.out.println("We've received the matrix");
            printMatrix(tMatrix);

    }

    public static double[][] mainDiagonal(double[][] matrix1) {
        double[][] matrix2 = matrix1.clone();
        int rowD = matrix1[0].length;
        int colD = matrix1.length;

        double[][] tMatrix = new double[rowD][colD];

        for (int i = 0; i < rowD; i++) {
            for (int j = 0; j < colD; j++) {
                tMatrix [i][j] = matrix2[j][i];
            }
        }
        return tMatrix;
    }

    public static double[][] sideDiagonal(double[][] matrix1) {
        double[][] matrix2 = matrix1.clone();
        int rowD = matrix1[0].length;
        int colD = matrix1.length;

        double[][] tMatrix = new double[rowD][colD];

        for (int i = 0; i < rowD; i++) {
            for (int j = 0; j < colD; j++) {
                tMatrix [i][j] = matrix2[(colD - 1) - j][(rowD - 1) - i];
            }
        }
        return tMatrix;
    }

    public static double[][] verticalT(double[][] matrix1) {
        double[][] matrix2 = matrix1.clone();
        int rowD = matrix1.length;
        int colD = matrix1[0].length;

        double[][] tMatrix = new double[rowD][colD];

        for (int i = 0; i < rowD; i++) {
            for (int j = 0; j < colD; j++) {
                tMatrix [i][j] = matrix2[i][(colD - 1) - j];
            }
        }
        return tMatrix;
    }

    public static double[][] horizontalT(double[][] matrix1) {
        double[][] matrix2 = matrix1.clone();
        int rowD = matrix1.length;
        int colD = matrix1[0].length;

        double[][] tMatrix = new double[rowD][colD];

        for (int i = 0; i < rowD; i++) {
            for (int j = 0; j < colD; j++) {
                tMatrix [i][j] = matrix2[(rowD - 1) - i][j];
            }
        }
        return tMatrix;
    }

    public static void detScan() {
        double[][] matrix1 = matrixInit();
        double detValue = detMatrix(matrix1);
        System.out.println(detValue);
    }

    public static double detMatrix(double[][] matrix1) {

        Boolean rowCheck = true;
        int indexCheck = 0;
        double y = 0, z = 0;

        if (matrix1.length == 2) {
             return matrix1[0][0]*matrix1[1][1] - matrix1[0][1]*matrix1[1][0];
        }


        int[] rowX = minElementsRow(matrix1);
        int[] colY = minElementsCol(matrix1);

        /* Finds the reference row or column to start the calculations */
        if (colY[1] > rowX [1]) {
            rowCheck = false;
            indexCheck = colY[0];
        } else {
            indexCheck = rowX[0];
        }

        if (rowCheck) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if(matrix1[indexCheck][j] == 0) continue;
                y += detMatrix(subMatrix(matrix1,indexCheck,j)) * Math.pow(-1,(j + indexCheck+ 2)) * matrix1[indexCheck][j];
            }
        } else {
            for (int k = 0; k < matrix1.length; k++) {
                if(matrix1[k][indexCheck] == 0) continue;
                y += detMatrix(subMatrix(matrix1,k,indexCheck)) * Math.pow(-1,(k + indexCheck+ 2)) * matrix1[k][indexCheck];
            }

        }



        return y;
    }

    public static int[] minElementsRow(double[][] matrix1) {
        int[] valX = {0,0};
        int tempA = 0, tempB = 0;
        int rowD = matrix1.length;
        int colD = matrix1[0].length;

        for (int i = 0; i < rowD; i++) {
            for (int j = 0; j < colD; j++) {
                if (matrix1[i][j] == 0){
                    tempA++;
                }
            }
            if (tempA > tempB) {
                valX[0] = i;
                valX[1] = tempA;
                tempB = tempA;
                tempA = 0;
            }
        }
        return valX;
    }

    public static int[] minElementsCol(double[][] matrix1) {
        int[] valX = {0,0};
        int tempA = 0, tempB = 0;
        int rowD = matrix1.length;
        int colD = matrix1[0].length;

        for (int i = 0; i < rowD; i++) {
            for (int j = 0; j < colD; j++) {
                if (matrix1[j][i] == 0){
                    tempA++;
                }
            }
            if (tempA > tempB) {
                valX[0] = i;
                valX[1] = tempA;
                tempB = tempA;
                tempA = 0;
            }
        }
        return valX;
    }

    public static double[][] subMatrix(double[][] primaryMatrix, int a, int b) {
        int rowD = primaryMatrix.length - 1;
        int colD = primaryMatrix[0].length - 1;
        double[][] secondaryMatrix = new double[rowD][colD];
        int p = 0;
        int q = 0;

        for (int i = 0; i < rowD; i++) {

            if(p == a) {
                p++;
                p %= rowD + 1;
            }

            for (int j = 0; j < colD; j++) {

                if (q == b) {
                  q++;
                  q %= colD + 1;
                }

                secondaryMatrix[i][j] = primaryMatrix[p][q];
                q++;
                q %= colD + 1;
            }
            p++;
            p %= rowD + 1;

        }

        return secondaryMatrix;
    }

    public static void invMatrixScan() {
        double[][] matrix1 = matrixInit();
        double detValue = detMatrix(matrix1);

        if (detValue == 0) {
            System.out.println("This matrix doesn't have an inverse.");
        } else {
            //System.out.println(" time do calculate");
            double[][] matrix2 = invMatrixCalc(matrix1, 1 / detValue);
            printMatrix(matrix2);
        }

    }

    public static double[][] invMatrixCalc(double[][] matrix1, double scalar) {
        int rowD = matrix1.length;
        int colD = matrix1[0].length;
        double[][] matrix2 = new double[rowD][colD];

        if (rowD == colD && rowD == 2) {
            matrix2[0][0] = matrix1[1][1];
            matrix2[0][1] = -matrix1[0][1];
            matrix2[1][0] = -matrix1[1][0];
            matrix2[1][1] = matrix1[0][0];


        } else {

            for (int i = 0; i < rowD; i++ ) {
                for (int j = 0; j < colD; j++) {
                    matrix2[i][j] = detMatrix(subMatrix(matrix1, i, j)) * Math.pow(-1, (j + i + 2));
                }
            }
            matrix2 = mainDiagonal(matrix2);

        }

        return scalarMultiply(matrix2, scalar);
    }

}
