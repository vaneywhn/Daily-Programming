import java.util.*;

public class MaxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        List<Integer> list  = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))!=null){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for (Character c:map.keySet()){
            if (map.get(c)>=2){
                int x = s.indexOf(c);
                int y = s.lastIndexOf(c);
                list.add(y-x-1);
            }
        }
        if (list.size()==0){
            return -1;
        }else{
            Collections.sort(list);
        }
        return list.get(list.size()-1);
    }

//快速解法
//    public int maxLengthBetweenEqualCharacters(String s) {
//        int max = -1;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            int lastIndex = s.lastIndexOf(c);
//            if (i != lastIndex) {
//                int space = lastIndex - i - 1;
//                max = space > max ? space : max;
//            }
//        }
//        return max;
//    }

}
