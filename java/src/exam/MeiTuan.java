package exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 小萌非常喜欢能被 7 整除的数字，比如 7,21,121996，等等。有一天他得到了 n 个正整数，她想用这些数制造出更多的能够被 7 整除的数。于是她从这 n 个数中选出两个数，然后将一个数写在另一个数的前面，以此得到一个新的数。按这种方法她一共可以得到个数，她想知道在这些数中，有多少个是能被 7 整除的。
 输入
 第一行包含一个整数n。2 ≤n≤ 105
 第二行包含n个正整数ai。1 ≤ai≤109
 输出
 输出对应的答案。

 样例输入
 3
 127 1996 12
 样例输出
 4

 Hint
 一共有 4 种组合方式，其中：把 12 写在 1996 前面得到 121996；把 127 写在 12 前面得到12712；把 1996 写在 12 前面得到 199612；把 1996 写在 127 前面得到 1996127；都是可以被 7 整除的，其余的组合方式不能被 7 整除。
 */
public class MeiTuan {
    public static void main1(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] array = new int[n];
        for (int i = 0; i < n; i ++){
            array[i] = scanner.nextInt();
            hashMap.put(array[i], weishu(array[i]));
        }

        int count = 0;
        for (int i = 0; i < n-1; i ++){
            for (int j = i + 1; j < n; j ++){
//                System.out.println(array[i] + " " + array[j]);
                count += jisuan(array[i], array[j], hashMap);
            }
        }
        System.out.println(count);
    }

    private static int jisuan(int a, int b, HashMap<Integer, Integer> hashMap){
        int i = 0;
        int temp = (a * hashMap.get(b) + b );
        if (temp % 7 == 0)i++;
        temp = (b * hashMap.get(a) + a);
        if (temp %7 == 0)i++;
        return i;
    }

    private static int weishu(int num){
        int i = 0;
        while (num / 10 > 0){
            i ++;
            num =  num/10;
        }
        return (int) Math.pow(10, i+1);
    }

    public static void main(String[] arys){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i ++)scanner.nextInt();
        if (n%2==1){
            System.out.println("Alice");
        }else {
            System.out.println("Bob");
        }
    }
}
