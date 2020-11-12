import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nSquare = n * n;
        int sigmaX = 0, testVal = 0;
        int[][] arr1 = new int[nSquare][nSquare];

        for (int i = 0; i < nSquare; i++) {
            for (int j = 0; j < nSquare; j++) {
                arr1[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i <= nSquare; i++) {
            sigmaX += i * i;
        }

        for (int i = 0; i < nSquare; i++) {
            for (int j = 0; j < nSquare; j++) {
                testVal += arr1[i][j] * arr1[i][j];
            }

            if (testVal != sigmaX) {
                System.out.println("NO");
                return;
            }
            testVal = 0;
        }

        for (int i = 0; i < nSquare; i++) {
            for (int j = 0; j < nSquare; j++) {
                testVal += arr1[j][i] * arr1[j][i];
            }
            if (testVal != sigmaX) {
                System.out.println("NO");
                return;
            }
            testVal = 0;
        }


        for (int i = 0; i < nSquare; i += n) {
            for (int j = 0; j < nSquare; j += n) {
                for (int k = i; k < i + n; k++) {
                    for (int l = j; l < j + n; l++) {
                        testVal += arr1[k][l] * arr1[k][l];
                    }
                }
                if (testVal != sigmaX) {
                    System.out.println("NO");
                    return;
                }
                testVal = 0;
            }
        }


        System.out.println("YES");
    }
}