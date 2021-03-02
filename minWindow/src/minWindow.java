import java.util.*;

public class minWindow {
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> tmap = new HashMap<>();

        String minStr = ""; //最小字串
        int min = 0;

        for (int i=0;i<t.length();i++){
            if(tmap.get(t.charAt(i))!=null){
                tmap.put(t.charAt(i),tmap.get(t.charAt(i))+1);
            }else{
                tmap.put(t.charAt(i),1);
            }
        }
        int k = 0;
        for (int j=0;j<s.length();j++){
            if(smap.get(s.charAt(j))!=null){
                smap.put(s.charAt(j),smap.get(s.charAt(j))+1);
            }else{
                smap.put(s.charAt(j),1);
            }
            //
            if (check(smap,tmap)){   //当前s字串是否满足t中条件
                if (min>j-k+1 || min==0){
                    minStr = s.substring(k,j+1);
                    min = j-k+1;
                    if (min==t.length()){
                        return minStr;
                    }
                }
                //
                while(k<j && check(smap,tmap)){
                    smap.put(s.charAt(k),smap.get(s.charAt(k))-1);
                    k++;
                    if (check(smap,tmap)){
                        if (min>j-k+1 || min==0){
                            minStr = s.substring(k,j+1);
                            min = j-k+1;
                        }
                    }
                }
            }
        }

        return minStr;

    }

    public static Boolean check(HashMap<Character,Integer> smap,HashMap<Character,Integer> tmap){
        Boolean flag = true;
        for (Character key:tmap.keySet()){
            if (smap.get(key)==null || tmap.get(key)>smap.get(key)){
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("最小字串为："+minWindow(s,t));
    }
}
