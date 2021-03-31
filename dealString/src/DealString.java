public class DealString {

    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public static String solve (String str) {
        //方法一
        //return new StringBuffer(str).reverse().toString();
        //方向二
        StringBuffer sb = new StringBuffer(str);
        int i=0;
        int j=sb.length()-1;
        while(i<j){
            char c = sb.charAt(i);
            sb.setCharAt(j,sb.charAt(i));
            sb.setCharAt(i,c);
            i++;
            j--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
