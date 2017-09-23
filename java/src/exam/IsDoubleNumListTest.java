package exam;
import java.util.Scanner;

/**
 * 判断一个数列是否能组合成相邻两个数两两的积能被四整除
 * 例如
 * 2 3 4 4 5-> 2 4 3 5 4 Yes
 * 1 2 3 4 -> No
 */
public class IsDoubleNumListTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0 ; i < n; i ++){
            test();
        }
    }

    public static void test(){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count4 = 0;
        int count2 = 0;
        int countx = 0;
        int temp;
        for (int i = 0; i < n; i ++){
            temp = scanner.nextInt();
            if (temp > 0 && temp % 4 == 0){
                count4 ++;
            }else {
                if (temp > 0 && temp % 2 == 0){
                    count2 ++;
                }else {
                    countx ++;
                }
            }
        }
        if (count4 + 1 >= count2 + countx){
            System.out.println("YES");
        }else {
            if (count2 >= 2){
                if (count4 + 1 > countx){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }else {
                System.out.println("NO");
            }
        }
    }
}
