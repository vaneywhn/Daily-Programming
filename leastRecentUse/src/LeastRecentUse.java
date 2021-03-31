import java.util.*;

public class LeastRecentUse {
    /**
     * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
     * set(key, value)：将记录(key, value)插入该结构
     * get(key)：返回key对应的value值
     * [要求]
     * set和get方法的时间复杂度为O(1)
     * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
     * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
     * 若opt=1，接下来两个整数x, y，表示set(x, y)
     * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
     * 对于每个操作2，输出一个答案
     *
     *
     * 第一次操作后：最常使用的记录为("1", 1)
     * 第二次操作后：最常使用的记录为("2", 2)，("1", 1)变为最不常用的
     * 第三次操作后：最常使用的记录为("3", 2)，("1", 1)还是最不常用的
     * 第四次操作后：最常用的记录为("1", 1)，("2", 2)变为最不常用的
     * 第五次操作后：大小超过了3，所以移除此时最不常使用的记录("2", 2)，加入记录("4", 4)，并且为最常使用的记录，然后("3", 2)变为最不常使用的记录
     * @param operators
     * @param k
     * @return
     */
    public static int[] LRU(int[][] operators, int k) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<operators.length;i++){
            if (operators[i][0]==1){        //set操作
                map.put(operators[i][1],operators[i][2]);
                if (!q.contains(operators[i][1])){      //set新值
                    if (q.size()<k){
                        q.offer(operators[i][1]);
                    }else{
                        Integer head = q.poll();
                        map.remove(head);
                        q.offer(operators[i][1]);
                    }
                }else{                                  //set已有值
                    q = makeQueue(q, operators[i][1]);
                }
            }else{                          //get操作
                Integer value = map.get(operators[i][1]);
                if (value!=null){
                    list.add(value);
                }else{
                    list.add(-1);
                }
                q = makeQueue(q, operators[i][1]);

            }
        }
        Integer[] a = list.toArray(new Integer[list.size()]);

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static Queue<Integer> makeQueue(Queue<Integer> q, int i) {
        Integer tmp = null;
        int size = q.size();
        for (int j = 0; j < size; j++) {
            Integer temp = q.poll();
            if(temp!=null && temp==i){
                tmp = temp;
            }else{
                q.offer(temp);
            }
        }
        q.offer(tmp);
        return q;
    }

    public static void main(String[] args) {
        int[][] k = {{1,-324690837,-72487934},{1,-723504364,-369145172},{2,-324690837},{1,724101438,-30727452},{1,366967562,290286156},{2,366967562},{1,-21417066,-450706222},{1,-484359960,-121414361},{1,-629538923,-759874959},{1,-461538894,749719150},{1,-338664886,-3080586},{2,522415046},{1,134352387,-391032350},{1,283492390,210901529},{2,-328994470},{2,-254674447},{2,85161833}};
        int[] lru = LRU(k, 3);
        System.out.println(Arrays.toString(lru));
    }
}
