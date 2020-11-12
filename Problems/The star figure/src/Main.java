import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        String[][] arr1 = new String[length][length];

        for (String[] vector : arr1)
            Arrays.fill(vector,".");

        for (int i = 0; i < length; i++) {
            arr1[(length - 1) / 2][i] = "*";
            arr1[i][(length - 1) / 2] = "*";
            arr1[i][i] = "*";
            arr1[i][length - (i + 1)] = "*";
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(arr1[i][j]);
                if (j >= 0 && j < length - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }

    }
}