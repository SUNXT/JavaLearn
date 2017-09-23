package exam;

import java.util.Scanner;

/**
 * 查找字符串中是否存在已[img]开头，以[/img]结尾的子串
 */
public class YYTest1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String start = "[img]";
        String end = "[\\img]";
        if (!str.contains(start)||!str.contains(end)){
            System.out.println("null");
            return;
        }

        int firstStartIndex = str.lastIndexOf(start);
//        System.out.println(firstStartIndex);
//        while (str.substring(0, firstStartIndex).lastIndexOf(start) != -1){
//            firstStartIndex = str.substring(0, firstStartIndex).lastIndexOf(start);
//        }


//        System.out.println(subStr);
        int lastEndIndex = str.lastIndexOf(end);
//        System.out.println(firstStartIndex + " " + lastEndIndex);
        System.out.println(str.substring(firstStartIndex, lastEndIndex + 6));
    }
}
