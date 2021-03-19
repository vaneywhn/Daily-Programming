import java.util.HashSet;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 5149 👎 0


public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int j = 0;
        int maxlength = 0;
        if(s.length()==1){
            return 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))){
                int temp = i-j;
                if(temp>maxlength){
                    maxlength = temp;
                }
                while(set.contains(s.charAt(i)) && j<=i){
                    set.remove(s.charAt(j));
                    j++;
                }
                set.add(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }
            if (i==s.length()-1){
                int temp = i-j+1;
                if(temp>maxlength){
                    maxlength = temp;
                }
            }

        }
        return maxlength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("a"));
    }
}
