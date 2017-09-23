package exam;

import java.util.Scanner;

/**
 * 组合数字
 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 给出n(n < 1000)个数，求任意两个数之间二进制表示位数不同的数量之和。

 输入
 0  <= n < 32767。输入首先为n，然后跟随n个整数，范围为[0, 4294967295]
 输出
 组合数量

 样例输入
 2
 9
 15
 样例输出
 2

 */
public class DjiTest1 implements ITestRun {

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int count = 0;
        scanner.nextLine();
        for (int i = 0; i < n; i ++){
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < n-1; i ++){
            for (int j = i + 1; j < n; j ++){
                System.out.println(array[i] + "," + array[j]);
                int a = array[i]^array[j];
                while (a != 0){
                    a &= (a - 1);
                    count ++;
                }
            }
        }
        System.out.print(count);
    }

    public static int countBitDiff(int m, int n) {
        //异或
        int ans = m^n;
        //求ans中1的个数
        int count = 0;
        while(ans != 0){
            ans &= (ans -1);
            count++;
        }
        return count;
    }
}
