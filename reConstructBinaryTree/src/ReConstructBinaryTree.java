import java.util.Arrays;


public class ReConstructBinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 根据先序遍历和中序遍历重构二叉树
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        int head = pre[0];
        TreeNode treeNode = new TreeNode(head);
        if(pre.length>1){
            int index = 0;
            for(int i=0 ;i<in.length;i++){
                if(in[i]==head){
                    index = i;
                    break;
                }
            }
            int[] aa = Arrays.copyOfRange(pre, 1, index + 1);
            if (aa.length==0){
                treeNode.left=null;
            }else{
                treeNode.left = reConstructBinaryTree(aa,Arrays.copyOfRange(in, 0, index));
            }
            int[] bb = Arrays.copyOfRange(pre, index + 1, pre.length);
            if (bb.length==0){
                treeNode.right=null;
            }else{
                treeNode.right = reConstructBinaryTree(bb,Arrays.copyOfRange(in, index+1, pre.length));
            }
        }else{
            treeNode.left = null;
            treeNode.right = null;
        }
        return treeNode;
    }

    public static void main(String[] args) {
        //int [] pre = {1,2,3,4,5,6,7};
        int [] pre = {1,2,4,3,5,6};
        //int [] in = {3,2,4,1,6,5,7};
        int [] in = {4,2,1,5,3,6};
        TreeNode t = reConstructBinaryTree(pre,in);
    }
}
