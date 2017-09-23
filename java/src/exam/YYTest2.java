package exam;

import java.util.Scanner;

public class YYTest2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(max(input));
    }

    private static int max(String str){
        int length = str.length();

        int A[][] = new int[length + 1][length + 1];
        for (int m = 0; m < length; m++) {

            for (int n = 0; n < length; n++) {
                if (str.charAt(m) == str.charAt(n))
                    A[m + 1][n + 1] = A[m][n] + 1;

            }

        }

        int max = 0;
        for (int m = 0; m < length + 1; m++) {

            for (int n = 0; n < length + 1; n++) {
                if ((m != n) && (A[m][n] > max))
                    max = A[m][n];

            }

        }
        return max;
    }
}
