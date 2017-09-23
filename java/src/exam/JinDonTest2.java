package exam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class JinDonTest2 {
    public static void main(String[] s){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        int count = 1;
        Character temp;
        boolean flag = false;
        for (int i = 0; i < str.length(); i ++){
            temp = str.charAt(i);
            int c = 0;
            if (temp.equals(')')){
                flag = true;
            }else {
                flag = false;
                stack.push(temp);
            }
        }
    }
}
