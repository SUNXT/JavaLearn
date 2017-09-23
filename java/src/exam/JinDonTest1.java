package exam;

import java.util.Scanner;

public class JinDonTest1 {
    public static void main(String[] strings){
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int l = scanner.nextInt();
        int temp;
        int temp1;
        int count = 0;
        for (int i = r; i <= l; i ++){
            if (i >= 11){
                temp = i % 11;
                temp1 = i / 10;
                if (temp1 < 10){
                    if (temp == 0){
                        count ++;
                        System.out.println(i);
                    }
                }else
                if (temp == 0 || temp == 2 ){
                    count ++;
                    System.out.println(i);
                }
            }
        }
        System.out.println(count);
    }
}
