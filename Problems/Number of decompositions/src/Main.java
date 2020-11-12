import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] arr1 = new int[input + 1];
        Arrays.fill(arr1, 0);
        arr1[0] = input;
        decompose(arr1, 0);
    }

    private static void newOnes(int[] arr) {
        int tempA = arr[0];
        int tempB = arr[1];

        Arrays.fill(arr, 0);
        arr[0] = tempA;
        arr[1] = tempB + 1;

        for (int i = 2; i < 2 + arr[0] - arr[1]; i++) {
            arr[i] = 1;
        }
    }

    private static void secondaryOnes(int[] arr, int x) {

        int counter = 1;
        int sumVal = 0;
        int index = 1;

        while (arr[counter] >= x) {
            sumVal += arr[counter];
            counter++;
            index++;
        }

        for (int i = index; i < index + arr[0] - sumVal; i++) {
            arr[i] = 1;
        }
    }

    private static int arrangeArray(int[] arr) {
        //Sort the array in descending order
        int temp;
        int minValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    minValue = temp == 0 ? arr[i] : arr[j];
                }

                if (arr[i] == arr[j] && arr[i] == 0) {
                    return minValue;
                }

                minValue = arr[i];
            }
        }

        return minValue;
    }

    private static void decompose(int[] arr1, int minValue) {

        int counter = 1;
        int tempA;
        int newMin = 0;

        while (counter != arr1.length && arr1[1] != arr1[0]) {

            if (minValue == 0) {
                newOnes(arr1);
                newMin = 1;
                break;
            }

            if (arr1[counter] == minValue) {
                if (arr1[counter] == arr1[counter + 1]) {
                    if (arr1[counter] + 1 <= arr1[1]) {
                        arr1[counter] += 1;
                        arr1[counter + 1] -= 1;
                        tempA = arr1[counter];
                        arrangeArray(arr1);
                        secondaryOnes(arr1, tempA);
                        newMin = arrangeArray(arr1);
                    } else {
                        newOnes(arr1);
                        newMin = 1;
                    }
                    break;
                } else if (arr1[counter + 1] == 0) {
                    if (arr1[counter - 1] + 1 <= arr1[1]) {
                        arr1[counter - 1] += 1;
                        arr1[counter] -= 1;
                        tempA = arr1[counter - 1];
                        arrangeArray(arr1);
                        secondaryOnes(arr1, tempA);
                        newMin = arrangeArray(arr1);
                    } else {
                        newOnes(arr1);
                        newMin = 1;
                    }
                    break;
                }

            }
            counter++;
        }


        if (arr1[1] >= arr1[0]) {
            printString(arr1);
        } else {
            printString(arr1);
            decompose(arr1, newMin);
        }




    }

    private static void printString(int[] arr1) {
        for (int i = 1; i < arr1.length && arr1[i] != 0; i++) {
            System.out.print(arr1[i]);
            if (i + 1 < arr1.length && arr1[i + 1] != 0) {
                System.out.print(" ");
            }
        }

        if (arr1[0] != arr1[1]) {
            System.out.println();
        }
    }

}