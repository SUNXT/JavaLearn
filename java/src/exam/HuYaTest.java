package exam;

import sun.rmi.runtime.Log;

import java.util.Scanner;

public class HuYaTest {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        String max = "9223372036854775807";
//        String min = "-9223372036854775808";
        for (int i = 0; i < 10; i ++){
            String num = scanner.nextLine();
            isNum(num);
        }
    }

    private static void isNum(String input){

        if (!(input.equals("0") || input.matches("^[+][0-9]*[1-9][0-9]*$") || input.matches("^-[0-9]*[1-9][0-9]*$") || input.matches("^[0-9]*[1-9][0-9]*$"))){
            System.out.println(-1);
            return;
        }

        String temp = "";
        if (input.charAt(0) != '+' && input.charAt(0) != '-'){
            for (int i= 0; i < input.length(); i ++){
                if (input.charAt(i)!= '0'){
                    temp = input.substring(i, input.length());
                    break;
                }
            }
            input = temp;
            if (input.length() > 19){
                System.out.println(-1);
                return;
            }
        }else {
            for (int i= 1; i < input.length(); i ++){
                if (input.charAt(i)!= '0'){
                    temp = input.substring(i, input.length());
                    break;
                }
            }
            if (temp.length() > 19){
                System.out.println(-1);
                return;
            }
            input = input.charAt(0) + temp;
        }

        String max = "9223372036854775807";
        String min = "9223372036854775808";

        long num = 1;
        //带+的数字
        if (input.matches("^[+][0-9]*[1-9][0-9]*$")){
            if (input.length()-1 < 19){
                System.out.println(Long.parseLong(temp));
            }else {
                for (int i = 0; i < 19; i ++){
                    if (temp.charAt(i) > max.charAt(i)){
                        System.out.println(-1);
                        return;
                    }
                }
                System.out.println(Long.parseLong(temp));
            }
            return;
        }

        //带-的数字
        if (input.matches("^-[0-9]*[1-9][0-9]*$")){
            if (input.length()-1 < 19){
                System.out.println(Long.parseLong(input));
            }else {
                for (int i = 0; i < 19; i ++){
                    if (temp.charAt(i) > min.charAt(i)){
                        System.out.println(-1);
                        return;
                    }
                }
                System.out.println(Long.parseLong(input));
            }
            return;
        }

        if (input.matches("^[0-9]*[1-9][0-9]*$")  && input.length() < 20){
            if (input.length() < 19){
                System.out.println(Long.parseLong(input));
            }else {
                for (int i = 0; i < 19; i ++){
                    if (input.charAt(i) > max.charAt(i)){
                        System.out.println(-1);
                        return;
                    }
                }
                System.out.println(Long.parseLong(input));
            }
            return;
        }

        if (input.equals("0")){
            System.out.println(0);
        }else {
            System.out.println(-1);
        }
    }

}
