package exam;

import exam.Array2FindTarget;
import exam.ITestRun;

public class Main {
    public static void main(String[] strings){
//        Scanner scanner = new Scanner(System.in);
//        String string = scanner.nextLine();
//        System.out.println("You input: " + string);
//        for (int i = 0; i < string.length(); ++ i){
//            System.out.println((int)string.charAt(i));
//        }
        ITestRun iTestRun = new Array2FindTarget();
        iTestRun.run();
    }
}
