import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo1 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> mt = new HashMap<>();
        mt.put(3,11);
        mt.put(1,12);
        mt.put(5,23);
        mt.put(2,22);
        for( Map.Entry e : mt.entrySet()){
            System.out.println(e.getKey());
        }


        HashMap<Integer, Integer> m = new LinkedHashMap<>();
        m.put(3,11);
        m.put(1,12);
        m.put(5,23);
        m.put(2,22);
        for( Map.Entry e : m.entrySet()){
            System.out.println(e.getKey());
        }
    }

}
