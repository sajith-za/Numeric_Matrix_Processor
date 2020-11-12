import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        double degCelsius = scanner.nextDouble();
        System.out.println(degCelsius * 1.8 + 32);
    }
}