import java.util.*;

/**
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 *
 */

public class ZigzagLevelOrder {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
//         Stack<TreeNode> stack = new Stack<TreeNode>();
//         stack.push(root);
        TreeNode node = root;
        if(node==null){
            return new ArrayList<ArrayList<Integer>>();
        }
        int i = 1;//所在层
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(node);
        while(!q.isEmpty()){
            ArrayList<Integer> li = new ArrayList<Integer>();
            int size = q.size();
            for(int j=0;j<size;j++){
                TreeNode t = q.poll();
                if(t.left!=null){
                    q.offer(t.left);
                }
                if(t.right!=null){
                    q.offer(t.right);
                }
                if(i%2==1){
                    li.add(t.val);
                }else{
                    li.add(0,t.val);
                }
            }
            i++;
            res.add(li);
        }
        return res;
    }
}
