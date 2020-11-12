import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String[] arrS = new String[4];
        Boolean notPretty = false;

        for (int i = 0; i < 4; i++)
            arrS[i] = scanner.next();

          for (int i = 0; i < 3 && !notPretty; i++) {
            for (int j = 0; j < 3; j++) {
                notPretty = arrS[i].charAt(j) == arrS[i].charAt(j + 1) &&
                            arrS[i].charAt(j) == arrS[i + 1].charAt(j) &&
                            arrS[i].charAt(j) == arrS[i + 1].charAt(j + 1);
                if (notPretty) break;
            }
        }

        System.out.println(notPretty ? "NO" : "YES");

    }
}