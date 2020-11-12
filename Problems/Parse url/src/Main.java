import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int counter = 0;

        String[] parts = input.split("\\?|\\*");

        if (parts.length == 1) {
            System.out.println("Error");
            return;
        }

        String webDetails = parts[1];
        String[] parts2 = webDetails.split("&");
        String password = "";

        while (parts2.length != 1 && counter != parts2.length) {
            String[] parts3 = parts2[counter].split("=");
            System.out.println(parts3[0] + " : " + (parts3.length == 1 ? "not found" : parts3[1]));

            if (parts3[0].equals("pass") && parts3.length != 1) {
                password = parts3[1];
            }
            counter++;
        }

        if (!password.isEmpty()) {
            System.out.println("password : " + password);
        }

    }
}