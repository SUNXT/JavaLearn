package exam;

import java.util.Scanner;

/**
 * 2017年5月18日，国土资源部中国地质调查局昨日在南海宣布,我国正在南海北部神狐海域进行的可燃冰试采获得成功。准备用一个N*N的地图来标记这些可燃冰的位置，图中用*标示了可燃冰的存在，冰田有大有小，地图上两个点之间可以直接连成直线的认为是同一块冰田，但不能通过其它非冰田的区域。例如：

 *000
 0000
 0000
 0000

 上图中有一块冰田
 *000
 0000
 00*0
 000*

 上图中有两块冰田，左上角为第一块，右下角3个*由于每两点之间可以通过直线连通，算作一块冰田，为第二块。

 当输入一个二维数组（里面包含了*和0）地图的时候，可以输出冰田的数量。输入第一行为二维数组的大小，例如4，表示4*4的地图。后面每一行为二维数组的实际内容。
 */
public class FindIceBoxCount implements ITestRun {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Character[][] NN = new Character[n][n];
        String temp;
        for (int i = 0; i < n; ++i){
            temp = scanner.nextLine();
            for (int k = 0; k < temp.length(); ++k){
                NN[i][k] = temp.charAt(k);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i ++){
            for (int k = 0; k < n; k++){
                if (NN[i][k].equals('*')){
                    if (!find(NN, i, k, n))
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public boolean find(Character[][] NN, int i, int k, int n){
        if (k-1>=0){
            if (NN[i][k-1].equals('*')){
                return true;
            }
        }

//        if (k+1<n){
//            if (NN[i][k+1].equals('*')){
//                return true;
//            }
//        }

        if (i -1 >= 0){
            if (NN[i-1][k].equals('*')){
                return true;
            }
            if (k-1 >=0){
                if (NN[i-1][k-1].equals('*')){
                    return true;
                }
            }
//            if (k+1<n){
//                if (NN[i-1][k+1].equals('*')){
//                    return true;
//                }
//            }
        }
        if (i +1 < n){
            if (NN[i+1][k].equals('*')){
                return true;
            }
            if (k-1 >=0){
                if (NN[i+1][k-1].equals('*')){
                    return true;
                }
            }
//            if (k+1<n){
//                if (NN[i+1][k+1].equals('*')){
//                    return true;
//                }
//            }
        }


        return false;
    }
}
