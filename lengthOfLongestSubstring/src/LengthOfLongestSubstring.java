import java.util.HashSet;

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
