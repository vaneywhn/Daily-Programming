//最长回文子串
public class LongestPalindrome {
    //暴力解法时间超时
//    public static String longestPalindrome(String s) {
//        if(s.equals(new StringBuffer(s).reverse().toString())){
//            return s;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j <= i; j++){
//                String temp = s;
//                String subString = temp.substring(j,j+temp.length()-i);
//                if (subString.equals(new StringBuffer(subString).reverse().toString())){
//                    return subString;
//                }
//            }
//        }
//        return "";
//    }
    //动态规划的方案
    public static String longestPalindrome(String s) {
        //回文串的特征是，去掉回文头尾字符得到的子串也是回文串
        //可得到推导式：P[i,j] = P[i+1][j-1] && s[i]==s[j]
        //动态规划的核心是填表和边界处理
        int n = s.length();
        if(n==0){
            return s;
        }
        Boolean[][] chart = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            chart[i][i] = true;
        }
        int maxlength = 1;
        String maxString = s.charAt(0)+"";
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if(s.charAt(i)!=s.charAt(j)){
                    chart[i][j]=false;
                }else{
                    if (j-i<3){
                        chart[i][j]=true;
                    }else {
                        chart[i][j] = chart[i+1][j-1];
                    }
                }
                if (chart[i][j]){
                    if(j-i+1>maxlength){
                        maxlength = j-i+1;
                        maxString = s.substring(i,j+1);
                    }
                }
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
}
