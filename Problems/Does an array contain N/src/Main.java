import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int [] array_x = new int [x];
        int counter = 0;
        boolean data_present = false;

        while (counter < x){
            array_x[counter] = scanner.nextInt();
            counter++;
        }

        int val_x = scanner.nextInt();

        for (int y = 0; y < x; y++)
            if (array_x[y] == val_x) {
                data_present = true;
                break;
            }

        System.out.println(data_present);
    }
}