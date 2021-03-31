import java.util.Stack;

public class isValid {
    /**
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     */

    public static boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if ('('==s.charAt(i)||'['==s.charAt(i)||'{'==s.charAt(i)){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (('(' == pop && ')' != s.charAt(i)) || ('[' == pop && ']' != s.charAt(i)) || ('{' == pop && '}' != s.charAt(i))) {
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));

    }
}
