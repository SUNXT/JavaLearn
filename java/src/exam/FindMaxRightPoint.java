package exam;

import java.util.*;

public class FindMaxRightPoint implements ITestRun {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x,y;
        Map<Integer, Integer> set = new HashMap<>();
        ArrayList<Integer> xArray = new ArrayList<>();
        for (int i = 0; i < n; i ++){
            x = scanner.nextInt();
            y = scanner.nextInt();
            xArray.add(x);
            set.put(x, y);
        }
        Collections.sort(xArray);
//
//        for (Integer i: xArray){
//            System.out.println(i);
//        }

        int tempY;
        boolean isMax;
        for (int i = 0; i < n; i ++){
            tempY = set.get(xArray.get(i));
            isMax = true;
            for (int j = i + 1; j < n; j ++){
                if (tempY < set.get(xArray.get(j))){
                    isMax = false;
                    break;
                }
            }
            if (isMax){
                System.out.println(xArray.get(i) + " " + tempY);
            }
        }
//        int tempX;
//        for (int i = 0; i < n; i ++){
//            tempX = xArray[i];
//            for (int j = 0; j < n; j++){
//
//            }
//        }
//        for (Integer i: set.keySet()){
//            System.out.println(i + " " + set.get(i));
//        }

    }

}
