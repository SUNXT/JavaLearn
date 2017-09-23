package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MeiTuan1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i ++){
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        int max = 0;
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);
        if ( a + b > c){
            max = a + b + c;
        }else {
            max = (a + b) * 2 - 1;
        }
        System.out.println(max);
    }
}
