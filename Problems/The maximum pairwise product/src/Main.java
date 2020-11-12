import java.util.Scanner;
import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] arr = new int[x];
        int counter = 0;

        while (counter < x) {
            arr[counter] = scanner.nextInt();
            counter++;
        }

        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1] * arr[arr.length - 2]);

    }
}