package exam;

/**
 * 二维数组找是否存在元素
 * 原题：（剑指offer）
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Array2FindTarget implements ITestRun {

    @Override
    public void run() {
        int[][] array = {{1, 2, 8, 9},{4, 7, 10 , 13}};
        if (searchMatrix(array, 10)){
            System.out.println("find it");
        }else {
            System.out.println("not find it");
        }
    }

    private boolean find(int target, int[][] array){
        int a = array.length;
        int b = array[0].length;
        return find(a, b, a, b, target, array);
//        int tempA = a;
//        for (int i = a - tempA; i < a; i++){
//            i =  a - tempA;
//            for (int j = b-1; j >= 0; j--){
//                if (target == array[i][j]){
//                    return true;
//                }
//                if (target > array[i][j]){
//                    tempA --;
//                    break;
//                }
//                if (target < array[i][j]){
//                    b--;
//                    break;
//                }
//            }
//        }
//        return false;
    }

    private boolean find(int a, int b, int i, int j, int target, int[][] array){
        if (i < 0 || i >= a || j < 0 || j >= b)
            return false;
        else {
            if (target == array[i][j]){
                return true;
            }else {
                if (target > array[i][j])
                    return find(a, b, i, j - 1, target, array);
                else
                    return find(a, b, i+1, j, target, array);
            }
        }
    }

    /**
     * 剑指offer中的算法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target){
        int x = matrix.length-1;
        int k = matrix[0].length;
        int y = 0;
        while(x >= 0 && y < k){
            if (matrix[x][y] == target){
                return true;
            }
            if (matrix[x][y] > target){
                x--;
            }else{
                y++;
            }
        }
        return false;
    }
}
