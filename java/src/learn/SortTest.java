package learn;

public class SortTest {

    public static void main(String[] strings){

        int[] A = {1, 2, 8, 11, 3, 0, 5, 9};
        selectSort(A);
        int[] B = {4, 6, 8, 10};
        int[] C = margeTwoSortedArrays(A,B);
        for (int i: A){
            System.out.print(i + ",");
        }
    }

    /**
     * 升序排列
     * 合并已排好序的数组
     * @param A
     * @param B
     * @return  margeArrays 合并后的数组
     */
    private static int[] margeTwoSortedArrays(int[] A, int[] B){
        int q = A.length;
        int p = B.length;
        int t = 0;//记录A数组对比元素的当前下标，移动指针
        int s = 0;//记录B数组对比元素的当前下标，移动指针
        int k = 0;//记录合并完数组的元素当前下标，移动指针
        int[] mergeArrays = new int[q + p];//存储返回的排序好的数组
        while (t < q && s < p){
            if (A[t] <= B[s]){
                mergeArrays[k] = A[t];//将比较结果中较小的一个元素存入到合并后的数组mergeArrays中
                t ++;//A数组的指针前移
            }else {
                mergeArrays[k] = B[s];
                s ++;
            }
            k ++;
        }
        //判断哪个数组先结束比较
        if (t == q){//A数组先结束比较，将剩余的B数组元素依次存入到mergeArrays中
            for (int i = s; i < p; i ++, k ++){
                mergeArrays[k] = B[i];
            }
        }else {
            for (int i = t; i < q; i ++, k ++){
                mergeArrays[k] = A[i];
            }
        }
        return mergeArrays;
    }

    /**
     * 升序排序
     * 选择排序
     * @param A
     */
    private static void selectSort(int[] A){
        int n = A.length;//数组的长度
        int k;//当前排序后的元素下标
        for (int i = 0; i < n-1; i ++){
            k = i;
            //查找未排序的数组中的最小元素
            for (int j = i + 1; j < n; j ++){
                if (A[j] < A[k]){
                    k = j;
                }
            }
            if (k != i){
                int temp = A[k];
                A[k] = A[i];
                A[i] = temp;
            }
        }
    }

}
