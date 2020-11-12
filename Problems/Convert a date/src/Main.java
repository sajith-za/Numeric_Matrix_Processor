import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();

        String[] parts = date.split("-");
        String newDate = "";

        for (int i = 1; i < parts.length; i++) {
            newDate += parts[i] + "/";
        }

        newDate += parts[0];

        System.out.println(newDate);
    }
}
