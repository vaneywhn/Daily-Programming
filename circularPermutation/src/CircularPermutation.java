//给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
//
//
// p[0] = start
// p[i] 和 p[i+1] 的二进制表示形式只有一位不同
// p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
//
//
//
//
// 示例 1：
//
// 输入：n = 2, start = 3
//输出：[3,2,0,1]
//解释：这个排列的二进制表示是 (11,10,00,01)
//     所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
//
//
// 示例 2：
//
// 输出：n = 3, start = 2
//输出：[2,6,7,5,4,0,1,3]
//解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
//
//
//
//
// 提示：
//
//
// 1 <= n <= 16
// 0 <= start < 2^n
//
// Related Topics 数学
// 👍 27 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CircularPermutation {
    //循环码排列
    public static List<Integer> circularPermutation(int n, int start) {

        List<Integer> res = new ArrayList<>();
        if (n<=0){
            return Collections.emptyList();
        }
        if (n==1){
            res.add(start);
            res.add(1-start);
            return res;
        }
        int index = start == 1 ? 1:0;
        res.add(0);
        res.add(1);
        for (int i = 2; i <= n ; i++) {
            int tmp = res.size()-1;
            for (int j = tmp; j >=0 ; j--) {
                int value = res.get(j) + (1 << (i - 1));
                res.add(value);
                if (value==start){
                    index = res.size()-1;
                }
            }
        }
        ArrayList<Integer> newArr = new ArrayList<>();
        newArr.addAll(res.subList(index,res.size()));
        newArr.addAll(res.subList(0,index));
        return newArr;
    }

    public static List<Integer> getGrayCode(int n){
        if (n<=0){
            return Collections.emptyList();
        }
        if (n==1){
            return Arrays.asList(0,1);
        }
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        for (int i = 2; i < n ; i++) {
            int tmp = res.size()-1;
            for (int j = tmp; j >=0 ; j--) {
                res.add(res.get(j)+(1 << (i-1)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(circularPermutation(1,1));
    }
}
