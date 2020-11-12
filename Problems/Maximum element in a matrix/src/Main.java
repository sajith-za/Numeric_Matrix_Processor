import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int counter = -50;
        int x_index = 0;
        int y_index = 0;


        int[][] arr1 = new int [n][m];

        for (int i = 0; i < n; i++) {
            for (int j=0; j < m; j++){
                arr1[i][j] = scanner.nextInt();
                if(arr1[i][j] > counter){
                    x_index = i;
                    y_index = j;
                    counter = arr1[i][j];
                }
            }
        }

        System.out.println(x_index+" "+y_index);

    }
}