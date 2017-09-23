package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class MeiTuan2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int strLengthCutOne = str.length() - 1;
        if (strLengthCutOne > 49){
            return;
        }
        ArrayList<Integer> GIndexList = new ArrayList<>();
        ArrayList<Integer> RIndexList = new ArrayList<>();
        for (int i = 0; i < str.length(); i ++){
            if (str.charAt(i)=='G'){
                GIndexList.add(i);
            }else {
                RIndexList.add(i);
            }
        }
        int GIndexListSize = GIndexList.size();
        int[] backG = new int[GIndexListSize];//后G个数
        for (int i = 0; i < GIndexListSize; i ++){
//            System.out.print(GIndexList.get(i) + " ");
//            preR[i] = i;
            backG[i] = strLengthCutOne - GIndexList.get(i) - ( GIndexListSize - i - 1 );
        }
        int min = 0;
        for (int i = 0; i < GIndexListSize; i ++){
            if (min < i + backG[i]){
                min = i + backG[i];
            }
        }

        int RIndexListSize = RIndexList.size();
        int[] preR = new int[RIndexListSize];//前R个数
        int[] backMin = new int[RIndexListSize];
        int temp;
        for (int i = 0 ; i < RIndexListSize; i ++){
            preR[i] = RIndexList.get(i) - i;
            temp = strLengthCutOne - i - (RIndexListSize - i - 1);
            if (temp > (strLengthCutOne - i) - temp){
                backMin[i] = strLengthCutOne - i - temp;
            }else {
                backMin[i] = temp;
            }
//            System.out.print(preR[i] + " ");
        }

        for (int i = 0 ; i < RIndexListSize; i ++){
            if (min < preR[i] + backMin[i]){
                min = preR[i] + backMin[i];
            }
        }

        System.out.println(min);
    }
}
