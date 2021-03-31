import java.util.Arrays;

/**
 * 给出两个有序的整数数组A和B，请将数组B合并到数组A中，变成一个有序的数组
 * 注意：
 * 可以假设A数组有足够的空间存放B数组的元素，A和B中初始的元素数目分别为m和n
 */
public class Merge {
    public static void merge(int A[], int m, int B[], int n) {

        int aPtr = m - 1, bPtr = n - 1;
//  两数组元素从右至左比较，大的去 A 尾部，直至有一方指针到头为止
        for (int ptr = m + n - 1; aPtr >= 0 && bPtr >= 0; ptr--){
            A[ptr] = A[aPtr] > B[bPtr] ? A[aPtr--] : B[bPtr--];
        }
//  A 指针先走完的情况，B 中剩余元素直接copy至 A 对应位置即可；
        while (bPtr >= 0){
            A[bPtr] = B[bPtr--];
        }
        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,3,0};
        int[] B = new int[]{2};
        merge(A,2,B,1);
    }
}
