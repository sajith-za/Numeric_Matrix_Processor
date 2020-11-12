import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        int[] boxOne = new int[3];
        int[] boxTwo = new int[3];
        boolean validEntry = true;
        String operand = "";

        for (int i = 0; i < 3; i++) {
            boxOne[i] = scanner.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            boxTwo[i] = scanner.nextInt();
        }

        Arrays.sort(boxOne);
        Arrays.sort(boxTwo);

        if (boxOne[2] == boxTwo[2] && boxOne[1] == boxTwo[1] && boxOne[0] == boxTwo[0]) {
            operand = "=";
        } else if (boxOne[2] >= boxTwo[2] && boxOne[1] >= boxTwo[1] && boxOne[0] >= boxTwo[0]) {
            operand = ">";
        } else if (boxOne[2] <= boxTwo[2] && boxOne[1] <= boxTwo[1] && boxOne[0] <= boxTwo[0]) {
            operand = "<";
        } else {
            validEntry = false;
        }

        System.out.println(validEntry ? "Box 1 " + operand + " Box 2" : "Incomparable");


    }
}